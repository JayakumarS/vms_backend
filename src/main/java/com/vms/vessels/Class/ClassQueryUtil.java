package com.vms.vessels.Class;

public class ClassQueryUtil {

	
public static final String SAVE_CLASS = "Insert into vessel_class (vessel_class_code,vsl_class_desc,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

public static final String getList = "select vessel_class_code as code,vsl_class_desc as description from vessel_class order by created_dt desc";

public static final String getEdit = "select vessel_class_code as code,vsl_class_desc as description from vessel_class where vessel_class_code = ?";

public static final String delete = "delete from vessel_class where vessel_class_code = ? ";

public static final String checkDelete = "select count(*) from vessel_class where vessel_class_code = ?";

public static final String UPDATE_CLASS = "update vessel_class set vessel_class_code=:code,vsl_class_desc=:desc,modified_by=:userName,modified_dt=now() where vessel_class_code = :code";

}
