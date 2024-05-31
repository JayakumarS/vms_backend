package com.vms.userlog;

import java.util.List;

public interface UserLogDao {

	List<UserLogBean> getUserLogList(UserLogBean bean) throws Exception;

	public UserLogResultBean getUserName();

	UserLogResultBean getEmployeepuncheslist(UserLogBean bean)throws Exception;

	UserLogResultBean getemployeelist()throws Exception;
	
}
