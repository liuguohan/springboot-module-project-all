package com.biyouche.enums;

import java.util.Calendar;
import java.util.Date;

import com.biyouche.utils.CommonUtils;
import com.biyouche.utils.TimeUtils;

public enum OssKeyEnum {
	
	COMMUNITY_THEME("community_theme","社区话题"),
	COMMUNITY_REPLY("community_reply","社区回复");
	
	public String CODE = "";
	public String REMARK = "" ;
	
	OssKeyEnum(String code,String remark){
		CODE = code ;
		REMARK = remark ;
	}
	
	public static OssKeyEnum getKey(String picType){
		OssKeyEnum[] enums = OssKeyEnum.values();
		for (OssKeyEnum ossKeyEnum : enums) {
			if(picType.equals(ossKeyEnum.CODE)){
				return ossKeyEnum;
			}
		}
		return null;
	}
	
	public static String getKey(OssKeyEnum enums){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int year =  cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int days = cal.get(Calendar.DAY_OF_MONTH);
		return enums.CODE+"/"+year+"/"+month+"/"+days+"/"+TimeUtils.getSysTime("HHmmss")+CommonUtils.getRandom(999999999)+".data";
	}
	
}
