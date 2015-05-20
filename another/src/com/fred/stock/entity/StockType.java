package com.fred.stock.entity;

/**
 * StockType entity. @author MyEclipse Persistence Tools
 */

public class StockType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stockId;
	private String stockCode;
	private String stockName;
	private String editFlag;

	// Constructors

	/** default constructor */
	public StockType() {
	}

	/** minimal constructor */
	public StockType(String stockId) {
		this.stockId = stockId;
	}

	/** full constructor */
	public StockType(String stockId, String stockCode, String stockName, String editFlag) {
		this.stockId = stockId;
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.editFlag = editFlag;
	}

	// Property accessors

	public String getStockId() {
		return this.stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getEditFlag() {
		return editFlag;
	}

	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}
	
}