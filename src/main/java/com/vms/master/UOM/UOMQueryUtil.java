package com.vms.master.UOM;

public class UOMQueryUtil {

	public static final String SAVE_UOM = "Insert into unit_of_measurement (uom_code_id,uom_code,created_by,create_dt) values (:uomCode,:uomName,:userName,now())";
	
	public static final String GET_UOM_LIST = "select uom_id as uomId,uom_code_id as uomCode,uom_code as uomName from unit_of_measurement ORDER by create_dt desc";
	
	public static final String GET_EDIT_UOM = "select uom_code_id as uomCode,uom_code as uomName from unit_of_measurement where uom_id=?";
	
	public static final String DELETE_UOM = "delete from unit_of_measurement where uom_id=?";
	
	public static final String UPDATE_UOM = "UPDATE unit_of_measurement SET uom_code_id = :uomCode,uom_code = :uomName,modified_by = :userName,modified_dt = NOW() WHERE uom_id = :uomId";
	
	public static final String get_sequence_code="SELECT COALESCE(MAX(uom_code_id+1), 1) AS uomCode FROM unit_of_measurement";

	
}
