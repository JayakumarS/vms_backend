package com.vms.supplies.Supplier;

import java.util.List;

public class SupplierResultBean {
	
	private boolean success;
	private String message;
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<SupplierBean> list;
	
	public List<SupplierBean> getList() {
		return list;
	}
	public void setList(List<SupplierBean> list) {
		this.list = list;
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

}
