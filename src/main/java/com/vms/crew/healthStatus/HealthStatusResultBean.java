package com.vms.crew.healthStatus;

import java.util.List;


public class HealthStatusResultBean {

	

	
	public boolean success;


	private List<HealthStatusBean> list;
	private HealthStatusBean healthStatusBean;

	



	public List<HealthStatusBean> getList() {
		return list;
	}

	public void setList(List<HealthStatusBean> list) {
		this.list = list;
	}

	public HealthStatusBean getHealthStatusBean() {
		return healthStatusBean;
	}

	public void setHealthStatusBean(HealthStatusBean healthStatusBean) {
		this.healthStatusBean = healthStatusBean;
	}

	public boolean isSuccess() {
		return success;
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


	public String message;
	
}
