package com.vms.vessels.shipManagers;

public class ShipManagersQueryUtil {
	
	public static final String SAVE_SHIP_MANAGERS = " Insert into ship_managers (ship_manager_code,ship_manager_name,ship_manager_remarks,vat_registration,created_by,created_dt)"
			+ "values (:shipman,:name,:remarks,:vatreg,:userName,now())";

public static final String getList = "select ship_managers_id as shipmanid,ship_manager_code as shipman, ship_manager_name as name,ship_manager_remarks as remarks,vat_registration as vatreg from ship_managers order by created_dt desc ";

public static final String getEdit = "select ship_managers_id as shipmanid, ship_manager_code as shipman,ship_manager_name as name ,ship_manager_remarks as remarks,vat_registration as vatreg from ship_managers where ship_managers_id = ?";

public static final String delete = "delete from ship_managers where ship_managers_id = ? ";

public static final String checkDelete = "select count(*) from ship_managers where ship_managers_id = ?";

public static final String get_desc = "select count(ship_manager_name) from ship_managers where ship_manager_name=?";

public static final String get_code = "select count(ship_manager_code) from ship_managers where ship_manager_code=?";



public static final String UPDATE_SHIP_MANAGERS = "update ship_managers set ship_manager_code=:shipman,ship_manager_name=:name,ship_manager_remarks=:remarks,vat_registration=:vatreg, modified_by=:userName,modified_dt=now() where ship_managers_id = :shipmanid";

public static String get_shipman_edit="SELECT COUNT(ship_manager_code) FROM ship_managers WHERE ship_manager_code = ?  AND ship_manager_code != ?";

public static String get_name_edit="SELECT COUNT(ship_manager_name) FROM ship_managers WHERE ship_manager_name = ?  AND ship_manager_name != ?";

public static final String shipman_code = "select ship_manager_code from ship_managers where ship_managers_id= ?";

public static final String name_desc = "select ship_manager_name from ship_managers where ship_managers_id= ?";

public static final String get_shipManagersId = "SELECT CONCAT('VSM', LPAD(CAST(COALESCE(MAX(CAST(SUBSTRING(ship_manager_code, 4) AS INTEGER)), 0) + 1 AS TEXT), 4, '0')) AS next_ship_manager_code\r\n"
		+ "FROM ship_managers";

}
