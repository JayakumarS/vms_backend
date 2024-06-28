package com.vms.common.services;

public class CommonServiceBean {
	
	private String id;
	private String text;
	private String code;
	private Integer RankId;
	private Integer nationalityId;
	
	public Integer getNationalityId() {
		return nationalityId;
	}
	public void setNationalityId(Integer nationalityId) {
		this.nationalityId = nationalityId;
	}
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
