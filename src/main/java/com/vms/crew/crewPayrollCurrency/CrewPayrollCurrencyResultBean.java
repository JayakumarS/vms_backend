package com.vms.crew.crewPayrollCurrency;

import java.util.List;



public class CrewPayrollCurrencyResultBean {
	
	public boolean success;
	public String message;
	private List<CrewPayrollCurrencyBean> list;
	public List<CrewPayrollCurrencyBean> getList() {
		return list;
	}
	public void setList(List<CrewPayrollCurrencyBean> list) {
		this.list = list;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
