package com.vms.usermaster;

public class UserMasterQueryUtil {
	
	public static final String INSERT_AUTH_MASTER = "INSERT INTO auth.app_user(user_id,password,reference_id,is_active)values(:loginName,:password,:empId,'true')";

	public static final String INSERT_EMPLOYEE = "INSERT INTO employee (emp_id, email_id, emp_user_id,emp_name,created_by,created_dt) VALUES \r\n"
			+ "(:empId, :emailId, :loginName,:createdby, '',now())";


	public static final String INSERT_Company_User = "INSERT INTO company_user (user_id, company_code) VALUES (:empId, :company)";
	
	public static final String GETEMPID = "SELECT CASE WHEN MAX(emp_id) IS NULL  THEN 'E0001' ELSE rpad(MAX(emp_id),1,'E')|| lpad(cast(cast((SUBSTRING(MAX(emp_id),2)) as int)+1  as text),4,'0') END FROM employee";

	public static final String VALIDATE_UNIQUE = "select count(*) from auth.app_user where user_id = ?";
	
	public static final String VALIDATE_UNIQUE_id = "select count(*) from auth.app_user where reference_id = ?";


	public static String getDesignationList = "select desgn_code as id, desgn_name as text from designation order by desgn_code asc";
	
	public static String getDepartnemtList = "select dept_code as id ,dept_name as text from department";
	
	public static String getUserNameList = "select user_master_id as id ,user_name as text from user_master order by text asc";
	
	public static String Insert_User_Master = "insert into user_master(user_name,email_id,mobile_number,designation,department,company,address,location,reporting_manager,user_type,is_active,created_by,\r\n"
			+ "	created_dt,modified_by,modified_dt,login_name,emp_id) values (:fullName,:emailId,:contactNumber,:designation,:department,:company,:address,:location,:reportingmngr,:usertype,:status,:createdby,now(),:fullName,now(),:loginName,:empId)";
	
	public static final String UPDATE_USER_MASTER = "update user_master set user_name=:fullName,email_id=:emailId,mobile_number=:contactNumber,designation=:designation,\r\n"
			+ "department=:department,company=:company,address=:address,location=:location,reporting_manager=:reportingmngr,user_type=:usertype,is_active=:status,login_name=:loginName where emp_id = :empId";
	
	public static final String UPDATE_AUTH_MASTER = "update auth.app_user set user_id=:loginName where reference_id = :empId ";
	
	public static final String UPDATE_EMPLOYEE_MASTER = "update employee set email_id=:emailId,emp_name=:fullName,emp_user_id=:loginName where emp_id = :empId ";
	
	public static final String UPDATE_COMPANY_MASTER = "update company_user set company_code = :company where user_id =:empId ";
	
	public static String Delete_User_Master = "Delete from user_master where user_master_id = ? ";
	
	public static String getList = "select user_master_id as id,UPPER(user_name) as fullName,email_id as emailId,mobile_number as contactNumber,ds.desgn_name as designation,\r\n"
			+ "d.dept_name as department,company as company,address as address,l.location_name as locationName,emp_id as empId from user_master u\r\n"
			+ "left join designation ds on ds.desgn_code = u.designation\r\n"
			+ "left join department d on d.dept_code = u.department\r\n"
			+ "left join location l on l.location_id = u.location order by fullname asc " ;
	
	public static String getEdit = "select user_master_id as userId,user_name as fullName,email_id as emailId,mobile_number as contactNumber,designation as designation,department as \r\n"
			+ "department,company as company,address as address,location as location,reporting_manager as reportingmngr,user_type as usertype,is_active as status,emp_id as empId,login_name as loginName from user_master\r\n"
			+ "where user_master_id = ? ";
	
	public static final String GETOLDPASSWORD = "select password  from auth.app_user where user_id = ?";
	
	public static final String UPDATE_CHANGE_PASSWORD = "UPDATE auth.app_user set password=:password,pwd_changed='true' where user_id=:emailId";
	
	public static final String GET_FLAG_VALUE = "select pwd_changed as pwdChanged from auth.app_user where user_id=?";
	
	public static final String GET_USER_ID = "select user_master_id from user_master where emp_id = ? ";

	public static final String Delete_flag_User_Master = "UPDATE auth.app_user set is_active = false where user_id ilike ?";


	
	
}
