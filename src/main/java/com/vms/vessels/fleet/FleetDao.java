package com.vms.vessels.fleet;


public interface FleetDao {

	
	public FleetResultBean save(FleetBean bean);

	public FleetResultBean getList();

	public FleetResultBean edit(String id);

	public FleetResultBean delete(String id);

	public FleetResultBean update(FleetBean bean);

}
