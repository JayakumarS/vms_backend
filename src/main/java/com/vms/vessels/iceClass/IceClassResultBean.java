package com.vms.vessels.iceClass;

import java.util.List;


public class IceClassResultBean {
	private  List<IceClassBean>  list;
	private  IceClassBean iceClassBean;
	private String  msg;
	private boolean success;
	public IceClassBean getIceClassBean() {
		return iceClassBean;
	}
	public void setIceClassBean(IceClassBean iceClassBean) {
		this.iceClassBean = iceClassBean;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<IceClassBean> getList() {
		return list;
	}
	public void setList(List<IceClassBean> list) {
		this.list = list;
	}
	

}
