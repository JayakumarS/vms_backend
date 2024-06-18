package com.vms.vessels.wageScale;

import java.util.List;


public class WageScaleBean {

	
	private String code;
	private String description;
	private List<WageScaleBean> wageScaleDetails;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<WageScaleBean> getWageScaleDetails() {
		return wageScaleDetails;
	}
	public void setWageScaleDetails(List<WageScaleBean> wageScaleDetails) {
		this.wageScaleDetails = wageScaleDetails;
	}
}
