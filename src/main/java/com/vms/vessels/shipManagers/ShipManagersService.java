package com.vms.vessels.shipManagers;



public interface ShipManagersService {
	
	public ShipManagersResultBean save(ShipManagersBean bean);

	public ShipManagersResultBean getList();

	public ShipManagersResultBean edit(int id);

	public ShipManagersResultBean delete(int id);

	public ShipManagersResultBean update(ShipManagersBean bean);

}
