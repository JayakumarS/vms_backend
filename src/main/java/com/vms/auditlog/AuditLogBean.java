package com.vms.auditlog;

import java.util.Date;

public class AuditLogBean {

	private Long auditLogId;
	
	private String auditLogEmpId;

	private Date createdDate;
	
	private String createdBy;
	
	private String lastModifiedBy;

	private Date lastModifiedDate;

	Long version;

	private String comment;

	private Integer status;

	private String ipAddress;

	private String hostName;
	
	private String actions;

	private String object;	
	
	private String objectId;
	
	private String setUp; 
	
	private String data;

	private String primaryValue;

	private String primaryKeyType;

	private String macAddress;

	private String oldData;
	
	private String fromDate;
	
	private String toDate;
	
    private String userName;
	
	private String date;
	
	private String is_returnable;
	
	private String form;
	
	private String dateTime;
	
	private String userId;
	
	private Long auditId;
	
	private String id;
	
	private String text;
	
	private String formName;
	
	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getIs_returnable() {
		return is_returnable;
	}

	public void setIs_returnable(String is_returnable) {
		this.is_returnable = is_returnable;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getAuditLogId() {
		return auditLogId;
	}

	public void setAuditLogId(Long auditLogId) {
		this.auditLogId = auditLogId;
	}

	public String getAuditLogEmpId() {
		return auditLogEmpId;
	}

	public void setAuditLogEmpId(String auditLogEmpId) {
		this.auditLogEmpId = auditLogEmpId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	
	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getSetUp() {
		return setUp;
	}

	public void setSetUp(String setUp) {
		this.setUp = setUp;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getPrimaryValue() {
		return primaryValue;
	}

	public void setPrimaryValue(String primaryValue) {
		this.primaryValue = primaryValue;
	}

	public String getPrimaryKeyType() {
		return primaryKeyType;
	}

	public void setPrimaryKeyType(String primaryKeyType) {
		this.primaryKeyType = primaryKeyType;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getOldData() {
		return oldData;
	}

	public void setOldData(String oldData) {
		this.oldData = oldData;
	}
	
}
