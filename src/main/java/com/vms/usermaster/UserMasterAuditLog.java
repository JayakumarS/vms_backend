package com.vms.usermaster;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class UserMasterAuditLog {
	@SuppressWarnings("unchecked")
	public JSONObject userMasterAuditLog(UserMasterBean bean) throws JSONException {
		JSONObject userMasterMap = new JSONObject();
		
		userMasterMap.put("fullName",bean.getFullName());
		userMasterMap.put("loginName", bean.getLoginName());
		userMasterMap.put("emailId", bean.getEmailId());
		userMasterMap.put("contactNumber",bean.getContactNumber() );
		userMasterMap.put("password", bean.getPassword());
		userMasterMap.put("empId", bean.getEmpId());
		userMasterMap.put("designation", bean.getDesignation());
		userMasterMap.put("department", bean.getDepartment());
		userMasterMap.put("company", bean.getCompany());
		userMasterMap.put("address", bean.getAddress());
		userMasterMap.put("location", bean.getLocation());
		userMasterMap.put("status", bean.getStatus());
	
		return userMasterMap;

	}
}
