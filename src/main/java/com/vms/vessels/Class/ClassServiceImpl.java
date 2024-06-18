package com.vms.vessels.Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClassServiceImpl implements ClassService{

	
	@Autowired
	ClassDao ClassDao;
	
	@Override
	public ClassResultBean save(ClassBean bean) {
		// TODO Auto-generated method stub
		return ClassDao.save(bean);
	}

	@Override
	public ClassResultBean getList() {
		// TODO Auto-generated method stub
		return ClassDao.getList();
	}

	@Override
	public ClassResultBean edit(String id) {
		// TODO Auto-generated method stub
		return ClassDao.edit(id);
	}

	@Override
	public ClassResultBean delete(String id) {
		// TODO Auto-generated method stub
		return ClassDao.delete(id);
	}

	@Override
	public ClassResultBean update(ClassBean bean) {
		// TODO Auto-generated method stub
		return ClassDao.update(bean);
	}
}
