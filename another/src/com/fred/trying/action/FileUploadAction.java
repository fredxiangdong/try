package com.fred.trying.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
  
@Namespace("/crm")
@ParentPackage("struts-default")
@Action( value ="fileUploadAction")
@Results({
	@Result( name = "input", location ="swfupload.jsp")
})
public class FileUploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private File file;
	private String fileFileName;
	private String fileContentType;

	@SuppressWarnings("unchecked")
	public String fileUpload() throws Exception {
		InputStream is = new FileInputStream(file);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationPath.xml");
		String root = ((Map<String,String>)context.getBean("appExtConfig")).get("filePath");
		File destFile = new File(root,this.getFileFileName());
		OutputStream os = new FileOutputStream(destFile);
		byte[] bytefer = new byte[1024];
		int length = 0;
		while((length = is.read(bytefer)) != -1){
			os.write(bytefer, 0, length);
		}
		os.close();
		is.close();
		return INPUT;
	}
	
	@Override
	public String execute(){
		return INPUT;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}
