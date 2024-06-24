package com.vms.common.agent;

import java.util.List;


public class AgentBean {

	private String code;
	private String description;
	private int agentid;
	private List<AgentBean> agentDetails;
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
	public List<AgentBean> getAgentDetails() {
		return agentDetails;
	}
	public void setAgentDetails(List<AgentBean> agentDetails) {
		this.agentDetails = agentDetails;
	}
	public int getAgentid() {
		return agentid;
	}
	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}


}
