package com.vms.crew.maintain.ranktrainings;

public class RankTrainingsQueryUtil {

	public static final String SAVE_trainings= "Insert into training_rank(training_code,rank_code,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select training_code as trainingcode,training_name as certificatename from training_master order by created_dt desc";

	public static final String checkDelete = "select count(*) from training_rank where training_code = ? and rank_code = ?";


	public static final String getListALL = "SELECT training_code AS trainingcode,rank_code AS rankcode FROM training_rank  ORDER BY created_dt DESC";

	public static final String DELETE_trainings = "DELETE FROM training_rank WHERE rank_code = ?";

	public static final String getrank = "SELECT * FROM (SELECT 'A' AS id, 'All Ranks' AS text, 0 AS sort_order UNION SELECT rank_code AS id, rank_name AS text, 1 AS sort_order FROM rank_master) AS combined ORDER BY sort_order, id";

}
