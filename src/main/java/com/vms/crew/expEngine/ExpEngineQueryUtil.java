package com.vms.crew.expEngine;

public class ExpEngineQueryUtil {
	
	
	public static final String SAVE_exp_Engine = "Insert into engine_type (engine_type_code,engine_type_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select engine_type_id as engineid,engine_type_code as code,engine_type_name as description from engine_type order by created_dt desc";

	public static final String getEdit = "select engine_type_id as engineid, engine_type_code as code,engine_type_name as description from engine_type where engine_type_id = ?";

	public static final String delete = "delete from engine_type where engine_type_id = ? ";

	public static final String checkDelete = "select count(*) from engine_type where engine_type_id = ?";

	public static final String UPDATE_exp_Engine = "update engine_type set engine_type_code=:code,engine_type_name=:desc,modified_by=:userName,modified_dt=now() where engine_type_id = :engineid";
	
	public static final String get_code = "select count(engine_type_code) from engine_type where engine_type_code=?";

	public static final String get_desc = "select count(engine_type_name) from engine_type where engine_type_name=?";
	
	public static final String engine_code = "select engine_type_code from engine_type where engine_type_id= ?";

	public static final String engine_desc = "select engine_type_name from engine_type where engine_type_id= ?";

	public static String get_code_edit="SELECT COUNT(engine_type_code) FROM engine_type WHERE engine_type_code = ?  AND engine_type_code != ?";

	public static String get_desc_edit="SELECT COUNT(engine_type_name) FROM engine_type WHERE engine_type_name = ?  AND engine_type_name != ?";

	

}
