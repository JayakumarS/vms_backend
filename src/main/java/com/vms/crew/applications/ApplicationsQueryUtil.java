package com.vms.crew.applications;

public class ApplicationsQueryUtil {
	public static final String getvessel = "select vessel_type_code as id ,vessel_type_name as text  from vessel_type";
	
	public static final String getrank = "select rank_code as id ,rank_name as text  from rank_master";
	
	public static final String getnationality = "select country_code as id ,nationality as text from country_master WHERE nationality IS NOT NULL";
	
	public static final String getagent = "select agent_code as id , agent_code_name as text from agent_master";
	
	public static final String getlicence = "select work_license_code as id , work_license_name as text from work_license";

	
	public static final String SAVE_APPLICATION = "Insert into crew_applicant (appl_sur_name,appl_name,appl_nationality,appl_middle_name,appl_rank,appl_birth_date,appl_father,\r\n"
			+ "appl_mother,appl_birth_place,appl_vessel ,appl_prior_month ,appl_decision_code ,appl_engine,appl_sign_off_Date,appl_agent,\r\n"
			+ "appl_remarks,appl_application_Date,appl_recom,appl_avail_from_Date,appl_book,appl_issue,appl_expiry_Date,appl_passport,\r\n"
			+ "appl_passport_issue,appl_passport_expiry_Date,appl_licence,appl_licence_issue,appl_licence_expiry_Date,appl_grade,appl_licence_no,\r\n"
			+ "appl_kin,appl_city,appl_address1,appl_tel1,appl_address2,appl_tel2,cv_Operations_file_Path,cv_Operations_file_Name,pass_Book_file_Path,pass_Book_file_Name,sBook_file_Path,sBook_file_Name,applicant_image_Path,applicant_image_File_Name,created_by,created_dt)\r\n"
			+ "values (:surname,:name,:nation,:midname,:rank,to_date(:dob,'dd/mm/yyyy'),:father,:mother,:birthplace,:vessel,:priormonth,:decisioncode,:engine,\r\n"
			+ "to_date(:signOffDate,'dd/mm/yyyy'),:agent,:remarks,to_date(:appDate,'dd/mm/yyyy'),:recom,to_date(:availfromDate,'dd/mm/yyyy'),:book,:issue,\r\n"
			+ "to_date(:expiryDate,'dd/mm/yyyy'),:passport,:passportissue,to_date(:passportExpiryDate,'dd/mm/yyyy'),:licence,:licenceissue,to_date(:licenceExpiryDate,'dd/mm/yyyy'),\r\n"
			+ ":grade,:licenceno,:kin,:city,:address1,:tel1,:address2,:tel2,:cvOperationsfilePath,:cvOperationsfileName,:passBookfilePath,:passBookfileName,:sBookfilePath,:sBookfileName,:applicantimagePath,:applicantimageFileName,:userName,now())";
	
	public static final String getList = "select crew_applicant_code as code,appl_sur_name as surname,appl_name as name,appl_nationality as nation,appl_middle_name as midname,appl_rank as rank,appl_birth_date as dob,\r\n"
			+ "appl_father as father,appl_mother as mother,appl_birth_place as birthplace,appl_vessel  as vessel,appl_prior_month as  priormonth,appl_decision_code  as decisioncode,appl_engine as engine,\r\n"
			+ "appl_sign_off_Date as signOffDate,appl_agent as agent,appl_remarks as remarks,appl_application_Date as appDate,appl_recom  as recom,appl_avail_from_Date as availfromDate,appl_book as book,\r\n"
			+ "appl_issue as issue,appl_expiry_Date as expiryDate,appl_passport as passport,appl_passport_issue as passportissue,appl_passport_expiry_Date as passportExpiryDate,appl_licence as licence,\r\n"
			+ "appl_licence_issue as licenceissue,appl_licence_expiry_Date as licenceExpiryDate,appl_grade as grade,appl_licence_no as licenceno,appl_kin as kin,appl_city as city,\r\n"
			+ "appl_address1 address1,appl_tel1 as tel1,appl_address2 as address2,appl_tel2 as tel2,cv_Operations_file_Path as cvOperationsfilePath,cv_Operations_file_Name as cvOperationsfileName,pass_Book_file_Path as passBookfilePath,pass_Book_file_Name as passBookfileName,sBook_file_Path as sBookfilePath,sBook_file_Name as sBookfileName,applicant_image_Path as applicantimagePath,applicant_image_File_Name as applicantimageFileName from crew_applicant";
	
	public static final String getEdit = "select crew_applicant_code as code,appl_sur_name as surname,appl_name as name,appl_nationality as nation,appl_middle_name as midname,appl_rank as rank,to_char(appl_birth_date,'dd/mm/yyyy') as dob ,\r\n"
			+ "appl_father as father,appl_mother as mother,appl_birth_place as birthplace,appl_vessel  as vessel,appl_prior_month as  priormonth,appl_decision_code  as decisioncode,appl_engine as engine,\r\n"
			+ "to_char(appl_sign_off_Date,'dd/mm/yyyy') as signOffDate,appl_agent as agent,appl_remarks as remarks, to_char(appl_application_Date,'dd/mm/yyyy') as appDate,appl_recom  as recom,to_char(appl_avail_from_Date,'dd/mm/yyyy') as availfromDate,appl_book as book,\r\n"
			+ "appl_issue as issue, to_char(appl_expiry_Date,'dd/mm/yyyy') as expiryDate,appl_passport as passport,appl_passport_issue as passportissue, to_char(appl_passport_expiry_Date,'dd/mm/yyyy') as passportExpiryDate,appl_licence as licence,\r\n"
			+ "appl_licence_issue as licenceissue,to_char(appl_licence_expiry_Date,'dd/mm/yyyy') as licenceExpiryDate,appl_grade as grade,appl_licence_no as licenceno,appl_kin as kin,appl_city as city,\r\n"
			+ "appl_address1 address1,appl_tel1 as tel1,appl_address2 as address2,appl_tel2 as tel2,cv_Operations_file_Path as cvOperationsfilePath,cv_Operations_file_Name as cvOperationsfileName,pass_Book_file_Path as passBookfilePath,pass_Book_file_Name as passBookfileName,sBook_file_Path as sBookfilePath,sBook_file_Name as sBookfileName,applicant_image_Path as applicantimagePath,applicant_image_File_Name as applicantimageFileName  from crew_applicant where crew_applicant_code=?";

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
	
	

}
