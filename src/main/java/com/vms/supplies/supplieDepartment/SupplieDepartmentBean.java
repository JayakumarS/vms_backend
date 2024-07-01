package com.vms.supplies.supplieDepartment;

import java.util.List;


public class SupplieDepartmentBean {
	private String code;
	private String department;
	private String formType;
	private String itemsToOrderComments;
	private String itemsNotToOrderComments;
	private boolean availableOffice;
	private boolean availableVessel;
	private boolean officeUndefinedItemS;
	private boolean vesselUndefinedItemS;
	private boolean proposedItems;
	private double tolerance;
	private Integer minimumItems;
	private String lscInvoiceDate;
	private List<SupplieDepartmentBean> list;
	
	public List<SupplieDepartmentBean> getList() {
		return list;
	}
	public void setList(List<SupplieDepartmentBean> list) {
		this.list = list;
	}
	public Integer getMinimumItems() {
		return minimumItems;
	}
	public void setMinimumItems(Integer minimumItems) {
		this.minimumItems = minimumItems;
	}
	public String getLscInvoiceDate() {
		return lscInvoiceDate;
	}
	public void setLscInvoiceDate(String lscInvoiceDate) {
		this.lscInvoiceDate = lscInvoiceDate;
	}
	public double getTolerance() {
		return tolerance;
	}
	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public String getItemsToOrderComments() {
		return itemsToOrderComments;
	}
	public void setItemsToOrderComments(String itemsToOrderComments) {
		this.itemsToOrderComments = itemsToOrderComments;
	}
	public String getItemsNotToOrderComments() {
		return itemsNotToOrderComments;
	}
	public void setItemsNotToOrderComments(String itemsNotToOrderComments) {
		this.itemsNotToOrderComments = itemsNotToOrderComments;
	}
	public boolean isAvailableOffice() {
		return availableOffice;
	}
	public void setAvailableOffice(boolean availableOffice) {
		this.availableOffice = availableOffice;
	}
	public boolean isAvailableVessel() {
		return availableVessel;
	}
	public void setAvailableVessel(boolean availableVessel) {
		this.availableVessel = availableVessel;
	}
	public boolean isOfficeUndefinedItemS() {
		return officeUndefinedItemS;
	}
	public void setOfficeUndefinedItemS(boolean officeUndefinedItemS) {
		this.officeUndefinedItemS = officeUndefinedItemS;
	}
	public boolean isVesselUndefinedItemS() {
		return vesselUndefinedItemS;
	}
	public void setVesselUndefinedItemS(boolean vesselUndefinedItemS) {
		this.vesselUndefinedItemS = vesselUndefinedItemS;
	}
	public boolean isProposedItems() {
		return proposedItems;
	}
	public void setProposedItems(boolean proposedItems) {
		this.proposedItems = proposedItems;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

	
}
