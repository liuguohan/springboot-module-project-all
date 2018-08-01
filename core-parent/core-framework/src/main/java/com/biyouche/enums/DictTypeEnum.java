package com.biyouche.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 字典类型表枚举(参考dict_type表)
 * @author lgh
 *
 */
public enum DictTypeEnum {
	
	SEARCH_RECOMMAND("search_recommand", "搜索标签"),
	NEEDS_FACTOR("needs_factor", "学车需求因素"),
	DRIVING_LICENSE_TYPE("driving_license_type", "驾驶证类型"),
	NEEDS_CANCEL_REASON("needs_cancel_reason", "学车需求取消原因"),
	COMMUNITY_TOPIC_LABEL("community_topic_label", "社会话题标签");
	
	public String KEY;
	public String REMARK;
	
	DictTypeEnum(String key, String remark) {
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
