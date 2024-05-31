package com.vms.auditlog;

import java.util.List;

import com.vms.common.Selectivity;



public class AuditLogResultBean {
	
	private static final long serialVersionUID = 1L;
	
	public boolean success;

	public boolean isSuccess() {
		return success;
	}
	private List<AuditLogBean> auditLogDetails;
	
	private List<AuditLogBean> Auditlist;
	
	public List<AuditLogBean> getAuditlist() {
		return Auditlist;
	}

	public void setAuditlist(List<AuditLogBean> auditlist) {
		Auditlist = auditlist;
	}
	private AuditLogBean auditLogBean;
	private List<AuditLogBean> listSearchBean;
	private List<AuditLogBean> returnBean;

	private List<AuditLogBean> nonReturnBean;
	
	private List<Selectivity> formList;
	

	public List<Selectivity> getFormList() {
		return formList;
	}

	public void setFormList(List<Selectivity> formList) {
		this.formList = formList;
	}

	public List<AuditLogBean> getReturnBean() {
		return returnBean;
	}

	public void setReturnBean(List<AuditLogBean> returnBean) {
		this.returnBean = returnBean;
	}

	public List<AuditLogBean> getNonReturnBean() {
		return nonReturnBean;
	}

	public void setNonReturnBean(List<AuditLogBean> nonReturnBean) {
		this.nonReturnBean = nonReturnBean;
	}

	public List<AuditLogBean> getListSearchBean() {
		return listSearchBean;
	}

	public void setListSearchBean(List<AuditLogBean> listSearchBean) {
		this.listSearchBean = listSearchBean;
	}

	public AuditLogBean getAuditLogBean() {
		return auditLogBean;
	}

	public void setAuditLogBean(AuditLogBean auditLogBean) {
		this.auditLogBean = auditLogBean;
	}

	public List<AuditLogBean> getAuditLogDetails() {
		return auditLogDetails;
	}

	public void setAuditLogDetails(List<AuditLogBean> auditLogDetails) {
		this.auditLogDetails = auditLogDetails;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private AuditLogBean auditLog;
	
	private List<AuditLogBean> listAuditLog;

	public AuditLogBean getAuditLog() {
		return auditLog;
	}

	public void setAuditLog(AuditLogBean auditLog) {
		this.auditLog = auditLog;
	}

	public List<AuditLogBean> getListAuditLog() {
		return listAuditLog;
	}

	public void setListAuditLog(List<AuditLogBean> listAuditLog) {
		this.listAuditLog = listAuditLog;
	}}
