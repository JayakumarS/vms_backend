package com.vms.crew.maintain.Medicals;

public class MedicalQueryUtil {

	public static final String SAVE_medical = "Insert into medical_master (medical_code,medical_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";
	

	
	public static final String getList = "select medical_code as mcode,medical_name as mdescription,medical_id as MedicalId from medical_master order by created_dt desc";

	public static final String getEdit = "select medical_code as mcode,medical_name as mdescription,medical_id as MedicalId from medical_master where medical_id = ?";

	public static final String delete = "delete from medical_master where medical_id = ? ";


	public static final String UPDATE_medical = "update medical_master set medical_code=:code,medical_name=:desc,modified_by=:userName,modified_dt=now() where medical_id = :medicalId";


	public static final String get_desc = "select count(medical_name) from medical_master where medical_name=?";

	public static final String medical_desc = "select medical_name from medical_master where medical_id= ?";

	public static final String get_medical_edit = "SELECT COUNT(medical_name) FROM medical_master WHERE medical_name = ?  AND medical_name != ?";

	public static final String get_code ="select count(medical_code) from medical_master where medical_code=?";

	
	public static final String medical_code ="select medical_code from medical_master where medical_id= ?";

	
	public static final String get_code_edit = "SELECT COUNT(medical_code) FROM medical_master WHERE medical_code = ?  AND medical_code != ?";

	public static final String getCodeById = "SELECT medical_code FROM medical_master WHERE medical_id = ?";

}
