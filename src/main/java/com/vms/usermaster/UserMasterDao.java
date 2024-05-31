package com.vms.usermaster;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface UserMasterDao {

	UserMasterResultBean save(UserMasterBean bean, HttpServletRequest request) throws Exception;

	public UserMasterResultBean getDesignationList() throws Exception;

	public UserMasterResultBean getDepartmentList() throws Exception;
	
	public UserMasterResultBean getUserNameList() throws Exception;

	
	public UserMasterResultBean getList() throws Exception;


	public List<UserMasterBean> getUserList(UserMasterBean bean) throws Exception;

	public UserMasterResultBean edit(String userId) throws Exception;

	public UserMasterResultBean update(UserMasterBean bean, HttpServletRequest request) throws Exception;

	public UserMasterResultBean delete(String userId, HttpServletRequest request) throws Exception;

//	boolean validateFullName(String tableName, String columnName, String columnValue) throws Exception;
	
	UserMasterResultBean validateFullName(String userId) throws Exception;
	
	boolean validateLoginName(String tableName, String columnName, String columnValue) throws Exception;
	
	UserMasterResultBean oldPasswordValidation(String validatePassword,String userId) throws Exception;

	UserMasterResultBean updatePassword(UserMasterBean bean) throws Exception;
	
	boolean resetPasswordCheck(String userId) throws Exception;

	boolean validateLoginid(String tableName, String columnName, String columnValue);

	UserMasterResultBean deleteUser(String userId) throws Exception;;

	
	
}
