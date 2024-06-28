package com.vms.vessels.bunkerTanks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service

public class BunkerTankServiceImpl implements BunkerTankService {
	@Autowired
	BunkerTankDao BunkerTankDao;
	
	@Override
	public BunkerTankResultBean save(BunkerTankBean bean) {
		// TODO Auto-generated method stub
		return BunkerTankDao.save(bean);
	}

	@Override
	public BunkerTankResultBean getList() {
		// TODO Auto-generated method stub
		return BunkerTankDao.getList();
	}

	@Override
	public BunkerTankResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return BunkerTankDao.edit(id);
	}

	@Override
	public BunkerTankResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return BunkerTankDao.delete(id);
	}

	@Override
	public BunkerTankResultBean update(BunkerTankBean bean) {
		// TODO Auto-generated method stub
		return BunkerTankDao.update(bean);
	}
	

}
