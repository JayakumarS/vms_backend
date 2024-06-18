package com.vms.common.services;

import java.io.Serializable;
import java.util.List;

import com.vms.core.util.BasicResultBean;

public class CommonServicesResultBean extends BasicResultBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public boolean success;
	private List<CommonServiceBean> lCommonUtilityBean;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<CommonServiceBean> getlCommonUtilityBean() {
		return lCommonUtilityBean;
	}
	public void setlCommonUtilityBean(List<CommonServiceBean> lCommonUtilityBean) {
		this.lCommonUtilityBean = lCommonUtilityBean;
	}
	
}
