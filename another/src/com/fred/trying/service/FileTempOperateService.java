package com.fred.trying.service;

import java.io.File;

/**
 * ��ʱ�ļ��ϴ��ķ���
 * @author Administrator
 *
 */
public interface FileTempOperateService {

	public boolean delFile(String fileName);

	/**
	 * ���ļ��ϴ�����������ʱ�ļ����С�
	 * @param from
	 * @return ���ļ����ļ�����
	 */
	public String fileCopy(File from, String importFileName);
	
	/**
	 * ����ʱ�ļ�����д�ļ�
	 * @param data
	 * @param filename
	 * @return
	 */
	public File writeTempFile(byte[] data,String filename);

}
