package com.vms.crew.applications;

public class ApplicationsQueryUtil {

	
	public static final String SAVE_APPLICATION = "Insert into crew_applicant (appl_sur_name,appl_name,appl_nationality,appl_middle_name,appl_rank,appl_birth_date,appl_father,\r\n"
			+ "appl_mother,appl_birth_place,appl_vessel ,appl_prior_month ,appl_decision_code ,appl_engine,appl_sign_off_Date,appl_agent,\r\n"
			+ "appl_remarks,appl_application_Date,appl_recom,appl_avail_from_Date,appl_book,appl_issue,appl_expiry_Date,appl_passport,\r\n"
			+ "appl_passport_issue,appl_passport_expiry_Date,appl_licence,appl_licence_issue,appl_licence_expiry_Date,appl_grade,appl_licence_no,\r\n"
			+ "appl_kin,appl_city,appl_address1,appl_tel1,appl_address2,appl_tel2,cv_Operations_file_Path,cv_Operations_file_Name,pass_Book_file_Path,pass_Book_file_Name,sBook_file_Path,sBook_file_Name,applicant_image_Path,applicant_image_File_Name,created_by,created_dt)\r\n"
			+ "values (:surname,:name,:nation,:midname,:rank,to_date(:dob,'dd/mm/yyyy'),:father,:mother,:birthplace,:vessel,:priormonth,:decisioncode,:engine,\r\n"
			+ "to_date(:signOffDate,'dd/mm/yyyy'),:agent,:remarks,to_date(:appDate,'dd/mm/yyyy'),:recom,to_date(:availfromDate,'dd/mm/yyyy'),:book,:issue,\r\n"
			+ "to_date(:expiryDate,'dd/mm/yyyy'),:passport,:passportissue,to_date(:passportExpiryDate,'dd/mm/yyyy'),:licence,:licenceissue,to_date(:licenceExpiryDate,'dd/mm/yyyy'),\r\n"
			+ ":grade,:licenceno,:kin,:city,:address1,:tel1,:address2,:tel2,:cvOperationsfilePath,:cvOperationsfileName,:passBookfilePath,:passBookfileName,:sBookfilePath,:sBookfileName,:applicantimagePath,:applicantimageFileName,:userName,now()) returning crew_applicant_code";
	
	public static final String getList = "select ca.crew_applicant_code as code,ca.appl_sur_name as surname,ca.appl_name as name,ca.appl_nationality as nation,\r\n"
			+ "ca.appl_middle_name as midname,ca.appl_rank as rank,to_char(ca.appl_birth_date,'dd/mm/yyyy') as dob ,\r\n"
			+ "ca.appl_father as father,ca.appl_mother as mother,ca.appl_birth_place as birthplace,ca.appl_vessel  as vessel,\r\n"
			+ "ca.appl_prior_month as  priormonth,ca.appl_decision_code  as decisioncode,ca.appl_engine as engine,\r\n"
			+ "to_char(ca.appl_sign_off_Date,'dd/mm/yyyy') as signOffDate,ca.appl_agent as agent,ca.appl_remarks as remarks, \r\n"
			+ "to_char(ca.appl_application_Date,'dd/mm/yyyy') as appDate,ca.appl_recom  as recom,to_char(ca.appl_avail_from_Date,'dd/mm/yyyy') as \r\n"
			+ "availfromDate,ca.appl_book as book,\r\n"
			+ "ca.appl_issue as issue, to_char(ca.appl_expiry_Date,'dd/mm/yyyy') as expiryDate,ca.appl_passport as passport,\r\n"
			+ "ca.appl_passport_issue as passportissue, to_char(ca.appl_passport_expiry_Date,'dd/mm/yyyy') as passportExpiryDate,ca.appl_licence as licence,\r\n"
			+ "ca.appl_licence_issue as licenceissue,to_char(ca.appl_licence_expiry_Date,'dd/mm/yyyy') as licenceExpiryDate,ca.appl_grade as grade,\r\n"
			+ "ca.appl_licence_no as licenceno,ca.appl_kin as kin,appl_city as city,\r\n"
			+ "ca.appl_address1 address1,ca.appl_tel1 as tel1,ca.appl_address2 as address2,ca.appl_tel2 as tel2,ca.cv_Operations_file_Path as \r\n"
			+ "cvOperationsfilePath,ca.cv_Operations_file_Name as cvOperationsfileName,ca.pass_Book_file_Path as passBookfilePath,\r\n"
			+ "ca.pass_Book_file_Name as passBookfileName,ca.sBook_file_Path as sBookfilePath,ca.sBook_file_Name as sBookfileName,\r\n"
			+ "ca.applicant_image_Path as applicantimagePath,ca.applicant_image_File_Name as applicantimageFileName,\r\n"
			+ "cm.nationality as nationalityname,rm.rank_name as rankname,vh,vessel_name as vesselname,am.agent_code_name as agentname,et.engine_type_name as enginename\r\n"
			+ ",wl.work_license_name as licensename from crew_applicant ca \r\n"
			+ "left Join  country_master cm ON cm.country_id = ca.appl_nationality\r\n"
			+ "left Join rank_master rm ON rm.rank_id = ca.appl_rank\r\n"
			+ "left Join vessel_hdr vh ON vh.vessel_code = ca.appl_vessel\r\n"
			+ "left Join agent_master am ON am.agent_id = ca.appl_agent\r\n"
			+ "left Join engine_type et ON et.engine_type_id = ca.appl_engine\r\n"
			+ "left Join work_license wl ON wl.work_license_id = ca.appl_licence";
	
