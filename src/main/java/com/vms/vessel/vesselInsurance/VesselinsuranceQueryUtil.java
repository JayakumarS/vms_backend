package com.vms.vessel.vesselInsurance;

public class VesselinsuranceQueryUtil {
	
public static final String SAVE_vsl_insurance = "Insert into vessel_insurance (vessel_insurance_code,vessel_insurance_name,created_by,created_dt)"
		+ "values (:code,:desc,:userName,now())";

public static final String getList = "select vessel_insurance_code as code,vessel_insurance_name as description from vessel_insurance order by created_dt desc";

public static final String getEdit = "select vessel_insurance_code as code,vessel_insurance_name as description from vessel_insurance where vessel_insurance_code = ?";

public static final String delete = "delete from vessel_insurance where vessel_insurance_code = ? ";

public static final String checkDelete = "select count(*) from vessel_insurance where vessel_insurance_code = ?";

public static final String UPDATE_vsl_insurance = "update vessel_insurance set vessel_insurance_code=:code,vessel_insurance_name=:desc,modified_by=:userName,modified_dt=now() where vessel_insurance_code = :code";


}
