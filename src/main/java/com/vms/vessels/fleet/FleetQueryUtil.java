package com.vms.vessels.fleet;

public class FleetQueryUtil {

	public static final String SAVE_FLEET = "Insert into fleet_master (fleet_code,fleet_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

public static final String getList = "select fleet_id as fleetid,fleet_code as code,fleet_name as description from fleet_master order by created_dt desc";

public static final String getEdit = "select fleet_id as fleetid,fleet_code as code,fleet_name as description from fleet_master where fleet_id = ?";

public static final String delete = "delete from fleet_master where fleet_id = ? ";

public static final String checkDelete = "select count(*) from fleet_master where fleet_id = ?";

public static final String UPDATE_FLEET = "update fleet_master set fleet_id =:fleetid,fleet_code=:code,fleet_name=:desc,modified_by=:userName,modified_dt=now() where fleet_id = :fleetid";

public static final String get_code = "select count(fleet_code) from fleet_master where fleet_code=?";

public static final String get_desc = "select count(fleet_name) from fleet_master where fleet_name=?";

public static final String fleet_code = "select fleet_code from fleet_master where fleet_id= ?";

public static final String fleet_desc = "select fleet_name from fleet_master where fleet_id= ?";

public static final String get_code_edit = "SELECT COUNT(fleet_code) FROM fleet_master WHERE fleet_code = ?  AND fleet_code != ?";

public static final String get_desc_edit = "SELECT COUNT(fleet_name) FROM fleet_master WHERE fleet_name = ?  AND fleet_name != ?";

public static final String getCodeById = "SELECT fleet_code FROM fleet_master WHERE fleet_id = ?";


}
