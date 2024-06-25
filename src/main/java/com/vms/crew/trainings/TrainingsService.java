package com.vms.crew.trainings;

public interface TrainingsService {
	
	public TrainingsResultBean save(TrainingsBean bean);

	public TrainingsResultBean getList();

	public TrainingsResultBean edit(Integer id);

	public TrainingsResultBean delete(Integer id);

	public TrainingsResultBean update(TrainingsBean bean);

}
