package com.vms.vessels.Class;

import java.util.List;


public class ClassBean {

	
	private String code;
	private String description;
	private int classid;
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
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
}
