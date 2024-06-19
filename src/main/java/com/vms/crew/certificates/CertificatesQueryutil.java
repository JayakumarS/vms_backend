package com.vms.crew.certificates;

public class CertificatesQueryutil {

	
	
	public static final String SAVE_certificates = "Insert into certificate_master (certificate_code,certificate_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select certificate_code as code,certificate_name as description from certificate_master order by created_dt desc";

	public static final String getEdit = "select certificate_code as code,certificate_name as description from certificate_master where certificate_code = ?";

	public static final String delete = "delete from certificate_master where certificate_code = ? ";

	public static final String checkDelete = "select count(*) from certificate_master where certificate_code = ?";

	public static final String UPDATE_certificates = "update certificate_master set certificate_code=:code,certificate_name=:desc,modified_by=:userName,modified_dt=now() where certificate_code = :code";

	
}
