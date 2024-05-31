package com.vms.usermaster;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMasterServiceImpl implements UserMasterService {
	
	@Autowired
	UserMasterDao userMasterDao;

	@Override
	public UserMasterResultBean save(UserMasterBean bean, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return userMasterDao.save(bean,request);
	}

	@Override
	public UserMasterResultBean getDesignationList() throws Exception {
		// TODO Auto-generated method stub
		return userMasterDao.getDesignationList();
	}

	@Override
	public UserMasterResultBean getDepartmentList() throws Exception {
		// TODO Auto-generated method stub
		return userMasterDao.getDepartmentList();
	}

	@Override
	public List<UserMasterBean> getUserList(UserMasterBean bean) throws Exception {
		// TODO Auto-generated method stub
		return userMasterDao.getUserList(bean);
	}

	@Override
	public UserMasterResultBean edit(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userMasterDao.edit(userId);
	}

	@Override
	public UserMasterResultBean update(UserMasterBean bean, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return userMasterDao.update(bean,request);
	}

	@Override
	public UserMasterResultBean delete(String userId, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return userMasterDao.delete(userId,request);
	}

//	@Override
//	public boolean validateFullName(String tableName, String columnName, String columnValue) throws Exception {
//		// TODO Auto-generated method stub
//		return userMasterDao.validateFullName(tableName,columnName,columnValue);
//	}
	
	@Override
	public UserMasterResultBean validateFullName(String userId) throws Exception {
 		return userMasterDao.validateFullName(userId);
	}
	
	@Override
	public boolean validateLoginName(String tableName, String columnName, String columnValue) throws Exception {
		// TODO Auto-generated method stub
		return userMasterDao.validateLoginName(tableName,columnName,columnValue);
	}
	
	@Override
	public UserMasterResultBean oldPasswordValidation(String validatePassword,String userId) throws Exception {
		// TODO Auto-generated method stub
		return userMasterDao.oldPasswordValidation(validatePassword,userId);
	}

	@Override
	public UserMasterResultBean updatePassword(UserMasterBean bean) throws Exception{
		// TODO Auto-generated method stub
		return userMasterDao.updatePassword(bean);
	}
	
	@Override
	public boolean resetPasswordCheck(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userMasterDao.resetPasswordCheck(userId);
	}

	@Override
	public UserMasterResultBean getUserNameList() throws Exception {
		// TODO Auto-generated method stub
		return userMasterDao.getUserNameList();	
	}

	@Override
	public boolean validateLoginid(String tableName, String columnName, String columnValue) {
		// TODO Auto-generated method stub
		return userMasterDao.validateLoginid(tableName,columnName,columnValue);
	}

	@Override
	public UserMasterResultBean deleteUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userMasterDao.deleteUser(userId);
	}
}
