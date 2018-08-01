package com.biyouche.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.biyouche.dao.user.UserMapper;
import com.biyouche.domain.apply.InsuranceOrder;
import com.biyouche.domain.user.User;
import com.biyouche.exception.BussinessException;
import com.biyouche.springboot.SpringContext;


public class ValidatorUtils {
	
//	private static final Log log = LogFactory.getLog(ValidatorUtils.class);

	public static boolean isEmpty(String str) {

		return ((str == null) || (str.trim().length() == 0));
	}
	
	public static boolean isNotEmpty(String str) {
		if(str==null){
			return false;
		}

		return ((str != null) && (str.trim().length() > 0)&&!"null".equals(str.trim()));
	}
	
	public static boolean isNotEmpty(@SuppressWarnings("rawtypes") Map result){
		if(result!=null&&!result.isEmpty()&&result.size()>0){
			return true;
		}
		return false;
	}
	
	public static boolean isEmpty(@SuppressWarnings("rawtypes") Map result){		
		return !isNotEmpty(result);
	}
	
	public static boolean isNotEmpty(@SuppressWarnings("rawtypes") List result){
		if(result!=null&&!result.isEmpty()&&result.size()>0){
			return true;
		}
		return false;
	}
	
	public static boolean isEmpty(@SuppressWarnings("rawtypes") List result){		
		return !isNotEmpty(result);
	}
	
	public static boolean isNotEmpty(@SuppressWarnings("rawtypes") Set result){
		if(result!=null&&!result.isEmpty()&&result.size()>0){
			return true;
		}
		return false;
	}
	
	public static boolean isEmpty(@SuppressWarnings("rawtypes") Set result){		
		return !isNotEmpty(result);
	}

	public static boolean isNotNull(String str) {
		if (str == null) {
			return false;
		}
		return ((str != null) && (str.trim().length() > 0) && !"null"
				.equals(str.trim()));
	}
	
	public static boolean isNotNull(Object obj){
		if(obj==null){
			return false;
		}
		return isNotNull(obj+"");
	}
	
	public static boolean isNull(Object obj){
		return !isNotNull(obj);
	}

	public static boolean isNull(String str) {
		return !isNotNull(str);
	}
	
	public static boolean isNotNull(Integer str) {
		if (str == null) {
			return false;
		}
		return true;
	}

	public static boolean isNull(Integer str) {
		return !isNotNull(str);
	}
	
	public static boolean isNotNull(Long str) {
		if (str == null) {
			return false;
		}
		return true;
	}

	public static boolean isNull(Long str) {
		return !isNotNull(str);
	}
	
	public static boolean isNotNull(Date str) {
		if (str == null) {
			return false;
		}
		return true;
	}

	public static boolean isNull(Date str) {
		return !isNotNull(str);
	}
	

