package com.vms.crew.workStatus;

public class WorkStatusQueryUtil {
	public static final String SAVE_work_status = "Insert into work_status (work_status_code,work_status_desc,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select work_status_code as code,work_status_desc as description from work_status order by created_dt desc";

	public static final String getEdit = "select work_status_code as code,work_status_desc as description from work_status where work_status_code = ?";

	public static final String delete = "delete from work_status where work_status_code = ? ";

	public static final String checkDelete = "select count(*) from work_status where work_status_code = ?";

	public static final String UPDATE_work_status = "update work_status set work_status_code=:code,work_status_desc=:desc,modified_by=:userName,modified_dt=now() where work_status_code = :code";
}
