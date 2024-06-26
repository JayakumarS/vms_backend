package com.vms.master.bloodgroup;

import java.util.List;

public class BloodGroupResultBean {

	public boolean success;
	private List<BloodGroupBean> list;
	private BloodGroupBean bloodGroupBean;
	public String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BloodGroupBean getBloodGroupBean() {
		return bloodGroupBean;
	}
	public void setBloodGroupBean(BloodGroupBean bloodGroupBean) {
		this.bloodGroupBean = bloodGroupBean;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<BloodGroupBean> getList() {
		return list;
	}
	public void setList(List<BloodGroupBean> list) {
		this.list = list;
	}
	
	
	
}