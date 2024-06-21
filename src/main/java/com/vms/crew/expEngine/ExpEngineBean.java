package com.vms.crew.expEngine;

import java.util.List;


public class ExpEngineBean {
	
	private String code;
	private String description;
	private List<ExpEngineBean> expEngineBeanBeanDtls;
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
	public List<ExpEngineBean> getExpEngineBeanBeanDtls() {
		return expEngineBeanBeanDtls;
	}
	public void setExpEngineBeanBeanDtls(List<ExpEngineBean> expEngineBeanBeanDtls) {
		this.expEngineBeanBeanDtls = expEngineBeanBeanDtls;
	}

}
