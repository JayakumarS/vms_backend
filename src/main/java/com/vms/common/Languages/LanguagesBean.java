package com.vms.common.Languages;


public class LanguagesBean {
	private String active;
	private String code;
	private String description;
	private int languageid;
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
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public int getLanguageid() {
		return languageid;
	}
	public void setLanguageid(int languageid) {
		this.languageid = languageid;
	}
}
