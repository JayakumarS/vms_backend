package com.vms.master.currency;

public class CurrencyQueryUtil {
	
	public static final String currency_save="INSERT INTO currency_master (currency_code,currency_name,currency_conver_from,currency_conver_to,"
			+ "currency_fraction,currency_default,currency_status,book_currency,created_by,created_dt)"
			+ "values (:code,:name,:fromcurren,:tocurren,:fractpart,:dvalue,:active,:currency,:userName,now())";
	
	public static final String currency_list="SELECT currency_code as code,currency_name as name from currency_master order by created_dt desc";
	
	public static final String currency_edit="SELECT currency_code as code,currency_name as name, currency_conver_from as fromcurren,currency_conver_to as tocurren,"
			+ "currency_fraction as fractpart,currency_default as dvalue, currency_status as active,book_currency as currency FROM currency_master WHERE currency_code=?";
	
	public static final String currency_update="UPDATE currency_master SET currency_code=:code, currency_name=:name, currency_conver_from=:fromcurren,"
			+ "currency_conver_to=:tocurren, currency_fraction=:fractpart,currency_default=:dvalue,currency_status=:active,book_currency=:currency,"
			+ "modified_by=:userName,modified_dt=now() WHERE currency_code=:code";
	
	public static final String currency_delete="DELETE FROM currency_master WHERE currency_code = ? ";
	
	public static final String checkDelete = "SELECT COUNT(*) FROM currency_master WHERE currency_code = ?";
	
	

}
