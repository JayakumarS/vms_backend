package com.vms.vessels.bunkerTanks;

import java.util.List;



public class BunkerTankResultBean {
	
	public boolean success;
	public String message;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<BunkerTankBean> getList() {
		return list;
	}
	public void setList(List<BunkerTankBean> list) {
		this.list = list;
	}
	public BunkerTankBean getBunkerTankBean() {
		return BunkerTankBean;
	}
	public void setBunkerTankBean(BunkerTankBean bunkerTankBean) {
		BunkerTankBean = bunkerTankBean;
	}
	private List<BunkerTankBean> list;
	private BunkerTankBean BunkerTankBean;

}
