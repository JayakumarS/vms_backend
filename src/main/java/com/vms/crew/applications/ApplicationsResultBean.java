package com.vms.crew.applications;

import java.util.List;


public class ApplicationsResultBean {
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean success;
	private List<ApplicationsBean> list;
	private List<ApplicationsBean> list1;
	private List<ApplicationsBean>listpopup;
	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ApplicationsBean> getListpopup() {
		return listpopup;
	}

	public void setListpopup(List<ApplicationsBean> listpopup) {
		this.listpopup = listpopup;
	}

	public List<ApplicationsBean> getList() {
		return list;
	}

	public void setList(List<ApplicationsBean> list) {
		this.list = list;
	}
	private ApplicationsBean getdata;
	public ApplicationsBean getGetdata() {
		return getdata;
	}

	public void setGetdata(ApplicationsBean getdata) {
		this.getdata = getdata;
	}
	
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<ApplicationsBean> getList1() {
		return list1;
	}

	public void setList1(List<ApplicationsBean> list1) {
		this.list1 = list1;
	}

	private String path;

}
