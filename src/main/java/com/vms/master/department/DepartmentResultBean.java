package com.vms.master.department;

import java.util.List;


public class DepartmentResultBean {

	public boolean success;
	
	private List<DepartmentBean> list;
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<DepartmentBean> getList() {
		return list;
	}

	public void setList(List<DepartmentBean> list) {
		this.list = list;
	}

	public DepartmentBean getDepartmentBean() {
		return departmentBean;
	}

	public void setDepartmentBean(DepartmentBean departmentBean) {
		this.departmentBean = departmentBean;
	}

	private DepartmentBean departmentBean;
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
