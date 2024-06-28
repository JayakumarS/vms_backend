package com.vms.vessels.bunkerTanks;

public class BunkerTankBean {
	
	private Integer bunkertankid;
	public Integer getBunkertankid() {
		return bunkertankid;
	}
	public void setBunkertankid(Integer bunkertankid) {
		this.bunkertankid = bunkertankid;
	}
	private String code;
	private String description;
	
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
