package com.vms.master.Port;

public class PortQueryUtil {

	public static final String SAVE_COUNTRY = "Insert into port_master (port_code,port_name,port_type,isactive,created_by,created_date) values (:portCode,:portName,:portType,:active,:userName,now())";
	
	public static final String GET_PORT_LIST = "select port_code as portCode,port_name as portName,port_type as portType,isactive as isActive from port_master";
	
	public static final String GET_EDIT_PORT = "select port_code as portCode,port_name as portName,port_type as portType,isactive as active from port_master where port_code=?";
	
	public static final String DELETE_PORT = "delete from port_master where port_code = ?";
	
	public static final String UPDATE_PORT = "UPDATE port_master SET port_code = :portCode,port_name = :portName,port_type = :portType,isactive = :active,modified_by = :userName,modified_date = NOW() WHERE port_code = :portCode";

}
