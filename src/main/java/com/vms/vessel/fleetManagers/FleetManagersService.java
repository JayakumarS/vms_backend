package com.vms.vessel.fleetManagers;

public interface FleetManagersService{
	
	public FleetManagersResultBean save(FleetManagersBean bean);
	
	public FleetManagersResultBean getList();

	public FleetManagersResultBean edit(Integer id);

	public FleetManagersResultBean delete(Integer id);

	public FleetManagersResultBean update(FleetManagersBean bean);

	FleetManagersBean getSequenceCode();

}
