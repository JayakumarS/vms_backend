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
	
	private List<IdentifiersLibraryBean> luboillist;
	
	private List<IdentifiersLibraryBean> paymentlist;
	
	private List<IdentifiersLibraryBean> officelist;
	
	private List<IdentifiersLibraryBean> scoreslist;
	
	public List<IdentifiersLibraryBean> getScoreslist() {
		return scoreslist;
	}
	public void setScoreslist(List<IdentifiersLibraryBean> scoreslist) {
		this.scoreslist = scoreslist;
	}
	public List<IdentifiersLibraryBean> getOfficelist() {
		return officelist;
	}
	public void setOfficelist(List<IdentifiersLibraryBean> officelist) {
		this.officelist = officelist;
	}
	public List<IdentifiersLibraryBean> getPaymentlist() {
		return paymentlist;
	}
	public void setPaymentlist(List<IdentifiersLibraryBean> paymentlist) {
		this.paymentlist = paymentlist;
	}
	public List<IdentifiersLibraryBean> getLuboillist() {
		return luboillist;
	}
	public void setLuboillist(List<IdentifiersLibraryBean> luboillist) {
		this.luboillist = luboillist;
	}
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
