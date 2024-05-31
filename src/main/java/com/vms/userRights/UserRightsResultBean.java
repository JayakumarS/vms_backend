package com.vms.userRights;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vms.core.util.BasicResultBean;
import com.vms.core.util.DropDownList;

public class UserRightsResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private String roleremarks;

	public String getRoleremarks() {
		return roleremarks;
	}

	public void setRoleremarks(String roleremarks) {
		this.roleremarks = roleremarks;
	}

	private List<FormMasterBean> lFormMasterBean1 = new ArrayList<FormMasterBean>();

	private List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
	
	private List<UserRightsBean> FormMasterBean;
	
	private List<UserRightsBean> userList;
	
	private List<UserRightsBean> companyList;
	
	private List<UserRightsBean> moduleList;
	
	private List<UserRightsBean> userFormList;
	
	private List<UserRightsBean> propertyList;
	
	private List<UserRightsPropertyListBean> userRightsPropertyList;

	public List<UserRightsPropertyListBean> getUserRightsPropertyList() {
		return userRightsPropertyList;
	}

	public void setUserRightsPropertyList(List<UserRightsPropertyListBean> userRightsPropertyList) {
		this.userRightsPropertyList = userRightsPropertyList;
	}

	private List<UserRightsBean> formPropertyList;

	
	public List<UserRightsBean> getFormPropertyList() {
		return formPropertyList;
	}

	public void setFormPropertyList(List<UserRightsBean> formPropertyList) {
		this.formPropertyList = formPropertyList;
	}

	public List<UserRightsBean> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<UserRightsBean> propertyList) {
		this.propertyList = propertyList;
	}

	private List<Map<String,Object>> formList;

	
	public List<Map<String, Object>> getFormList() {
		return formList;
	}

	public void setFormList(List<Map<String, Object>> formList) {
		this.formList = formList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private int companyUserId;
	
	public int getCompanyUserId() {
		return companyUserId;
	}

	public void setCompanyUserId(int companyUserId) {
		this.companyUserId = companyUserId;
	}

	public List<FormMasterBean> getlFormMasterBean1() {
		return lFormMasterBean1;
	}

	public void setlFormMasterBean1(List<FormMasterBean> lFormMasterBean1) {
		this.lFormMasterBean1 = lFormMasterBean1;
	}
	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	
	

	public List<UserRightsBean> getUserList() {
		return userList;
	}

	public void setUserList(List<UserRightsBean> userList) {
		this.userList = userList;
	}

	public List<UserRightsBean> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<UserRightsBean> companyList) {
		this.companyList = companyList;
	}

	public List<UserRightsBean> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<UserRightsBean> moduleList) {
		this.moduleList = moduleList;
	}

	public List<UserRightsBean> getUserFormList() {
		return userFormList;
	}

	public void setUserFormList(List<UserRightsBean> userFormList) {
		this.userFormList = userFormList;
	}

	public List<FormMasterBean> getlFormMasterBean() {
		return lFormMasterBean;
	}

	public void setlFormMasterBean(List<FormMasterBean> lFormMasterBean) {
		this.lFormMasterBean = lFormMasterBean;
	}

	public List<UserRightsBean> getFormMasterBean() {
		return FormMasterBean;
	}

	public void setFormMasterBean(List<UserRightsBean> formMasterBean) {
		FormMasterBean = formMasterBean;
	}


//Mobile User Rigts
	
	boolean F4003;
	boolean F6021;
	boolean F3004;
	boolean F5009;
	boolean F2002;
	boolean F9057;
	boolean F5010;

	public boolean isF4003() {
		return F4003;
	}
	public void setF4003(boolean f4003) {
		F4003 = f4003;
	} 
	public boolean isF6021() {
		return F6021;
	}
	public void setF6021(boolean f6021) {
		F6021 = f6021;
	}
	public boolean isF3004() {
		return F3004;
	}
	public void setF3004(boolean f3004) {
		F3004 = f3004;
	}
	public boolean isF5009() {
		return F5009;
	}
	public void setF5009(boolean f5009) {
		F5009 = f5009;
	}
	public boolean isF2002() {
		return F2002;
	}
	public void setF2002(boolean f2002) {
		F2002 = f2002;
	}
	public boolean isF9057() {
		return F9057;
	}

	public void setF9057(boolean f9057) {
		F9057 = f9057;
	}

	public boolean isF5010() {
		return F5010;
	}

	public void setF5010(boolean f5010) {
		F5010 = f5010;
	}
	
	



	
	
}
