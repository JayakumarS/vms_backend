package com.vms.vessels.iceClass;

public class IceClassQueryUtil {
	
	public static final String save_ice = "INSERT INTO ice_class (ice_code_id,ice_code,created_by,create_dt)"
			+ "VALUES (:code,:desc,:userName,now())";

	public static final String get_ice_list = "SELECT  ice_id as iceId, ice_code_id as code,ice_code as desc FROM ice_class ORDER by create_dt desc";

	public static final String get_ice_edit = "SELECT ice_id as iceId, ice_code_id as code, ice_code as desc FROM ice_class WHERE ice_id= ?";

	public static final String delete_ice = "DELETE from ice_class where ice_id = ? ";

	public static final String update_ice = "UPDATE ice_class set ice_code_id=:code,ice_code=:desc,modified_by=:userName,modified_dt=now() where ice_id =:iceId";

	public static final String get_code= "SELECT MAX(ice_code_id+1) FROM ice_class";

	public static final String getCodeById = "SELECT COALESCE(MAX(ice_code_id+1), 1) AS code FROM ice_class";
}
