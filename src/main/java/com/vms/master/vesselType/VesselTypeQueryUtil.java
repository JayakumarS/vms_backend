package com.vms.master.vesselType;

public class VesselTypeQueryUtil {

	public static final String SAVE_VESSEL_TYPE = "Insert into vessel_type (vessel_type_code,vessel_type_name,created_by,created_dt)"
												+ "values (:code,:desc,:userName,now())";
	
	public static final String getList = "select vessel_type_code as code,vessel_type_name as description,vessel_type_id as vessetypeid from vessel_type order by created_dt desc";
	
	public static final String getEdit = "select vessel_type_code as code,vessel_type_name as description,vessel_type_id as vessetypeid from vessel_type where vessel_type_id = ?";
	
	public static final String delete = "delete from vessel_type where vessel_type_id = ? ";
		
	public static final String UPDATE_VESSEL_TYPE = "update vessel_type set vessel_type_code=:code,vessel_type_name=:desc,modified_by=:userName,modified_dt=now() where vessel_type_id = :vessetypeid";

	public static final String get_code = "select count(vessel_type_code) from vessel_type where vessel_type_code=?";

	public static final String vessetype_code = "select vessel_type_code from vessel_type where vessel_type_id = ?";

	public static final String get_code_edit = "SELECT COUNT(vessel_type_code) FROM vessel_type WHERE vessel_type_code = ?  AND vessel_type_code != ?";

	public static final String getCodeById = "SELECT vessel_type_code FROM vessel_type WHERE vessel_type_id = ?";


}
