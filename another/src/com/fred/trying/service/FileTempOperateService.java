package com.fred.trying.service;

import java.io.File;

/**
 * 临时文件上传的服务
 * @author Administrator
 *
 */
public interface FileTempOperateService {

	public boolean delFile(String fileName);

	/**
	 * 将文件上传到服务器临时文件夹中。
	 * @param from
	 * @return 新文件的文件名。
	 */
	public String fileCopy(File from, String importFileName);
	
	/**
	 * 向临时文件夹中写文件
	 * @param data
	 * @param filename
	 * @return
	 */
	public File writeTempFile(byte[] data,String filename);

}
