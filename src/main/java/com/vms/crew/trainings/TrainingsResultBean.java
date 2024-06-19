package com.vms.crew.trainings;

import java.util.List;



public class TrainingsResultBean {
	
	public boolean success;


	private List<TrainingsBean> list;
	private TrainingsBean trainingsBean;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<TrainingsBean> getList() {
		return list;
	}
	public void setList(List<TrainingsBean> list) {
		this.list = list;
	}
	public TrainingsBean getTrainingsBean() {
		return trainingsBean;
	}
	public void setTrainingsBean(TrainingsBean trainingsBean) {
		this.trainingsBean = trainingsBean;
	}

}
