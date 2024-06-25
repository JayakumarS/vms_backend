package com.vms.vessels.wageScale;

public class WageScaleQueryUtil {


	public static final String SAVE_WAGE = "Insert into wage_scales (wage_scale_code,wage_scale_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

public static final String getList = "select wage_scale_id as wagescaleid,wage_scale_code as code,wage_scale_name as description from wage_scales order by created_dt desc";

public static final String getEdit = "select wage_scale_id as wagescaleid,wage_scale_code as code,wage_scale_name as description from wage_scales where wage_scale_id = ?";

public static final String delete = "delete from wage_scales where wage_scale_id = ? ";

public static final String checkDelete = "select count(*) from wage_scales where wage_scale_id = ?";

public static final String UPDATE_WAGE = "update wage_scales set wage_scale_id=:wagescaleid ,wage_scale_code=:code,wage_scale_name=:desc,modified_by=:userName,modified_dt=now() where wage_scale_id = :wagescaleid";

public static final String get_code = "select count(wage_scale_code) from wage_scales where wage_scale_code=?";

public static final String get_desc = "select count(wage_scale_name) from wage_scales where wage_scale_name=?";


public static final String scale_code = "select wage_scale_code from wage_scales where wage_scale_id= ?";

public static final String scale_desc = "select wage_scale_name from wage_scales where wage_scale_id= ?";

public static final String get_code_edit = "SELECT COUNT(wage_scale_code) FROM wage_scales WHERE wage_scale_code = ?  AND wage_scale_code != ?";

public static final String get_desc_edit = "SELECT COUNT(wage_scale_name) FROM wage_scales WHERE wage_scale_name = ?  AND wage_scale_name != ?";


}
