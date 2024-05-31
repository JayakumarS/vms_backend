package com.vms.userRights;

public class UserRightsQueryUtil {



	public static final String getUomList = "select uom_id as id,uom as text from uom";

	public static final String getItemList = "select item_id as id,item_name as text from item";
	
	public static final String getUserList = "SELECT  concat(reference_id, concat(' - ',user_id)) as text,reference_id as id  FROM auth.app_user where reference_id is not null order by text asc ";
	
	public static final String getCompanyList = "SELECT  concat(company_code, concat(' - ',company_name)) as text,company_code as id  FROM company where company_code is not null";
	
	public static final String getModuleList = "SELECT MODULE_CODE, MODULE_NAME, MODULE_CODE AS id, MODULE_NAME as text, DISPLAY_ORDER, IMAGE_ICON_URL FROM auth.module WHERE MODULE_CODE != 'M0000' order by text asc";
	
	public static final String getuserFormList = "SELECT  concat(form_code, concat(' - ',form_name)) as text,form_code as id  FROM auth.form where form_code is not null ";
	
	public static final String getPropertyList = "SELECT PROPERTY_CODE,PROPERTY_NAME FROM auth.PROPERTY ORDER BY DISPLAY_ORDER ASC ";
	
	
	public static final String GET_COMPANY_USER_ID ="SELECT COMPANY_USER_ID FROM COMPANY_user WHERE  COMPANY_CODE = ? AND USER_ID = ?";
	
	
	public static String FORM_PROPERTY_LIST_FROM_USER_RIGHTS = "SELECT FORM_PROPERTY_ID FROM auth.USER_RIGHTS WHERE COMPANY_USER_ID =?";
	
	
	public static final String FORM_CODE_LIST_FROM_USER_RIGHTS = "SELECT FORM_CODE FROM auth.FORM_PROPERTY WHERE FORM_PROPERTY_ID IN(SELECT FORM_PROPERTY_ID FROM auth.USER_RIGHTS WHERE COMPANY_USER_ID =? )";
	
	
	public static String GET_FORM_MASTER_PARENT_LIST = " SELECT  FORM_CODE,FORM_NAME, DISPLAY_ORDER, IMAGE_ICON_URL,MODULE_CODE,FORM_CODE_PARENT, FORM_URL,IS_PARENT FROM auth.form  WHERE MODULE_CODE IN (?)  AND IS_PARENT = ? and IS_ACTIVE='Y'  ORDER BY FORM_CODE ASC";
	
	
	public static String GET_PROPERTY_MASTER_LIST = "SELECT PROPERTY_CODE,PROPERTY_NAME FROM auth.PROPERTY ORDER BY DISPLAY_ORDER ASC";
	
	
	public static final String GET_FORM_MASTER_PARENT_LIST_BASE = "SELECT FORM_CODE,FORM_NAME, DISPLAY_ORDER,\r\n"
			+ "			IMAGE_ICON_URL, MODULE_CODE,FORM_CODE_PARENT,FORM_URL,\r\n"
			+ "			 IS_PARENT FROM auth.form where MODULE_CODE IN (?) and FORM_CODE \r\n"
			+ "			in(SELECT distinct FORM_CODE_PARENT\r\n"
			+ "			 FROM auth.form fm inner join auth.FORM_PROPERTY fp on fm.FORM_CODE=fp.FORM_CODE\r\n"
			+ "			 inner join auth.user_rights ur on ur.FORM_PROPERTY_ID=fp.FORM_PROPERTY_ID\r\n"
			+ "			 inner join company_user cu on cu.company_user_id=ur.company_user_id where cu.is_primary=1) and IS_ACTIVE='Y'";
	
	
	public static final String sCheckEmployeeCompny = "select count(company_code) as ct from COMPANY_USER where company_code = ? and user_id = ?";
	
	public static final String parentCode = "Y";
	
	public static final String childCode = "N";
	
	public static String GET_FORM_MASTER_CHILD_LIST = "SELECT   FORM_CODE,FORM_NAME,DISPLAY_ORDER,IMAGE_ICON_URL,MODULE_CODE,FORM_CODE_PARENT,FORM_URL, IS_PARENT  FROM auth.form  WHERE MODULE_CODE = ?  AND FORM_CODE_PARENT = ? AND IS_PARENT = ? and IS_ACTIVE='Y'  ORDER BY DISPLAY_ORDER ASC";
	
	
	public static String GET_FORM_PROPERTY_LIST = "SELECT FORM_PROPERTY_ID,fp.FORM_CODE,fp.PROPERTY_CODE FROM auth.form_property fp inner join auth.form f on f.form_Code = fp.form_code and IS_ACTIVE='Y' WHERE fp.FORM_CODE = ? ORDER BY PROPERTY_CODE ASC";
	
	
	
