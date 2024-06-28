package com.vms.crew.multiSeamenSignOff;

public class MultiSeamenSignOffQueryUtil {
	

	public static final String GET_LIST = "select md.m_seamen_hdr_code as code,md.m_seamen_name as seaman,md.m_seamen_rank_code as rank, \r\n"
			+ "to_char(md.m_seamen_joining_date,'dd/mm/yyyy') AS joiningdate ,\r\n"
			+ "to_char(md.m_seamen_est_sign_off,'dd/mm/yyyy')  as estSignoff,mh.m_seamen_joining_port as port,md.nationality as nationality\r\n"
			+ "from multi_seamen_dtl md inner join  multi_seamen_hdr mh on mh.m_seamen_code=md.m_seamen_hdr_code\r\n"
			+ "where mh.m_seamen_vessel_code=? and mh.m_seamen_starting_date=to_date(?,'dd/mm/yyyy') and mh.m_seamen_joining_port=?";


	public static final String SAVE_MULTI_SEAMEN_HDR = "insert Into multi_seamen_sign_off_hdr (m_seamen_sign_off_hdr_fromdate,m_seamen_sign_off_hdr_vessel,\r\n"
			+ "m_seamen_sign_off_hdr_signoffcode,m_seamen_sign_off_hdr_port,created_by,created_dt)\r\n"
			+ "values(to_date(:fromdate,'DD/MM/YYYY'),:vessel,:signoffcode,:port,:userName,now())returning m_seamen_sign_off_hdr_id ";




	public static final String SAVE_MULTI_SEAMEN_DTL = "INSERT INTO multi_seamen_sign_off_dtl(m_seamen_sign_off_id, m_seamen_sign_off_code, m_seamen_sign_off_seamen,\r\n"
			+ "m_seamen_sign_off_rank,m_seamen_sign_off_nationality,m_seamen_sign_off_joiningdate,\r\n"
			+ "m_seamen_sign_off_joiningport,m_seamen_sign_off_estsignOff,m_seamen_sign_off_reason,m_seamen_sign_off_signoffDate ,\r\n"
			+ "m_seamen_sign_off_signoffport,created_by,created_dt )VALUES(:id,:code,:seman,:rank,:nation,to_date(:jdate,'dd/mm/yyyy'),\r\n"
			+ ":port,to_date(:est,'dd/mm/yyyy'),:reason,to_date(:signoffDate,'dd/mm/yyyy'),:signoffport,:userName,now())";


	public static final String get_count = "select COUNT(*) from multi_seamen_sign_off_hdr where m_seamen_sign_off_hdr_vessel=? and m_seamen_sign_off_hdr_fromdate=to_date(?,'dd/mm/yyyy') and m_seamen_sign_off_hdr_port=?";


	public static final String GET_LIST_SIGN_OFF = "with first_table as (\r\n"
			+ "select \r\n"
			+ "mh.m_seamen_sign_off_hdr_id as seamenId, \r\n"
			+ "msd.m_seamen_sign_off_code as code,\r\n"
			+ "msd.m_seamen_sign_off_seamen as seaman,\r\n"
			+ "msd.m_seamen_sign_off_rank as rank,\r\n"
			+ "msd.m_seamen_sign_off_reason as reason,\r\n"
			+ "msd.m_seamen_sign_off_nationality as nationality,\r\n"
			+ "to_char(msd.m_seamen_sign_off_joiningdate,'dd/mm/yyyy') as joiningdate,\r\n"
			+ "msd.m_seamen_sign_off_joiningport as port,\r\n"
			+ "to_char(msd.m_seamen_sign_off_signoffDate ,'dd/mm/yyyy') as signOffDate,\r\n"
			+ "msd.m_seamen_sign_off_signoffport as signoffport,\r\n"
			+ "to_char(msd.m_seamen_sign_off_estsignOff ,'dd/mm/yyyy') as estSignoff \r\n"
			+ "from multi_seamen_sign_off_dtl msd  \r\n"
			+ "left join multi_seamen_sign_off_hdr mh on mh.m_seamen_sign_off_hdr_id = msd.m_seamen_sign_off_id\r\n"
			+ "where mh.m_seamen_sign_off_hdr_vessel = ?\r\n"
			+ "and mh.m_seamen_sign_off_hdr_fromdate = to_date(?,'dd/mm/yyyy') \r\n"
			+ "and mh.m_seamen_sign_off_hdr_port = ?\r\n"
			+ ")\r\n"
			+ "select * from first_table\r\n"
			+ "union \r\n"
			+ "select \r\n"
			+ "null as seamenId,\r\n"
			+ "msd.m_seamen_hdr_code as code,\r\n"
			+ "msd.m_seamen_name as seaman,\r\n"
			+ "msd.m_seamen_rank_code as rank,\r\n"
			+ "null as reason,\r\n"
			+ "msd.nationality as nationality,\r\n"
			+ "to_char(msd.m_seamen_joining_date,'dd/mm/yyyy') as joiningdate,\r\n"
			+ "mh.m_seamen_joining_port as port,\r\n"
			+ "null as signOffDate,\r\n"
			+ "null as signoffport,\r\n"
			+ "to_char(msd.m_seamen_est_sign_off ,'dd/mm/yyyy') as estSignoff\r\n"
			+ "from multi_seamen_dtl msd\r\n"
			+ "left join multi_seamen_hdr mh on mh.m_seamen_code = msd.m_seamen_hdr_code\r\n"
			+ "left join first_table ft on \r\n"
			+ "ft.code = msd.m_seamen_hdr_code and\r\n"
			+ "ft.seaman = msd.m_seamen_name and\r\n"
			+ "ft.rank = msd.m_seamen_rank_code and\r\n"
			+ "ft.joiningdate = to_char(msd.m_seamen_joining_date,'dd/mm/yyyy') and\r\n"
			+ "ft.port = mh.m_seamen_joining_port and\r\n"
			+ "ft.estSignoff = to_char(msd.m_seamen_est_sign_off ,'dd/mm/yyyy')\r\n"
			+ "where mh.m_seamen_vessel_code = ?\r\n"
			+ "and mh.m_seamen_starting_date = to_date(?,'dd/mm/yyyy') \r\n"
			+ "and mh.m_seamen_joining_port = ?\r\n"
			+ "and ft.code is null;\r\n"
			+ "";

	
	public static final String delete_hdr = "delete from multi_seamen_sign_off_hdr where m_seamen_sign_off_hdr_id=?";

	public static final String delete_dtl = "delete from multi_seamen_sign_off_dtl where m_seamen_sign_off_id=?";


	public static final String UPDATE_MULTI_SEAMEN_HDR = "update multi_seamen_sign_off_hdr set \r\n"
			+ "m_seamen_sign_off_hdr_vessel=:vessel,\r\n"
			+ "m_seamen_sign_off_hdr_fromdate=to_date(:fromdate,'DD/MM/YYYY'),m_seamen_sign_off_hdr_signoffcode=:signoffcode,\r\n"
			+ "m_seamen_sign_off_hdr_port=:port where m_seamen_sign_off_hdr_id = :id returning m_seamen_sign_off_hdr_id";
}
