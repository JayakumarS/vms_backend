package com.vms.crew.certificates;

public class CertificatesQueryutil {

	
	
	public static final String SAVE_certificates = "Insert into certificates (certificates_code,certificates_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select certificates_code as code,certificates_name as description from certificates order by created_dt desc";

	public static final String getEdit = "select certificates_code as code,certificates_name as description from certificates where certificates_code = ?";

	public static final String delete = "delete from certificates where certificates_code = ? ";

	public static final String checkDelete = "select count(*) from certificates where certificates_code = ?";

	public static final String UPDATE_certificates = "update certificates set certificates_code=:code,certificates_name=:desc,modified_by=:userName,modified_dt=now() where certificates_code = :code";

	
}
