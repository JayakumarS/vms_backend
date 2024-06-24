package com.vms.crew.payTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PayTypesServiceImpl implements PayTypesService {
	
	@Autowired
	PayTypesDao PayTypesDao;
	
	@Override
	public PayTypesResultBean save(PayTypesBean bean) {
		// TODO Auto-generated method stub
		return PayTypesDao.save(bean);
	}

	@Override
	public PayTypesResultBean getList() {
		// TODO Auto-generated method stub
		return PayTypesDao.getList();
	}

	@Override
	public PayTypesResultBean edit(int id) {
		// TODO Auto-generated method stub
		return PayTypesDao.edit(id);
	}

	@Override
	public PayTypesResultBean delete(int id) {
		// TODO Auto-generated method stub
		return PayTypesDao.delete(id);
	}

	@Override
	public PayTypesResultBean update(PayTypesBean bean) {
		// TODO Auto-generated method stub
		return PayTypesDao.update(bean);
	}
	

}
