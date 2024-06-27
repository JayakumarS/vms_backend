package com.vms.crew.multiSeamenSignOff;

public class MultiSeamenSignOffQueryUtil {
	
	public static final String GET_LIST = "select md.m_seamen_hdr_code as code,cm.crew_master_name as seaman,rm.rank_name as rank, md.m_seamen_joining_date AS joiningdate , \r\n"
			+ "md.m_seamen_est_sign_off as estSignoff,pm.port_name as port,country.nationality as nationality\r\n"
			+ "from multi_seamen_dtl md inner join  multi_seamen_hdr mh on mh.m_seamen_code=md.m_seamen_hdr_code\r\n"
			+ "left join crew_master cm on cm.crew_master_code = md.m_seamen_name\r\n"
			+ "left join rank_master rm on rm.rank_id = md.m_seamen_rank_code\r\n"
			+ "left join port_master pm on pm.port_id = mh.m_seamen_joining_port \r\n"
			+ "left join country_master country on country.country_id = md.nationality \r\n"
			+ "where mh.m_seamen_vessel_code=? and mh.m_seamen_starting_date=to_date(?,'dd/mm/yyyy') and mh.m_seamen_joining_port=?";

}
