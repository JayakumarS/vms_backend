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
	public VesselinsuranceResultBean getListpandi() {
		// TODO Auto-generated method stub
		return VesselinsuranceDao.getListpandi();
	}
	
	@Override
	public VesselinsuranceResultBean getListfdandd() {
		// TODO Auto-generated method stub
		return VesselinsuranceDao.getListfdandd();
	}


	@Override
	public VesselinsuranceResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return VesselinsuranceDao.edit(id);
	}

	@Override
	public VesselinsuranceResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return VesselinsuranceDao.delete(id);
	}

	@Override
	public VesselinsuranceResultBean update(VesselinsuranceBean bean) {
		// TODO Auto-generated method stub
		return VesselinsuranceDao.update(bean);
	}

}
