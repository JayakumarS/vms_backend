package com.vms.vessel.vesselOwner;

public class VesselOwnerQueryUtil {
	public static final String SAVE_vessel_owner = "Insert into vessel_owner (vessel_owner_code,vessel_owner_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select vessel_owner_code as code,vessel_owner_name as description from vessel_owner order by created_dt desc";

	public static final String getEdit = "select vessel_owner_code as code,vessel_owner_name as description from vessel_owner where vessel_owner_code = ?";

	public static final String delete = "delete from vessel_owner where vessel_owner_code = ? ";

	public static final String checkDelete = "select count(*) from vessel_owner where vessel_owner_code = ?";

	public static final String UPDATE_vessel_owner = "update vessel_owner set vessel_owner_code=:code,vessel_owner_name=:desc,modified_by=:userName,modified_dt=now() where vessel_owner_code = :code";


}