package com.fred.common.sysmodel;

import java.util.ArrayList;
import java.util.List;
/**
 * ʵ��easyUI���ݱ���ҳ
 * @author haojiahong
 *
 * @param <T>
 */
public class EasyGridData<T> {
	private int total=0;
	private List<T> rows = new ArrayList<T>();
	private String msg;
	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	
	public int getTotal() {
		return total;
	}

	
	public void setTotal(int total) {
		this.total = total;
	}

	
	public String getMsg() {
		return msg;
	}

	
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
