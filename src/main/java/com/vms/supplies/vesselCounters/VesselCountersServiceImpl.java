package com.vms.supplies.vesselCounters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class VesselCountersServiceImpl implements VesselCountersService{
	
	@Autowired
	VesselCountersDao vesselCountersDao;
	
	@Override
	public VesselCountersResultBean save(VesselCountersBean bean) {
		// TODO Auto-generated method stub
		return vesselCountersDao.save(bean);
	}

	@Override
	public VesselCountersResultBean getList() {
		// TODO Auto-generated method stub
		return vesselCountersDao.getList();
	}

	@Override
	public VesselCountersResultBean delete(String id) {
		// TODO Auto-generated method stub
		return vesselCountersDao.delete(id);
	}

	@Override
	public VesselCountersResultBean edit(String id) {
		// TODO Auto-generated method stub
		return vesselCountersDao.edit(id);
	}

	@Override
	public VesselCountersResultBean update(VesselCountersBean bean) {
		// TODO Auto-generated method stub
		return vesselCountersDao.update(bean);
	}

	@Override
	public String generateCode() {
		// TODO Auto-generated method stub
		return vesselCountersDao.generateCode();
	}

}
