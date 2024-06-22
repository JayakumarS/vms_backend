package com.vms.crew.personMaintenance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.vessel.vesselParticular.VesselParticularResultBean;



@Service
public class PersonMaintenanceServiceImpl implements PersonMaintenanceService{
	
	@Autowired
	PersonMaintenanceDao RankWorkingShiftDao;
	
	@Override
	public PersonMaintenanceResultBean save(PersonMaintenanceBean bean) {
		// TODO Auto-generated method stub
		return RankWorkingShiftDao.save(bean);
	}

	@Override
	public PersonMaintenanceResultBean getList() {
		// TODO Auto-generated method stub
		return RankWorkingShiftDao.getList();
	}

	@Override
	public PersonMaintenanceResultBean getDetails(String id) {
		// TODO Auto-generated method stub
		return RankWorkingShiftDao.getDetails(id);
	}

}
