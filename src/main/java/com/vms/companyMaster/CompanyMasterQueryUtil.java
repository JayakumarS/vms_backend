package com.vms.companyMaster;

public class CompanyMasterQueryUtil {

	public static final String INSERT_COMPANY_MASTER = "Insert into company_master(company_name,company_logo,created_by,created_on,user_name,background_image) "
			+ "values(:companyName,:companyLogo,'E0001',now(),:userName,:backGroundImg)";
	
	public static final String Get_Company_Logo = "Select company_logo as companyLogo,background_image as backGroundImg from company_master order by created_on desc limit 1";
	
	public static final String getCount = "select count(*) from company_master";

}
