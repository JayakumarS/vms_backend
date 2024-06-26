package com.vms.master.religion;

import java.util.List;


public class ReligionResultBean {

	public boolean success;
	private List<ReligionBean> list;
	private ReligionBean religionBean;
	public String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ReligionBean getReligionBean() {
		return religionBean;
	}
	public void setReligionBean(ReligionBean religionBean) {
		this.religionBean = religionBean;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<ReligionBean> getList() {
		return list;
	}
	public void setList(List<ReligionBean> list) {
		this.list = list;
	}

	
	
	
	
	
	
	
	
	
	
	
}
