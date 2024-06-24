package com.vms.crew.workStatus;

public class WorkStatusQueryUtil {
	public static final String SAVE_work_status = "Insert into work_status (work_status_code,work_status_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select work_status_code as code,work_status_name as description,work_status_id as workstatusid from work_status order by created_dt desc";

	public static final String getEdit = "select work_status_code as code,work_status_name as description,work_status_id as workstatusid from work_status where work_status_id = ?";

	public static final String delete = "delete from work_status where work_status_id = ? ";

	public static final String checkDelete = "select count(*) from work_status where work_status_code = ?";

	public static final String UPDATE_work_status = "update work_status set work_status_code=:code,work_status_name=:desc,modified_by=:userName,modified_dt=now() where work_status_id = :workstatusid";
	
	public static final String get_code = "select count(work_status_code) from work_status where work_status_code=?";

	public static final String get_desc = "select count(work_status_name) from work_status where work_status_name=?";

	public static final String workstatus_code = "select work_status_code from work_status where work_status_id= ?";

	public static final String workstatus_desc = "select work_status_name from work_status where work_status_id= ?";

	public static final String get_code_edit = "SELECT COUNT(work_status_code) FROM work_status WHERE work_status_code = ?  AND work_status_code != ?";

	public static final String get_desc_edit = "SELECT COUNT(work_status_name) FROM work_status WHERE work_status_name = ?  AND work_status_name != ?";

}
