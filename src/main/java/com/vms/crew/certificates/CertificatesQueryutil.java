package com.vms.crew.certificates;

public class CertificatesQueryutil {

	
	
	public static final String SAVE_certificates = "Insert into certificate_master (certificate_code,certificate_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";
	
	public static final String code = "SELECT CONCAT('C', LPAD(CAST(COALESCE(MAX(CAST(SUBSTRING(certificate_code, 2) AS UNSIGNED)), 0) + 1 AS CHAR(4)), '0') AS next_certificate_code\r\n"
			+ "			FROM certificate_master";
	
	public static final String getList = "select certificate_code as code,certificate_name as description,certificate_id as certificateId from certificate_master order by created_dt desc";

	public static final String getEdit = "select certificate_code as code,certificate_name as description,certificate_id as certificateId from certificate_master where certificate_id = ?";

	public static final String delete = "delete from certificate_master where certificate_id = ? ";

	public static final String checkDelete = "select count(*) from certificate_master where certificate_code = ?";

	public static final String UPDATE_certificates = "update certificate_master set certificate_code=:code,certificate_name=:desc,modified_by=:userName,modified_dt=now() where certificate_id = :code";

	public static final String get_certificate_Id = "SELECT CONCAT('C', LPAD(CAST(COALESCE(MAX(CAST(SUBSTRING(certificate_code, 2) AS INTEGER)), 0) + 1 AS TEXT), 4, '0')) AS next_certificate_code FROM certificate_master";

	public static final String get_desc = "select count(certificate_name) from certificate_master where certificate_name=?";

	public static final String certificates_desc = "select certificate_name from certificate_master where certificate_id= ?";

	public static final String get_certificates_edit = "SELECT COUNT(certificate_name) FROM certificate_master WHERE certificate_name = ?  AND certificate_name != ?";

	
}
