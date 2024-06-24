package com.vms.common.Languages;

public class LanguagesQueryUtil {

public static final String SAVE_LANG = "Insert into language_master (language_code,language_name,created_by,created_dt,is_active)"
			+ "values (:code,:desc,:userName,now(),:active)";

public static final String getList = "select language_code as code,language_name as description from language_master order by created_dt desc";

public static final String getEdit = "select language_code as code,language_name as description,is_active as active from language_master where language_code = ?";

public static final String delete = "delete from language_master where language_code = ? ";

public static final String checkDelete = "select count(*) from language_master where language_code = ?";

public static final String UPDATE_LANG = "update language_master set language_code=:code,language_name=:desc,modified_by=:userName,modified_dt=now(),is_active=:active where language_code = :code";

}
