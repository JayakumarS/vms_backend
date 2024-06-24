package com.vms.master.Country;

import java.util.List;

public class CountryResultBean {

	public boolean success;
	public String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private List<CountryBean> list;


	public boolean isSuccess() {
		return success;
	}

	public List<CountryBean> getList() {
		return list;
	}

	public void setList(List<CountryBean> list) {
		this.list = list;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
