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

	
	public String getFleetname() {
		return fleetname;
	}
	public void setFleetname(String fleetname) {
		this.fleetname = fleetname;
	}

	private String fleetname;
	
	private String techmanagername;
	
	public String getTechmanagername() {
		return techmanagername;
	}
	public void setTechmanagername(String techmanagername) {
		this.techmanagername = techmanagername;
	}
	public String getOpmanagername() {
		return opmanagername;
	}
	public void setOpmanagername(String opmanagername) {
		this.opmanagername = opmanagername;
	}

	private String opmanagername;
}
