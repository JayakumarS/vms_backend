package com.vms.core.util;

public class CommonDeleteBean {
	
	private Integer deletingId;
	private String deletingid;
	private boolean activeFlag;

	public String getDeletingid() {
		return deletingid;
	}

	public void setDeletingid(String deletingid) {
		this.deletingid = deletingid;
	}

	public Integer getDeletingId() {
		return deletingId;
	}

	public void setDeletingId(Integer deletingId) {
		this.deletingId = deletingId;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

}
