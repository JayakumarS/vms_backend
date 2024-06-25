package com.vms.common.Languages;

import java.util.List;


public class LanguagesResultBean {

	public boolean success;
	private List<LanguagesBean> list;
	public String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private LanguagesBean languagesBean;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<LanguagesBean> getList() {
		return list;
	}
	public void setList(List<LanguagesBean> list) {
		this.list = list;
	}
	public LanguagesBean getLanguagesBean() {
		return languagesBean;
	}
	public void setLanguagesBean(LanguagesBean languagesBean) {
		this.languagesBean = languagesBean;
	}
}
