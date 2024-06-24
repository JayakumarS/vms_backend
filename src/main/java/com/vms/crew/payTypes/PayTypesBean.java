package com.vms.crew.payTypes;

import java.util.List;


public class PayTypesBean {
	private Integer paytypeid;
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
	public Integer getPaytypeid() {
		return paytypeid;
	}
	public void setPaytypeid(Integer paytypeid) {
		this.paytypeid = paytypeid;
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
