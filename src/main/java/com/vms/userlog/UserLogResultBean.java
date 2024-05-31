package com.vms.userlog;

import java.io.Serializable;
import java.util.List;

import com.vms.common.Selectivity;
import com.vms.core.util.BasicResultBean;



public class UserLogResultBean extends BasicResultBean implements Serializable {
	
	public boolean Success;
	
	private List<UserLogBean> userLogDetails;
	
	private List<Selectivity> userNameList;

	public List<Selectivity> getUserNameList() {
		return userNameList;
	}

	public void setUserNameList(List<Selectivity> userNameList) {
		this.userNameList = userNameList;
	}

	public List<UserLogBean> getUserLogDetails() {
		return userLogDetails;
	}

	public void setUserLogDetails(List<UserLogBean> userLogDetails) {
		this.userLogDetails = userLogDetails;
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	
}
