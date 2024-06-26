package com.vms.crew.utilities.MultiSeamen;

public class MultiSeamenQueryUtil {

	public static final String SAVE_MULTI_SEAMEN_HDR = "Insert INTO multi_seamen_hdr (m_seamen_vessel_code,m_seamen_starting_date,m_seamen_joining_port,created_by,created_dt) Values(:vessel,:startdate::Date,:joinPort,:userName,now()) returning m_seamen_code";

	
	public static final String SAVE_MULTI_SEAMEN_DTL = "Insert INTO multi_seamen_dtl (m_seamen_hdr_code,m_seamen_name,m_seamen_rank_code,m_seamen_pay,m_seamen_currency,m_seamen_joining_date,m_seamen_est_sign_off,nationality) Values(:code,:name,:rank,:pay,:currency,to_date(:joiningDate,'DD/MM/YYYY'),to_date(:estSignOff,'DD/MM/YYYY'),:nationality)";


	public static final String SAVE_CERTIFICATE = "";
	

	public static final String GET_EDIT_MULTISEAMEN = "select m_seamen_code as seamenCode,m_seamen_vessel_code as vessel,to_char(m_seamen_starting_date,'DD/MM/YYYY') as startdate,m_seamen_joining_port as joinPort\r\n"
			+ " from multi_seamen_hdr where m_seamen_code=?";


	public static final String DELETE_MULTISEAMEN = "delete from multi_seamen_hdr where m_seamen_code=?";

	public static final String DELETE_MULTISEAMEN_Dtl = "delete from multi_seamen_dtl where m_seamen_hdr_code=?";


	public static final String UPDATE_OFFSIGN = "update multi_seamen_hdr set m_seamen_vessel_code=:vessel,m_seamen_starting_date=to_date(:startdate,'DD/MM/YYYY'),m_seamen_joining_port=:joinPort,modified_by=:userName,modified_dt=now()\r\n"
			+ " where m_seamen_code = :seamenCode returning m_seamen_code";


	public static final String DELETE_OFFSIGN_DTL = "delete from multi_seamen_dtl where m_seamen_hdr_code=?";


	public static final String GET_MULTISEAMEN_LIST = "select ms.m_seamen_code as seamenCode,ms.m_seamen_vessel_code as vessel,to_char(ms.m_seamen_starting_date,'DD/MM/YYYY') as\r\n"
			+ "startdate,ms.m_seamen_joining_port as joinPort,to_char(ms.created_dt,'DD/MM/YYYY') as createdDate,\r\n"
			+ "vh.vessel_name as vesselname,pm.port_name as portname from multi_seamen_hdr ms \r\n"
			+ "left join vessel_hdr vh on vh.vessel_code=ms.m_seamen_vessel_code\r\n"
			+ "left join port_master pm on pm.port_id=ms.m_seamen_joining_port";


	public static final String GET_EDIT_MUlTISEAMEN_DTL = "select m_seamen_name as name,m_seamen_rank_code as rank,nationality as nationality,m_seamen_pay as pay,m_seamen_currency as currency,\r\n"
			+ "to_char(m_seamen_joining_date,'DD/MM/YYYY') as joiningDate,\r\n"
			+ "to_char(m_seamen_est_sign_off,'DD/MM/YYYY') as estSignOff,appl_mandatory_valid as validCheck from multi_seamen_dtl\r\n"
			+ "left join appl_checklist on appl_rank_code = m_seamen_rank_code where m_seamen_hdr_code=?";


	public static String GET_MULTISEAMEN_LIST(Integer id) {
	    String query = "WITH valid_rows AS (\r\n"
	    		+ "    SELECT * \r\n"
	    		+ "    FROM appl_checklist \r\n"
	    		+ "    WHERE appl_rank_code = 4\r\n"
	    		+ ")\r\n"
	    		+ "SELECT * \r\n"
	    		+ "FROM valid_rows\r\n"
	    		+ "WHERE appl_mandatory_valid = TRUE\r\n"
	    		+ "AND (SELECT COUNT(*) FROM valid_rows WHERE appl_mandatory_valid = TRUE) = (SELECT COUNT(*) FROM valid_rows);";
	    return query;
	}
}
