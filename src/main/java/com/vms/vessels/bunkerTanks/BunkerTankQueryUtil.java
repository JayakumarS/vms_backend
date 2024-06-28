package com.vms.vessels.bunkerTanks;

public class BunkerTankQueryUtil {
	
	public static final String SAVE_bunkertank = "Insert into bunker_tank (bunker_tank_code,bunker_tank_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select bunker_tank_id as bunkertankid, bunker_tank_code as code,bunker_tank_name as description from bunker_tank order by created_dt desc";

	public static final String getEdit = "select bunker_tank_id as bunkertankid,bunker_tank_code as code,bunker_tank_name as description from bunker_tank where bunker_tank_id = ?";

	public static final String delete = "delete from bunker_tank where bunker_tank_id = ? ";

	public static final String checkDelete = "select count(*) from bunker_tank where bunker_tank_id = ?";

	public static final String UPDATE_bunkertank = "update bunker_tank set bunker_tank_code=:code,bunker_tank_name=:desc,modified_by=:userName,modified_dt=now() where bunker_tank_id = :bunkertankid";
	
	public static final String get_code = "select count(bunker_tank_code) from bunker_tank where bunker_tank_code=?";

	public static final String get_desc = "select count(bunker_tank_name) from bunker_tank where bunker_tank_name=?";
	
	public static final String bunker_tank_code = "select bunker_tank_code from bunker_tank where bunker_tank_id= ?";

	public static final String bunkertank_desc = "select bunker_tank_name from bunker_tank where bunker_tank_id= ?";
	
	public static final String getCodeById = "SELECT bunker_tank_code FROM bunker_tank WHERE bunker_tank_id = ?";


	public static String get_code_edit="SELECT COUNT(bunker_tank_code) FROM bunker_tank WHERE bunker_tank_code = ?  AND bunker_tank_code != ?";

	public static String get_desc_edit="SELECT COUNT(bunker_tank_name) FROM bunker_tank WHERE bunker_tank_name = ?  AND bunker_tank_name != ?";


}
