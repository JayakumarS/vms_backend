package com.vms.userRights;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.vms.core.util.CustomException;
import com.vms.core.util.DropDownList;
import com.vms.formProperty.FormPropertyBean;

public interface UserRightsDao {


 List<UserRightsBean> getuserList() throws Exception;

 List<UserRightsBean> getCompanyList() throws Exception;
 
 List<UserRightsBean> getuserFormList() throws Exception;
 
 UserRightsResultBean save(UserRightsBean bean) throws Exception;

 
 List<FormMasterBean> getFormMasterListByCompanyUser(String userId, String companyCode, String moduleCode)
			throws CustomException;
 
 
 List<UserRightsBean> getModuleList() throws Exception;
 
 List<UserRightsBean>  getPropertyList() throws Exception;

 
 UserRightsResultBean getFormList(String userId)throws Exception; 
 
 UserRightsResultBean getFormByModuleList(String userId, String moduleCode)throws Exception;

 PermissionResultBean getAllPagePermissionList(PermissionBean permissionBean, HttpServletRequest request);
 
 //Mobile User Rigts

 UserRightsResultBean getPermissionList(String userId)throws Exception; 

	/*
	 * //MVJ
	 *  
	 * public List<FormPropertyBean> getFormPropertyBeanList(String formCode) throws
	 * CustomException;
	 * 
	 * public int getCompanyUserId(String companyCode, String userId) throws
	 * CustomException;
	 * 
	 * public List<Integer> getFormPropertyIdList(int companyUserId) throws
	 * CustomException;
	 * 
	 * public List<FormMasterBean> getFormMasterList(String moduleCode, String
	 * formCode) throws CustomException;
	 */


}
