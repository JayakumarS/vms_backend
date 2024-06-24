package com.vms.crew.payTypes;

public class PayTypesQueryUtil {
	
	public static final String SAVE_pay_types = "Insert into pay_type (pay_type_code,pay_type_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select pay_type_id as paytypeid,pay_type_code as code,pay_type_name as description from pay_type order by created_dt desc";

	public static final String getEdit = "select pay_type_id as paytypeid, pay_type_code as code,pay_type_name as description from pay_type where pay_type_id = ?";

	public static final String delete = "delete from pay_type where pay_type_id = ? ";

	public static final String checkDelete = "select count(*) from pay_type where pay_type_code = ?";

	public static final String UPDATE_pay_types = "update pay_type set pay_type_code=:code,pay_type_name=:desc,modified_by=:userName,modified_dt=now() where pay_type_id = :paytypeid";
	
	public static final String get_code = "select count(pay_type_code) from pay_type where pay_type_code=?";

	public static final String get_desc = "select count(pay_type_name) from pay_type where pay_type_name=?";
	
	public static final String paytype_code = "select pay_type_code from pay_type where pay_type_id= ?";

	public static final String paytype_desc = "select pay_type_name from pay_type where pay_type_id= ?";

	public static String get_code_edit="SELECT COUNT(pay_type_code) FROM pay_type WHERE pay_type_code = ?  AND pay_type_code != ?";

	public static String get_desc_edit="SELECT COUNT(pay_type_name) FROM pay_type WHERE pay_type_name = ?  AND pay_type_name != ?";


}
