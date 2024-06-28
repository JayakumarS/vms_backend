package com.vms.supplies.freightType;

import java.util.List;


public class FreightTypeResultBean {
	
	private List<FreightTypeBean> list;
	private FreightTypeBean FreightTypeBean;
	public List<FreightTypeBean> getList() {
		return list;
	}
	public void setList(List<FreightTypeBean> list) {
		this.list = list;
	}
	public FreightTypeBean getFreightTypeBean() {
		return FreightTypeBean;
	}
	public void setFreightTypeBean(FreightTypeBean freightTypeBean) {
		FreightTypeBean = freightTypeBean;
	}
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
	public boolean success;
	public String message;

}
