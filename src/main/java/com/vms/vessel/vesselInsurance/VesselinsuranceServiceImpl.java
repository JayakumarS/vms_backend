package com.vms.vessel.vesselInsurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VesselinsuranceServiceImpl implements VesselinsuranceService{
	@Autowired
	VesselinsuranceDao VesselinsuranceDao;
	
	@Override
	public VesselinsuranceResultBean save(VesselinsuranceBean bean) {
		// TODO Auto-generated method stub
		return VesselinsuranceDao.save(bean);
	}

	@Override
	public VesselinsuranceResultBean getList() {
		// TODO Auto-generated method stub
		return VesselinsuranceDao.getList();
	}

	@Override
	public VesselinsuranceResultBean edit(String id) {
		// TODO Auto-generated method stub
		return VesselinsuranceDao.edit(id);
	}

	@Override
	public VesselinsuranceResultBean delete(String id) {
		// TODO Auto-generated method stub
		return VesselinsuranceDao.delete(id);
	}

	@Override
	public VesselinsuranceResultBean update(VesselinsuranceBean bean) {
		// TODO Auto-generated method stub
		return VesselinsuranceDao.update(bean);
	}

}
