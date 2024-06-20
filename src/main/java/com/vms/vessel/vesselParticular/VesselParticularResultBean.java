package com.vms.vessel.vesselParticular;

import java.util.List;

public class VesselParticularResultBean {
	public boolean success;
	private List<VesselParticularBean> list;
	private VesselParticularBean vesselTypeBean;
	private VesselParticularBean hdrBean;
	private VesselParticularBean mainDtlBean;
	private VesselParticularBean commDtlBean;
	private VesselParticularBean crewDtlBean;
	private String vesselCode;

	public String getVesselCode() {
		return vesselCode;
	}

	public void setVesselCode(String vesselCode) {
		this.vesselCode = vesselCode;
	}

	public VesselParticularBean getHdrBean() {
		return hdrBean;
	}

	public void setHdrBean(VesselParticularBean hdrBean) {
		this.hdrBean = hdrBean;
	}

	public VesselParticularBean getMainDtlBean() {
		return mainDtlBean;
	}

	public void setMainDtlBean(VesselParticularBean mainDtlBean) {
		this.mainDtlBean = mainDtlBean;
	}

	public VesselParticularBean getCommDtlBean() {
		return commDtlBean;
	}

	public void setCommDtlBean(VesselParticularBean commDtlBean) {
		this.commDtlBean = commDtlBean;
	}

	public VesselParticularBean getCrewDtlBean() {
		return crewDtlBean;
	}

	public void setCrewDtlBean(VesselParticularBean crewDtlBean) {
		this.crewDtlBean = crewDtlBean;
	}

	public List<VesselParticularBean> getList() {
		return list;
	}

	public VesselParticularBean getVesselTypeBean() {
		return vesselTypeBean;
	}

	public void setVesselTypeBean(VesselParticularBean vesselTypeBean) {
		this.vesselTypeBean = vesselTypeBean;
	}

	public void setList(List<VesselParticularBean> list) {
		this.list = list;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
