package com.biyouche.third.ip;

import com.alibaba.fastjson.JSON;
import com.biyouche.redis.enums.RedisKeyEnum;
import com.biyouche.utils.JSONUtils;
import com.biyouche.utils.ValidatorUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class IpUtils {
	protected static final Log logger = LogFactory.getLog(IpUtils.class);
	
	//数美请求
	public static String convert(String ip) {
		//判断redis中是否有ip，有的话直接返回
//		RedisUtil util = RedisUtil.getJedisUtils(RedisEnum.DATA);
//		String info = util.getHashKey(RedisKeyEnum.LOGINIP_LIB.KEY, ip);
//		if(ValidatorUtils.isNotNull(info)){
//			return info;
//		}
		String code = convertReal(ip);
		if(ValidatorUtils.isNotNull(code)){
//			util.setHashKey(RedisKeyEnum.REFRESH.KEY, ip, code);
			return code;
		}
		return "";
	}
	
	public static String convertReal(String ip){
		String str = null;
		try {
			URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip="+ip);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setConnectTimeout(5000);
			con.setReadTimeout(6000);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();
			int code=con.getResponseCode();
			if (code != 200) {
				return "";
			}
			str = formatIsToString(con.getInputStream(),"utf-8");
			logger.info("ip:"+ip+" 返回信息:"+str);
			Map<String, String> contentMap = JSON.parseObject(str,Map.class);
			int resultCode = Integer.valueOf(contentMap.get("code"));
			if(resultCode!=0){
				return "0";
			}
			Map<String, String> dataMap = JSON.parseObject(contentMap.get("data"),Map.class);
			if(!"-1".equals(dataMap.get("county_id"))){
				return dataMap.get("county_id");
			}
			if(!"-1".equals(dataMap.get("city_id"))){
				return dataMap.get("city_id");
			}
			if(!"-1".equals(dataMap.get("region_id"))){
				return dataMap.get("region_id");
			}
		} catch (Exception e) {
			logger.info("IP转换("+ip+")失败,请求失败:",e);
			return "";
		}
		return "";
	}
	
	public static String formatIsToString(InputStream is,String decode) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int len = -1;
		try {
			while ((len = is.read(buf)) != -1) {
				baos.write(buf, 0, len);
			}
			baos.flush();
			baos.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(baos.toByteArray(), decode);
	}

	public static void main(String[] args) {		
		System.out.println("返回值："+convert("183.128.184.94"));
		System.out.println("返回值："+convert("223.94.80.204"));
		System.out.println("返回值："+convert("117.136.31.222"));
		System.out.println("返回值："+convert("192.168.31.79"));
		System.out.println("返回值："+convert("0:0:0:0:0:0:0:1"));
	}
}
