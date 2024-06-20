package com.vms.crew.maintain.rankcertificates;

public class RankCertificatesQueryUtil {

	public static final String SAVE= "Insert into  (health_status_code,health_status_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select certificate_code as categories,certificate_name as categories from certificate_master order by created_dt desc";

}
