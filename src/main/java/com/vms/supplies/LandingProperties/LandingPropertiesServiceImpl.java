package com.vms.supplies.LandingProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LandingPropertiesServiceImpl implements LandingPropertiesService{
	
	@Autowired
	LandingPropertiesDao landingPropertiesDao;
	
	@Override
	public LandingPropertiesResultBean save(LandingPropertiesBean bean) {
		// TODO Auto-generated method stub
		return landingPropertiesDao.save(bean);
	}
	
	@Override
	public LandingPropertiesResultBean list() {
		// TODO Auto-generated method stub
		return landingPropertiesDao.list();
	}
	
	@Override
	public LandingPropertiesResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return landingPropertiesDao.edit(id);
	}
	

	@Override
	public LandingPropertiesResultBean delete(String id) {
		// TODO Auto-generated method stub
		return landingPropertiesDao.delete(id);
	}

	@Override
	public LandingPropertiesResultBean update(LandingPropertiesBean bean) {
		// TODO Auto-generated method stub
		return landingPropertiesDao.update(bean);
	
	}

}
