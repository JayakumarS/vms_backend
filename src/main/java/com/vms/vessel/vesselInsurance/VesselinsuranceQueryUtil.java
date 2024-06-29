package com.vms.vessel.vesselInsurance;

public class VesselinsuranceQueryUtil {
	
public static final String SAVE_vsl_insurance = "Insert into vessel_insurance (vessel_insurance_code,vessel_insurance_name,remarks,ins_flag,created_by,created_dt)"
		+ "values (:code,:desc,:remarks,:flag,:userName,now())";

public static final String getList_pandi = "select vessel_insurance_code as code,vessel_insurance_name as description,remarks as remarks,vessel_insurance_id as vesselinsuranceid,ins_flag as flag from vessel_insurance where ins_flag='P&I' order by created_dt desc";

public static final String getList_fdandd = "select vessel_insurance_code as code,vessel_insurance_name as description,remarks as remarks,vessel_insurance_id as vesselinsuranceid,ins_flag as flag from vessel_insurance where ins_flag='FD&D' order by created_dt desc";


public static final String getEdit = "select vessel_insurance_code as code,vessel_insurance_name as description,remarks as remarks,vessel_insurance_id as vesselinsuranceid,ins_flag as flag from vessel_insurance where vessel_insurance_id = ?";

public static final String delete = "delete from vessel_insurance where vessel_insurance_id = ? ";

public static final String checkDelete = "select count(*) from vessel_insurance where vessel_insurance_id = ?";

public static final String UPDATE_vsl_insurance = "update vessel_insurance set vessel_insurance_code=:code,vessel_insurance_name=:desc,remarks=:remarks,modified_by=:userName,modified_dt=now() where vessel_insurance_id = :vesselinsuranceid";

public static final String get_code = "select count(vessel_insurance_code) from vessel_insurance where vessel_insurance_code=?";

public static final String get_desc = "select count(vessel_insurance_name) from vessel_insurance where vessel_insurance_name=?";

public static final String vesselinsurance_code ="select vessel_insurance_code from vessel_insurance where vessel_insurance_id= ?";

public static final String vesselinsurance_desc = "select vessel_insurance_name from vessel_insurance where vessel_insurance_id= ?";

public static final String get_code_edit = "SELECT COUNT(vessel_insurance_code) FROM vessel_insurance WHERE vessel_insurance_code = ?  AND vessel_insurance_code != ?";

public static final String get_desc_edit = "SELECT COUNT(vessel_insurance_name) FROM vessel_insurance WHERE vessel_insurance_name = ?  AND vessel_insurance_name != ?";

public static final String getCodeById = "SELECT vessel_insurance_code FROM vessel_insurance WHERE vessel_insurance_id = ?";


}
