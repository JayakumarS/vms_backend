package com.vms.master.UOM;

public class UOMQueryUtil {

	public static final String SAVE_UOM = "Insert into unit_of_measurement (uom_code,uom_name,created_by,created_dt) values (:uomCode,:uomName,:userName,now())";
	
	public static final String GET_UOM_LIST = "select uom_id as uomId,uom_code as uomCode,uom_name as uomName from unit_of_measurement";
	
	public static final String GET_EDIT_UOM = "select uom_code as uomCode,uom_name as uomName from unit_of_measurement where uom_id=?";
	
	public static final String DELETE_UOM = "delete from unit_of_measurement where uom_code=?";
	
	public static final String UPDATE_UOM = "UPDATE unit_of_measurement SET uom_code = :uomCode,uom_name = :uomName,modified_by = :userName,modified_dt = NOW() WHERE uom_id = :uomId;";

	public static final String get_code = "select count(uom_code) from unit_of_measurement where uom_code=?";

	public static final String get_name = "select count(uom_name) from unit_of_measurement where uom_name=?";
}
