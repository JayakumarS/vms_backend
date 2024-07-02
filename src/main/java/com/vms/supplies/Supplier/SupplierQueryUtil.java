package com.vms.supplies.Supplier;

public class SupplierQueryUtil {

	public static final String SAVE_SUPPLIER = "Insert into supplier_master(supplier_code,supplier_shortname,supplier_name,created_by,created_dt) values(:supplierCode,:supplierShortName,:supplierName,:userName,now())";
	
	public static final String GET_SUPPLIER_LIST = "select supplier_code as supplierCode,supplier_shortname as supplierShortName,supplier_name as supplierName from supplier_master";
	
	public static final String GET_EDIT_SUPPLIER = "select supplier_code as supplierCode,supplier_shortname as supplierShortName,supplier_name as supplierName from supplier_master where supplier_code=?";
	
	public static final String DELETE_SUPPLIER = "delete from supplier_master where supplier_code=?";
	
	public static final String UPDATE_SUPPLIER = "update supplier_master set supplier_shortname=:supplierShortName,supplier_name=:supplierName,modified_by=:userName,modified_dt=now() where supplier_code=:supplierCode";
	
	public static final String GET_SUPPLIER_CODE = "SELECT CASE WHEN MAX(supplier_code) IS NULL THEN 'S0001'\r\n"
			+ "ELSE rpad(MAX(supplier_code),2,'PM')|| lpad(cast(cast((null_or_empty(SUBSTRING(MAX(supplier_code),3),'0')) as int)+1 as text),3,'0')\r\n"
			+ "END AS supplier_code  FROM supplier_master where supplier_code like 'S%'";

}
