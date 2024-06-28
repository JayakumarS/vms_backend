package com.vms.supplies.freightType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class FreightTypeServiceImpl implements FreightTypeService{
	
	@Autowired
	FreightTypeDao FreightTypeDao;
	
	@Override
	public FreightTypeResultBean save(FreightTypeBean bean) {
		// TODO Auto-generated method stub
		return FreightTypeDao.save(bean);
	}

	@Override
	public FreightTypeResultBean getList() {
		// TODO Auto-generated method stub
		return FreightTypeDao.getList();
	}

	@Override
	public FreightTypeResultBean edit(int id) {
		// TODO Auto-generated method stub
		return FreightTypeDao.edit(id);
	}

	@Override
	public FreightTypeResultBean delete(int id) {
		// TODO Auto-generated method stub
		return FreightTypeDao.delete(id);
	}

	@Override
	public FreightTypeResultBean update(FreightTypeBean bean) {
		// TODO Auto-generated method stub
		return FreightTypeDao.update(bean);
	}
	
	
	
	
	

}
