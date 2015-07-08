package com.fred.common.baseaction;

import com.fred.common.sysmodel.PageInfo;
import com.fred.common.sysmodel.SortParamList;

public class EasyGridAction<T> extends BaseAction<T> {

	private static final long serialVersionUID = 1L;

	private int page;
	private int rows = 20;// Ĭ��ֵ
	private String sort;
	private String order;
	private PageInfo pageInfo = new PageInfo();
	private SortParamList sortInfo = new SortParamList();
	protected String msg = "�����ɹ�";

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public PageInfo getPageInfo() {
		pageInfo.setRowOfPage(rows);//һҳ����
		pageInfo.setCurPageNum(page);//��ǰҳ��
		return pageInfo;
	}

	public SortParamList getSortInfo() {
		if (sort != null)
			sortInfo.addParam(sort, order);
		return sortInfo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
