package com.vms.vessels.fleet;



public interface FleetService {

	
	public FleetResultBean save(FleetBean bean);

	public FleetResultBean getList();

	public FleetResultBean edit(String id);

	public FleetResultBean delete(String id);

	public FleetResultBean update(FleetBean bean);

}
