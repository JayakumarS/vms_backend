package com.vms.master.bloodgroup;

public class BloodGroupQueryUtil {

	public static final String SAVE_BLOODGROUP = "Insert into blood_group (blood_group_code,blood_group_name,created_by,created_dt,is_active)"
			+ "values (:bloodGroupCode,:name,:userName,now(),:active)";
	
	
	
	public static final String UPDATE_BLOODGROUP ="update blood_group set blood_group_code=:bloodGroupCode,blood_group_name=:name,modified_by=:userName,modified_dt=now(),is_active=:active where blood_group_id =:bloodGroupId";

	public static final String getList ="select blood_group_code as bloodGroupCode,blood_group_name as name,blood_group_id as bloodGroupId  from blood_group order by created_dt desc";

	
	public static final String getEdit ="SELECT blood_group_code AS bloodGroupCode, blood_group_name AS name, is_active AS active, blood_group_id AS bloodGroupId FROM blood_group WHERE blood_group_id = CAST(? AS INTEGER)";
	
	public static final String delete = "delete from blood_group where blood_group_id = CAST(? AS INTEGER) ";

	public static final String get_BLOODGROUP_Id = "SELECT CONCAT(CAST(COALESCE(MAX(CAST(NULLIF(SUBSTRING(blood_group_code FROM 1), '') AS INTEGER)), 0) + 1 AS TEXT)) AS next_blood_group_code FROM blood_group";

	public static final String get_name =  "select count(blood_group_name) from blood_group where blood_group_name=?";

	public static final String get_bloodGroup_edit =  "SELECT COUNT(blood_group_name) FROM blood_group WHERE blood_group_name = ?  AND blood_group_name != ?";


	public static final String bloodGroup_name = "select blood_group_name from blood_group where blood_group_id= ?";
	
	

	
}