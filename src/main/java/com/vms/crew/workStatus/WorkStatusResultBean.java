package com.vms.crew.workStatus;

import java.util.List;


public class WorkStatusResultBean {
	
	public boolean success;


	private List<WorkStatusBean> list;
	private WorkStatusBean workStatusBean;

	

	

	public List<WorkStatusBean> getList() {
		return list;
	}

	public void setList(List<WorkStatusBean> list) {
		this.list = list;
	}

	public WorkStatusBean getWorkStatusBean() {
		return workStatusBean;
	}

	public void setWorkStatusBean(WorkStatusBean workStatusBean) {
		this.workStatusBean = workStatusBean;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
