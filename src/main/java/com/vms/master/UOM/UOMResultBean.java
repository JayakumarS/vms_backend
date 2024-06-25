package com.vms.master.UOM;

import java.util.List;


public class UOMResultBean {

	public boolean success;
	public String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private List<UOMBean> list;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<UOMBean> getList() {
		return list;
	}
	public void setList(List<UOMBean> list) {
		this.list = list;
	}

}
