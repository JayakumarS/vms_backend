package com.vms.crew.utilities.MultiSeamen;

public class MultiSeamenQueryUtil {

	public static final String SAVE_MULTI_SEAMEN_HDR = "Insert INTO multi_seamen_hdr (m_seamen_vessel_code,m_seamen_starting_date,m_seamen_joining_port) Values(:vessel,:startdate::Date,:joinPort) returning m_seamen_code";

	
	public static final String SAVE_MULTI_SEAMEN_DTL = "Insert INTO multi_seamen_dtl (m_seamen_hdr_code,m_seamen_name,m_seamen_rank_code,m_seamen_pay,m_seamen_currency,m_seamen_joining_date,m_seamen_est_sign_off) Values(:code,:name,:rank,:pay,:currency,to_date(:joiningDate,'DD/MM/YYYY'),to_date(:estSignOff,'DD/MM/YYYY'))";


	public static final String SAVE_CERTIFICATE = "";
}
