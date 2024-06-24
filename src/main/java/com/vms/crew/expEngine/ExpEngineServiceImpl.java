package com.vms.crew.expEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExpEngineServiceImpl implements ExpEngineService{
	
	@Autowired
	ExpEngineDao ExpEngineDao;
	
	@Override
	public ExpEngineResultBean save(ExpEngineBean bean) {
		// TODO Auto-generated method stub
		return ExpEngineDao.save(bean);
	}

	@Override
	public ExpEngineResultBean getList() {
		// TODO Auto-generated method stub
		return ExpEngineDao.getList();
	}

	@Override
	public ExpEngineResultBean edit(int id) {
		// TODO Auto-generated method stub
		return ExpEngineDao.edit(id);
	}

	@Override
	public ExpEngineResultBean delete(int id) {
		// TODO Auto-generated method stub
		return ExpEngineDao.delete(id);
	}

	@Override
	public ExpEngineResultBean update(ExpEngineBean bean) {
		// TODO Auto-generated method stub
		return ExpEngineDao.update(bean);
	}

}
