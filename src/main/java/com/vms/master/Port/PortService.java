package com.vms.master.Port;

public interface PortService {

	public PortResultBean savePort(PortBean bean);

	public PortResultBean listPort();

	public PortResultBean editPort(String id);

	public PortResultBean updatePort(PortBean bean);

	public PortResultBean deletePort(String id);

}
