package com.vms.vessel.fleetManagers;

import java.util.List;


public class FleetManagersResultBean {
	
	public boolean success;


	private List<FleetManagersBean> list;
	public List<FleetManagersBean> getList() {
		return list;
	}

	public void setList(List<FleetManagersBean> list) {
		this.list = list;
	}

	public FleetManagersBean getFleetManagersBean() {
		return FleetManagersBean;
	}

	public void setFleetManagersBean(FleetManagersBean fleetManagersBean) {
		FleetManagersBean = fleetManagersBean;
	}


	private FleetManagersBean FleetManagersBean;

	

	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String message;
	
	
}
