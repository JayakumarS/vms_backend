package com.vms.common.Languages;

import java.util.List;


public class LanguagesBean {

	private String code;
	private String description;
	private List<LanguagesBean> languageDetails;
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
	public List<LanguagesBean> getLanguageDetails() {
		return languageDetails;
	}
	public void setLanguageDetails(List<LanguagesBean> languageDetails) {
		this.languageDetails = languageDetails;
	}
	
}
