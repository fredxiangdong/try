package com.fred.trying.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.json.annotations.JSON;

import com.fred.trying.entity.User;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/crm")
@Action(value ="gsonAction")
@ParentPackage("json-default")
@Results({
	@Result(name ="input", location ="gson.jsp"),
	@Result(name = "jsontest", type = "json", params = { "includeproperties", "rows.*,total" })
})
public class GsonAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	List<User> rows = new ArrayList<User>();
	private String total ="2";
	private String gsonStr = "{\"userId\":\"1\",\"userName\":\"׷��\",\"name\":\"��ľ\",\"sex\":\"��\",\"department\":\"�Ͼ�\"}";
	HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	
	public String execute(){
		return INPUT;
	}
	
	public String testGson(){
		User u1 = new User("1","׷��","��ľ","��","�Ͼ�");
		User u2 = new User("2","��ʱ","����","��","��̨");
		rows.add(u1);
		rows.add(u2);
		
/*		Gson gson = new Gson();
		gsonStr = gson.toJson(rows);
		System.out.println(gsonStr);*/
		
/*		����@Result(type="json")��ʽ����ʱ,����GSONת��һ�飬���򣬷���ʱtypeΪJSON��ת������
		Ч����testGson2�ж��Ѿ�ת��JSON�����ٴ�תJSON
		{"userId":"1","userName":"׷��","name":"��ľ","sex":"��","department":"�Ͼ�"}
		"{\"userId\":\"1\",\"userName\":\"׷��\",\"name\":\"��ľ\",\"sex\":\"��\",\"department\":\"�Ͼ�\"}"*/
		
		return "jsontest";
	}
	
	public void testGson2(){
		response.setCharacterEncoding("UTF-8");
		User u1 = new User("2","��ʱ","����","��","��̨");
		Gson gson = new Gson();
		gsonStr = gson.toJson(u1);
//		String gsonStr2 = gson.toJson(gsonStr);
		System.out.println(gsonStr);
		try {
			PrintWriter out = response.getWriter();
			out.println(gsonStr);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testAjaxData(){
		response.setCharacterEncoding("UTF-8");
		System.out.println(gsonStr);
		Gson gson = new Gson();
		User u = gson.fromJson(gsonStr, User.class);
		System.out.println(u.getUserName());
		try {
			PrintWriter out = response.getWriter();
			out.println(u.getUserName());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testCNfonts(){
		try {
			//ǰ̨���ݵĺ��ֽ��н���
			gsonStr = URLDecoder.decode(gsonStr, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
//		web.xml��������encodingFilter��������ʡȥ�����response.setCharacterEncoding,��������һ����������������
//		response.setCharacterEncoding("UTF-8");
		
		System.out.println(gsonStr);
		try {
			PrintWriter out = response.getWriter();
			out.println(gsonStr);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@JSON(serialize = false)
	//ʹ��serialize Ϊ false�򷵻�jsonΪroot��ʱ���践��
	public String getGsonStr() {
		return gsonStr;
	}

	public void setGsonStr(String gsonStr) {
		this.gsonStr = gsonStr;
	}

	public List<User> getRows() {
		return rows;
	}

	public void setRows(List<User> rows) {
		this.rows = rows;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
