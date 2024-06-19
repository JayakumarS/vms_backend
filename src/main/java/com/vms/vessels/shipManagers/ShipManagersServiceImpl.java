package com.vms.vessels.shipManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ShipManagersServiceImpl implements ShipManagersService {
	@Autowired
	ShipManagersDao shipManagersDao;
	
	@Override
	public ShipManagersResultBean save(ShipManagersBean bean) {
		// TODO Auto-generated method stub
		return shipManagersDao.save(bean);
	}

	@Override
	public ShipManagersResultBean getList() {
		// TODO Auto-generated method stub
		return shipManagersDao.getList();
	}

	@Override
	public ShipManagersResultBean edit(String id) {
		// TODO Auto-generated method stub
		return shipManagersDao.edit(id);
	}

	@Override
	public ShipManagersResultBean delete(String id) {
		// TODO Auto-generated method stub
		return shipManagersDao.delete(id);
	}

	@Override
	public ShipManagersResultBean update(ShipManagersBean bean) {
		// TODO Auto-generated method stub
		return shipManagersDao.update(bean);
	}

}
