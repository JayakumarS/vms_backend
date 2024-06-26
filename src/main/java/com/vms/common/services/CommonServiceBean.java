package com.vms.common.services;

public class CommonServiceBean {
	
	private String id;
	private String text;
	private Integer RankId;
	
	public Integer getRankId() {
		return RankId;
	}
	public void setRankId(Integer rankId) {
		RankId = rankId;
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
	
}
