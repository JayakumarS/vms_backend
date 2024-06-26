package com.vms.master.religion;


public class ReligionBean {
	
	private String code;
	private String name;
	private String active;
	private Integer religionId;
	
	public String getCode() {
		return code;
	}
	public Integer getReligionId() {
		return religionId;
	}
	public void setReligionId(Integer religionId) {
		this.religionId = religionId;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	
	

}
