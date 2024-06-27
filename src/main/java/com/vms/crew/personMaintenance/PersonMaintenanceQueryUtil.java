package com.vms.crew.personMaintenance;

public class PersonMaintenanceQueryUtil {
	
	public static final String SAVE_CREW_MASTER = "Insert into crew_master "
			+ "(crew_master_code, crew_master_surname, crew_master_name, crew_master_middle_name, crew_master_nationality, crew_master_rank, crew_master_birth_date, crew_master_gender, crew_master_father_name, crew_master_mother_name, crew_master_place, crew_master_license, "
			+ "crew_master_health_status, crew_master_decision_c, crew_master_work_status, crew_master_religion, crew_master_agent, exp_month, no_voyages, crew_master_vessel_type, crew_master_last_sign_off, crew_master_available_from, remarks_one, "
			+ "remarks_two, recom_by, status,crew_master_age,crew_master_comp_service,crew_master_sea_service,crew_master_years_rank,created_by, created_dt) "
			+ "values(:code,:surname,:name,:middle,:nationality,:rank,to_date(:bDate,'dd/mm/yyyy'),:gender,:father,:mother,:place,:licence,:healthSt,:decisionC,:workStatus,:religion, "
			+ ":agent,:expMonth,:noVoyage,:vslType,to_date(:lastSignOff,'dd/mm/yyyy'),to_date(:available,'dd/mm/yyyy'),:remarksOne,:remarksTwo,:reCom,:active,:age,:compService,:seaService,:yearsInRank,:userName,now()) ";
	
	public static final String SAVE_CREW_MASTER_DOCUMENT = "Insert into crew_master_document "
			+ "(crew_master_code, crew_master_passport, passport_issue, passport_expiry, passport_issue_place, crew_master_s_book, "
			+ "s_book_issue, s_book_expiry, s_book_issue_place, us_visa, us_visa_no, us_visa_expiry, sid, sid_issue, sid_expiry, indos, pan_no, aadhar_no, "
			+ "sid_file_path, sid_file_name, cv_file_path, cv_file_name,crew_master_img,crew_master_file_path, created_by, created_dt) "
			+ "values(:code,:passPort,to_date(:pIssue,'dd/mm/yyyy'),to_date(:pExpiry,'dd/mm/yyyy'),:pIssuePlace,:sBook,to_date(:sIssue,'dd/mm/yyyy'),to_date(:sExpiry,'dd/mm/yyyy'),:sIssuePlace,:usVisa,:usVisaNo,to_date(:usExpiry,'dd/mm/yyyy'),:sid,to_date(:sidIssue,'dd/mm/yyyy'),to_date(:sidExpiry,'dd/mm/yyyy'),:indos,:pan,:adhar,:sidFilePath, "
			+ ":sidFileName,:cvFilePath,:cvFileName,:crewMasterImg,:crewMasterFilePath,:userName,now()) ";
	
	public static final String SAVE_RANK_DTLS = "Insert into crew_master_rank_dtl (crew_master_code,crew_master_rank_id,created_by,created_dt) values (:code,:rank,:userName,now())";
//	
//	public static final String GET_LIST = "select person_maintenance_code as code,surname as surname,name as name,status as active,cm.country_name as nationality, "
//			+ "gender as gender,am.agent_code_name as agent,w.work_status_name as workStatus,rm.rank_name as rank "
//			+ "from person_maintenance pm "
//			+ "left join rank_master rm on rm.rank_code = pm.rank "
//			+ "left join agent_master am on am.agent_code = pm.agent "
//			+ "left join work_status w on w.work_status_code  = pm.work_status "
//			+ "left join country_master cm on cm.country_code = pm.nationality "
//			+ "order by person_maintenance_code desc ";
	
	public static final String GET_DETAILS="SELECT crew_master_id as id, crew_master_code as code, crew_master_surname as surname, crew_master_name as name,"
			+"crew_master_middle_name as middle, crew_master_nationality as nationality, crew_master_rank as rank, to_char(crew_master_birth_date,'dd/mm/yyyy') as birthDate,"
			+"crew_master_gender as gender, crew_master_father_name as father, crew_master_mother_name as mother, crew_master_place as place,"
			+"crew_master_license as licence, crew_master_health_status as health, crew_master_decision_c as decision, crew_master_work_status as workStatus,"
			+"crew_master_religion as religion, crew_master_agent as agent, exp_month as expMonth, no_voyages as noVoyage,"
			+"to_char(crew_master_last_sign_off,'dd/mm/yyyy') as signedOff, to_char(crew_master_available_from,'dd/mm/yyyy') as availableFrom, remarks_one as remarksOne, status as active FROM crew_master"
			+ " WHERE crew_master_code = ? ";
	
