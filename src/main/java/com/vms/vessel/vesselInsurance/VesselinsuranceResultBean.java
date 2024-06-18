package com.vms.vessel.vesselInsurance;

import java.util.List;


public class VesselinsuranceResultBean {

	
	public boolean success;
	public List<VesselinsuranceBean> getList() {
		return list;
	}

	public void setList(List<VesselinsuranceBean> list) {
		this.list = list;
	}


	private List<VesselinsuranceBean> list;
	private VesselinsuranceBean vesselinsuranceBean;

	

	public VesselinsuranceBean getVesselinsuranceBean() {
		return vesselinsuranceBean;
	}

	public void setVesselinsuranceBean(VesselinsuranceBean vesselinsuranceBean) {
		this.vesselinsuranceBean = vesselinsuranceBean;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
