package com.vms.formProperty;

public class FormPropertyQueryUtil {

	public static final String getFormPropertyList = "select * from vw_get_user_rigths_forms (?)";
	
	
	public static final String getCompanyUserId="select company_user_id from company_user where user_id =? ";

    public static final String getDashBoardList="select distinct form_code as formCode from auth.user_rights ur\n" + 
    		"left join auth.form_property fp on fp.form_property_id=ur.form_property_id \n" + 
    		"where company_user_id=? order by form_code asc ";


}
