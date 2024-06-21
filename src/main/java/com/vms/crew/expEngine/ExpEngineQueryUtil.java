package com.vms.crew.expEngine;

public class ExpEngineQueryUtil {
	
	
	public static final String SAVE_exp_Engine = "Insert into engine_master (engine_master_code,engine_master_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select engine_master_code as code,engine_master_name as description from engine_master order by created_dt desc";

	public static final String getEdit = "select engine_master_code as code,engine_master_name as description from engine_master where engine_master_code = ?";

	public static final String delete = "delete from engine_master where engine_master_code = ? ";

	public static final String checkDelete = "select count(*) from engine_master where engine_master_code = ?";

	public static final String UPDATE_exp_Engine = "update engine_master set engine_master_code=:code,engine_master_name=:desc,modified_by=:userName,modified_dt=now() where engine_master_code = :code";

	

}
