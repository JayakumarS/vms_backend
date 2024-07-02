package com.vms.supplies.LandingProperties;

import java.util.List;

public class LandingPropertiesResultBean {
	
	public boolean success;
	public String message;
	
	private List<LandingPropertiesBean> list;
	
	public boolean isSuccess() {
		return success;
	}
	public List<LandingPropertiesBean> getList() {
		return list;
	}
	public void setList(List<LandingPropertiesBean> list) {
		this.list = list;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
