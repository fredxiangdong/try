package com.fred.trying.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.fred.common.UUIDGenerator;
import com.fred.trying.service.FileTempOperateService;


@Component("fileTempOperateService")
public class FileTempOperateServiceImpl implements FileTempOperateService {

	private static final int BUFFER_SIZE = 16 * 1024;

	public boolean delFile(String fileName) {
		boolean flag = false;
		try {
			File toFile = new File(getTempFilePath() + fileName);
			if (toFile.exists()) {
				toFile.delete();
			}
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	private String getTempFilePath() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationPath.xml");
		return  ((Map<String,String>)context.getBean("appExtConfig")).get("filePath");
	}

	public String fileCopy(File importFile, String importFileName) {
		if (importFile == null)
			return "";
		String fileType = importFileName.substring(importFileName.lastIndexOf("."));
		String toSrc = UUIDGenerator.generate() + fileType;
		String path = "";
		File to = null;
		path = getTempFilePath() + "";
		if (toSrc.indexOf(".") > 0) {
			to = new File(path + toSrc);
		}
		this.fileCopy(importFile, to);
		return toSrc;
	}

	private void fileCopy(File from, File to) {
		if (from != null && from.exists()) {
			try {
				InputStream in = null;
				OutputStream out = null;
				try {
					in = new BufferedInputStream(new FileInputStream(from), BUFFER_SIZE);
					out = new BufferedOutputStream(new FileOutputStream(to), BUFFER_SIZE);
					int byteread = 0;
					byte[] buffer = new byte[BUFFER_SIZE];
					while ((byteread = in.read(buffer)) > 0) {
						out.write(buffer, 0, byteread);
					}
				} finally {
					if (null != in) {
						in.close();
					}
					if (null != out) {
						out.close();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public File writeTempFile(byte[] data, String filename) {
		String path = this.getTempFilePath()+ filename;
		File outFile = new File(path);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outFile);
			fos.write(data);
			return new File(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if(fos!=null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}

