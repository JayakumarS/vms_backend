package com.vms.userlog;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class UserLogUtil {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@SuppressWarnings("unchecked")
	public static JSONObject auditLogForLogin(String userName, String msg) throws JSONException {
		JSONObject dataObj = new JSONObject();
		String str = "";
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormatTime = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");

		if(msg.equals("Success")) {
			str = "Login Successful";
		} else if(msg.equals("Failed")) {
			str = "Login Failed";
		} else if(msg.equals("Logout")) {
			str = "Log Out";
		} else if(msg.equals("Timeout")) {
			str = "Session Time Out";
		} else if(msg.equals("Token")) {
			str = "Token Deletion";
		} else if(msg.equals("ChangeRole")) {
			str = "Change Role";
		}
		dataObj.put("Date", dateFormatTime.format(date));
		dataObj.put("UserName", userName);
		dataObj.put("Status", str);
		
		return dataObj;
	}

	public void auditLog(JSONObject data) throws JSONException {
		
		String userName = data.getString("UserName");
		String status = data.getString("Status");
		String date = data.getString("Date");
		
		
		try {
			jdbcTemplate.update(UserLogQueryUtil.INSERT_USER_LOG,new Object[] {userName,status,date});
			status="";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
