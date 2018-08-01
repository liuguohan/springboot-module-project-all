package com.biyouche.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 短信类型
 * @author lgh
 *
 */
public enum MessageTypeEnum {

	REGISTER(0, "注册"),
	
	FORGET_PASSWORD(1, "忘记密码");
	
	public int KEY;
	public String REMARK;
	
	MessageTypeEnum(int key, String remark) {
		this.KEY = key;
		this.REMARK = remark;
	}
	
	public static Map<Integer, String> getMap(){
		Map<Integer, String> resultMap = new LinkedHashMap<Integer, String>();
		for (MessageTypeEnum enums : MessageTypeEnum.values()) {
			resultMap.put(enums.KEY, enums.REMARK);
		}
		return resultMap;
	}
	public static boolean validator(String type){
		for (MessageTypeEnum enums : MessageTypeEnum.values()) {
			if(enums.KEY==Integer.valueOf(type)){
				return true;
			}
		}
		return false;
	}

	public static Object getValue(String key) {
		for (MessageTypeEnum enums : MessageTypeEnum.values()) {
			if(enums.KEY==Integer.valueOf(key)){
				return enums.REMARK;
			}
		}
		return "";
	}
	
}
