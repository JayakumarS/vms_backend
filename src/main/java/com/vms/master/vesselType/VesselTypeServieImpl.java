package com.vms.master.vesselType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VesselTypeServieImpl implements VesselTypeService{
	
	@Autowired
	VesselTypeDao vesselTypeDao;
	
	@Override
	public VesselTypeResultBean save(VesselTypeBean bean) {
		// TODO Auto-generated method stub
		return vesselTypeDao.save(bean);
	}

	@Override
	public VesselTypeResultBean getList() {
		// TODO Auto-generated method stub
		return vesselTypeDao.getList();
	}

	@Override
	public VesselTypeResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return vesselTypeDao.edit(id);
	}

	@Override
	public VesselTypeResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return vesselTypeDao.delete(id);
	}

	@Override
	public VesselTypeResultBean update(VesselTypeBean bean) {
		// TODO Auto-generated method stub
		return vesselTypeDao.update(bean);
	}

}
