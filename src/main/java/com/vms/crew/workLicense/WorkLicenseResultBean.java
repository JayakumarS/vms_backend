package com.vms.crew.workLicense;

import java.util.List;

import com.vms.vessel.vesselInsurance.VesselinsuranceBean;

public class WorkLicenseResultBean {

	
	public boolean success;


	private List<WorkLicenseBean> list;
	private WorkLicenseBean workLicenseBean;

	

	public List<WorkLicenseBean> getList() {
		return list;
	}

	public void setList(List<WorkLicenseBean> list) {
		this.list = list;
	}

	

	public WorkLicenseBean getWorkLicenseBean() {
		return workLicenseBean;
	}

	public void setWorkLicenseBean(WorkLicenseBean workLicenseBean) {
		this.workLicenseBean = workLicenseBean;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
