package com.vms.vessel.vesselOwner;

public class VesselOwnerQueryUtil {
	public static final String SAVE_vessel_owner = "Insert into vessel_owner (vsl_owner_code,vsl_owner_desc,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select vsl_owner_code as code,vsl_owner_desc as description from vessel_owner order by created_dt desc";

	public static final String getEdit = "select vsl_owner_code as code,vsl_owner_desc as description from vessel_owner where vsl_owner_code = ?";

	public static final String delete = "delete from vessel_owner where vsl_owner_code = ? ";

	public static final String checkDelete = "select count(*) from vessel_owner where vsl_owner_code = ?";

	public static final String UPDATE_vessel_owner = "update vessel_owner set vsl_owner_code=:code,vsl_owner_desc=:desc,modified_by=:userName,modified_dt=now() where vsl_owner_code = :code";


}
