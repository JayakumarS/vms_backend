package com.vms.crew.maintain.Medicals;

import java.util.List;


public class MedicalResultBean {

	
	public boolean success;


	private List<MedicalBean> list;

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


	public List<MedicalBean> getList() {
		return list;
	}


	public void setList(List<MedicalBean> list) {
		this.list = list;
	}
}
