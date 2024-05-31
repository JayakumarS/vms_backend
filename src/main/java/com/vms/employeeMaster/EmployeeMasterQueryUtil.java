package com.vms.employeeMaster;

public class EmployeeMasterQueryUtil {
	
	public static final String INSERT_Employee = " INSERT INTO employee (emp_id, email_id, emp_user_id,emp_name,created_by,created_date) VALUES (:empId, :emailId, :empUserId, '',now())";
	
	public static final String INSERT_AppUser = "INSERT INTO auth.app_user(user_id,password,reference_id)values(:empUserId,:password,:empId)";
//	
//	public static String GETUSERDETAILS = "select user_id as username,reference_id as email,c.company_logo as companyLogo, "
//			+ "password as password from auth.app_user a "
//			+ "left join company_master c on c.user_name = a.user_id where user_id=? ";
	
	public static String GETUSERDETAILS = "select user_id as username,reference_id as email,password as password from auth.app_user where user_id ilike ? and is_active = true  ";
	
	public static String GET_COMPANY_LOGO = "select company_logo as companyLogo from company_master ";
	
	public static String GETEMPID = "SELECT CASE WHEN MAX(emp_id) IS NULL  THEN 'E0001' ELSE rpad(MAX(emp_id),1,'E')|| lpad(cast(cast((SUBSTRING(MAX(emp_id),2)) as int)+1  as text),4,'0') END FROM employee";
}