	public static final String GET_CODE = "SELECT CASE WHEN MAX(crew_master_code) IS NULL THEN 'CM0001' "
			+ "ELSE rpad(MAX(crew_master_code),2,'PM')|| lpad(cast(cast((null_or_empty(SUBSTRING(MAX(crew_master_code),3),'0')) as int)+1 as text),4,'0') "
			+ "END AS crew_master_code  FROM crew_master where crew_master_code like 'CM%' ";
	
	public static final String GET_LIST = "select crew_master_code as code,crew_master_surname as surname,crew_master_name as name,status as active,cm.country_name as nationality, "
			+ "crew_master_gender as gender,am.agent_code_name as agent,w.work_status_name as workStatus,rm.rank_name as rank "
			+ "from crew_master pm "
			+ "left join rank_master rm on rm.rank_id = pm.crew_master_rank "
			+ "left join agent_master am on am.agent_id = pm.crew_master_agent "
			+ "left join work_status w on w.work_status_id  = pm.crew_master_work_status "
			+ "left join country_master cm on cm.country_id = pm.crew_master_nationality "
			+ "order by crew_master_code desc ";
	
	public static final String DELETE_CREW_DOCUMNENT = "delete from crew_master_document where crew_master_code = ? ";
	
	public static final String DELETE_CREW_MASTER = "delete from crew_master where crew_master_code = ? ";
	
	public static final String DELETE_CREW_MASTER_RANK_DTL = "delete from crew_master_rank_dtl where crew_master_code = ? ";
	
	public static final String GET_CREW_MASTER_DTLS = "select crew_master_code as code,crew_master_surname as surname,crew_master_name as name,crew_master_middle_name as middle,crew_master_nationality as nationality, "
			+ "crew_master_rank as rank,to_char(crew_master_birth_date,'dd/mm/yyyy') as birthDate,crew_master_gender as gender,crew_master_father_name as father, "
			+ "crew_master_mother_name as mother,crew_master_place as place,crew_master_license as licence,crew_master_health_status as health, "
			+ "crew_master_decision_c as decision,crew_master_work_status as workStatus,crew_master_religion as religion,crew_master_agent as agent,exp_month as expMonth, "
			+ "no_voyages as noVoyage,crew_master_vessel_type as proposedType,to_char(crew_master_last_sign_off,'dd/mm/yyyy') as signedOff,to_char(crew_master_available_from,'dd/mm/yyyy') as availableFrom, "
			+ "remarks_one as remarksOne,remarks_two as remarksTwo,recom_by as reCom,status as active from crew_master cm "
			+ "where crew_master_code = ? ";
	
	public static final String GET_CREW_MASTER_DOCUMENT_DTLS = "select crew_master_passport as passPort,to_char(passport_issue,'dd/mm/yyyy') as pIssue,to_char(passport_expiry,'dd/mm/yyyy') as pExpiry,passport_issue_place as pIssuePlace, "
			+ "crew_master_s_book as sBook,to_char(s_book_issue,'dd/mm/yyyy') as sIssue,to_char(s_book_expiry,'dd/mm/yyyy') as sExpiry,s_book_issue_place as sIssuePlace,us_visa as usVisa, "
			+ "us_visa_no as usVisaNo,to_char(us_visa_expiry,'dd/mm/yyyy') as usExpiry,sid as sid,to_char(sid_issue,'dd/mm/yyyy') as sidIssue,to_char(sid_expiry,'dd/mm/yyyy') as sidExpiry,indos as indos, "
			+ "pan_no as pan,aadhar_no as adhar,crew_master_img as imgName,crew_master_file_path as imgPath,cv_file_name as cvFileName,cv_file_path as cvFilePath,sid_file_name as sidFileName,sid_file_path as sidFilePath from crew_master_document cmd where crew_master_code = ? ";
	
	public static final String UPDATE_CREW_MASTER = "update crew_master "
			+ "set crew_master_surname=:surname, crew_master_name=:name, crew_master_middle_name=:middle, crew_master_nationality=:nationality, crew_master_rank=:rank, "
			+ "crew_master_birth_date=to_date(:bDate,'dd/mm/yyyy'), crew_master_gender=:gender, crew_master_father_name=:father, crew_master_mother_name=:mother, crew_master_place=:place, "
			+ "crew_master_license=:licence, crew_master_health_status=:healthSt, crew_master_decision_c=:decisionC, crew_master_work_status=:workStatus, crew_master_religion=:religion, "
			+ "crew_master_agent=:agent, exp_month=:expMonth, no_voyages=:noVoyage, crew_master_vessel_type=:vslType, crew_master_last_sign_off=to_date(:lastSignOff,'dd/mm/yyyy'), crew_master_available_from=to_date(:available,'dd/mm/yyyy'), "
			+ "remarks_one=:remarksOne, remarks_two=:remarksTwo, recom_by=:reCom, status=:active,"
			+ "crew_master_age=:age,crew_master_comp_service=:compService,crew_master_sea_service=:seaService,crew_master_years_rank=:yearsInRank,"
			+ "modified_by=:userName, modified_dt=now() "
			+ "where crew_master_code=:code ";
	
