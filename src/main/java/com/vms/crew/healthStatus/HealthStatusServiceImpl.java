package com.vms.crew.healthStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthStatusServiceImpl implements HealthStatusService {
	@Autowired
	HealthStatusDao HealthStatusDao;
	
	@Override
	public HealthStatusResultBean save(HealthStatusBean bean) {
		// TODO Auto-generated method stub
		return HealthStatusDao.save(bean);
	}

	@Override
	public HealthStatusResultBean getList() {
		// TODO Auto-generated method stub
		return HealthStatusDao.getList();
	}

	@Override
	public HealthStatusResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return HealthStatusDao.edit(id);
	}

	@Override
	public HealthStatusResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return HealthStatusDao.delete(id);
	}

	@Override
	public HealthStatusResultBean update(HealthStatusBean bean) {
		// TODO Auto-generated method stub
		return HealthStatusDao.update(bean);
	}
}
