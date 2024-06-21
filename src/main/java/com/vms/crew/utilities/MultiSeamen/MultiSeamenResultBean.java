package com.vms.crew.utilities.MultiSeamen;

import java.util.List;


public class MultiSeamenResultBean {
	
	public boolean success;
	
	private List<MultiSeamenBean> list;
	
	private MultiSeamenBean multiSeamenBean;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<MultiSeamenBean> getList() {
		return list;
	}

	public void setList(List<MultiSeamenBean> list) {
		this.list = list;
	}

	public MultiSeamenBean getMultiSeamenBean() {
		return multiSeamenBean;
	}

	public void setMultiSeamenBean(MultiSeamenBean multiSeamenBean) {
		this.multiSeamenBean = multiSeamenBean;
	}

}
