package com.vms.master.vesselType;

import java.util.List;

public class VesselTypeResultBean {
	public boolean success;
	private List<VesselTypeBean> list;
	private VesselTypeBean vesselTypeBean;

	public List<VesselTypeBean> getList() {
		return list;
	}

	public VesselTypeBean getVesselTypeBean() {
		return vesselTypeBean;
	}

	public void setVesselTypeBean(VesselTypeBean vesselTypeBean) {
		this.vesselTypeBean = vesselTypeBean;
	}

	public void setList(List<VesselTypeBean> list) {
		this.list = list;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
