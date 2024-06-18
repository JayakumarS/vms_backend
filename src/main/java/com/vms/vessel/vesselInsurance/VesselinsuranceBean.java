package com.vms.vessel.vesselInsurance;

import java.util.List;


public class VesselinsuranceBean {
	private String code;
	private String description;
	private List<VesselinsuranceBean> vesselInsuranceDtls;


	public List<VesselinsuranceBean> getVesselInsuranceDtls() {
		return vesselInsuranceDtls;
	}
	public void setVesselInsuranceDtls(List<VesselinsuranceBean> vesselInsuranceDtls) {
		this.vesselInsuranceDtls = vesselInsuranceDtls;
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
