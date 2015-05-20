package com.fred.stock.entity;

/**
 * StockData entity. @author MyEclipse Persistence Tools
 */

public class StockData implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uuid;
	private String code;
	private String date;
	private String name;
	private Double open;
	private Double high;
	private Double low;
	private Double close;
	private Double volume;

	// Constructors

	/** default constructor */
	public StockData() {
	}

	/** minimal constructor */
	public StockData(String uuid) {
		this.uuid = uuid;
	}

	/** full constructor */
	public StockData(String uuid, String code, String date,String name,
		Double open,Double high, Double low, Double close, Double volume) {
		this.uuid = uuid;
		this.code = code;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.name = name;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getOpen() {
		return this.open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getHigh() {
		return this.high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return this.low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getClose() {
		return this.close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Double getVolume() {
		return this.volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}