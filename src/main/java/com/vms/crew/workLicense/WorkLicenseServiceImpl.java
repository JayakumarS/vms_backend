package com.vms.crew.workLicense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class WorkLicenseServiceImpl implements WorkLicenseService{
	@Autowired
	WorkLicenseDao WorkLicenseDao;
	
	@Override
	public WorkLicenseResultBean save(WorkLicenseBean bean) {
		// TODO Auto-generated method stub
		return WorkLicenseDao.save(bean);
	}

	@Override
	public WorkLicenseResultBean getList() {
		// TODO Auto-generated method stub
		return WorkLicenseDao.getList();
	}

	@Override
	public WorkLicenseResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return WorkLicenseDao.edit(id);
	}

	@Override
	public WorkLicenseResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return WorkLicenseDao.delete(id);
	}

	@Override
	public WorkLicenseResultBean update(WorkLicenseBean bean) {
		// TODO Auto-generated method stub
		return WorkLicenseDao.update(bean);
	}
}
