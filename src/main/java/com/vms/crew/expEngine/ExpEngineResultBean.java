package com.vms.crew.expEngine;

import java.util.List;



public class ExpEngineResultBean {
	
	public boolean success;


	private List<ExpEngineBean> list;
	private ExpEngineBean ExpEngineBean;
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
	public List<ExpEngineBean> getList() {
		return list;
	}
	public void setList(List<ExpEngineBean> list) {
		this.list = list;
	}
	public ExpEngineBean getExpEngineBean() {
		return ExpEngineBean;
	}
	public void setExpEngineBean(ExpEngineBean expEngineBean) {
		ExpEngineBean = expEngineBean;
	}

}