	public static boolean isBlank(String str) {

		int length = 0;

		if ((str == null) || ((length = str.length()) == 0)) {
			return true;
		}

		for (int i = 0; i < length; i++) {
			if (Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}

		return false;
	}

	public static boolean checkString(String str, String regex) {

		return str.matches(regex);
	}
	
	public static boolean isMd5(String md5) {

		if (md5.length() != 32) {
			return false;
		}

		return checkString(md5, "[0-9A-Fa-f]+");
	}

	public static boolean isLoginMobile(String code){
		code = StringUtils.nullToStrTrim(code);
		if(isNull(code)){
			return false;
		}
		if(code.length() != 11) {
			return false;
		}
		String regex = "^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}|17[0-9]{9}$|18[0-9]{9}$";

		boolean flg =  code.matches(regex);
		if(!flg){
			return false;
		}
		return true;
	}

	public static boolean isPassword(String password){
		password = StringUtils.nullToStrTrim(password);
		if(password.length()<6||password.length()>20){
			return false;
		}
		return true;
	}

	public static String nullToStrTrim(String str) {
		if (str == null) {
			str = "";
		}
		return str.trim();
	}
	
	public static boolean isInfoCode(String code) {

		code = nullToStrTrim(code);
    	if(code.length() != 6) {
    		return false;
    	}

    	String regex = "^([1-9])\\d{5}$";

    	return code.matches(regex);
	}
	
	/**
	 * 校验身份证长度
	 * @author lgh
	 * @param cardNo
	 * @return
	 */
	public static boolean isCardNoLength(String cardNo) {
		
		cardNo = nullToStrTrim(cardNo);
		cardNo = cardNo.replaceAll(" ", "");
		if(cardNo.length() == 15 || cardNo.length() == 18) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断是否是姓名
	 * @author lgh
	 * @param name
	 * @return
	 */
	public static boolean isRealName(String name) {
		
		name = nullToStrTrim(name);
		name = name.replaceAll(" ", "");
    	String regex = "^[\u4e00-\u9fa5]{2,20}$";
    	return name.matches(regex);
	}
	
	/**
	 * 手机号脱敏（例：18245671234 脱敏后返回 182****1234）
	 * @author lgh
	 * @param code
	 * @return
	 */
	public static String mobileEncrypt(String mobilePhone) {

		if( isEmpty(mobilePhone) || mobilePhone.length() != 11 ) {
			return mobilePhone;
		}
		
		mobilePhone = nullToStrTrim(mobilePhone);
    	return mobilePhone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
	}
	
	/**
	 * 验证码校验（四位且纯数字）
	 * @author lgh
	 * @param code
	 * @return
	 */
	public static boolean isFourValidCode(String code) {

		code = nullToStrTrim(code);
    	String regex = "^\\d{4}$";
    	return code.matches(regex);
	}
	
	/**
	 * 身份证脱敏
	 * @author lgh
	 * @param cardNo
	 * @return
	 */
	public static String encryptCardNo(String cardNo) {
		
		cardNo = nullToStrTrim(cardNo);
    	
		if( cardNo.length() == 15 ) {
			return cardNo.substring(0, 6) + "****" + cardNo.substring(8);
		}
		
		if( cardNo.length() == 18 ) {
			return cardNo.substring(0, 6) + "****" + cardNo.substring(10);
		}
		
		return cardNo;
	}
	
	/**
	 * 根据身份证判断性别
	 * @param cardNo
	 * @author lgh
	 * @return
	 */
	public static String getSexByCardNo(String cardNo) {

		cardNo = nullToStrTrim(cardNo);
    	
		if( cardNo.length() == 15 ) {
			return Integer.parseInt(cardNo.substring(14))%2 != 0?"男":"女";
		}
		
		if( cardNo.length() == 18 ) {
			return Integer.parseInt(cardNo.substring(16,17))%2 != 0?"男":"女";
		}
		
		return "无法识别";
	}
	
	/**
	 * 根据身份证判断出生日期
	 * @param cardNo
	 * @author lgh
	 * @return
	 */
	public static String getBirthDayByCardNo(String cardNo) {

		cardNo = nullToStrTrim(cardNo);
		String birthday = null;
		if( cardNo.length() == 15 ) {
			birthday = "19" + cardNo.substring(6, 12);
		}
		if( cardNo.length() == 18 ) {
			birthday = cardNo.substring(6, 14);
		}
		
        
        Date birthdate;
		try {
			birthdate = new SimpleDateFormat("yyyyMMdd").parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new BussinessException(100003);
		}  
        GregorianCalendar currentDay = new GregorianCalendar(); 
        currentDay.setTime(birthdate);
        int year = currentDay.get(Calendar.YEAR);
        int month = currentDay.get(Calendar.MONTH) + 1;
        int day = currentDay.get(Calendar.DAY_OF_MONTH);
        return year + "-" + month + "-" + day;
	}
	
	/**
	 * 根据身份证判断年龄
	 * @param cardNo
	 * @author lgh
	 * @return
	 */
	public static int getAgeByCardNo(String cardNo) {

		cardNo = nullToStrTrim(cardNo);
		String birthday = null;
		if( cardNo.length() == 15 ) {
			birthday = "19" + cardNo.substring(6, 12);
		}
		if( cardNo.length() == 18 ) {
			birthday = cardNo.substring(6, 14);
		}
		
        
        Date birthdate;
		try {
			birthdate = new SimpleDateFormat("yyyyMMdd").parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new BussinessException(100003);
		}  
        GregorianCalendar currentDay = new GregorianCalendar(); 
        currentDay.setTime(birthdate);
        int year = currentDay.get(Calendar.YEAR);
    	
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy");
        String currYear=simpleDateFormat.format(new Date());
        return Integer.parseInt(currYear)-year;

	}
	
	/**
	 * 判断是否若密码
	 * @param key
	 * @throws EduException
	 */
	public static boolean isWeakPassword(String key) {
		List<String> list = new ArrayList<String>();
		list.add("00000000");
		list.add("11111111");
		list.add("12345678");
		list.add("87654321");
		list.add("66666666");
		list.add("88888888");
		list.add("abcdefgh");
		list.add("abcdabcd");
		list.add("abcd1234");
		list.add("a1b2c3d4");
		list.add("aaaa1111");
		list.add("1234qwer");
		list.add("qwertyui");
		list.add("qwerasdf");
		list.add("administrator");
		list.add("password");
		list.add("p@ssword");
		list.add("iloveyou");
		list.add("52013140");
		list.add("12341234");
		list.add("12344321");
		if(list.contains(key.toLowerCase())){
			return true;
		}
		return false;
	}
	
	/**
	 * 忘记密码校验
	 * @author lgh
	 * @param params
	 */
	public static void forgetPasswordValid(Map<String, String> params) throws BussinessException {
    	
    	String phone = String.valueOf( params.get("phone") );
    	String password = String.valueOf( params.get("password") );
    	String validCode = String.valueOf( params.get("validCode") );
    	
    	//手机号校验
    	if( !ValidatorUtils.isLoginMobile(phone) ) {
    		
    		throw new BussinessException(200012);	
    	}
    	UserMapper userMapper = SpringContext.getBean(UserMapper.class);
    	User user = userMapper.selectByloginMobile(phone);
    	if( ValidatorUtils.isNull(user) ) {
    		
    		throw new BussinessException(200016);
    	}
    	
    	//新密码校验
    	if( !ValidatorUtils.isPassword(password) ) {
    		
    		throw new BussinessException(200004);
    	}
    	if( ValidatorUtils.isWeakPassword(password) ) {
    		
    		throw new BussinessException(200017);
    	}
    	
    	if( user.getUserPassword().equals(CommonUtils.encodeLoginPwd(password)) ) {
    		
    		throw new BussinessException(200020);
    	}
    	
    	//验证码校验
    	if( !ValidatorUtils.isFourValidCode(validCode) ) {
    		
    		throw new BussinessException(200018);
    	}
	}
	
	/**
	 * 学车保险订单校验
	 * @author lgh
	 * @param order
	 */
	public static void insuranceOrderValid(InsuranceOrder order) {
		
		String userName = order.getUserName();
		String mobilePhone = order.getMobilePhone();
		String cardNo = order.getCardNo();
		
		if( ValidatorUtils.isEmpty(userName) ) {
			throw new BussinessException(210014);
		}
		if( ValidatorUtils.isRealName(userName) ) {
			throw new BussinessException(210015);
		}
		if( ValidatorUtils.isEmpty(mobilePhone) ) {
			throw new BussinessException(200011);
		}
		if( ValidatorUtils.isLoginMobile(mobilePhone) ) {
			throw new BussinessException(200012);
		}
		if( ValidatorUtils.isEmpty(cardNo) ) {
			throw new BussinessException(210016);
		}
		if( ValidatorUtils.isCardNoLength(cardNo) ) {
			throw new BussinessException(210017);
		}
	}
	
	public static void communityTopicUserInfoValid(Integer userId) {
		
		UserMapper userMapper = SpringContext.getBean(UserMapper.class);
		User user = userMapper.selectUserById(userId);
		String nickName = user.getNickName();
		String avatarUrl = user.getAvatarUrl();
		
		//校验用户昵称和头像
		if( ValidatorUtils.isEmpty( nickName )) {
			throw new BussinessException(230025);
		}
		if( ValidatorUtils.isEmpty( avatarUrl )) {
			throw new BussinessException(230026);
		}
	}
	
	
}
