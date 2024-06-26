package com.vms.master.bloodgroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodGroupServiceImpl implements BloodGroupService {

	@Autowired
	BloodGroupDao bloodGroupDao;
	
	@Override
	public BloodGroupResultBean delete(String id) {
		
		return bloodGroupDao.delete(id) ;
	}

	@Override
	public BloodGroupResultBean update(BloodGroupBean bean) {
		
		return bloodGroupDao. update(bean);
	}

	@Override
	public BloodGroupResultBean edit(String id) {
		
		return bloodGroupDao.edit(id);
	}

	@Override
	public BloodGroupResultBean getList() {
		
		return bloodGroupDao.getList();
	}

	@Override
	public BloodGroupResultBean save(BloodGroupBean bean) {
		
		return bloodGroupDao.save(bean);
	}

	@Override
	public BloodGroupBean getSequenceCode() {
		// TODO Auto-generated method stub
		return bloodGroupDao.getSequenceCode();
	}

	

}

