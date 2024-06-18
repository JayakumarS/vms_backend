package com.vms.vessels.wageScale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



public class WageScaleResultBean {

	public boolean success;
	private List<WageScaleBean> list;
	private WageScaleBean fleetBean;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<WageScaleBean> getList() {
		return list;
	}
	public void setList(List<WageScaleBean> list) {
		this.list = list;
	}
	public WageScaleBean getFleetBean() {
		return fleetBean;
	}
	public void setFleetBean(WageScaleBean fleetBean) {
		this.fleetBean = fleetBean;
	}

}
