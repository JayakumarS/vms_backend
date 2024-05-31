package com.vms.userlog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class UserLogServiceImpl implements UserLogService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	UserLogDao userLogDao;

	@Override
	public void successUserLog(String userName , HttpServletRequest request) {		
		
		try {
//			JSONObject data = UserLogUtil.auditLogForLogin(userName , "Success");
			JSONObject dataObj = new JSONObject();
			String str = "";
			Date date = Calendar.getInstance().getTime();
			DateFormat dateFormatTime = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
			
			Date newDate = new Date();
			DateFormat dateTime = new SimpleDateFormat("dd-MM-yyyy");

			str = "Login Successful";
			
			dataObj.put("Date", dateFormatTime.format(date));
			dataObj.put("UserName", userName);
			dataObj.put("Status", str);
			dataObj.put("NewDate", dateTime.format(newDate));
			
			String userName1 = dataObj.getString("UserName");
			String status = dataObj.getString("Status");
			String date1 = dataObj.getString("Date");
			String newDate1 = dataObj.getString("NewDate");
			
			jdbcTemplate.update(UserLogQueryUtil.INSERT_USER_LOG,new Object[] {userName1,status,date1,newDate1});

		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void logOutUserLog(String username, HttpServletRequest request) {		
		
		try {
//			JSONObject data = UserLogUtil.auditLogForLogin(username , "Failed");
			JSONObject dataObj = new JSONObject();
			String str = "";
			Date date = Calendar.getInstance().getTime();
			DateFormat dateFormatTime = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
			
			Date newDate = new Date();
			DateFormat dateTime = new SimpleDateFormat("dd-MM-yyyy");
			
			str = "Logout Successful";
			
			dataObj.put("Date", dateFormatTime.format(date));
			dataObj.put("UserName", username);
			dataObj.put("Status", str);
			dataObj.put("NewDate", dateTime.format(newDate));
			
			String userName1 = dataObj.getString("UserName");
			String status = dataObj.getString("Status");
			String date1 = dataObj.getString("Date");
			String newDate1 = dataObj.getString("NewDate");
			
			jdbcTemplate.update(UserLogQueryUtil.INSERT_USER_LOG,new Object[] {userName1,status,date1,newDate1});

		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<UserLogBean> getUserLogList(UserLogBean bean) throws Exception {
		// TODO Auto-generated method stub
		return userLogDao.getUserLogList(bean);
	}

	@Override
	public UserLogResultBean getUserName() throws Exception {
		// TODO Auto-generated method stub
		return userLogDao.getUserName();
	}
	

	@Override
	public UserLogResultBean getemployeelist() throws Exception {
		// TODO Auto-generated method stub
		return userLogDao.getemployeelist();
	}
public UserLogResultBean getEmployeepuncheslist(UserLogBean bean) throws Exception {
		
		return userLogDao.getEmployeepuncheslist(bean);
	}
}
