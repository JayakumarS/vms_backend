package com.vms.crew.payTypes;

import java.util.List;


public class PayTypesResultBean {
	
	public boolean success;
	public String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private List<PayTypesBean> list;
	private PayTypesBean payTypesBean;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<PayTypesBean> getList() {
		return list;
	}
	public void setList(List<PayTypesBean> list) {
		this.list = list;
	}
	public PayTypesBean getPayTypesBean() {
		return payTypesBean;
	}
	public void setPayTypesBean(PayTypesBean payTypesBean) {
		this.payTypesBean = payTypesBean;
	}

}
