package com.vms.vessel.vesselOwner;

import java.util.List;


public class VesselOwnerBean {
	private String code;
	private String description;
	private List<VesselOwnerBean> vesselOwnerBeanDtls;



	public List<VesselOwnerBean> getVesselOwnerBeanDtls() {
		return vesselOwnerBeanDtls;
	}
	public void setVesselOwnerBeanDtls(List<VesselOwnerBean> vesselOwnerBeanDtls) {
		this.vesselOwnerBeanDtls = vesselOwnerBeanDtls;
	}
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
	
}
