package com.vms.supplies.freightType;

public class FreightTypeQueryUtil {
	
	public static final String SAVE_freight_type = "Insert into freight_type (freight_type_code,freight_type_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select freight_type_id as freighttypeid,freight_type_code as code,freight_type_name as description from freight_type order by created_dt desc";

	public static final String getEdit = "select freight_type_id as freighttypeid, freight_type_code as code,freight_type_name as description from freight_type where freight_type_id = ?";

	public static final String delete = "delete from freight_type where freight_type_id = ? ";

	public static final String checkDelete = "select count(*) from freight_type where freight_type_code = ?";

	public static final String UPDATE_freight_type = "update freight_type set freight_type_code=:code,freight_type_name=:desc,modified_by=:userName,modified_dt=now() where freight_type_id = :freighttypeid";
	
	public static final String get_code = "select count(freight_type_code) from freight_type where freight_type_code=?";

	public static final String get_desc = "select count(freight_type_name) from freight_type where freight_type_name=?";
	
	public static final String freight_type_code = "select freight_type_code from freight_type where freight_type_id= ?";

	public static final String freight_type_desc = "select freight_type_name from freight_type where freight_type_id= ?";

	public static String get_code_edit="SELECT COUNT(freight_type_code) FROM freight_type WHERE freight_type_code = ?  AND freight_type_code != ?";

	public static String get_desc_edit="SELECT COUNT(freight_type_name) FROM freight_type WHERE freight_type_name = ?  AND freight_type_name != ?";
	
	public static final String getCodeById = "SELECT freight_type_code FROM freight_type WHERE freight_type_id = ?";


}
