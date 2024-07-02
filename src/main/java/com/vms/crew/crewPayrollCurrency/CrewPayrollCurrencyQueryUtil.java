package com.vms.crew.crewPayrollCurrency;

public class CrewPayrollCurrencyQueryUtil {
	
	public static final String save_country_data="Insert into crew_payroll_currency (crew_payroll_currency_country_name,crew_payroll_currency_code,crew_payroll_currency_validation,created_by,created_dt) values (:countryname,:currencycode,:validation,:userName,now())";
	
	public static final String get_country_list="SELECT \r\n"
			+ " cm.nationality AS countryname,\r\n"
			+ " cp.crew_payroll_currency_code AS currencycode,\r\n"
			+ " cp.crew_payroll_currency_validation AS validation,\r\n"
			+ " cp.crew_payroll_currency_id AS currencyid\r\n"
			+ " FROM \r\n"
			+ " crew_payroll_currency cp\r\n"
			+ " LEFT JOIN \r\n"
			+ " country_master cm ON  cm.country_id  = cp.crew_payroll_currency_country_name";
	
	public static final String getCountry="SELECT currency_code AS currencycode FROM country_master where country_id=?";

	
	public static final String getNationality="select nationality as nationality from country_master where country_code=?";
	
	public static final String getEdit = "SELECT "
			+ " cp.crew_payroll_currency_id AS currencyid,"
			+ " cp.crew_payroll_currency_country_name AS countryname,"
			+ " cm1.nationality AS countryname1,"
			+ " cp.crew_payroll_currency_code AS currencycode,"
			+ " cp.crew_payroll_currency_validation AS validation"
			+ " FROM "
			+ " crew_payroll_currency cp"
			+ " LEFT JOIN "
			+ " country_master cm1 ON cm1.country_id = cp.crew_payroll_currency_country_name"
			+ " LEFT JOIN "
			+ " country_master cm2 ON cm2.country_id = cp.crew_payroll_currency_country_name"
			+ " WHERE "
			+ " cp.crew_payroll_currency_id = ?";
	
	public static final String delete = "delete from crew_payroll_currency where crew_payroll_currency_id = ? ";
	
	public static final String get_country_name="select count(crew_payroll_currency_country_name)from crew_payroll_currency where crew_payroll_currency_country_name=?";
	
	public static final String get_country_code="select count(crew_payroll_currency_code)from crew_payroll_currency where crew_payroll_currency_code=?";


	public static final String getCodeById = "SELECT crew_payroll_currency_country_name FROM crew_payroll_currency WHERE crew_payroll_currency_id = ?";


	
	
	public static final String Update ="update crew_payroll_currency set crew_payroll_currency_country_name=:countryname,crew_payroll_currency_code=:currencycode,crew_payroll_currency_validation =:validation,modified_by=:userName,modified_dt=now() where crew_payroll_currency_id = :currencyid";
  

	
	

	
	
			

}
