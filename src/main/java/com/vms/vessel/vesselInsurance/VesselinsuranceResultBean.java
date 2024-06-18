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

	public VesselinsuranceBean getVesselinsuranceBean() {
		return VesselinsuranceBean;
	}

	public void setVesselinsuranceBean(VesselinsuranceBean vesselinsuranceBean) {
		VesselinsuranceBean = vesselinsuranceBean;
	}

	private List<VesselinsuranceBean> list;
	private VesselinsuranceBean VesselinsuranceBean;

	

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
