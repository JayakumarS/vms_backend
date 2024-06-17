package com.vms.master.vesselType;

import java.util.List;

public class VesselTypeBean {
	private String code;
	private String description;
	private List<VesselTypeBean> vesselTypeDtls;

	public List<VesselTypeBean> getVesselTypeDtls() {
		return vesselTypeDtls;
	}
	public void setVesselTypeDtls(List<VesselTypeBean> vesselTypeDtls) {
		this.vesselTypeDtls = vesselTypeDtls;
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
