package com.vms.master.bloodgroup;

public class BloodGroupBean {
	private String bloodGroupCode;
	private String name;
	private String active;
	private Integer bloodGroupId;
	
	public String getBloodGroupCode() {
		return bloodGroupCode;
	}
	public void setBloodGroupCode(String bloodGroupCode) {
		this.bloodGroupCode = bloodGroupCode;
	}
	public String getName() {
		return name;
	}
	public Integer getBloodGroupId() {
		return bloodGroupId;
	}
	public void setBloodGroupId(Integer bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
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