	public static final String getEdit = "select ca.crew_applicant_code as code,ca.appl_sur_name as surname,ca.appl_name as name,ca.appl_nationality as nation,\r\n"
			+ "ca.appl_middle_name as midname,ca.appl_rank as rank,to_char(ca.appl_birth_date,'dd/mm/yyyy') as dob ,\r\n"
			+ "ca.appl_father as father,ca.appl_mother as mother,ca.appl_birth_place as birthplace,ca.appl_vessel  as vessel,\r\n"
			+ "ca.appl_prior_month as  priormonth,ca.appl_decision_code  as decisioncode,ca.appl_engine as engine,\r\n"
			+ "to_char(ca.appl_sign_off_Date,'dd/mm/yyyy') as signOffDate,ca.appl_agent as agent,ca.appl_remarks as remarks, \r\n"
			+ "to_char(ca.appl_application_Date,'dd/mm/yyyy') as appDate,ca.appl_recom  as recom,to_char(ca.appl_avail_from_Date,'dd/mm/yyyy') as \r\n"
			+ "availfromDate,ca.appl_book as book,\r\n"
			+ "ca.appl_issue as issue, to_char(ca.appl_expiry_Date,'dd/mm/yyyy') as expiryDate,ca.appl_passport as passport,\r\n"
			+ "ca.appl_passport_issue as passportissue, to_char(ca.appl_passport_expiry_Date,'dd/mm/yyyy') as passportExpiryDate,ca.appl_licence as licence,\r\n"
			+ "ca.appl_licence_issue as licenceissue,to_char(ca.appl_licence_expiry_Date,'dd/mm/yyyy') as licenceExpiryDate,ca.appl_grade as grade,\r\n"
			+ "ca.appl_licence_no as licenceno,ca.appl_kin as kin,appl_city as city,\r\n"
			+ "ca.appl_address1 address1,ca.appl_tel1 as tel1,ca.appl_address2 as address2,ca.appl_tel2 as tel2,ca.cv_Operations_file_Path as \r\n"
			+ "cvOperationsfilePath,ca.cv_Operations_file_Name as cvOperationsfileName,ca.pass_Book_file_Path as passBookfilePath,\r\n"
			+ "ca.pass_Book_file_Name as passBookfileName,ca.sBook_file_Path as sBookfilePath,ca.sBook_file_Name as sBookfileName,\r\n"
			+ "ca.applicant_image_Path as applicantimagePath,ca.applicant_image_File_Name as applicantimageFileName,\r\n"
			+ "cm.nationality as nationalityname,rm.rank_name as rankname,vh,vessel_name as vesselname,am.agent_code_name as agentname,et.engine_type_name as enginename\r\n"
			+ ",wl.work_license_name as licensename from crew_applicant ca \r\n"
			+ "left Join  country_master cm ON cm.country_id = ca.appl_nationality\r\n"
			+ "left Join rank_master rm ON rm.rank_id = ca.appl_rank\r\n"
			+ "left Join vessel_hdr vh ON vh.vessel_code = ca.appl_vessel\r\n"
			+ "left Join agent_master am ON am.agent_id = ca.appl_agent\r\n"
			+ "left Join engine_type et ON et.engine_type_id = ca.appl_engine\r\n"
			+ "left Join work_license wl ON wl.work_license_id = ca.appl_licence\r\n"
			+ "where crew_applicant_code=?";

	public static final String delete = "delete from crew_applicant where crew_applicant_code = ? ";

