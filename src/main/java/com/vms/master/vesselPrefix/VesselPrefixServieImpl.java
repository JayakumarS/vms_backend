package com.vms.master.vesselPrefix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VesselPrefixServieImpl implements VesselPrefixService{
	
	@Autowired
	VesselPrefixDao vesselTypeDao;
	
	@Override
	public VesselPrefixResultBean save(VesselPrefixBean bean) {
		// TODO Auto-generated method stub
		return vesselTypeDao.save(bean);
	}

	@Override
	public VesselPrefixResultBean getList() {
		// TODO Auto-generated method stub
		return vesselTypeDao.getList();
	}

	@Override
	public VesselPrefixResultBean edit(String id) {
		// TODO Auto-generated method stub
		return vesselTypeDao.edit(id);
	}

	@Override
	public VesselPrefixResultBean delete(String id) {
		// TODO Auto-generated method stub
		return vesselTypeDao.delete(id);
	}

	@Override
	public VesselPrefixResultBean update(VesselPrefixBean bean) {
		// TODO Auto-generated method stub
		return vesselTypeDao.update(bean);
	}

}
