package com.vms.usermaster;

import java.io.Serializable;
import java.util.List;

import com.vms.common.Selectivity;
import com.vms.core.util.BasicResultBean;
import com.vms.userlog.UserLogBean;

public class UserMasterResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private String userNameForPopUp;
	private String passwordForPopUp;
	
	private List<Selectivity> designationList;
	
	private List<Selectivity> departmentList;
	
	private List<Selectivity> UserNameList;
	
	private List<UserMasterBean> userMasterDetails;
	
	private UserMasterBean userMasterBean;

	public String getUserNameForPopUp() {
		return userNameForPopUp;
	}

	public void setUserNameForPopUp(String userNameForPopUp) {
		this.userNameForPopUp = userNameForPopUp;
	}

	public String getPasswordForPopUp() {
		return passwordForPopUp;
	}

	public void setPasswordForPopUp(String passwordForPopUp) {
		this.passwordForPopUp = passwordForPopUp;
	}

	public UserMasterBean getUserMasterBean() {
		return userMasterBean;
	}

	public void setUserMasterBean(UserMasterBean userMasterBean) {
		this.userMasterBean = userMasterBean;
	}

	public List<UserMasterBean> getUserMasterDetails() {
		return userMasterDetails;
	}

	public void setUserMasterDetails(List<UserMasterBean> userMasterDetails) {
		this.userMasterDetails = userMasterDetails;
	}

	public List<Selectivity> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Selectivity> departmentList) {
		this.departmentList = departmentList;
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public List<Selectivity> getDesignationList() {
		return designationList;
	}

	public void setDesignationList(List<Selectivity> designationList) {
		this.designationList = designationList;
	}

	public List<Selectivity> getUserNameList() {
		return UserNameList;
	}

	public void setUserNameList(List<Selectivity> userNameList) {
		UserNameList = userNameList;
	}
	
	private boolean validateFullName;

	public boolean isValidateFullName() {
		return validateFullName;
	}

	public void setValidateFullName(boolean validateFullName) {
		this.validateFullName = validateFullName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