	public static final String UPDATE_APPLICATION = "UPDATE crew_applicant SET appl_sur_name=:surname,appl_name=:name,\r\n"
			+ "appl_middle_name=:midname,appl_nationality=:nation,appl_rank=:rank,appl_birth_date =to_date(:dob,'dd/mm/yyyy'),appl_father=:father,\r\n"
			+ "appl_mother=:mother,appl_birth_place=:birthplace,appl_vessel =:vessel,appl_prior_month =:priormonth,appl_decision_code=:decisioncode,\r\n"
			+ "appl_engine=:engine,appl_sign_off_date =to_date(:signOffDate,'dd/mm/yyyy'),appl_agent=:agent,appl_remarks=:remarks,\r\n"
			+ "appl_application_date =to_date(:appDate,'dd/mm/yyyy'),appl_recom=:recom,appl_avail_from_date =to_date(:availfromDate,'dd/mm/yyyy'),\r\n"
			+ "appl_book=:book,appl_issue=:issue,appl_expiry_date =to_date(:expiryDate,'dd/mm/yyyy'),appl_passport=:passport,appl_passport_issue=:passportissue,\r\n"
			+ "appl_passport_expiry_date=to_date(:passportExpiryDate,'dd/mm/yyyy'),\r\n"
			+ "appl_licence=:licence,appl_licence_issue=:licenceissue,appl_licence_expiry_date =to_date(:licenceExpiryDate,'dd/mm/yyyy'),\r\n"
			+ "appl_grade =:grade,appl_licence_no=:licenceno ,appl_kin =:kin,appl_city =:city,appl_address1=:address1,\r\n"
			+ "appl_tel1 =:tel1,appl_address2=:address2,appl_tel2 =:tel2,cv_operations_file_path=:cvOperationsfilePath,\r\n"
			+ "cv_operations_file_name=:cvOperationsfileName,pass_book_file_path=:passBookfilePath,pass_book_file_name=:passBookfileName,\r\n"
			+ "sbook_file_path=:sBookfilePath,sbook_file_name=:sBookfileName,applicant_image_path=:applicantimagePath,\r\n"
			+ "applicant_image_file_name=:applicantimageFileName,modified_by = :userName,modified_dt = NOW() WHERE crew_applicant_code = :code";


	public static final String get_certificate_List = "select rc.certificate_code as certificateCode,cm.certificate_name as certificateName from rank_certificate rc"
			+ "left join certificate_master cm on rc.certificate_code = cm.certificate_code"
			+ "where rank_code=?";


	public static String bulkMailDesignList(String currentUserId) {
		
		String query = "select DISTINCT designation as designation from new.experience_info where organisation_id=('" + currentUserId +"')";

		return query;
	 }

	public static String get_certificate_List(int rankCode) {
		String query = "SELECT rc.rank_code as rankCode, cm.certificate_id as CertifiCode, STRING_AGG(cm.certificate_name, ', ') as certificateName FROM rank_certificate rc "
	               + "LEFT JOIN certificate_master cm ON rc.certificate_code = cm.certificate_id "
	               + "WHERE rc.rank_code =('" + rankCode +"')"
	               + "GROUP BY rc.rank_code,cm.certificate_id";
		return query;
	}
	
	
	public static String get_mcertificate_List(int rankCode) {
		String query = "SELECT rm.rank_code as rankCode, cm.medical_id as mcertificateCode, STRING_AGG(cm.medical_name, ', ') as mcertificateName FROM rank_medicals rm \r\n"
				+ "	LEFT JOIN medical_master cm ON rm.medical_code = cm.medical_id "
				+ "	WHERE rm.rank_code =('" + rankCode +"')"
				+ "	GROUP BY rm.rank_code,cm.medical_id";	          
		return query;
	}
	
	public static final String SAVE_CERTIFICATE = "Insert into appl_checklist(appl_code,appl_rank_code,appl_certificate_code,appl_medicalcertificate_code,appl_mandatory_valid,appl_mandatory_invalid,appl_optional_invalid,created_by,created_dt)"
			+ "values (:applcode,:rankCode,:certifiCode,:mcertificateCode,:mandatoryValid,:mandatoryInvalid,:optionalInvalid,:userName,now())";

