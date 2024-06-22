package com.vms.crew.personMaintenance;

public interface PersonMaintenanceDao {
	
	public PersonMaintenanceResultBean save(PersonMaintenanceBean bean);

	public PersonMaintenanceResultBean getList();
	
	public PersonMaintenanceResultBean getDetails(String id);


}
