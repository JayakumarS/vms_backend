package com.vms.crew.crewVesselAssignment;

public class CrewVesselAssignmentQueryUtil {

	public static final String getvessel = "select vessel_type_code as id ,vessel_type_name as text  from vessel_type";
	public static final String getrank = "select rank_code as id ,rank_name as text  from rank_master";
	public static final String getport = "select port_code as id ,port_name as text  from port_master";
	
	public static final String getList = "select m_seamen_name as name, m_seamen_rank_code as rank,m_seamen_joining_date as signon,m_seamen_est_sign_off as signoff from multi_seamen_dtl order by created_dt desc";

	public static final String SEARCH_VSL_DTL = "SELECT cm.crew_master_surname AS name, "
            + "rank_master.rank_name AS rank, "
            + "dtl.m_seamen_joining_date AS signon, "
            + "dtl.m_seamen_est_sign_off AS signoff "
            + "FROM multi_seamen_dtl dtl "
            + "JOIN multi_seamen_hdr hdr ON dtl.m_seamen_hdr_code = hdr.m_seamen_code "
            + "JOIN rank_master ON dtl.m_seamen_rank_code = rank_master.rank_id "
            + "JOIN crew_master cm ON dtl.m_seamen_name = cm.crew_master_code "
            + "WHERE 1=1";
	
			
			
			
			
			
//			"SELECT cm.crew_master_surname AS name,rank_master.rank_name AS rank,dtl.m_seamen_joining_date AS signon,dtl.m_seamen_est_sign_off AS signoff\r\n"
//			+ "FROM multi_seamen_dtl dtl \r\n"
//			+ "JOIN multi_seamen_hdr hdr ON dtl.m_seamen_hdr_code = hdr.m_seamen_code\r\n"
//			+ "JOIN rank_master ON dtl.m_seamen_rank_code = rank_master.rank_id\r\n"
//			+ "JOIN crew_master cm ON dtl.m_seamen_name = cm.crew_master_code";
			
//			"select m_seamen_name as name, m_seamen_rank_code as rank,m_seamen_joining_date as signon,m_seamen_est_sign_off as signoff from multi_seamen_dtl order by created_dt desc";

	
}
