package com.vms.vessels.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class FleetServiceImpl implements FleetService{

	@Autowired
	FleetDao FleetDao;
	
	@Override
	public FleetResultBean save(FleetBean bean) {
		// TODO Auto-generated method stub
		return FleetDao.save(bean);
	}

	@Override
	public FleetResultBean getList() {
		// TODO Auto-generated method stub
		return FleetDao.getList();
	}

	@Override
	public FleetResultBean edit(String id) {
		// TODO Auto-generated method stub
		return FleetDao.edit(id);
	}

	@Override
	public FleetResultBean delete(String id) {
		// TODO Auto-generated method stub
		return FleetDao.delete(id);
	}

	@Override
	public FleetResultBean update(FleetBean bean) {
		// TODO Auto-generated method stub
		return FleetDao.update(bean);
	}

}
