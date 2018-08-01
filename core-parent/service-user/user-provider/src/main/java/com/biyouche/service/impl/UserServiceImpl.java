package com.biyouche.service.impl;

import java.io.UnsupportedEncodingException;

import java.util.*;
import com.alibaba.fastjson.JSON;
import com.biyouche.config.Config;
import com.biyouche.constants.SmsConstant;
import com.alibaba.fastjson.JSONObject;
import com.biyouche.constants.ConfigConstant;
import com.biyouche.constants.UserConstant;
import com.biyouche.dao.user.UserLoginLogMapper;
import com.biyouche.dao.user.SmsMapper;
import com.biyouche.dao.user.UserMapper;
import com.biyouche.dao.user.UserSurveyMapper;
import com.biyouche.dao.user.UserTokenMapper;
import com.biyouche.domain.user.*;
import com.biyouche.enums.MessageTypeEnum;
import com.biyouche.enums.SmsEnum;
import com.biyouche.exception.BussinessException;
import com.biyouche.message.SmsUtil;
import com.biyouche.redis.prefix.RedisKeyPrefix;
import com.biyouche.utils.CommonUtils;
import com.biyouche.utils.DesUtils;
import com.biyouche.utils.TimeUtils;
import com.biyouche.utils.ValidatorUtils;
import com.biyouche.redis.utils.RedisTempleteUtils;
import com.biyouche.utils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biyouche.dao.BlogTypeMapper;
import com.biyouche.domain.BlogType;
import com.biyouche.rabbitmq.producer.RabbitMQProducer;
import com.biyouche.redis.annotations.Cacheable;
import com.biyouche.redis.enums.ExpireTime;
import com.biyouche.service.UserService;


