package com.vms.supplies.identifiersLibrary;

import java.util.List;


public class IdentifiersLibraryResultBean {
	public boolean success;
	public String message;
	private Integer codemax;
	public Integer getCodemax() {
		return codemax;
	}
	public void setCodemax(Integer codemax) {
		this.codemax = codemax;
	}
	private List<IdentifiersLibraryBean> list;
	private List<IdentifiersLibraryBean> list1;
	private List<IdentifiersLibraryBean> list2;
	private List<IdentifiersLibraryBean> list3;
	
	private List<IdentifiersLibraryBean> locationlist;
	
	public List<IdentifiersLibraryBean> getLocationlist() {
		return locationlist;
	}
	public void setLocationlist(List<IdentifiersLibraryBean> locationlist) {
		this.locationlist = locationlist;
	}
	public List<IdentifiersLibraryBean> getList3() {
		return list3;
	}
	public void setList3(List<IdentifiersLibraryBean> list3) {
		this.list3 = list3;
	}
	public List<IdentifiersLibraryBean> getList2() {
		return list2;
	}
	public void setList2(List<IdentifiersLibraryBean> list2) {
		this.list2 = list2;
	}
	public List<IdentifiersLibraryBean> getList1() {
		return list1;
	}
	public void setList1(List<IdentifiersLibraryBean> list1) {
		this.list1 = list1;
	}
	public List<IdentifiersLibraryBean> getList() {
		return list;
	}
	public void setList(List<IdentifiersLibraryBean> list) {
		this.list = list;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
