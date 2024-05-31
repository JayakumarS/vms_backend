package com.vms.common.services;

public class CommonServiceQueryUtil {

	public static final String VALIDATE_UNIQUE = "SELECT * FROM fn_unique_validation(?,?,?)";

	
	public static final String GET_USER_ID="select emp_name as userId from employee where email_id=?";
	
	
	public static final String GET_EMPLOYEE_ID="select emp_id as empId from employee where email_id=?";

	public static final String UPDATE_PASSWORD_WITH_EMAIL ="Update auth.app_user set password=:forgottenPassword,pwd_changed='false' where reference_id=:empId returning reference_id as referenceId";

	
	public static final String GET_EMP_NAME="select user_name as userName from user_master where emp_id=?";
}
