package com.vms.vessels.Class;

public class ClassQueryUtil {

	
public static final String SAVE_CLASS = "Insert into vessel_class (vessel_class_code,vessel_class_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

public static final String getList = "select vessel_class_id as classid,vessel_class_code as code,vessel_class_name as description from vessel_class order by created_dt desc";

public static final String getEdit = "select vessel_class_id as classid,vessel_class_code as code,vessel_class_name as description from vessel_class where vessel_class_id = ?";

public static final String delete = "delete from vessel_class where vessel_class_id = ? ";

public static final String checkDelete = "select count(*) from vessel_class where vessel_class_id = ?";

public static final String UPDATE_CLASS = "update vessel_class set vessel_class_id=:classid,vessel_class_code=:code,vessel_class_name=:desc,modified_by=:userName,modified_dt=now() where vessel_class_id = :classid";

public static final String get_code = "select count(vessel_class_code) from vessel_class where vessel_class_code=?";

public static final String get_desc = "select count(vessel_class_name) from vessel_class where vessel_class_name=?";

public static final String class_code = "select vessel_class_code from vessel_class where vessel_class_id= ?";

public static final String class_desc = "select vessel_class_name from vessel_class where vessel_class_id= ?";

public static final String get_code_edit = "SELECT COUNT(vessel_class_code) FROM vessel_class WHERE vessel_class_code = ?  AND vessel_class_code != ?";

public static final String get_desc_edit = "SELECT COUNT(vessel_class_name) FROM vessel_class WHERE vessel_class_name = ?  AND vessel_class_name != ?";

public static final String getCodeById = "SELECT vessel_class_code FROM vessel_class WHERE vessel_class_id = ?";

}
