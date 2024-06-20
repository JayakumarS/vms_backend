package com.vms.vessel.vesselParticular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VesselParticularServieImpl implements VesselParticularService{
	
	@Autowired
	VesselParticularDao vesselTypeDao;
	
	@Override
	public VesselParticularResultBean save(VesselParticularBean bean) {
		// TODO Auto-generated method stub
		return vesselTypeDao.save(bean);
	}

	@Override
	public VesselParticularResultBean getList() {
		// TODO Auto-generated method stub
		return vesselTypeDao.getList();
	}

	@Override
	public VesselParticularResultBean edit(String id) {
		// TODO Auto-generated method stub
		return vesselTypeDao.edit(id);
	}

	@Override
	public VesselParticularResultBean delete(String id) {
		// TODO Auto-generated method stub
		return vesselTypeDao.delete(id);
	}

	@Override
	public VesselParticularResultBean update(VesselParticularBean bean) {
		// TODO Auto-generated method stub
		return vesselTypeDao.update(bean);
	}

	@Override
	public String generateCode() {
		// TODO Auto-generated method stub
		return vesselTypeDao.generateCode();
	}

}
