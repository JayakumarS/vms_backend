package com.vms.crew.maintain.religion;

public class ReligionQueryUtil {

	public static final String SAVE_RELIGION_TYPE = "Insert into religion_master (religion_code,religion_name,created_by,created_dt,is_active)"
			+ "values (:code,:name,:userName,now(),:active)";
	
	public static final String UPDATE_RELIGION_TYPE ="update religion_master set religion_code=:code,religion_name=:name,modified_by=:userName,modified_dt=now(),is_active=:active where religion_code = :code";

	public static final String getList ="select religion_code as code,religion_name as name from religion_master order by created_dt desc";

	public static final String getEdit =  "select religion_code as code,religion_name as name,is_active as active from religion_master where religion_code = ?";

	public static final String checkDelete = "select count(*) from religion_master where religion_code = ?";
	
	public static final String delete = "delete from religion_master where religion_code = ? ";



}
