package com.vms.common.services;

public class CommonServiceQueryUtil {

	public static final String VALIDATE_UNIQUE = "SELECT * FROM fn_unique_validation(?,?,?)";

	
	public static final String GET_USER_ID="select emp_name as userId from employee where email_id=?";
	
	
	public static final String GET_EMPLOYEE_ID="select emp_id as empId from employee where email_id=?";

	public static final String UPDATE_PASSWORD_WITH_EMAIL ="Update auth.app_user set password=:forgottenPassword,pwd_changed='false' where reference_id=:empId returning reference_id as referenceId";
	
	public static final String GET_EMP_NAME="select user_name as userName from user_master where emp_id=?";
	
	public static final String FLEET_LIST = "select fleet_id as id,fleet_name as text from fleet_master";
	
	public static final String CLASS_LIST = "select vessel_class_id as id,vessel_class_name as text from vessel_class";
	
	public static final String VESSEL_TYPE = "select vessel_type_id as id,vessel_type_name as text from vessel_type";
	
	public static final String VESSEL_INSURANCE = "select vessel_insurance_id as id,vessel_insurance_name as text from vessel_insurance";
	
	public static final String WAGE_SCALE = "select wage_scale_id as id,wage_scale_name as text from wage_scales";
	
	public static final String GET_PORT = "select port_id as id,port_name as text from port_master";
	
	public static final String GET_COUNTRY = "select country_code as id,country_name as text from country_master";
//	public static final String GET_COUNTRY = "select country_id as id,country_name as text from country_master";

	public static final String GET_CURRENCY = "select currency_code as id,currency_code as text from currency_master";

	public static final String GET_PHONECODE = "select distinct phonecode as id,phonecode as text from country_master";
		
	public static final String GET_VESSEL_OWNER = "select vessel_owner_id as id,vessel_owner_name as text from vessel_owner";
	
	public static final String GET_OFFICIAL_MANAGERS = "select official_managers_id as id,official_manager_name as text from official_managers";
	
	public static final String GET_SHIP_MANAGERS = "select ship_managers_id as id,ship_manager_name as text from ship_managers";

	public static final String GET_VESSEL = "select vessel_code as id,vessel_name as text from vessel_hdr";

	public static final String GET_JOINPORT = "select port_id as id,port_name as text,cm.country_name as code from port_master pm\r\n"
			+ "left join country_master cm on cm.country_code = pm.country_code";
	
	public static final String GET_RANK_MASTERS = "select rank_id as id,rank_name as text from rank_master";
	
	public static final String GET_AGENTS = "select agent_id as id,agent_code_name as text from agent_master";
	
	public static final String GET_RELIGION = "select religion_id as id,religion_name as text from religion_master";
	
	public static final String GET_WORK_LICENSE = "select work_license_id as id,work_license_name as text from work_license";
	
	public static final String GET_WORK_STATUS = "select work_status_id as id,work_status_name as text from work_status";
	
	public static final String GET_HEALTH_STATUS = "select health_status_id as id,health_status_name as text from health_status";

	public static final String GET_SEAMEN_NAME = "select crew_master_code as id,crew_master_name as text,crew_master_rank as rankId,\r\n"
			+ " crew_master_nationality as nationalityId,rm.rank_name as rankName,co.nationality as nationalityName\r\n"
			+ " from crew_master cm\r\n"
			+ " left join rank_master rm on rm.rank_id = cm.crew_master_rank\r\n"
			+ " left join country_master co on co.country_id = cm.crew_master_nationality";
	
	public static final String GET_EXP_ENGINE = "select engine_type_id as id,engine_type_name as text from engine_type";

	public static final String GET_RANK_GROUP = "select rank_group_id as id ,rank_group_name as text  from rank_group";

	public static final String GET_DEPARTMENT = "select dept_id as id ,dept_name as text  from department_master";

	public static final String GET_NATIONALITY = "select country_id as id ,nationality as text from country_master";
	
	public static final String GET_UOM = "select uom_id as id,uom_code as text from unit_of_measurement ";
	
	public static final String GET_SUPPLIE_DEPARTMENT = "select supplie_department_id as id,supplie_dep_code || '-' || supplie_department_name as text from supplie_department ";
}
