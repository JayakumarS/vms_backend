package com.vms.auditlog;

public class AuditLogQueryUtil {
	
	
	public static final String INSERT_AUDIT_LOG = "INSERT INTO audit_log( \r\n"
			+ "	created_by, created_date, last_modified_by, last_modified_date, action, data, host_name, \r\n"
			+ "	ip_address, mac_address, object, object_id, old_data, primary_key_type, primary_value, \r\n"
			+ "	audit_log_emp_id,user_name,date_time) \r\n"
			+ "	VALUES (:createdBy, now(), :lastModifiedBy, now(), :actions, :data, :hostName, :ipAddress, :macAddress, \r\n"
			+ "	:object, :objectId, :oldData, :primaryKeyType, :primaryValue, :auditLogEmpId, :userId, :dateTime) ";
	
	
	public static final String getAuditLogList = "select audit_log_id as auditId,object as form,ip_address as ipAddress,action as actions,date_time as dateTime,\r\n"
			+ "user_name as userName from audit_log where 1=1  ";
	
	
	public static final String SELECT_AUDIT_LOG = "select user_name as userName,action as actions,data as data,old_data as oldData from audit_log where audit_log_id = ?";
	
	public static final String getFormName = "select distinct object as text,object as id from audit_log";
}

