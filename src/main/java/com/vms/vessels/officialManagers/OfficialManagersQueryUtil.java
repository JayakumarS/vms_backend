package com.vms.vessels.officialManagers;

public class OfficialManagersQueryUtil {
	
	public static final String SAVE_OFFICIAL_MANAGERS = "  Insert into official_managers ( official_manager_code,official_manager_name,city,address,postal_code,phoneno,official_manager_remarks,blogo_file_Name,blogo_file_Path,plogo_file_Name,plogo_file_Path,created_by,created_dt)"
			+ "values (:code,:description,:city,:address,:poscode,:phone,:remarks,:blogofileName,:blogofilePath,:plogofileName,:plogofilePath,:userName,now())";

public static final String getList = "select official_managers_id as offmanagerid, official_manager_code as code, official_manager_name as description,city as city,address as address ,phoneno as phone from official_managers order by created_dt desc";
		

public static final String getEdit = " select official_managers_id as offmanagerid, official_manager_code as code,official_manager_name as description ,city as city,address as address,postal_code as poscode,phoneno as phone, official_manager_remarks as remarks from official_managers where  official_managers_id = ?";
		

public static final String delete = "delete from official_managers where  official_managers_id = ? ";

public static final String checkDelete = "select count(*) from official_managers where  official_manager_code = ?";

public static final String UPDATE_OFFICIAL_MANAGERS = "update official_managers set  official_manager_code=:code,official_manager_name=:description,city=:city,address=:address,postal_code=:poscode,phoneno =:phone,official_manager_remarks =:remarks,  modified_by=:userName,modified_dt=now() where  official_managers_id = :offmanagerid";

public static String get_code_edit="SELECT COUNT(official_manager_code) FROM official_managers WHERE official_manager_code = ?  AND official_manager_code != ?";

public static String get_name_edit="SELECT COUNT(official_manager_name) FROM official_managers WHERE official_manager_name = ?  AND official_manager_name != ?";

public static final String offmanager_code = "select official_manager_code from official_managers where official_managers_id= ?";

public static final String name_desc = "select official_manager_name from official_managers where official_managers_id= ?";


}
