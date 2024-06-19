package com.vms.crew.trainings;


public interface TrainingsDao {
	
	public TrainingsResultBean save(TrainingsBean bean);

	public TrainingsResultBean getList();

	public TrainingsResultBean edit(String id);

	public TrainingsResultBean delete(String id);

	public TrainingsResultBean update(TrainingsBean bean);

}