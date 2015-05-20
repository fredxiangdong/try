package com.fred.common.timer.entity;

public class Warning {
	
	private Long warningId;
	
	private String warningName;
	
	private String warningDescribe;

	public Long getWarningId() {
		return warningId;
	}

	public void setWarningId(Long warningId) {
		this.warningId = warningId;
	}

	public String getWarningName() {
		return warningName;
	}

	public void setWarningName(String warningName) {
		this.warningName = warningName;
	}

	public String getWarningDescribe() {
		return warningDescribe;
	}

	public void setWarningDescribe(String warningDescribe) {
		this.warningDescribe = warningDescribe;
	}
	
	public Warning(Long warningId,String warningName,String warningDescribe){
		this.warningId = warningId;
		this.warningName = warningName;
		this.warningDescribe = warningDescribe;
	}
	
	public Warning(){}
}
