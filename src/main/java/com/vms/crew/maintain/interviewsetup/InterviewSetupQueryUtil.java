package com.vms.crew.maintain.interviewsetup;

public class InterviewSetupQueryUtil {

	
	
	public static final String SAVE_INTERVIEWSETUP_HDR = "Insert into interview_setup_hdr (rank_id,created_by,created_dt)"
			+ "values (:rank,:userName,now())returning interview_setup_id";
	
	public static final String getList = "select interview_setup_id  as interviewsetupid,rank_id as rank,interview_setup_description as description  from interview_setup order by created_dt desc";

	
	
	public static final String getEdit = "select interview_setup_id  as interviewsetupid,rank_id as rank,interview_setup_description as description from interview_setup where interview_setup_id = ?";

	
	public static final String UPDATE_INTERVIEWSETUP ="update  interview_setup_id  as interviewsetupid,rank_id=:rank,interview_setup_description=:description,modified_by=:userName,modified_dt=now() where interview_setup_id=:interviewsetupid ";
	
	public static final String delete = "delete from interview_setup where interview_setup_id = ? ";

	public static final String GET_RANK_MASTERS = "select rank_id as id,rank_name as text from rank_master";

	public static final String SAVE_INTERVIEWSETUP_DTL = "Insert into interview_setup_dtl (interview_setup_hdr_id,interview_setup_description)"
			+ "values (:interviewsetupid,:description)";
	
	




}






