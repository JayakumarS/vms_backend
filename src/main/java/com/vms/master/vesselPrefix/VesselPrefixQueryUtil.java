package com.vms.master.vesselPrefix;

public class VesselPrefixQueryUtil {

	public static final String SAVE_VESSEL_TYPE = "Insert into vessel_prefix (vsl_prefix_code,vsl_prefix_desc,created_by,created_dt)"
												+ "values (:code,:desc,:userName,now())";
	
	public static final String getList = "select vessel_prefix_code as code,vessel_prefix_desc as description from vessel_prefix order by created_dt desc";
	
	public static final String getEdit = "select vsl_prefix_code as code,vsl_prefix_desc as description from vessel_prefix where vsl_prefix_code = ?";
	
	public static final String delete = "delete from vessel_prefix where vsl_prefix_code = ? ";
	
	public static final String checkDelete = "select count(*) from vessel_prefix where vsl_prefix_code = ?";
	
	public static final String UPDATE_VESSEL_TYPE = "update vessel_prefix set vsl_prefix_code=:code,vsl_prefix_desc=:desc,modified_at=:userName,modified_dt=now() where vsl_prefix_code = :code";

}