	public static final String getEditpopup ="SELECT acl.appl_code AS applcode,acl.appl_rank_code AS rankCode,acl.appl_certificate_code AS CertifiCode,cm.certificate_name AS certificateName,acl.appl_medicalcertificate_code AS mcertificateCode,"
			+ " mm.medical_name AS mcertificateName,acl.appl_mandatory_valid AS mandatoryValid,acl.appl_mandatory_invalid AS mandatoryInvalid,acl.appl_optional_invalid AS optionalInvalid"
			+ " FROM appl_checklist acl LEFT JOIN certificate_master cm ON acl.appl_certificate_code = cm.certificate_id"
			+ " LEFT JOIN medical_master mm ON acl.appl_medicalcertificate_code = mm.medical_id"
			+ " WHERE acl.appl_code = ?"
			+ " UNION ALL"
			+ " SELECT NULL AS applcode,rc.rank_code AS rankCode,cm.certificate_id AS CertifiCode,STRING_AGG(cm.certificate_name, ', ') AS certificateName,NULL AS mcertificateCode,NULL AS mcertificateName,NULL AS mandatoryValid, NULL AS mandatoryInvalid,NULL AS optionalInvalid"
			+ " FROM rank_certificate rc"
			+ " LEFT JOIN certificate_master cm ON rc.certificate_code = cm.certificate_id"
			+ " LEFT JOIN appl_checklist acl ON cm.certificate_id = acl.appl_certificate_code AND acl.appl_code = ?"
			+ " WHERE rc.rank_code = ? AND acl.appl_certificate_code IS NULL"
			+ " GROUP BY rc.rank_code, cm.certificate_id"
			+ " UNION ALL"
			+ " SELECT NULL AS applcode,rm.rank_code AS rankCode,NULL AS CertifiCode,NULL AS certificateName,cm.medical_id AS mcertificateCode,STRING_AGG(cm.medical_name, ', ') AS mcertificateName,NULL AS mandatoryValid,NULL AS mandatoryInvalid,NULL AS optionalInvalid"
			+ " FROM rank_medicals rm"
			+ " LEFT JOIN medical_master cm ON rm.medical_code = cm.medical_id"
			+ " LEFT JOIN appl_checklist acl ON cm.medical_id = acl.appl_medicalcertificate_code AND acl.appl_code = ?"
			+ " WHERE rm.rank_code = ? AND acl.appl_medicalcertificate_code IS NULL"
			+ " GROUP BY rm.rank_code, cm.medical_id";
			
			
			
//			"SELECT acl.appl_code AS applcode,acl.appl_rank_code AS rankCode,acl.appl_certificate_code AS CertifiCode,cm.certificate_name AS certificateName,acl.appl_medicalcertificate_code AS mcertificateCode,mm.medical_name AS mcertificateName,acl.appl_mandatory_valid AS mandatoryValid,acl.appl_mandatory_invalid AS mandatoryInvalid,acl.appl_optional_invalid AS optionalInvalid"
//			+ " FROM appl_checklist acl"
//			+ " LEFT JOIN certificate_master cm ON acl.appl_certificate_code = cm.certificate_id"
//			+ " LEFT JOIN  medical_master mm ON acl.appl_medicalcertificate_code = mm.medical_id"
//			+ " WHERE acl.appl_code = ?";
//			
			
//			"select appl_code as applcode,appl_rank_code as rankCode,appl_certificate_code as CertifiCode,appl_medicalcertificate_code as mcertificateCode,appl_mandatory_valid as mandatoryValid,appl_mandatory_invalid as mandatoryInvalid,appl_optional_invalid as optionalInvalid from appl_checklist where appl_code =?";

	
	public static final String getCodeById = "SELECT crew_applicant_code FROM crew_applicant WHERE crew_applicant_code = ?";

//	public static final String update_popup ="UPDATE appl_checklist SET acl.appl_rank_code =:rankCode,acl.appl_certificate_code =:CertifiCode,cm.certificate_name =:certificateName,acl.appl_medicalcertificate_code =:mcertificateCode,"
//           + " mm.medical_name =:mcertificateName,acl.appl_mandatory_valid =:mandatoryValid,acl.appl_mandatory_invalid =:mandatoryInvalid,acl.appl_optional_invalid =:optionalInvalid"
//           + " FROM appl_checklist acl WHERE acl.appl_code = :code";
	
	
	public static final String DELETE_CERTIFICATES = "DELETE FROM appl_checklist WHERE appl_code = :applcode";
	
	public static final String FETCH_CERTIFICATES = "SELECT * FROM appl_checklist WHERE appl_code = :applcode";
	public static final String FETCH_MEDICAL_CERTIFICATES = "SELECT * FROM appl_checklist WHERE appl_code = :applcode";


}
