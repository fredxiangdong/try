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
	private String gsonStr = "{\"userId\":\"1\",\"userName\":\"追梦\",\"name\":\"易木\",\"sex\":\"男\",\"department\":\"南京\"}";
	HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	
	public String execute(){
		return INPUT;
	}
	
	public String testGson(){
		User u1 = new User("1","追梦","易木","男","南京");
		User u2 = new User("2","有时","东方","男","烟台");
		rows.add(u1);
		rows.add(u2);
		
/*		Gson gson = new Gson();
		gsonStr = gson.toJson(rows);
		System.out.println(gsonStr);*/
		
/*		采用@Result(type="json")形式返回时,不用GSON转换一遍，否则，返回时type为JSON则转换两遍
		效果如testGson2中对已经转过JSON数据再次转JSON
		{"userId":"1","userName":"追梦","name":"易木","sex":"男","department":"南京"}
		"{\"userId\":\"1\",\"userName\":\"追梦\",\"name\":\"易木\",\"sex\":\"男\",\"department\":\"南京\"}"*/
		
		return "jsontest";
	}
	
	public void testGson2(){
		response.setCharacterEncoding("UTF-8");
		User u1 = new User("2","有时","东方","男","烟台");
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
			//前台传递的汉字进行解码
			gsonStr = URLDecoder.decode(gsonStr, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
//		web.xml中增加了encodingFilter过滤器，省去这里的response.setCharacterEncoding,二者需有一个，否则中文乱码
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
	//使用serialize 为 false则返回json为root的时候不予返回
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
