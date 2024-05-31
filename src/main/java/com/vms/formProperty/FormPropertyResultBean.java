package com.vms.formProperty;

import java.util.List;
import java.util.Map;

public class FormPropertyResultBean {
	
	private String message;
	
	private List<FormPropertyBean> moduleLevelList;
	
	private List<FormPropertyBean> dashboardList;

	public List<FormPropertyBean> getDashboardList() {
		return dashboardList;
	}
	public void setDashboardList(List<FormPropertyBean> dashboardList) {
		this.dashboardList = dashboardList;
	}
	public void setSuccess(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<FormPropertyBean> getModuleLevelList() {
		return moduleLevelList;
	}
	public void setModuleLevelList(List<FormPropertyBean> moduleLevelList) {
		this.moduleLevelList = moduleLevelList;
	}
	
}
