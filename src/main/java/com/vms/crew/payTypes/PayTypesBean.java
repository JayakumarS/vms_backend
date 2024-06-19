package com.vms.crew.payTypes;

import java.util.List;


public class PayTypesBean {
	
	private String code;
	private String description;
	private List<PayTypesBean> payTypesBeanDtls;
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
	public List<PayTypesBean> getPayTypesBeanDtls() {
		return payTypesBeanDtls;
	}
	public void setPayTypesBeanDtls(List<PayTypesBean> payTypesBeanDtls) {
		this.payTypesBeanDtls = payTypesBeanDtls;
	}

}
