package com.vms.vessels.shipManagers;

public class ShipManagersQueryUtil {
	
	public static final String SAVE_SHIP_MANAGERS = " Insert into ship_managers (ship_mngr_code,ship_mngr_name,ship_mngr_remarks,vat_registration,created_by,created_dt)"
			+ "values (:shipman,:name,:remarks,:vatreg,:userName,now())";

public static final String getList = "select ship_mngr_code as shipman, ship_mngr_name as name,ship_mngr_remarks as remarks,vat_registration as vatreg from ship_managers order by created_dt desc ";

public static final String getEdit = "select ship_mngr_code as shipman,ship_mngr_name as name ,ship_mngr_remarks as remarks,vat_registration as vatreg from ship_managers where ship_mngr_code = ?";

public static final String delete = "delete from ship_managers where ship_mngr_code = ? ";

public static final String checkDelete = "select count(*) from ship_managers where ship_mngr_code = ?";

public static final String UPDATE_VESSEL_TYPE = "update ship_managers set ship_mngr_code=:shipman,ship_mngr_name=:name,ship_mngr_remarks=:remarks,vat_registration=:vatreg, modified_by=:userName,modified_dt=now() where ship_mngr_code = :shipman";

}
