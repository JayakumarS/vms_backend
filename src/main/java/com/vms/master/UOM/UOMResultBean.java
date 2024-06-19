package com.vms.master.UOM;

import java.util.List;


public class UOMResultBean {

	public boolean success;
	private List<UOMBean> list;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<UOMBean> getList() {
		return list;
	}
	public void setList(List<UOMBean> list) {
		this.list = list;
	}

}
