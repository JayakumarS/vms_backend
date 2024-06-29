package com.vms.master.vesselPrefix;

public class VesselPrefixQueryUtil {

	public static final String SAVE_VESSEL_TYPE = "Insert into vessel_prefix (vessel_prefix_code,vessel_prefix_name,created_by,created_dt)"
												+ "values (:code,:desc,:userName,now())";
	
	public static final String getList = "select vessel_prefix_code as code,vessel_prefix_name as description,vessel_prefix_id as vesselprefixid from vessel_prefix order by created_dt desc";
	
	public static final String getEdit = "select vessel_prefix_code as code,vessel_prefix_name as description,vessel_prefix_id as vesselprefixid from vessel_prefix where vessel_prefix_id = ?";
	
	public static final String delete = "delete from vessel_prefix where vessel_prefix_id = ? ";
		
	public static final String UPDATE_VESSEL_TYPE = "update vessel_prefix set vessel_prefix_code=:code,vessel_prefix_name=:desc,modified_by=:userName,modified_dt=now() where vessel_prefix_id = :vesselprefixid";

	public static final String get_code = "select count(vessel_prefix_code) from vessel_prefix where vessel_prefix_code=?";

	public static final String getCodeById = "SELECT vessel_prefix_code FROM vessel_prefix WHERE vessel_prefix_id = ?";

	public static final String prefix_code = "select vessel_prefix_code from vessel_prefix where vessel_prefix_id = ?";

	public static final String get_code_edit = "SELECT COUNT(vessel_prefix_code) FROM vessel_prefix WHERE vessel_prefix_code = ?  AND vessel_prefix_code != ?;";

}
