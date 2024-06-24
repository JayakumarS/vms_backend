package com.vms.master.Port;

public interface PortDao {

	public PortResultBean savePort(PortBean bean);

	public PortResultBean listPort();

	public PortResultBean editPort(Integer id);

	public PortResultBean deletePort(String id);

	public PortResultBean updatePort(PortBean bean);

}
