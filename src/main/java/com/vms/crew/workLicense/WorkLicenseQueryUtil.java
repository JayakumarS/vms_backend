package com.vms.crew.workLicense;

public class WorkLicenseQueryUtil {
	public static final String SAVE_work_license = "Insert into work_license (work_license_code,work_license_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select work_license_code as code,work_license_name as description from work_license order by created_dt desc";

	public static final String getEdit = "select work_license_code as code,work_license_name as description from work_license where work_license_code = ?";

	public static final String delete = "delete from work_license where work_license_code = ? ";

	public static final String checkDelete = "select count(*) from work_license where work_license_code = ?";

	public static final String UPDATE_work_license = "update work_license set work_license_code=:code,work_license_name=:desc,modified_by=:userName,modified_dt=now() where work_license_code = :code";

}
