package com.vms.vessels.fleet;

import java.util.List;


public class FleetBean {

	private String code;
	private String description;
	private int fleetid;
	private List<FleetBean> fleetDtls;
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
	public List<FleetBean> getFleetDtls() {
		return fleetDtls;
	}
	public void setFleetDtls(List<FleetBean> fleetDtls) {
		this.fleetDtls = fleetDtls;
	}
	public int getFleetid() {
		return fleetid;
	}
	public void setFleetid(int fleetid) {
		this.fleetid = fleetid;
	}

}
