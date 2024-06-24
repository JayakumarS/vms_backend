package com.vms.master.Port;

import java.util.List;


public class PortResultBean {
	
	public boolean success;
	public String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private List<PortBean> list;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<PortBean> getList() {
		return list;
	}
	public void setList(List<PortBean> list) {
		this.list = list;
	}


}
