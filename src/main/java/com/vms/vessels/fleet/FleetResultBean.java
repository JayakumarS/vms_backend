package com.vms.vessels.fleet;

import java.util.List;


public class FleetResultBean {

	
	public boolean success;
	private List<FleetBean> list;
	public String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private FleetBean fleetBean;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<FleetBean> getList() {
		return list;
	}
	public void setList(List<FleetBean> list) {
		this.list = list;
	}
	public FleetBean getFleetBean() {
		return fleetBean;
	}
	public void setFleetBean(FleetBean fleetBean) {
		this.fleetBean = fleetBean;
	}

}
