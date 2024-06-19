package com.vms.crew.trainings;

public class TrainingsQueryUtil {
	
	public static final String SAVE_trainings = "Insert into training_master (training_code,training_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

	public static final String getList = "select training_code as code,training_name as description from training_master order by created_dt desc";

	public static final String getEdit = "select training_code as code,training_name as description from training_master where training_code = ?";

	public static final String delete = "delete from training_master where training_code = ? ";

	public static final String checkDelete = "select count(*) from training_master where training_code = ?";

	public static final String UPDATE_trainings = "update training_master set training_code=:code,training_name=:desc,modified_by=:userName,modified_dt=now() where training_code = :code";

}
