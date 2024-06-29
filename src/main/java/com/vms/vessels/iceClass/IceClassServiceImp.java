package com.vms.vessels.iceClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class IceClassServiceImp implements IceClassService {
	
	@Autowired
	IceClassDao iceClassDao;
	

	@Override
	public IceClassBean getSequenceCode() {
		// TODO Auto-generated method stub
		return iceClassDao.getSequenceCode();
	}

	@Override
	public IceClassResultBean save(IceClassBean bean) {
		// TODO Auto-generated method stub
		return iceClassDao.save(bean);
	}

	@Override
	public IceClassResultBean getList() {
		// TODO Auto-generated method stub
		return iceClassDao.getList();
	}

	@Override
	public IceClassResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return iceClassDao.edit(id);
	}

	@Override
	public IceClassResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return iceClassDao.delete(id);
	}

	@Override
	public IceClassResultBean update(IceClassBean bean) {
		// TODO Auto-generated method stub
		return iceClassDao.update(bean);
	}

}
