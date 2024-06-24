package com.vms.crew.healthStatus;

import java.util.List;


public class HealthStatusBean {
	private String code;
	private String description;
	private List<HealthStatusBean> healthStatusBeanDtls;

	public Integer getHealthstatusid() {
		return healthstatusid;
	}
	public void setHealthstatusid(Integer healthstatusid) {
		this.healthstatusid = healthstatusid;
	}
	private Integer healthstatusid;
	
	
	public List<HealthStatusBean> getHealthStatusBeanDtls() {
		return healthStatusBeanDtls;
	}
	public void setHealthStatusBeanDtls(List<HealthStatusBean> healthStatusBeanDtls) {
		this.healthStatusBeanDtls = healthStatusBeanDtls;
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
