package com.vms.vessels.shipManagers;

import java.util.List;



public class ShipManagersResultBean {
	
	public boolean success;
	public String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private List<ShipManagersBean> list;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<ShipManagersBean> getList() {
		return list;
	}
	public void setList(List<ShipManagersBean> list) {
		this.list = list;
	}
	public ShipManagersBean getShipManagersBean() {
		return shipManagersBean;
	}
	public void setShipManagersBean(ShipManagersBean shipManagersBean) {
		this.shipManagersBean = shipManagersBean;
	}
	private ShipManagersBean shipManagersBean;

}
