package com.vms.master.Port;

public class PortQueryUtil {

	public static final String SAVE_COUNTRY = "Insert into port_master (port_code,port_name,port_type,isactive,country_code,created_by,created_date) values (:portCode,:portName,:portType,:active,:countryCode,:userName,now())";
	
	public static final String GET_PORT_LIST = "select port_id as portId,port_code as portCode,port_name as portName,port_type as portType,country_code as countryCode,isactive as isActive from port_master";
	
	public static final String GET_EDIT_PORT = "select port_code as portCode,port_name as portName,port_type as portType,country_code as countryCode,isactive as active from port_master where port_id=?";
	
	public static final String DELETE_PORT = "delete from port_master where port_code = ?";
	
	public static final String UPDATE_PORT = "UPDATE port_master SET port_code = :portCode,port_name = :portName,port_type = :portType,country_code= :countryCode,isactive = :active,modified_by = :userName,modified_date = NOW() WHERE port_id = :portId";

	public static final String get_code = "select count(port_code) from port_master where port_code=?";

	public static final String get_name = "select count(port_name) from port_master where port_name=?";

	public static final String port_code = "select port_code from port_master where port_id = ?";

	public static final String port_name = "select port_name  from port_master where port_id = ?";

	public static final String get_code_edit = "SELECT COUNT(port_code) FROM port_master WHERE port_code = ?  AND port_code != ?";

	public static final String get_name_edit = "SELECT COUNT(port_name) FROM port_master WHERE port_name = ?  AND port_name != ?";

	public static final String uom_code = "select uom_code from unit_of_measurement where uom_id = ?";

	public static final String uom_name = "select uom_name  from unit_of_measurement where uom_id = ?";

	public static final String get_uom_name_edit = "SELECT COUNT(uom_code) FROM unit_of_measurement WHERE uom_code = ?  AND uom_code != ?";
	
	public static final String get_uom_code_edit = "SELECT COUNT(uom_name) FROM unit_of_measurement WHERE uom_name = ?  AND uom_name != ?";

}
