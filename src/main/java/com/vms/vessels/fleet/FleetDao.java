package com.vms.vessels.fleet;


public interface FleetDao {

	
	public FleetResultBean save(FleetBean bean);

	public FleetResultBean getList();

	public FleetResultBean edit(int id);

	public FleetResultBean delete(int id);

	public FleetResultBean update(FleetBean bean);

}
