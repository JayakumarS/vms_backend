package com.vms.crew.workLicense;

import java.util.List;


public class WorkLicenseBean {
	private Integer worklicenseid;
	public Integer getWorklicenseid() {
		return worklicenseid;
	}
	public void setWorklicenseid(Integer worklicenseid) {
		this.worklicenseid = worklicenseid;
	}
	private String code;
	private String description;
	private List<WorkLicenseBean> workLicenseBeanDtls;


	
	public List<WorkLicenseBean> getWorkLicenseBeanDtls() {
		return workLicenseBeanDtls;
	}
	public void setWorkLicenseBeanDtls(List<WorkLicenseBean> workLicenseBeanDtls) {
		this.workLicenseBeanDtls = workLicenseBeanDtls;
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
