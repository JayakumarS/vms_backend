package com.vms.vessel.fleetManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.crew.certificates.CertificatesBean;



@Service
public class FleetManagersServiceImpl  implements FleetManagersService{
	@Autowired
	FleetManagersDao FleetManagersDao;
	
	@Override
	public FleetManagersResultBean save(FleetManagersBean bean) {
		// TODO Auto-generated method stub
		return FleetManagersDao.save(bean);
		
	}
	
	
	@Override
	public FleetManagersResultBean getList() {
		// TODO Auto-generated method stub
		return FleetManagersDao.getList();
	}

	@Override
	public FleetManagersResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return FleetManagersDao.edit(id);
	}

	@Override
	public FleetManagersResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return FleetManagersDao.delete(id);
	}

	@Override
	public FleetManagersResultBean update(FleetManagersBean bean) {
		// TODO Auto-generated method stub
		return FleetManagersDao.update(bean);
	}
	
	@Override
	public FleetManagersBean getSequenceCode() {
		return FleetManagersDao.getSequenceCode();
	}
}
