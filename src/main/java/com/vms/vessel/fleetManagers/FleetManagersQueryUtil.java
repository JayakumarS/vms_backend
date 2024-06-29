package com.vms.vessel.fleetManagers;

public class FleetManagersQueryUtil {

	public static final String SAVE_fleetManagers = "insert into fleet_Managers (fleet_Managers_code,fleet_Managers_fleet,fleet_Managers_Operating_Manager,\r\n"
			+ "fleet_Managers_Technical_Manager,created_by,created_dt) values(:code,:fleet,:opmanager,:techmanager,:userName,now())";
	
	
	public static final String getList = "select fma.fleet_Managers_id as fleetManagersid,fma.fleet_Managers_code as code,fma.fleet_Managers_fleet as fleet,fm.fleet_name as fleetname,\r\n"
			+ "fma.fleet_Managers_Operating_Manager as opmanager,fma.fleet_Managers_Technical_Manager as techmanager from fleet_Managers fma\r\n"
			+ "left join fleet_master fm on fm.fleet_id=fma.fleet_Managers_fleet";


	public static final String getEdit = "select fma.fleet_Managers_id as fleetManagersid,fma.fleet_Managers_code as code,fma.fleet_Managers_fleet as fleet,fm.fleet_name as fleetname,\r\n"
			+ "fma.fleet_Managers_Operating_Manager as opmanager,fma.fleet_Managers_Technical_Manager as techmanager from fleet_Managers fma\r\n"
			+ "left join fleet_master fm on fm.fleet_id=fma.fleet_Managers_fleet\r\n"
			+ "where fma.fleet_Managers_id=?";


	public static final String delete = "delete from fleet_Managers where fleet_Managers_id=?";


	public static final String UPDATE_fleetManagers = "update fleet_Managers set fleet_Managers_code=:code,fleet_Managers_fleet=:fleet,fleet_Managers_Operating_Manager=:opmanager,\r\n"
			+ "fleet_Managers_Technical_Manager=:techmanager,modified_by=:userName,modified_dt=now() \r\n"
			+ "where fleet_Managers_id = :fleetManagersid";


	public static final String get_fleetManagerId = "SELECT CONCAT('VFM', LPAD(CAST(COALESCE(MAX(CAST(SUBSTRING(fleet_Managers_code, 4) AS INTEGER)), 0) + 1 AS TEXT), 4, '0')) AS next_fleet_Managers_code\r\n"
			+ "FROM fleet_Managers";
	
	

}
