package com.vms.common.Languages;

public class LanguagesQueryUtil {

public static final String SAVE_LANG = "Insert into language_master (lang_code,lang_desc,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

public static final String getList = "select lang_code as code,lang_desc as description from language_master order by created_dt desc";

public static final String getEdit = "select lang_code as code,lang_desc as description from language_master where lang_code = ?";

public static final String delete = "delete from language_master where lang_code = ? ";

public static final String checkDelete = "select count(*) from language_master where lang_code = ?";

public static final String UPDATE_LANG = "update language_master set lang_code=:code,lang_desc=:desc,modified_by=:userName,modified_dt=now() where lang_code = :code";

}
