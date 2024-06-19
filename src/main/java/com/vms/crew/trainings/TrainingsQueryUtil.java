package com.vms.crew.trainings;

public class TrainingsQueryUtil {
	
	public static final String SAVE_trainings = "Insert into trainings (trainings_code,trainings_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select trainings_code as code,trainings_name as description from trainings order by created_dt desc";

	public static final String getEdit = "select trainings_code as code,trainings_name as description from trainings where trainings_code = ?";

	public static final String delete = "delete from trainings where trainings_code = ? ";

	public static final String checkDelete = "select count(*) from trainings where trainings_code = ?";

	public static final String UPDATE_trainings = "update trainings set trainings_code=:code,trainings_name=:desc,modified_by=:userName,modified_dt=now() where trainings_code = :code";

}
