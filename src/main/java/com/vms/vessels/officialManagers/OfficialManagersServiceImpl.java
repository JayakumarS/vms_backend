package com.vms.vessels.officialManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OfficialManagersServiceImpl implements OfficialManagersService {
	@Autowired
	OfficialManagersDao OfficialManagersDao;
	
	@Override
	public OfficialManagersResultBean save(OfficialManagersBean bean) {
		// TODO Auto-generated method stub
		return OfficialManagersDao.save(bean);
	}

	@Override
	public OfficialManagersResultBean getList() {
		// TODO Auto-generated method stub
		return OfficialManagersDao.getList();
	}

	@Override
	public OfficialManagersResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return OfficialManagersDao.edit(id);
	}

	@Override
	public OfficialManagersResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return OfficialManagersDao.delete(id);
	}

	@Override
	public OfficialManagersResultBean update(OfficialManagersBean bean) {
		// TODO Auto-generated method stub
		return OfficialManagersDao.update(bean);
	}
	
	
	
	
}
