package com.fred.trying.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/crm")
@ParentPackage("struts-default")
@Action(value="testPdfAction")
@Results({
	@Result(name="input" ,location = "pdftest.jsp"),
	@Result(name = "mypdf", type = "stream", params = {"contentType","application/pdf",
			"contentDisposition","inline;filename= ${pdfName}","inputName","pdfStream","encode","true"}),
	@Result(name = "downloadfile", type = "stream", params = { "contentType","application/octet-stream", 
			"contentDisposition","attachment;filename=${downloadFileName}","inputName","inputStream"}),
	@Result(name ="image",type="stream",params ={"contentType","image/jpeg","inputName","inputStream"}),
})
public class TestPdfAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private InputStream inputStream;//下载文件的流
	
	private String downloadFileName;//下载文件的名字
	
	@Override
	public String execute(){
		return INPUT;
	}

	public String showPdf(){
		InputStream in = null;
		try {
			in = new FileInputStream("E://1.pdf");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ActionContext.getContext().getValueStack().set("pdfStream", in);
		ActionContext.getContext().getValueStack().set("pdfName", "发文");//直接放入valuestack中
		return "mypdf";
	}
	
	public String downLoadPdf(){
		downloadFileName = "test.pdf";//采用struts的setget途径
		try {
			inputStream = new FileInputStream("E://1.pdf");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "downloadfile";
	}

	public String showPic(){
		try {
			inputStream = new FileInputStream("E://1.png");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "image";
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getDownloadFileName() {
		return downloadFileName;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}
	
}
