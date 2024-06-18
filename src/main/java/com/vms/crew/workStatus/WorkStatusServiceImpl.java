package com.vms.crew.workStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class WorkStatusServiceImpl implements WorkStatusService {
	@Autowired
	WorkStatusDao WorkStatusDao;
	
	@Override
	public WorkStatusResultBean save(WorkStatusBean bean) {
		// TODO Auto-generated method stub
		return WorkStatusDao.save(bean);
	}

	@Override
	public WorkStatusResultBean getList() {
		// TODO Auto-generated method stub
		return WorkStatusDao.getList();
	}

	@Override
	public WorkStatusResultBean edit(String id) {
		// TODO Auto-generated method stub
		return WorkStatusDao.edit(id);
	}

	@Override
	public WorkStatusResultBean delete(String id) {
		// TODO Auto-generated method stub
		return WorkStatusDao.delete(id);
	}

	@Override
	public WorkStatusResultBean update(WorkStatusBean bean) {
		// TODO Auto-generated method stub
		return WorkStatusDao.update(bean);
	}
}
