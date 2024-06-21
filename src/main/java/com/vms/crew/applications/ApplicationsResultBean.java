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

	private String path;

}
