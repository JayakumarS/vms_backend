package com.vms.master.department;

public class DepartmentQueryUtil {
	
	public static final String department_save="INSERT INTO department_master (dept_code,dept_name,dept_head,is_active,created_by,created_dt)"
			+ "values (:code,:name,:head,:active,:userName,now())";
	
	public static final String department_list="SELECT dept_code as code, dept_name as name,dept_head as head,is_active as active FROM department_master ORDER by created_dt desc";
	
	public static final String department_edit="SELECT dept_code as code,dept_name as name, dept_head as head,is_active as active"
			+ " FROM department_master WHERE dept_code=?";
	
	public static final String department_update="UPDATE department_master SET dept_code=:code, dept_name=:name, dept_head=:head,is_active=:active,"
			+ "modified_by=:userName,modified_dt=now() WHERE dept_code=:code";
	
	public static final String department_delete="DELETE FROM department_master WHERE dept_code = ? ";
	
	public static final String checkDelete="SELECT COUNT(*) FROM department_master WHERE dept_code = ?";
	

}
