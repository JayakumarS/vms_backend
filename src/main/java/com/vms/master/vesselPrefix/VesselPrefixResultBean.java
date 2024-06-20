package com.vms.master.vesselPrefix;

import java.util.List;

public class VesselPrefixResultBean {
	public boolean success;
	private List<VesselPrefixBean> list;
	private VesselPrefixBean vesselTypeBean;

	public List<VesselPrefixBean> getList() {
		return list;
	}

	public VesselPrefixBean getVesselTypeBean() {
		return vesselTypeBean;
	}

	public void setVesselTypeBean(VesselPrefixBean vesselTypeBean) {
		this.vesselTypeBean = vesselTypeBean;
	}

	public void setList(List<VesselPrefixBean> list) {
		this.list = list;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
