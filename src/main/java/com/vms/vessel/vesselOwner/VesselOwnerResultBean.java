package com.vms.vessel.vesselOwner;

import java.util.List;


public class VesselOwnerResultBean {

	public boolean success;


	private List<VesselOwnerBean> list;
	private VesselOwnerBean vesselOwnerBean;

	


	public List<VesselOwnerBean> getList() {
		return list;
	}

	public void setList(List<VesselOwnerBean> list) {
		this.list = list;
	}

	public VesselOwnerBean getVesselOwnerBean() {
		return vesselOwnerBean;
	}

	public void setVesselOwnerBean(VesselOwnerBean vesselOwnerBean) {
		this.vesselOwnerBean = vesselOwnerBean;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
