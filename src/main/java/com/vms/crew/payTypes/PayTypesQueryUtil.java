package com.vms.crew.payTypes;

public class PayTypesQueryUtil {
	
	public static final String SAVE_pay_types = "Insert into pay_types (pay_types_code,pay_types_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select pay_types_code as code,pay_types_name as description from pay_types order by created_dt desc";

	public static final String getEdit = "select pay_types_code as code,pay_types_name as description from pay_types where pay_types_code = ?";

	public static final String delete = "delete from pay_types where pay_types_code = ? ";

	public static final String checkDelete = "select count(*) from pay_types where pay_types_code = ?";

	public static final String UPDATE_pay_types = "update pay_types set pay_types_code=:code,pay_types_name=:desc,modified_by=:userName,modified_dt=now() where pay_types_code = :code";


}
