package com.vms.userRights;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface UserRightsService {

	UserRightsResultBean save(UserRightsBean bean) throws Exception;

	
	public List<UserRightsBean> getuserList() throws Exception;
	
	public List<UserRightsBean>getCompanyList() throws Exception;
	
	public List<UserRightsBean>getModuleList() throws Exception;
	
	public List<UserRightsBean>getuserFormList() throws Exception;
	
	public List<UserRightsBean>getPropertyList() throws Exception;
	
	UserRightsResultBean getFormList(String userId) throws Exception; 

	UserRightsResultBean getFormByModuleList(String userId, String moduleCode) throws Exception;
	
	List<FormMasterBean> getFormMasterListByCompanyUser(String userId, String companyCode, String moduleCode)
			throws Exception;
	/*
	 * // MVJ public int getCompanyUserId(String companyCode, String userId) throws
	 * Exception;
	 * 
	 * public List<FormMasterBean> getFormMasterList(int companyUserId, String
	 * moduleCode, String formCode) throws Exception;
	 * 
	 * public List<FormMasterBean> getFormMasterListFiltered(List<FormMasterBean>
	 * lFormMasterBean, List<Integer> lFormPropertyIdActive) throws Exception;
	 */


	PermissionResultBean getAllPagePermissionList(PermissionBean permissionBean, HttpServletRequest request);
	
	//Mobile User Rigts

	UserRightsResultBean getPermissionList(String userId) throws Exception; 


}