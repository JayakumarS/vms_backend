package com.vms.vessels.Class;

import java.util.List;


public class ClassResultBean {

	public boolean success;
	private List<ClassBean> list;
	private ClassBean classBean;
	public String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<ClassBean> getList() {
		return list;
	}
	public void setList(List<ClassBean> list) {
		this.list = list;
	}
	public ClassBean getClassBean() {
		return classBean;
	}
	public void setClassBean(ClassBean classBean) {
		this.classBean = classBean;
	}
}
