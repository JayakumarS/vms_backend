package com.vms.crew.healthStatus;

public class HealthStatusQueryUtil {
	
	public static final String SAVE_health_status = "Insert into health_status (health_status_code,health_status_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select health_status_code as code,health_status_name as description,health_status_id as healthstatusid from health_status order by created_dt desc";

	public static final String getEdit = "select health_status_code as code,health_status_name as description,health_status_id as healthstatusid from health_status where health_status_id = ?";

	public static final String delete = "delete from health_status where health_status_id = ? ";

	public static final String checkDelete = "select count(*) from health_status where health_status_code = ?";

	public static final String UPDATE_health_status = "update health_status set health_status_code=:code,health_status_name=:desc,modified_by=:userName,modified_dt=now() where health_status_id = :healthstatusid";

	public static final String get_code = "select count(health_status_code) from health_status where health_status_code=?";

	public static final String get_desc = "select count(health_status_name) from health_status where health_status_name=?";

	public static final String health_code = "select health_status_code from health_status where health_status_id= ?";

	public static final String health_desc = "select health_status_name from health_status where health_status_id= ?";

	public static final String getCodeById = "SELECT health_status_code FROM health_status WHERE health_status_id = ?";

	public static String get_code_edit="SELECT COUNT(health_status_code) FROM health_status WHERE health_status_code = ?  AND health_status_code != ?";

	public static String get_desc_edit="SELECT COUNT(health_status_name) FROM health_status WHERE health_status_name = ?  AND health_status_name != ?";

	
	

}