@Service("userService")
@SuppressWarnings({"unused"})
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String DESKEY = Config.getInstance().getValue("encryption_key");


    @Autowired
    private BlogTypeMapper blogTypeMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SmsMapper smsMapper;

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Autowired
    private UserLoginLogMapper userLoginLogMapper;

    @Autowired
    private UserSurveyMapper userSurveyMapper;

    @Value("${userqueue}")
    String queue;

    @Bean
    Queue queue() {
        return new Queue(queue, false);
    }

    @Autowired
    RabbitMQProducer producer;

    public void sendMsg(String msg) {
        producer.sendTo(queue, msg + " at " + new Date());
    }

    @Cacheable(key = "queryBlogType", expire = ExpireTime.FIVE_MIN)
    public List<BlogType> queryBlogType() {
        sendMsg("rabbitmq test > .....");
        return blogTypeMapper.getAll();
    }

    @RabbitListener(queues = "${userqueue}")
    public void handler(String message) {
        LOGGER.info("Consumer> " + message);
    }


    /**
     * 登录操作
     *
     * @param
     * @param loginMap
     * @autor pht
     */
    @SuppressWarnings("unchecked")
    @Cacheable(key = "login", expire = ExpireTime.FIVE_MIN)
    public Map<String, Object> login(LoginVO loginMap) throws BussinessException {
        sendMsg("rabbitmq 登录操作");
        if (ValidatorUtils.isNull(loginMap)) {
            throw new BussinessException(200002);
        }
        //获取登录手机号
        String userMobile = loginMap.getUser_mobile();
        //校验手机号
        if (!ValidatorUtils.isLoginMobile(userMobile)) {
            throw new BussinessException(200012);
        }
        //获取密码(客户端加密过的密码)
        String userPassword = loginMap.getUser_password();
        //解密
        try {
            //deskey  与客户端约定的密钥
            userPassword = DesUtils.decrypt(userPassword, DESKEY);
        } catch (Exception e) {
            throw new BussinessException(200003);
        }
        //密码校验
        if (!ValidatorUtils.isPassword(userPassword)) {
            throw new BussinessException(200004);
        }
        //通过用户名查询数据库
        User user = userMapper.selectByloginMobile(userMobile);

        //登录校验
        checkLogin(user, userPassword);

        LOGGER.info("用户校验成功,登录成功:" + loginMap);

        //生成令牌信息
        //通行证(令牌)id
        String accessId = CommonUtils.getRandom(userMobile);
        //保存数据key
        String dataKey = CommonUtils.getDesKey();
        //令牌key
        String accessKey = CommonUtils.encodeBase64String(CommonUtils.getRandom(dataKey));
        //设备类型
        int devicePort = Integer.parseInt(loginMap.getDevice_port());
        DeviceTypeEnum enums = DeviceTypeEnum.getEnumType(devicePort);
        //登陆时间
        int loginTime = Integer.parseInt(TimeUtils.getCurrentTimeStamp() + "");
        //将令牌token存入数据库与redis中
        addToken(accessId, accessKey, dataKey, user.getUserId(), enums, loginTime);
        //添加登录日志
        addLoginLog(user, enums, loginTime, loginMap);

        //返回数据
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("access_id", accessId);
        resultMap.put("access_key", accessKey);
        resultMap.put("data_transfer_key", dataKey);
        resultMap.put("user_id", user.getUserId());
        resultMap.put("share_key", CommonUtils.encodeUserToken(accessId));
        resultMap.put("nick_name", user.getNickName());
        resultMap.put("user_level", user.getUserLevel());
        //二维码和头像需要文件服务器地址前缀
        resultMap.put("user_qrcode", user.getUserQrcode());
        resultMap.put("avatar_url", user.getAvatarUrl());
        resultMap.put("user_mobile", user.getLoginMobile());
        return resultMap;
    }

    /**
     * 添加登录日志
     *
     * @param user
     * @param enums
     * @param loginTime
     * @param loginMap
     */
    private void addLoginLog(User user, DeviceTypeEnum enums, int loginTime, LoginVO loginMap) {
        UserLoginLog userLoginLog = new UserLoginLog();
        userLoginLog.setUserId(user.getUserId());
        userLoginLog.setUserMobile(loginMap.getUser_mobile());
        userLoginLog.setDeviceType(enums.KEY);
        userLoginLog.setLoginTime(loginTime);
        //获取ip
        String reqip = loginMap.getReqIp();
        userLoginLog.setLoginIp(reqip);
        //根据ip获取地址
        try {
            userLoginLog.setLoginAreaCode(AddressUtils.getAddresses("ip=" + reqip));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String longitude = loginMap.getLongitude();
        if (!ValidatorUtils.isNull(longitude)) {
            userLoginLog.setLongitude(longitude.length() > 16 ? longitude.substring(0, 16) : longitude);
        }
        if (!ValidatorUtils.isNull(loginMap.getLatitude())) {
            userLoginLog.setLatitude((loginMap.getLatitude().length() > 16) ? loginMap.getLatitude().substring(0, 16) : loginMap.getLatitude());
        }
        userLoginLog.setDeviceId((loginMap.getDevice_id().length() > 32) ? loginMap.getDevice_id().substring(0, 32) : loginMap.getDevice_id());
        userLoginLog.setDeviceOs((loginMap.getDevice_os().length() > 16) ? loginMap.getDevice_os().substring(0, 16) : loginMap.getDevice_os());
        userLoginLog.setDeviceName((loginMap.getDevice_name().length() > 32) ? loginMap.getDevice_name().substring(0, 32) : loginMap.getDevice_name());
        userLoginLog.setClientVersion((loginMap.getClient_version().length() > 16) ? loginMap.getClient_version().substring(0, 16) : loginMap.getClient_version());
        if (!ValidatorUtils.isNull(loginMap.getDevice_detail())) {
            userLoginLog.setDeviceDetail((loginMap.getDevice_detail().length() > 128) ? loginMap.getDevice_detail().substring(0, 128) : loginMap.getDevice_detail());
        }
        userLoginLogMapper.inserLogin(userLoginLog);
        if (!ValidatorUtils.isNull(userLoginLog.getLogId())) {
            LOGGER.info("添加日志成功,开始推送");
            //开始推送
        }
        //登录次数更新
        userMapper.updateLoginNum(TimeUtils.getCurrentTimeStamp(), user.getUserId());


    }

    /**
     * 生成令牌信息
     *
     * @param accessId  令牌id
     * @param accessKey 令牌key
     * @param dataKey   数据key
     * @param userId    用户id
     * @param enums     登录设备
     * @param loginTime 登陆时间
     */
    private void addToken(String accessId, String accessKey, String dataKey, Integer userId, DeviceTypeEnum enums, Integer loginTime) throws BussinessException {
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put("userId", userId + "");
        //先执行登出的动作
        if (DeviceTypeEnum.isApp(enums.KEY)) {
            params.put("devicePort", DeviceTypeEnum.ANDROID.KEY + "");
            logout(params);
            params.put("devicePort", DeviceTypeEnum.IOS.KEY + "");
            logout(params);
        } else {
            params.put("devicePort", enums.KEY + "");
            logout(params);
        }
        //重新添加登录信息
        UserToken userToken = new UserToken();
        userToken.setAccessId(accessId);
        userToken.setAccessKey(accessKey);
        userToken.setDataTransferKey(dataKey);
        userToken.setUserId(userId);
        userToken.setDeviceType(enums.KEY);
        userToken.setLoginTime(loginTime);
        userToken.setLastActionTime(loginTime);
        userToken.setExpireTime(loginTime + ConfigConstant.getInstance().LOGIN_EXPIRE_MINUTE * 60);
        //添加到数据库
        int t = userTokenMapper.insertUserToken(userToken);
        if (t != 1) {
            throw new BussinessException(200005);
        }
        //添加到redis队列中，并设置过期时间
        LinkedHashMap<String, Object> tokenMap = new LinkedHashMap<String, Object>();
        tokenMap.put("share_id", accessId);
        tokenMap.put("access_key", accessKey);
        tokenMap.put("data_transfer_key", dataKey);
        tokenMap.put("user_id", userId);
        tokenMap.put("last_action_time", loginTime);
        RedisTempleteUtils.set(RedisKeyPrefix.USER_TOKEN_PREFIX + accessId, CommonUtils.encodeUserToken(new JSONObject(tokenMap).toString()), ConfigConstant.getInstance().LOGIN_EXPIRE_MINUTE * 60);
    }

    private void logout(Map<String, String> params) {
        Integer userId = Integer.valueOf(params.get("userId"));
        int deviceKey = Integer.parseInt(params.get("devicePort"));
        //查询已存在令牌(通过用户id 和设备类型)
        List<UserToken> userTokens = userTokenMapper.selectLoginToken(userId, deviceKey);
        //不为空就删除
        if (!ValidatorUtils.isEmpty(userTokens)) {
            for (UserToken userToken : userTokens) {
                //redis中删除令牌信息
                RedisTempleteUtils.del(userToken.getAccessId());
            }
        }
        //数据库存在数据并删除
        userTokenMapper.deleteUserToken(userId, deviceKey);
    }

    /**
     * 检查登录
     *
     * @param user
     * @param userPassword
     */
    private void checkLogin(User user, String userPassword) throws BussinessException {
        if (ValidatorUtils.isNull(user) || user.getUserId() == null) {
            throw new BussinessException(200006);
        }
        //校验密码
        if (!CommonUtils.encodeLoginPwd(userPassword).equals(user.getUserPassword())) {
            //密码不正确
            throw new BussinessException(200007);
        }
        //登录状态判断
        if (user.getLoginLock() == UserConstant.LOGIN_LOCK_YES) {
            throw new BussinessException(200008);
        }
        if (user.getLoginLock() == UserConstant.LOGIN_LOCK_DELETED) {
            throw new BussinessException(200009);
        }
        //查询用户是否存在于黑名单
        int count = userMapper.checkUserBlackByuserId(user.getUserId());
        if (count > 0) {
            throw new BussinessException(200010);
        }

    }

    /**
     * 注册
     *
     * @autor hucong
     */
    public int register(String code, String device_type, String pwd, String recommecd_mobile, String user_mobile) throws BussinessException {

        User user = new User();
        int mobileNum = userMapper.selectNumByMobile(user_mobile);
        if (mobileNum > 0) {
            throw new BussinessException(200000);
        }
        //校验手机号格式和非空
        if (ValidatorUtils.isEmpty(user_mobile)) {
            throw new BussinessException(200011);
        }
        if (!ValidatorUtils.isLoginMobile(user_mobile)) {
            throw new BussinessException(200012);
        }

        try {
            pwd = DesUtils.decrypt(pwd, DESKEY);
        } catch (Exception e) {
            throw new BussinessException(200003);
        }

        if (!ValidatorUtils.isPassword(pwd)) {
            throw new BussinessException("200004");
        }
        //更新验证码
        SmsCode code1 = new SmsCode();
        code1.setSmsCode(code);
        code1.setUserMobile(user_mobile);
        code1.setSmsStatus(UserConstant.SMS_STATUS_UNUSE);
        code1.setSmsType(MessageTypeEnum.REGISTER.KEY);
        int count = smsMapper.findCountBySpecificCondition(code1);
        if (count < 1) {
            throw new BussinessException(200019);
        }

        int result = smsMapper.updateUsedBySpecificCondition(UserConstant.SMS_STATUS_USED,
                code, user_mobile, UserConstant.SMS_STATUS_UNUSE, MessageTypeEnum.REGISTER.KEY);
        if (result != 1) {
            throw new BussinessException(200019);
        }
        int recommendId = 0;
        //检验推荐人
        user.setLoginMobile(user_mobile);
        user.setUserPassword(CommonUtils.encodeLoginPwd(pwd));//需要加密
        user.setRecommendMobile(recommecd_mobile);//需要校验
        User user2 = userMapper.selectByloginMobile(recommecd_mobile);
        if (user2 != null) {
            recommendId = user2.getUserId();
        }
        user.setRecommendId(recommendId + "");
        user.setNickName(CommonUtils.getNickName());//生成用户初始化昵称
        user.setDeviceType(Byte.valueOf(device_type));
        user.setAvatarUrl("");
        user.setUserQrcode("");
        LOGGER.info("用户参数" + user);
        userMapper.register(user);
        int i = user.getUserId();
        LOGGER.info("插入数据库返回主键" + i);
        return i;
    }

    /*
     * 验证码发送
     * @param params
     * @autor hucong
     */
    public void send(String user_mobile, String type, String device_type) throws BussinessException {
        //获取参数 用户手机号  验证码类型
        String code = (int) ((Math.random() * 9 + 1) * 1000) + "";
        //校验手机号格式和非空
        if (ValidatorUtils.isEmpty(user_mobile)) {
            throw new BussinessException(200011);
        }
        if (!ValidatorUtils.isLoginMobile(user_mobile)) {
            throw new BussinessException(200012);
        }

        Integer sms_type = 0;
        String type_code = "";//短信验证码发送类型编码
        if (type.equals(SmsEnum.CODE_REGISTER + "")) {
            //注册的话先判断用户是否存在
            int i = userMapper.selectNumByMobile(user_mobile);
            if (i > 0) {
                throw new BussinessException(200000);
            }
            sms_type = 0;//注册验证码
            type_code = SmsEnum.CODE_REGISTER.getCode();
        } else if (type.equals(SmsEnum.CODE_FORGET_PASSWORD + "")) {
            sms_type = 1;//修改密码
            type_code = SmsEnum.CODE_FORGET_PASSWORD.getCode();
        } else {
            sms_type = 2;//验证码
            type_code = SmsEnum.CODE_VALIDCODE.getCode();
        }
        //生成传参对象
        SmsCode coder = new SmsCode();
        coder.setUserMobile(user_mobile);
        coder.setSmsCode(code);
        coder.setSmsType(sms_type);
        coder.setSendNums(1);
        coder.setDeviceType(Integer.parseInt(device_type));
        coder.setReqIp("");
        coder.setCreateTime(TimeUtils.getTimeStampByDate(TimeUtils.getSysdateTimeStart(), TimeUtils.yyyyMMddHHmmss));
        coder.setExpireTime(TimeUtils.getTimeStampByDate(TimeUtils.getSysdateTimeStart(), TimeUtils.yyyyMMddHHmmss)+60);
        //判定当日是否超过次数限制
        Integer sendNum = smsMapper.sendNumToday(coder);
        if (sendNum != null) {
            if (sendNum > SmsConstant.TODAY_NUM_MAX) {
                throw new BussinessException(200001);
            }
        }

        //短信消息不存在，新增发送记录
        int insert = smsMapper.insert(coder);
        int smsId = coder.getSmsId();
        //更新验证码
        if (SmsUtil.send(user_mobile, type_code, code)) {
            smsMapper.updateSendTime(smsId);
        }
    }

    @Transactional
    public void forgetPassword(Map<String, String> params) throws BussinessException {

        //业务校验
        ValidatorUtils.forgetPasswordValid(params);

        //业务处理开始
        String phone = String.valueOf(params.get("phone"));
        String password = String.valueOf(params.get("password"));
        String validCode = String.valueOf(params.get("validCode"));

        password = CommonUtils.encodeLoginPwd(password);

        //验证码处理
        SmsCode code = new SmsCode();
        code.setSmsCode(validCode);
        code.setUserMobile(phone);
        code.setSmsStatus(UserConstant.SMS_STATUS_UNUSE);
        code.setSmsType(MessageTypeEnum.FORGET_PASSWORD.KEY);
        int count = smsMapper.findCountBySpecificCondition(code);
        if (count < 1) {
            throw new BussinessException(200019);
        }

        int result = smsMapper.updateUsedBySpecificCondition(UserConstant.SMS_STATUS_USED,
                validCode, phone, UserConstant.SMS_STATUS_UNUSE, MessageTypeEnum.FORGET_PASSWORD.KEY);
        if (result != 1) {
            throw new BussinessException(200019);
        }

        //更新用户密码信息
        User user = new User();
        user.setLoginMobile(phone);
        user.setUserPassword(password);
        user.setLoginLock(Byte.parseByte(String.valueOf(UserConstant.LOGIN_LOCK_NO)));
        result = userMapper.updatePasswordByLoginMobileAndLoginLock(user);
        if (result != 1) {
            throw new BussinessException(200021);
        }

    }

    @Override
    public UserToken selectToken(String accessId, String deviceType) {
        //从redis中获取
        String token = RedisTempleteUtils.getStr(RedisKeyPrefix.USER_TOKEN_PREFIX + accessId);
        if (ValidatorUtils.isNull(token)) {
            //redis中是空的,直接返回空的
            return null;
        }
        //不为空查询数据库
        return userTokenMapper.selectTokenByAccessId(accessId, deviceType);
    }

    @Override
    public User selectUserById(Integer userId) {

        return userMapper.selectUserById(userId);
    }

    /**
     * 用户驾考需求入录
     *
     * @return
     */
    @Override
    public int userSurvey(String apply_status, String ddriver_type, String driver_purpose, String sex, String user_id) {
        UserSurvey survey = new UserSurvey();
        survey.setUserId(Integer.parseInt(user_id));
        survey.setSex(Integer.parseInt(sex));
        survey.setApplyStatus(Integer.parseInt(apply_status));
        survey.setDriverPurpose(Integer.parseInt(driver_purpose));
        survey.setDdriverType(Integer.parseInt(driver_purpose));
        userSurveyMapper.insert(survey);
        return survey.getSurveyId();
    }


}
