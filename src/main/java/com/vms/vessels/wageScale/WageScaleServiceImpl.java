package com.vms.vessels.wageScale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.crew.certificates.CertificatesBean;


@Service
public class WageScaleServiceImpl implements WageScaleService {

	
	@Autowired
	WageScaleDao WageScaleDao;

	@Override
	public WageScaleResultBean save(WageScaleBean bean) {
		// TODO Auto-generated method stub
		return WageScaleDao.save(bean);
	}

	@Override
	public WageScaleResultBean getList() {
		// TODO Auto-generated method stub
		return WageScaleDao.getList();
	}

	@Override
	public WageScaleResultBean edit(int id) {
		// TODO Auto-generated method stub
		return WageScaleDao.edit(id);
	}

	@Override
	public WageScaleResultBean delete(int id) {
		// TODO Auto-generated method stub
		return WageScaleDao.delete(id);
	}

	@Override
	public WageScaleResultBean update(WageScaleBean bean) {
		// TODO Auto-generated method stub
		return WageScaleDao.update(bean);
	}
	
	@Override
	public WageScaleBean getSequenceCode() {
		return WageScaleDao.getSequenceCode();
	}
	
}
