package com.vms.crew.healthStatus;

public interface HealthStatusService {
	public HealthStatusResultBean save(HealthStatusBean bean);

	public HealthStatusResultBean getList();

	public HealthStatusResultBean edit(String id);

	public HealthStatusResultBean delete(String id);

	public HealthStatusResultBean update(HealthStatusBean bean);
}
