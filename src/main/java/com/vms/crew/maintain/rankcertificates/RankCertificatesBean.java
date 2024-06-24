package com.vms.crew.maintain.rankcertificates;

import java.util.List;


public class RankCertificatesBean {

	private String categories;
	private String certificatecode;
	private String rankcode;
	public String getCertificatecode() {
		return certificatecode;
	}
	public void setCertificatecode(String certificatecode) {
		this.certificatecode = certificatecode;
	}
	public String getRankcode() {
		return rankcode;
	}
	public void setRankcode(String rankcode) {
		this.rankcode = rankcode;
	}
	
	private String id;
	private String text;
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
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}

}
