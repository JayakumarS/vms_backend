package com.vms.crew.maintain.rankcertificates;

public class RankCertificatesQueryUtil {

	public static final String SAVE= "Insert into rank_certificate(certificate_code,rank_code,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select certificate_id as certificatecode,certificate_name as categories from certificate_master order by created_dt desc";

	public static final String checkDelete = "select count(*) from rank_certificate where certificate_code = ? and rank_code = ?";

	public static final String UPDATE = "update rank_certificate set certificate_code = :code, rank_code = :desc, modified_by = :userName, modified_dt = now() where rank_certificate_id = :id";

	public static final String getListALL = "SELECT certificate_code AS certificatecode,rank_code AS rankcode FROM rank_certificate  ORDER BY created_dt DESC";

	public static final String DELETE = "DELETE FROM rank_certificate WHERE rank_code = ?";

	public static final String getrank = "SELECT * FROM (SELECT 0 AS id, 'A' AS text, 0 AS sort_order, 'All Ranks' AS text1 UNION SELECT rank_id AS id, rank_code AS text, 1 AS sort_order, rank_name as text1 FROM rank_master) AS combined ORDER BY sort_order, id";
//			"SELECT * FROM (SELECT 'A' AS id, 'All Ranks' AS text, 0 AS sort_order UNION SELECT rank_code AS id, rank_name AS text, 1 AS sort_order FROM rank_master) AS combined ORDER BY sort_order, id";

}
