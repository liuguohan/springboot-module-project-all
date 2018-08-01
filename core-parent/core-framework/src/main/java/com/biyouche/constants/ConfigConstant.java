package com.biyouche.constants;

import com.biyouche.config.PropertiesConfig;

import java.util.Random;

/**
 * 配置型常量
 *
 * @author Administrator
 */
public class ConfigConstant {

    private String cate = "business";

    private String sms = "sms";
    
    private String aliyun = "aliyunoss";


    public static ConfigConstant getInstance() {
        return new ConfigConstant();
    }
    
    //图片信息
  	public String PIC_TEMP_PATH  = PropertiesConfig.getProperties("config.properties", "pic_temp_path");//保存临时目录
  	public String PIC_URL_PREFIX = PropertiesConfig.getProperties(aliyun, "oss_prefix");//链接前缀

    //短信验证码防刷次数
    public int SMS_REFRESH_IP_NUMS = Integer.valueOf(PropertiesConfig.getProperties(cate, "SMS_REFRESH_IP_NUMS"));

    //短信验证码当天发送最大限制
    public int SMS_SEND_MAX = Integer.valueOf(PropertiesConfig.getProperties(sms, "TODAY_NUM_MAX"));

    //短信验证码有效期
    public int SMS_EXPIRE_TERM = Integer.valueOf(PropertiesConfig.getProperties(sms, "SEND_TIME"));


    //登录过期时间
    public int LOGIN_EXPIRE_MINUTE = Integer.valueOf(PropertiesConfig.getProperties(cate, "LOGIN_EXPIRE_MINUTE"));


    //官方微信
    public String WECHAT_OFFICIAL = PropertiesConfig.getProperties(cate, "WECHAT_OFFICIAL");//  1档递增

    //客服电话
    public String CUSTOME_TELEPHONE = PropertiesConfig.getProperties(cate, "CUSTOME_TELEPHONE");//  1档递增

    //开卡支付金额(120元)
    public Double CARD_PAY_AMOUNT = Double.parseDouble(PropertiesConfig.getProperties(cate, "PAY_AMOUNT"));


    //消息发送时间
    public String MESSAGE_SEND_TIME = PropertiesConfig.getProperties(cate, "MESSAGE_SEND_TIME");
    //联系电话
    public String PHONE_CONTACT = PropertiesConfig.getProperties(cate, "PHONE_CONTACT");
    //管理电话
    public String PHONE_MANAGE = PropertiesConfig.getProperties(cate, "PHONE_MANAGE");

    public String random() {
        Random random = new Random();
        int result = random.nextInt(10);
        if (result == 0) {
            result = 1;
        }
        return (result / 100.0) + "";
    }

    public boolean TESTING = ("product".equals(PropertiesConfig.getProperties("config", "environment"))) ? false : true;


}
