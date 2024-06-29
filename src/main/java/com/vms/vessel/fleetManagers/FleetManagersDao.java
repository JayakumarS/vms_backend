package com.vms.vessel.fleetManagers;

import com.vms.crew.certificates.CertificatesBean;

public interface FleetManagersDao {
	
	public FleetManagersResultBean save(FleetManagersBean bean);
		
	public FleetManagersResultBean getList();

	public FleetManagersResultBean edit(Integer id);

	public FleetManagersResultBean delete(Integer id);

	public FleetManagersResultBean update(FleetManagersBean bean);
	
	FleetManagersBean getSequenceCode();



}
