package com.vms.userlog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface UserLogService {

	public void successUserLog(String userName, HttpServletRequest request);

	public void logOutUserLog(String username, HttpServletRequest request);
	
	public List<UserLogBean> getUserLogList(UserLogBean bean) throws Exception;

	public UserLogResultBean getUserName() throws Exception;

	public UserLogResultBean getEmployeepuncheslist(UserLogBean bean)throws Exception;

	public UserLogResultBean getemployeelist()throws Exception;
	
}
