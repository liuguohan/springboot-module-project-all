package com.biyouche.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 首页搜索标签枚举
 * @author lgh
 *
 */
public enum SearchLabelEnum {
	
	NONE(-1, "无"),
	DISTANCE(0, "距离最近"),
	SCORE(1, "评分最高"),
	PRICE(2, "价格最低"),
	RECOMMAND(3, "推荐驾校"),
	INDEMNITY(4, "学车保障"),
	CREDIT(5, "信用学车");
	
	public int KEY;
	public String REMARK;
	
	SearchLabelEnum(int key, String remark) {
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
