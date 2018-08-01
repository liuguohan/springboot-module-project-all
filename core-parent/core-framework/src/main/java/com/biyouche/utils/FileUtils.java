package com.biyouche.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.biyouche.constants.Constants;

public class FileUtils {
	private final static Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);
	
	private static final int BUFFERSIZE = 8196;
	private static final String CHARSETNAME = Constants.UTF8;
	
	public static FileUtils getInstance(){
		return new FileUtils();
	}
	
	public void writeFile(String fileName, InputStream inputStream){

		if (inputStream == null) {
			return ;
		}

		File file = new File(fileName);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}

		OutputStream outputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
//		MessageDigest md = null;
		try {
			byte[] buffer = new byte[BUFFERSIZE];
			int count = 0;
			outputStream = new FileOutputStream(file);

			bufferedInputStream = new BufferedInputStream(inputStream, BUFFERSIZE);
			bufferedOutputStream = new BufferedOutputStream(outputStream, BUFFERSIZE);
//			md = MessageDigest.getInstance("MD5");

			while ((count = bufferedInputStream.read(buffer)) != -1) { // >0
				bufferedOutputStream.write(buffer, 0, count);
//				md.update(buffer, 0, count);
			}

			buffer = null;
			bufferedOutputStream.flush();
//			return StringUtils.byte2hex(md.digest());
		} catch (Exception e) {
			LOGGER.error("writeFile error",e);
			return ;
		} finally {
			closeStream(bufferedOutputStream);
			closeStream(outputStream);
			closeStream(bufferedInputStream);
			closeStream(inputStream);
		}
	}
	
	public String readFile(InputStream is,Charset cs) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(is,cs));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = in.readLine()) != null) {
			buffer.append(line);
		}
		String result =  buffer.toString();
		if(is!=null){
			is.close();
		}
		return result;
	}
	
	public void closeStream(OutputStream bufferedOutputStream) {

		if(bufferedOutputStream != null) {
			try {
				bufferedOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
				LOGGER.error("close",e);
			}
			bufferedOutputStream = null;
		}
	}
	
	public void closeStream(InputStream bufferedOutputStream) {

		if(bufferedOutputStream != null) {
			try {
				bufferedOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
				LOGGER.error("close",e);
			}
			bufferedOutputStream = null;
		}
	}
	
	public String generateContent(InputStream inputStream) {

		if (inputStream == null) {
			return null;
		}

		BufferedInputStream bufferedInputStream = null;

		StringBuffer content = new StringBuffer();

		try {
			byte[] buffer = new byte[BUFFERSIZE];
			int count = 0;

			bufferedInputStream = new BufferedInputStream(inputStream, BUFFERSIZE);

			while ((count = bufferedInputStream.read(buffer)) != -1) { // >0
				content.append(new String(buffer, 0, count, CHARSETNAME));
			}

			buffer = null;

			return content.toString();
		} catch (Exception e) {
			LOGGER.error("generateContent error",e);
			return null;
		} finally {
			closeStream(bufferedInputStream);
			closeStream(inputStream);
		}
	}
	
	public long getFileLength(String filename) {

		File file = new File(filename);
		if (file.isFile() && file.exists()) {
			return file.length();
		}

		return 0L;
	}
	

	public void deleteFile(File file){	
		if(file.exists()){
			file.delete();
		}
	}

	public String readFileToString(String file) throws IOException {
		return readFileToString(file,Charset.forName(CHARSETNAME));
	}
	
    public String readFileToString(String file, Charset cs) throws IOException {
    	InputStream in = new FileInputStream(file);
    	return readFile(in,cs);
    }
    
    public void writeStringToFile(String str,String file){
    	ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
    	writeFile(file,stream);    	
    }
    public String getFileMD5(File file){
        BufferedInputStream bufferedInputStream = null;
        MessageDigest md;
		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream(file), BUFFERSIZE);
			md = MessageDigest.getInstance("MD5");
			byte[] buffer = new byte[BUFFERSIZE];
	        int i = 0;
	        while((i = bufferedInputStream.read(buffer)) != -1){
	       	 md.update(buffer, 0, i);
	       }
	        return StringUtils.byte2hex(md.digest());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				bufferedInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
}
