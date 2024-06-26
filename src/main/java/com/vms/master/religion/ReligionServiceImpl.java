package com.vms.master.religion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReligionServiceImpl implements ReligionService {

	
	@Autowired
	ReligionDao religionDao;
	
	
	
	@Override
	public ReligionResultBean save(ReligionBean bean) {
		
		return religionDao.save(bean);
	}

	@Override
	public ReligionResultBean getList() {
		
		return religionDao.getList();
	}

	@Override
	public ReligionResultBean edit(String id) {
		
		return religionDao. edit(id);
	}

	@Override
	public ReligionResultBean update(ReligionBean bean) {
	
		return religionDao.update(bean);
	}

	@Override
	public ReligionResultBean delete(String id) {
		
		return religionDao. delete(id);
	}

	@Override
	public ReligionBean getSequenceCode() {
		// TODO Auto-generated method stub
		return religionDao.getSequenceCode();
	}

	

}