	public static final String DELETE_ROLERIGHTS = "delete from auth.user_rights where company_user_id=? and form_property_id in (select form_property_id  from auth.form_property \n" + 
			"where form_code in (select form_code from auth.form where is_parent='N' and is_active = 'Y' and module_code=?))";

	public static final String Generate_user_id = " select company_user_id from company_user where user_id =? ";

	
	public static final String INSERT = "insert into auth.user_rights (company_user_id,form_property_id) values(:userId,:formPropertyId) ";

	
	/*
	 * //MVJ public static String GET_FORM_MASTER_LIST = "select * from (" +
	 * "WITH RECURSIVE tree AS (" +
	 * "SELECT FORM_CODE,FORM_NAME,DISPLAY_ORDER,IMAGE_ICON_URL,MODULE_CODE,FORM_CODE_PARENT,FORM_URL, ARRAY[]::varchar[] AS ancestors"
	 * +
	 * " FROM auth.form fm WHERE MODULE_CODE IN ('M0000',?) and form_code_parent in (?) "
	 * + " UNION ALL " +
	 * " SELECT fm.FORM_CODE,fm.FORM_NAME,fm.DISPLAY_ORDER,fm.IMAGE_ICON_URL,fm.MODULE_CODE,fm.FORM_CODE_PARENT,fm.FORM_URL , tree.ancestors || fm.form_code_parent "
	 * + " FROM auth.form fm, tree " +
	 * " WHERE fm.form_code_parent = tree.form_code )" +
	 * " SELECT FORM_CODE,FORM_NAME,DISPLAY_ORDER,IMAGE_ICON_URL,MODULE_CODE,FORM_CODE_PARENT,FORM_URL  FROM tree order by display_order,form_code "
	 * + " ) a  union " +
	 * " (SELECT FORM_CODE,FORM_NAME,DISPLAY_ORDER,IMAGE_ICON_URL,MODULE_CODE,FORM_CODE_PARENT,FORM_URL "
	 * +
	 * " FROM auth.form WHERE   form_code in ('F1000',?) ) order by display_order,form_code"
	 * ;
	 */
	//public static final String GET_ROLE_REMARKS = "select remark as roleremarks from auth.role where role_id=?";

	public static final String GET_FORM_LIST = "select form_code as item_id,form_name as item_text from auth.form where is_parent='N' and is_active = 'Y' order by form_name";

	public static final String GET_PROPERTYLIST = "select property_code as propertyCode, property_name as propertyName from auth.property order by display_order asc";

	public static final String GET_FORMPROPERTYLIST = "select form_property_id as formPropertyId, form_code as formCode, property_code as propertyCode from auth.form_property order by form_code asc";

	
	public static final String getUserBasedFormPropertyList(String userId) {
		String query = "select form_property_id as formPropertyId from auth.user_rights ur "
				+ "left join company_user cu on cu.company_user_id=ur.company_user_id "
				+ "where cu.user_id='"+userId+"'";
		return query;
	}
	
	public static final String getUserBasedFormPropertyList(String userId,String moduleCode) {
		String query = "select ur.form_property_id as formPropertyId from auth.user_rights ur "
				+ "left join company_user cu on cu.company_user_id=ur.company_user_id left join auth.form_property af on af.form_property_id=ur.form_property_id "
				+ " left join auth.form afm on afm.form_code=af.form_code "
				+ "where cu.user_id='"+userId+"' and afm.module_code='"+moduleCode+"' ";
		return query;
	}
	
	public static final String getAllPagePermissionListByRoleAndFormcode(String formCode,Integer userId) {
		String query = "Select distinct af.property_code as propertyCode from auth.user_rights au "
				+ "left join auth.form_property af on af.form_property_id = au.form_property_id "
				+ "where au.company_user_id="+userId+ " and af.form_code='"+formCode+"'";
		return query;
	}
	
	public static final String Get_user_id = "Select company_user_id from company_user where user_id=? limit 1";
	
	//Mobile User Rigts

		public static final String GET_PERMISSION_LIST(String userId) {
			String query = "select form_code, form_name, form_code_parent, form_url, display_order"
					+ "		From auth.form"
					+ "		inner join auth.form_property using(form_code)"
					+ "		inner join auth.user_rights using(form_property_id)"
					+ "		inner join company_user using(company_user_id)"
					+ "		where user_id ='"+userId+"' and is_active = 'Y' and is_parent='N'"
					+ "		group by form_code";
			return query;
		}
}
