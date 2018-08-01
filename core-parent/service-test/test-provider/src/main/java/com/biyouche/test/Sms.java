package com.biyouche.test;

import com.biyouche.enums.SmsEnum;
import com.biyouche.message.SmsUtil;

public class Sms {
	public static void main(String[] args) {
		boolean send = SmsUtil.send("", SmsEnum.CODE_REGISTER.getCode(), "1234");
		System.out.println(send);
	}

}
