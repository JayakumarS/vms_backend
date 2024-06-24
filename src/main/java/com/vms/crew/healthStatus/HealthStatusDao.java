package com.vms.crew.healthStatus;



public interface HealthStatusDao {
	public HealthStatusResultBean save(HealthStatusBean bean);

	public HealthStatusResultBean getList();

	public HealthStatusResultBean edit(Integer id);

	public HealthStatusResultBean delete(Integer id);

	public HealthStatusResultBean update(HealthStatusBean bean);
}
