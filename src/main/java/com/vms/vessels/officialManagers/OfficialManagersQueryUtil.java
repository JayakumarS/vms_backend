package com.vms.vessels.officialManagers;

public class OfficialManagersQueryUtil {
	
	public static final String SAVE_OFFICIAL_MANAGERS = "  Insert into official_managers (off_mngr_code,off_mngr_name,city,address,postal_code,phoneno,off_mngr_remarks,bank_letter_logo,payslip_logo,created_by,created_dt)"
			+ "values (:code,:description,:city,:address,:poscode,:phone,:remarks,:blogo,:plogo,:userName,now())";

public static final String getList = "select off_mngr_code as code, off_mngr_name as description,city as city,address as address ,phoneno as phone from official_managers order by created_dt desc";
		

public static final String getEdit = " select off_mngr_code as code,off_mngr_name as description ,city as city,address as address,phoneno as phone from official_managers where off_mngr_code = ?";
		

public static final String delete = "delete from official_managers where off_mngr_code = ? ";

public static final String checkDelete = "select count(*) from official_managers where off_mngr_code = ?";

public static final String UPDATE_OFFICIAL_MANAGERS = "update official_managers set off_mngr_code=:code,off_mngr_name=:description,city=:city,address=:address,phoneno =:phone modified_by=:userName,modified_dt=now() where off_mngr_code = :code";

}
