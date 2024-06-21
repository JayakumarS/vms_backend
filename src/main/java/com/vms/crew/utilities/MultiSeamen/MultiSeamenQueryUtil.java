package com.vms.crew.utilities.MultiSeamen;

public class MultiSeamenQueryUtil {

	public static final String SAVE_MULTI_SEAMEN_HDR = "Insert INTO multi_seamen_hdr (m_seamen_vessel_code,m_seamen_starting_date,m_seamen_joining_port) Values(:vessel,:startdate::Date,:joinPort)";

	
	public static final String SAVE_MULTI_SEAMEN_DTL = "Insert INTO multi_seamen_dtl (m_seamen_name,m_seamen_rank_code,m_seamen_pay,m_seamen_currency,m_seamen_joining_date,m_seamen_est_sign_off) Values(:name,:rank,:pay,:currency,:joiningDate::Date,:estSignOff::Date)";
}
