package com.vms.common.agent;

import java.util.List;


public class AgentResultBean {

	
	public boolean success;
	private List<AgentBean> list;
	public String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private AgentBean agentsBean;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<AgentBean> getList() {
		return list;
	}
	public void setList(List<AgentBean> list) {
		this.list = list;
	}
	public AgentBean getAgentsBean() {
		return agentsBean;
	}
	public void setAgentsBean(AgentBean agentsBean) {
		this.agentsBean = agentsBean;
	}

}
