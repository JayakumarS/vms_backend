package com.vms.vessel.vesselOwner;

public class VesselOwnerQueryUtil {
	public static final String SAVE_vessel_owner = "Insert into vessel_owner (vessel_owner_code,vessel_owner_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select vessel_owner_code as code,vessel_owner_name as description,vessel_owner_id as vesselownerid from vessel_owner order by created_dt desc";

	public static final String getEdit = "select vessel_owner_code as code,vessel_owner_name as description,vessel_owner_id as vesselownerid from vessel_owner where vessel_owner_id = ?";

	public static final String delete = "delete from vessel_owner where vessel_owner_id = ? ";

	public static final String checkDelete = "select count(*) from vessel_owner where vessel_owner_code = ?";

	public static final String UPDATE_vessel_owner = "update vessel_owner set vessel_owner_code=:code,vessel_owner_name=:desc,modified_by=:userName,modified_dt=now() where vessel_owner_id = :vesselownerid";
	
	public static final String get_code = "select count(vessel_owner_code) from vessel_owner where vessel_owner_code=?";

	public static final String get_desc = "select count(vessel_owner_name) from vessel_owner where vessel_owner_name=?";
	
	public static final String vessel_code = "select vessel_owner_code from vessel_owner where vessel_owner_id = ?";

	public static final String vessel_desc = "select vessel_owner_name from vessel_owner where vessel_owner_id = ?";

	public static final String get_code_edit = "SELECT COUNT(vessel_owner_code) FROM vessel_owner WHERE vessel_owner_code = ?  AND vessel_owner_code != ?;";

	public static final String get_desc_edit = "SELECT COUNT(vessel_owner_name) FROM vessel_owner WHERE vessel_owner_name = ?  AND vessel_owner_name != ?;";

	public static final String getCodeById = "SELECT vessel_owner_code FROM vessel_owner WHERE vessel_owner_id = ?";



}
