package com.vms.common.agent;

public interface AgentService {

	public AgentResultBean save(AgentBean bean);

	public AgentResultBean getList();

	public AgentResultBean edit(int id);

	public AgentResultBean delete(int id);

	public AgentResultBean update(AgentBean bean);
}
