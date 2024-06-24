package com.vms.crew.maintain.bloodgroup;

public class BloodGroupQueryUtil {

	public static final String SAVE_RELIGION_TYPE = "Insert into blood_group (blood_group_code,blood_group_name,created_by,created_dt,is_active)"
			+ "values (:bloodGroupCode,:name,:userName,now(),:active)";
	
	public static final String checkDelete = "select count(*) from blood_group where blood_group_code = ?";
	
	public static final String UPDATE_RELIGION_TYPE ="update blood_group set blood_group_code=:bloodGroupCode,blood_group_name=:name,modified_by=:userName,modified_dt=now(),is_active=:active where blood_group_code =:bloodGroupCode";

	public static final String getList ="select blood_group_code as bloodGroupCode,blood_group_name as name from blood_group order by created_dt desc";

	
	public static final String getEdit = "select blood_group_code as bloodGroupCode,blood_group_name as name,is_active as active from blood_group where blood_group_code = ?";

	public static final String delete = "delete from blood_group where blood_group_code = ? ";

	

}
