package com.biyouche.utils;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.biyouche.constants.ConfigConstant;
import com.biyouche.enums.OssKeyEnum;
import com.biyouche.exception.BussinessException;

public class ImageUtil {

	private final static Logger LOGGER = LoggerFactory.getLogger(ImageUtil.class);

	public static String upload(Integer id,OssKeyEnum enums, MultipartFile f) {
		
		String tempFile = ConfigConstant.getInstance().PIC_TEMP_PATH + id +"_"+System.currentTimeMillis();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			LOGGER.error(" 线程睡眠失败异常",e);
			e.printStackTrace();
		}
		try {
			FileUtils.getInstance().writeFile(tempFile, f.getInputStream());
		} catch (IOException e1) {
			LOGGER.error(" 创建临时文件失败",e1);
			e1.printStackTrace();
			FileUtils.getInstance().deleteFile(new File(tempFile));
			throw new BussinessException(200202);
		}
		//上传到阿里云
		String fileName = OssKeyEnum.getKey(enums);
		File file = new File(tempFile);
		boolean flag = OssUtils.upload(file, fileName);
		if( !flag ){
			throw new BussinessException();
		}
		return fileName;
	}
	
}
