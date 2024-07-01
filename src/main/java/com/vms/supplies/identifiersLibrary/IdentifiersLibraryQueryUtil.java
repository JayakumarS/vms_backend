package com.vms.supplies.identifiersLibrary;

public class IdentifiersLibraryQueryUtil {
	
	public static final String SAVE_freight_type ="Insert into freight_type (freight_type_id,freight_type_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";
	
	public static final String SAVE_storage ="Insert into storage_location (storage_location_code,storage_location_name,created_by,created_dt)"
			+ "values (:code1,:desc,:userName,now())";
	
	public static final String SAVE_function="Insert into function (function_code,function_name,created_by,created_dt)"
			+ "values (:code2,:desc,:userName,now())";
	
	
	public static final String DELETE_freight_type ="delete from freight_type where freight_type_id=?";
	
	public static final String getEdit="select freight_type_id as code,freight_type_name as description from freight_type where freight_type_id = ?";
	
	public static final String getList="select freight_type_id as code, freight_type_name as description from freight_type order by created_dt desc";
	
	public static final String getListstorage="select storage_location_id  as storageId,storage_location_code as code1, storage_location_name as description from storage_location order by created_dt desc";
	
	public static final String getListfunction="select function_id as functionId,function_code as code2, function_name as description from function order by created_dt desc";

 
	public static final String get_storage_id="SELECT CONCAT('VSC', LPAD(CAST(COALESCE(MAX(CAST(SUBSTRING(storage_location_code::text FROM 4) AS INTEGER)), 0) + 1 AS TEXT), 4, '0')) AS next_storage_location_code FROM storage_location";
	 
	
	public static final String getmax="SELECT COALESCE(MAX(freight_type_id), 0) + 1 AS codemax FROM freight_type";
	
	public static final String delete = "delete from freight_type where freight_type_id = ? ";
	
	public static final String deletestorage = "delete from storage_location where storage_location_id = ? ";

			
	public static final String UPDATE_freight_type = "update freight_type set freight_type_id=:code,freight_type_name=:desc,modified_by=:userName,modified_dt=now() where freight_type_id = :code";

	public static String UPDATE_storage_places="update storage_location set storage_location_code=:code1,storage_location_name=:description,modified_by=:userName,modified_dt=now() where storage_location_id = :storageId";

	public static String getEditStorage ="select storage_location_id as storageId,storage_location_code as code1 ,storage_location_name as description from storage_location where storage_location_id =?";

	public static String deletefunction ="delete from function where function_id = ?";
	


	public static String UPDATE_function="update function set function_code=:code2,function_name=:description,modified_by=:userName,modified_dt=now() where function_id = :functionId";

	public static String getEditfunction="select function_id as functionId,function_code as code2, function_name as description from function  where function_id =?";
			
	

}
