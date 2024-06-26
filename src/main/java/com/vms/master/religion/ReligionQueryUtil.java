package com.vms.master.religion;

public class ReligionQueryUtil {

	public static final String SAVE_RELIGION = "Insert into religion_master (religion_code,religion_name,created_by,created_dt,is_active)"
			+ "values (:code,:name,:userName,now(),:active)";
	
	public static final String UPDATE_RELIGION ="update religion_master set religion_code=:code,religion_name=:name,modified_by=:userName,modified_dt=now(),is_active=:active where religion_id = :religionId";

	public static final String getList ="select religion_code as code,religion_name as name,religion_id as religionId from religion_master order by created_dt desc";

	public static final String getEdit =  "select religion_code as code,religion_name as name,is_active as active, religion_id as religionId from religion_master where religion_id = CAST(? AS INTEGER)";

	
	public static final String delete = "delete from religion_master where religion_id = ? ";

	public static final String get_RELIGION_Id ="SELECT CONCAT(CAST(COALESCE(MAX(CAST(NULLIF(SUBSTRING(religion_code FROM 1), '') AS INTEGER)), 0) + 1 AS TEXT)) AS next_religion_code FROM religion_master";

	public static final String get_name = "select count(religion_name) from religion_master where religion_name=?";

	public static final String religion_name = "select religion_name from religion_master where religion_id= ?";
	

	public static final String get_religion_edit = "SELECT COUNT(religion_name) FROM religion_master WHERE religion_name = ?  AND religion_name != ?";


	
}
