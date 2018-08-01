package com.biyouche.utils;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.PutObjectResult;
import com.biyouche.config.PropertiesConfig;

public class OssUtils {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(OssUtils.class);
	

	/**
	 * 上传协议书
	 * @param fileName 临时PDF文件名(标ID、投资ID)
	 * @param fileMd5 文件MD5值
	 * @param tenderId 投资ID
	 */
	public static boolean upload(File file,String key){
		
		String ptebucketName = PropertiesConfig.getProperties("aliyun", "bucket");
		String endpoint = PropertiesConfig.getProperties("aliyun", "endpoint");
		String accessid = PropertiesConfig.getProperties("aliyun", "accessid");
		String accesskey = PropertiesConfig.getProperties("aliyun", "accesskey");

		OSSClient client = new OSSClient(endpoint,accessid,accesskey);
		boolean exists = client.doesBucketExist(ptebucketName);
		LOGGER.info("阿里云OSS信息:"+ptebucketName+"\t"+endpoint+"\t exists:"+exists);
		if (!exists) {
			client.createBucket(ptebucketName);
			client.setBucketAcl(ptebucketName, CannedAccessControlList.PublicRead);
		}
	
		try {
			String fileMd5 = FileUtils.getInstance().getFileMD5(file);
			PutObjectResult result = client.putObject(ptebucketName, key, file);
			LOGGER.info("fileMd5 >> " + fileMd5);
			String md5 = result.getETag();
			if (!md5.trim().toLowerCase().equals(fileMd5.trim().toLowerCase())) {
				LOGGER.error("阿里云上传文件:"+file.getName()+"失败,文件md5值:"+fileMd5.trim().toLowerCase()+",阿里云返回MD5值:"+md5.trim().toLowerCase());
				client.deleteObject(ptebucketName, key);
				return false;
			}
			return true;
		} catch (Exception e) {
			LOGGER.error("阿里云上传文件:"+file.getName()+"失败",e);
			e.printStackTrace();
			return false;
		}finally{
			if(client!=null){
				client.shutdown();
				client = null;
			}
			//删除本地文件
			FileUtils.getInstance().deleteFile(file);
		}
	}

}
