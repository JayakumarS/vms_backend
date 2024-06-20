package com.vms.common.services;

public class CommonServiceQueryUtil {

	public static final String VALIDATE_UNIQUE = "SELECT * FROM fn_unique_validation(?,?,?)";

	
	public static final String GET_USER_ID="select emp_name as userId from employee where email_id=?";
	
	
	public static final String GET_EMPLOYEE_ID="select emp_id as empId from employee where email_id=?";

	public static final String UPDATE_PASSWORD_WITH_EMAIL ="Update auth.app_user set password=:forgottenPassword,pwd_changed='false' where reference_id=:empId returning reference_id as referenceId";
	
	public static final String GET_EMP_NAME="select user_name as userName from user_master where emp_id=?";
	
	public static final String FLEET_LIST = "select fleet_code as id,fleet_name as text from fleet_master";
	
	public static final String CLASS_LIST = "select vessel_class_code as id,vessel_class_name as text from vessel_class";
	
	public static final String VESSEL_TYPE = "select vessel_type_code as id,vessel_type_name as text from vessel_type";
	
	public static final String VESSEL_INSURANCE = "select vessel_insurance_code as id,vessel_insurance_name as text from vessel_insurance";
	
	public static final String WAGE_SCALE = "select wage_scale_code as id,wage_scale_name as text from wage_scales";
	
	public static final String GET_PORT = "select port_code as id,port_name as text from port_master";
	
	public static final String GET_COUNTRY = "select country_code as id,country_name as text from country_master";

	public static final String GET_CURRENCY = "select currency_code as id,currency_name as text from currency_master";

	public static final String GET_PHONECODE = "select distinct phonecode as id,phonecode as text from country_master";
		
	public static final String GET_VESSEL_OWNER = "select vessel_owner_code as id,vessel_owner_name as text from vessel_owner";
	
	public static final String GET_OFFICIAL_MANAGERS = "select official_manager_code as id,official_manager_name as text from official_managers";
	
	public static final String GET_SHIP_MANAGERS = "select ship_manager_code as id,ship_manager_name as text from ship_managers";

	public static final String GET_VESSEL = "select vessel_code as id,vessel_name as text from vessel_hdr";

	public static final String GET_JOINPORT = "select port_name as id,country_name as name from country_master cm\r\n"
			+ "left join port_master pm on cm.country_code = pm.country_code";
	
	public static final String GET_RANK_MASTERS = "select rank_id as id,rank_name as text from rank_master";
	
	public static final String GET_AGENTS = "select agent_code as id,agent_code_name as text from agent_master";
	
	public static final String GET_RELIGION = "select religion_code as id,religion_name as text from religion_master";
	
	public static final String GET_WORK_LICENSE = "select work_license_code as id,work_license_name from work_license";
	
	public static final String GET_WORK_STATUS = "select work_status_code as id,work_status_name as text from work_status";
	
	public static final String GET_HEALTH_STATUS = "select health_status_code as id,health_status_name as text from health_status";
}
