package com.vms.crew.maintain.ranktrainings;

public class RankTrainingsBean {

	private String certificatename;
	public String getCertificatename() {
		return certificatename;
	}
	public void setCertificatename(String certificatename) {
		this.certificatename = certificatename;
	}
	public String getTrainingcode() {
		return trainingcode;
	}
	public void setTrainingcode(String trainingcode) {
		this.trainingcode = trainingcode;
	}
	public String getRankcode() {
		return rankcode;
	}
	public void setRankcode(String rankcode) {
		this.rankcode = rankcode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	private String trainingcode;
	private String rankcode;
	private String id;
	private String text;
}
