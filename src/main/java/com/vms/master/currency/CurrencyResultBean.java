package com.vms.master.currency;

import java.util.List;

public class CurrencyResultBean {
	public boolean success;
	private List<CurrencyBean> list;
	private CurrencyBean currencyBean;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<CurrencyBean> getList() {
		return list;
	}
	public void setList(List<CurrencyBean> list) {
		this.list = list;
	}
	public CurrencyBean getCurrencyBean() {
		return currencyBean;
	}
	public void setCurrencyBean(CurrencyBean currencyBean) {
		this.currencyBean = currencyBean;
	}
	
	private String msg;

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
