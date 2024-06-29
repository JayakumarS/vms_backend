package com.vms.crew.maintain.interviewsetup;

public class InterviewSetupQueryUtil {

	
	
	public static final String SAVE_INTERVIEWSETUP_HDR = "Insert into interview_setup_hdr (rank_id,description,created_by,created_dt)"
			+ "values (:rank,:desc,:userName,now()) returning interview_setup_id ";
	
	public static final String SAVE_INTERVIEWSETUP_DTL = "Insert into interview_setup_dtl (interview_setup_hdr_id,interview_setup_description)"
			+ "values (:interviewsetupid,:description)";

	public static final String getList = "SELECT ihdr.interview_setup_id AS interviewsetupid,rm.rank_name AS rankname,regexp_replace(regexp_replace(idtl.interview_setup_description, '&nbsp;', ' ', 'g'), '<[^>]*>', '', 'g') AS description,ihdr.created_by AS createdBy,ihdr.created_dt AS createdDate\r\n"
			+ "FROM interview_setup_hdr ihdr LEFT JOIN  interview_setup_dtl idtl ON idtl.interview_setup_hdr_id = ihdr.interview_setup_id LEFT JOIN rank_master rm ON rm.rank_id = ihdr.rank_id";


	
	public static final String UPDATE_INTERVIEWSETUP ="update  interview_setup_id  as interviewsetupid,rank_id=:rank,interview_setup_description=:description,modified_by=:userName,modified_dt=now() where interview_setup_id=:interviewsetupid ";
	

	public static final String GET_RANK_MASTERS = "select rank_id as id,rank_name as text from rank_master";

	
	public static final String get_rank ="select count(*) from interview_setup_hdr where rank_id= ?";

	
	
	
	 public static final String delete_INTERVIEWSETUP_HDR = "DELETE FROM interview_setup_hdr WHERE interview_setup_id = ?";
	 public static final String delete_INTERVIEWSETUP_DTL = "DELETE FROM interview_setup_dtl WHERE interview_setup_hdr_id = ?";
	
     public static final String delete_INTERVIEWSETUP_dtl = "DELETE FROM interview_setup_dtl WHERE interview_setup_hdr_id = ?";
	
     public static final String UPDATE_INTERVIEWSETUP_DTL = "update   interview_setup_dtl set  interview_setup_hdr_id  as interviewsetupid,interview_setup_description=:description where interview_setup_dtl_id=:interviewsetupid  ";
	
	 public static final String UPDATE_INTERVIEWSETUP_HDR = "update  interview_setup_hdr set rank_id=:rank,description=:desc,modified_by=:userName,modified_dt=now() where interview_setup_id=:interviewsetupid returning interview_setup_id";
	
	

	public static final String getEdit = "select ihdr.interview_setup_id  as interviewsetupid,ihdr.rank_id as rank,rm.rank_name as rankname,regexp_replace(regexp_replace(idtl.interview_setup_description, '&nbsp;', ' ', 'g'),'<[^>]*>', '', 'g') AS description,ihdr.description as desc from interview_setup_hdr ihdr left join interview_setup_dtl idtl on idtl.interview_setup_hdr_id= ihdr.interview_setup_id LEFT JOIN rank_master rm ON rm.rank_id = ihdr.rank_id where ihdr.interview_setup_id = CAST(? AS INTEGER) ";

	
	

//	public static final String getEditDtl ="select  interview_setup_description as description from interview_setup_dtl where interview_setup_hdr_id =CAST(? AS INTEGER)";
//
//	public static final String getEdit = "select interview_setup_id  as interviewsetupid,rank_id as rank,description as desc  from interview_setup_hdr where interview_setup_id = CAST(? AS INTEGER) ";

	
	




}






