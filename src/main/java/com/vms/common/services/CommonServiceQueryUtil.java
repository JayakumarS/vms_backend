package com.vms.common.services;

public class CommonServiceQueryUtil {

	public static final String VALIDATE_UNIQUE = "SELECT * FROM fn_unique_validation(?,?,?)";

	
	public static final String GET_USER_ID="select emp_name as userId from employee where email_id=?";
	
	
	public static final String GET_EMPLOYEE_ID="select emp_id as empId from employee where email_id=?";

	public static final String UPDATE_PASSWORD_WITH_EMAIL ="Update auth.app_user set password=:forgottenPassword,pwd_changed='false' where reference_id=:empId returning reference_id as referenceId";
	
	public static final String GET_EMP_NAME="select user_name as userName from user_master where emp_id=?";
	
	public static final String FLEET_LIST = "select fleet_code as id,fleet_name as text from fleet_master";
	
	public static final String CLASS_LIST = "select vessel_class_code as id,vsl_class_desc as text from vessel_class";
	
	public static final String VESSEL_TYPE = "select vsl_type_code as id,vsl_type_name as text from vessel_type";
	
	public static final String VESSEL_INSURANCE = "select vsl_ins_code as id,description as text from vsl_insurance";
	
	public static final String WAGE_SCALE = "select wage_scale_code as id,wage_scale_desc as text from wage_scales";
	
	public static final String GET_PORT = "select portcode as id,portname as text from port_master";
	
	public static final String GET_COUNTRY = "select country_code as id,country_name as text from country_master";


	public static final String GET_CURRENCY = "select currency_code as id,currency_name as text from currency_master";


	public static final String GET_PHONECODE = "select distinct phonecode as id,phonecode as text from country_master";
}
