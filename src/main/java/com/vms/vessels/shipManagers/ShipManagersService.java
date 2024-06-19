package com.vms.vessels.shipManagers;



public interface ShipManagersService {
	
	public ShipManagersResultBean save(ShipManagersBean bean);

	public ShipManagersResultBean getList();

	public ShipManagersResultBean edit(String id);

	public ShipManagersResultBean delete(String id);

	public ShipManagersResultBean update(ShipManagersBean bean);

}
