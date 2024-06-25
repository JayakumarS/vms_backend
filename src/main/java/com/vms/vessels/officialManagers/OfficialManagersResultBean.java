package com.vms.vessels.officialManagers;

import java.util.List;

import com.vms.vessels.shipManagers.ShipManagersBean;


public class OfficialManagersResultBean {
	
	public boolean success;
	public String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private List<OfficialManagersBean> list;
	private OfficialManagersBean OfficialManagersBean;
	private String path;

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public OfficialManagersBean getOfficialManagersBean() {
		return OfficialManagersBean;
	}
	public void setOfficialManagersBean(OfficialManagersBean officialManagersBean) {
		OfficialManagersBean = officialManagersBean;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<OfficialManagersBean> getList() {
		return list;
	}
	public void setList(List<OfficialManagersBean> list) {
		this.list = list;
	}

}
