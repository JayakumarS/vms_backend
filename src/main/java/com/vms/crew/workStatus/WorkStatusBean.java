package com.vms.crew.workStatus;

import java.util.List;


public class WorkStatusBean {
	private String code;
	private String description;
	private List<WorkStatusBean> workStatusBeanDtls;



	public List<WorkStatusBean> getWorkStatusBeanDtls() {
		return workStatusBeanDtls;
	}
	public void setWorkStatusBeanDtls(List<WorkStatusBean> workStatusBeanDtls) {
		this.workStatusBeanDtls = workStatusBeanDtls;
	}
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
	
}
