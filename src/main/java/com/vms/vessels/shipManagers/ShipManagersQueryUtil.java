package com.vms.vessels.shipManagers;

public class ShipManagersQueryUtil {
	
	public static final String SAVE_SHIP_MANAGERS = " Insert into ship_managers (ship_manager_code,ship_manager_name,ship_manager_remarks,vat_registration,created_by,created_dt)"
			+ "values (:shipman,:name,:remarks,:vatreg,:userName,now())";

public static final String getList = "select ship_manager_code as shipman, ship_manager_name as name,ship_manager_remarks as remarks,vat_registration as vatreg from ship_managers order by created_dt desc ";

public static final String getEdit = "select ship_manager_code as shipman,ship_manager_name as name ,ship_manager_remarks as remarks,vat_registration as vatreg from ship_managers where ship_manager_code = ?";

public static final String delete = "delete from ship_managers where ship_manager_code = ? ";

public static final String checkDelete = "select count(*) from ship_managers where ship_manager_code = ?";

public static final String UPDATE_VESSEL_TYPE = "update ship_managers set ship_manager_code=:shipman,ship_manager_name=:name,ship_manager_remarks=:remarks,vat_registration=:vatreg, modified_by=:userName,modified_dt=now() where ship_manager_code = :shipman";

}
