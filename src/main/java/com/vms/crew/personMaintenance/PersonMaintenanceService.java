package com.vms.crew.personMaintenance;

public interface PersonMaintenanceService {
	
	public PersonMaintenanceResultBean save(PersonMaintenanceBean bean);

	public PersonMaintenanceResultBean getList();

}
