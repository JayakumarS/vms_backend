package com.vms.vessel.vesselOwner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class VesselOwnerServiceImpl implements VesselOwnerService{
	@Autowired
	VesselOwnerDao VesselOwnerDao;
	
	@Override
	public VesselOwnerResultBean save(VesselOwnerBean bean) {
		// TODO Auto-generated method stub
		return VesselOwnerDao.save(bean);
	}

	@Override
	public VesselOwnerResultBean getList() {
		// TODO Auto-generated method stub
		return VesselOwnerDao.getList();
	}

	@Override
	public VesselOwnerResultBean edit(String id) {
		// TODO Auto-generated method stub
		return VesselOwnerDao.edit(id);
	}

	@Override
	public VesselOwnerResultBean delete(String id) {
		// TODO Auto-generated method stub
		return VesselOwnerDao.delete(id);
	}

	@Override
	public VesselOwnerResultBean update(VesselOwnerBean bean) {
		// TODO Auto-generated method stub
		return VesselOwnerDao.update(bean);
	}
}
