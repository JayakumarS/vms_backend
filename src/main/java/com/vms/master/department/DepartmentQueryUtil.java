package com.vms.master.department;

public class DepartmentQueryUtil {
	
	public static final String department_save="INSERT INTO department_master (dept_code,dept_name,dept_head,is_active,created_by,created_dt)"
			+ "values (:code,:name,:head,:active,:userName,now())";
	
	public static final String department_list="SELECT dm.dept_id as deptId, dm.dept_code as code, dm.dept_name as name,rg.rank_group_name as head,"
			+ "dm.is_active as active FROM department_master dm LEFT JOIN rank_group rg ON dm.dept_head = rg.rank_group_id::text";
	
	public static final String department_edit="SELECT dm.dept_code as code, dm.dept_name as name, dm.dept_head as head,"
			+ "dm.is_active as active FROM department_master dm WHERE dept_id=?";
	
	public static final String department_update="UPDATE department_master SET dept_code=:code, dept_name=:name, dept_head=:head,is_active=:active,"
			+ "modified_by=:userName,modified_dt=now() WHERE dept_id=:deptId";
	
	public static final String department_delete="DELETE FROM department_master WHERE dept_id = ? ";
	
	public static final String checkDelete="SELECT COUNT(*) FROM department_master WHERE dept_code = ?";
	
	public static final String check_code_exists="SELECT COUNT(dept_code) FROM department_master WHERE dept_code= ?";
	
	public static final String check_name_exists="SELECT COUNT(dept_name) FROM department_master WHERE dept_name= ?";
	
	public static final String dept_code = "select dept_code from department_master where dept_id = ?";

	public static final String dept_name = "select dept_name  from department_master where dept_id = ?";
	
	public static final String get_code_edit = "SELECT COUNT(dept_code) FROM department_master WHERE dept_code = ?  AND dept_code != ?";

	public static final String get_name_edit = "SELECT COUNT(dept_name) FROM department_master WHERE dept_name = ?  AND dept_name != ?";
	
	public static final String get_dept_id = "SELECT CONCAT('D', LPAD(CAST(COALESCE(MAX(CAST(SUBSTRING(dept_code, 2) AS INTEGER)), 0) + 1 AS TEXT), 4, '0'))"
			+ " AS next_dept_code FROM department_master";
	
	public static final String getCodeById = "SELECT dept_code FROM department_master WHERE dept_id = ?";

	
	

}
