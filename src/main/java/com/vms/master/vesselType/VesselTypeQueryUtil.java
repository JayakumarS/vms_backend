package com.vms.master.vesselType;

public class VesselTypeQueryUtil {

	public static final String SAVE_VESSEL_TYPE = "Insert into vessel_type (vsl_type_code,vsl_type_name,created_by,created_dt)"
												+ "values (:code,:desc,:userName,now())";
	
	public static final String getList = "select vsl_type_code as code,vsl_type_name as description from vessel_type order by created_dt desc";
	
	public static final String getEdit = "select vsl_type_code as code,vsl_type_name as description from vessel_type where vsl_type_code = ?";
	
	public static final String delete = "delete from vessel_type where vsl_type_code = ? ";
	
	public static final String checkDelete = "select count(*) from vessel_type where vsl_type_code = ?";
	
	public static final String UPDATE_VESSEL_TYPE = "update vessel_type set vsl_type_code=:code,vsl_type_name=:desc,modified_by=:userName,modified_dt=now() where vsl_type_code = :code";

}
