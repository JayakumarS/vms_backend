package com.vms.master.Country;

public class CountryQueryUtil {

	public static final String SAVE_COUNTRY = "Insert into country_master (country_code,country_name,currency_code,is_active,phonecode,created_by,created_dt,nationality) "
			+ "values (:countryCode,:countryName,:currencyCode,:active,:phoneCode,:userName,now(),:nationality)";
	
	public static final String GET_COUNTRY_LIST = "select country_id as countryId,country_code as countryCode,country_name as countryName,currency_code as currencyCode,\r\n"
			+ "phonecode as phoneCode,is_active as active,nationality as nationality from country_master";
	
	public static final String GET_EDIT_COUNTRY = "select country_code as countryCode,country_name as countryName,currency_code as currencyCode,\r\n"
			+ " phonecode as phoneCode,is_active as active,nationality as nationality from country_master\r\n"
			+ " where country_id=?";


	public static final String UPDATE_COUNTRY = "UPDATE country_master SET country_code = :countryCode,country_name = :countryName,currency_code = :currencyCode,phonecode = :phoneCode,is_active = :active,modified_by = :userName,modified_date = NOW(),nationality=:nationality WHERE country_id = :countryId";

	public static final String DELETE_COUNTRY = "delete from country_master where country_code = ?";

	public static final String get_code = "select count(country_code) from country_master where country_code=?";

	public static final String get_name = "select count(country_name) from country_master where country_name=?";
	
	public static final String country_code = "select country_code from country_master where country_id = ?";

	public static final String country_name = "select country_name from country_master where country_id = ?";

	public static final String get_country_code_edit = "SELECT COUNT(country_code) FROM country_master WHERE country_code = ?  AND country_code != ?";

	public static final String get_country_name_edit = "SELECT COUNT(country_name) FROM country_master WHERE country_name = ?  AND country_name != ?";


}
