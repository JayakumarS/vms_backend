package com.vms.master.department;

import java.util.List;

public class DepartmentBean {
	private String code;
	private String name;
	private String head;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private String active;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public List<DepartmentBean> getDepartmentdtls() {
		return departmentdtls;
	}
	public void setDepartmentdtls(List<DepartmentBean> departmentdtls) {
		this.departmentdtls = departmentdtls;
	}
	private List<DepartmentBean> departmentdtls;
	

}
