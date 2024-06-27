package com.vms.crew.crewPayrollCurrency;

public class CrewPayrollCurrencyQueryUtil {
	
	public static final String save_country_data="Insert into crew_payroll_currency (crew_payroll_currency_country_name,crew_payroll_currency_code,crew_payroll_currency_validation,created_by,created_dt) values (:countryname,:currencycode,:validation,:userName,now())";
	
	public static final String get_country_list="select crew_payroll_currency_country_name as countryname,crew_payroll_currency_code as currencycode,crew_payroll_currency_validation as validation ,crew_payroll_currency_id as currencyid from crew_payroll_currency order by created_dt desc";
	
	public static final String getCountry="SELECT currency_code AS currencycode FROM country_master where country_code=?";
	
	public static final String getEdit = "select crew_payroll_currency_id as currencyid, crew_payroll_currency_country_name as countryname,crew_payroll_currency_code as currencycode,crew_payroll_currency_validation as validation from crew_payroll_currency where crew_payroll_currency_id = ?";
	
	public static final String delete = "delete from crew_payroll_currency where crew_payroll_currency_id = ? ";
	
	public static final String get_country_name="select count(crew_payroll_currency_country_name)from crew_payroll_currency where crew_payroll_currency_country_name=?";
	
	public static final String get_country_code="select count(crew_payroll_currency_code)from crew_payroll_currency where crew_payroll_currency_code=?";


	public static final String getCodeById = "SELECT crew_payroll_currency_country_name FROM crew_payroll_currency WHERE crew_payroll_currency_id = ?";


	
	
	public static final String Update ="update crew_payroll_currency set crew_payroll_currency_country_name=:countryname,crew_payroll_currency_code=:currencycode,crew_payroll_currency_validation =:validation,modified_by=:userName,modified_dt=now() where crew_payroll_currency_id = :currencyid";
  

	
	

	
	
			

}