	public static final String UPDATE_CREW_MASTER_DOCUMENT = "update crew_master_document "
			+ "set crew_master_code=:code, crew_master_passport=:passPort, passport_issue=to_date(:pIssue,'dd/mm/yyyy'), passport_expiry=to_date(:pExpiry,'dd/mm/yyyy'), "
			+ "passport_issue_place=:pIssuePlace, crew_master_s_book=:sBook, s_book_issue=to_date(:sIssue,'dd/mm/yyyy'), s_book_expiry=to_date(:sExpiry,'dd/mm/yyyy'), s_book_issue_place=:sIssuePlace, us_visa=:usVisa, us_visa_no=:usVisaNo, "
			+ "us_visa_expiry=to_date(:usExpiry,'dd/mm/yyyy'), sid=:sid, sid_issue=to_date(:sidIssue,'dd/mm/yyyy'), sid_expiry=to_date(:sidExpiry,'dd/mm/yyyy'), indos=:indos, pan_no=:pan, aadhar_no=:adhar, "
			+ "sid_file_path=:sidFilePath, sid_file_name=:sidFileName, cv_file_path=:cvFilePath, "
			+ "cv_file_name=:cvFileName,crew_master_img=:crewMasterImg,crew_master_file_path=:crewMasterFilePath,"
			+ "modified_by=:userName, modified_dt=now() "
			+ "where crew_master_code=:code ";
	
	public static final String GET_APPLICANT_LIST = "select crew_applicant_code as applCode, appl_sur_name as surname, appl_name as name, appl_middle_name as middle, appl_nationality as nationality, "
			+ "appl_rank as rank, to_char(appl_birth_date,'dd/mm/yyyy') as birthDate, appl_father as father, appl_mother as mother, "
			+ "appl_birth_place as place, appl_vessel as vesselType, appl_prior_month, appl_decision_code as descision, "
			+ "to_char(appl_sign_off_date,'dd/mm/yyyy') as signedOff, appl_agent as agent, "
			+ "appl_remarks as remarksOne, appl_recom as reCom, to_char(appl_avail_from_date,'dd/mm/yyyy') as availableFrom, "
			+ "appl_book as sBook, appl_issue as sPlace, to_char(appl_expiry_date,'dd/mm/yyyy') as sExpiry, "
			+ "appl_passport as passPort, appl_passport_issue as pIssuePlace, to_char(appl_passport_expiry_date,'dd/mm/yyyy') as pExpiry, "
			+ "appl_licence as licence, "
			+ "cv_operations_file_path,rm.rank_name as rankName,applicant_image_path as imgPath,applicant_image_file_name as imgName from crew_applicant ca "
			+ "left join rank_master rm on rm.rank_id = ca.appl_rank ";
	
	public static final String GET_RANK_DTL_COUNT = "select count(*) from crew_master_rank_dtl where crew_master_code = ? ";
	
	public static final String GET_RANK_DATE = "select to_char(created_dt,'dd/mm/yyyy') from crew_master_rank_dtl where crew_master_code = ? order by crew_master_rank_dtl_id desc limit 1 ";
	
	public static final String GET_RANK_CODE = "select crew_master_rank_id from crew_master_rank_dtl where crew_master_code = ? order by crew_master_rank_dtl_id desc limit 1 ";
	
	public static final String GET_DOC_CHECK_LIST = "select 'Password' as passPort,to_char(appl_passport_expiry_date,'dd/mm/yyyy') as pExpiry,'S.book' as sBook, "
			+ "to_char(appl_expiry_date,'dd/mm/yyyy') as sExpiry from crew_applicant ca "
			+ "where crew_applicant_code = ? ";
	
	public static final String GET_CERTIFICATE_CHECK_LIST = "select cm.certificate_name as name,appl_mandatory_valid as valid,appl_mandatory_invalid as inValid,appl_optional_invalid as optional from appl_checklist ac "
			+ "left join certificate_master cm on cm.certificate_id = ac.appl_certificate_code "
			+ "where appl_code = ? ";
}
