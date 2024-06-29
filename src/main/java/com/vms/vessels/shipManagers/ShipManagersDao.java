package com.vms.vessels.shipManagers;

import com.vms.crew.certificates.CertificatesBean;

public interface ShipManagersDao {

	public ShipManagersResultBean save(ShipManagersBean bean);

	public ShipManagersResultBean getList();

	public ShipManagersResultBean edit(int id);

	public ShipManagersResultBean delete(int id);

	public ShipManagersResultBean update(ShipManagersBean bean);
	
	ShipManagersBean getSequenceCode();


}
