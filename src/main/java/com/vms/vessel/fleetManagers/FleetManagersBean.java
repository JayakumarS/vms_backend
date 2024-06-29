package com.vms.vessel.fleetManagers;

public class FleetManagersBean {
	public Integer getFleet() {
		return fleet;
	}
	public void setFleet(Integer fleet) {
		this.fleet = fleet;
	}
	public String getOpmanager() {
		return opmanager;
	}
	public void setOpmanager(String opmanager) {
		this.opmanager = opmanager;
	}
	public String getTechmanager() {
		return techmanager;
	}
	public void setTechmanager(String techmanager) {
		this.techmanager = techmanager;
	}
	
	public Integer getFleetManagersid() {
		return fleetManagersid;
	}
	public void setFleetManagersid(Integer fleetManagersid) {
		this.fleetManagersid = fleetManagersid;
	}

	private Integer fleetManagersid;
	private Integer fleet;
	private String opmanager;
	private String techmanager;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	private String code;

}
