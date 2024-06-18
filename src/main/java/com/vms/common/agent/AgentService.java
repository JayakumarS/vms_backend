package com.vms.common.agent;

public interface AgentService {

	public AgentResultBean save(AgentBean bean);

	public AgentResultBean getList();

	public AgentResultBean edit(String id);

	public AgentResultBean delete(String id);

	public AgentResultBean update(AgentBean bean);
}
