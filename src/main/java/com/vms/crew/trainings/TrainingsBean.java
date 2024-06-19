package com.vms.crew.trainings;

import java.util.List;


public class TrainingsBean {
	private String code;
	private String description;
	private List<TrainingsBean> trainingsBeanDtls;
	public List<TrainingsBean> getTrainingsBeanDtls() {
		return trainingsBeanDtls;
	}
	public void setTrainingsBeanDtls(List<TrainingsBean> trainingsBeanDtls) {
		this.trainingsBeanDtls = trainingsBeanDtls;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
