package com.vms.vessel.vesselInsurance;

public class VesselinsuranceQueryUtil {
	
public static final String SAVE_vsl_insurance = "Insert into vsl_insurance (vsl_ins_code,description,created_by,created_dt)"
		+ "values (:code,:desc,:userName,now())";

public static final String getList = "select vsl_ins_code as code,description as description from vsl_insurance order by created_dt desc";

public static final String getEdit = "select vsl_ins_code as code,description as description from vsl_insurance where vsl_ins_code = ?";

public static final String delete = "delete from vsl_insurance where vsl_ins_code = ? ";

public static final String checkDelete = "select count(*) from vsl_insurance where vsl_ins_code = ?";

public static final String UPDATE_vsl_insurance = "update vsl_insurance set vsl_ins_code=:code,description=:desc,modified_by=:userName,modified_dt=now() where vsl_ins_code = :code";


}
