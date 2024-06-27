package com.vms.crew.personMaintenance;

public interface PersonMaintenanceService {
	
	public PersonMaintenanceResultBean save(PersonMaintenanceBean bean);

	public PersonMaintenanceResultBean getList();

	public PersonMaintenanceResultBean getDetails(String id);

	public PersonMaintenanceResultBean delete(String id);

	public PersonMaintenanceResultBean edit(String id);

	public PersonMaintenanceResultBean update(PersonMaintenanceBean bean);

	public PersonMaintenanceResultBean getApplicantList();

	public String generateCode();

	public PersonMaintenanceResultBean getCheckListDtl(Integer id);

}
