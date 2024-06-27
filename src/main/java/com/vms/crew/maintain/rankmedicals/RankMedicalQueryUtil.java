package com.vms.crew.maintain.rankmedicals;

public class RankMedicalQueryUtil {

	
	public static final String SAVE_Medical_Rank= "Insert into rank_medicals(medical_code,rank_code,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select medical_id as medicalcode,medical_name as certificatename from medical_master order by created_dt desc";

	public static final String checkDelete = "select count(*) from rank_medicals where medical_code = ? and rank_code = ?";


	public static final String getListALL = "SELECT medical_code AS medicalcode,rank_code AS rankcode FROM rank_medicals  ORDER BY created_dt DESC";

	public static final String DELETE_Medical_Rank = "DELETE FROM rank_medicals WHERE rank_code = ?";

	public static final String getrank = "SELECT * FROM (SELECT 0 AS id, 'A' AS text, 0 AS sort_order, 'All Ranks' AS text1 UNION SELECT rank_id AS id, rank_code AS text, 1 AS sort_order, rank_name as text1 FROM rank_master) AS combined ORDER BY sort_order, id";
//			"SELECT * FROM (SELECT 'A' AS id, 'All Ranks' AS text, 0 AS sort_order UNION SELECT rank_code AS id, rank_name AS text, 1 AS sort_order FROM rank_master) AS combined ORDER BY sort_order, id";

}
