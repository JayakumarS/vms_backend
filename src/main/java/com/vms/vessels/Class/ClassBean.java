package com.vms.vessels.Class;

import java.util.List;


public class ClassBean {

	
	private String code;
	private String description;
	private List<ClassBean>classDetails;
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
	public List<ClassBean> getClassDetails() {
		return classDetails;
	}
	public void setClassDetails(List<ClassBean> classDetails) {
		this.classDetails = classDetails;
	}
}
