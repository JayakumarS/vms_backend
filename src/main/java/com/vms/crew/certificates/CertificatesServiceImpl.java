package com.vms.crew.certificates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CertificatesServiceImpl implements CertificatesService {
	@Autowired
	CertificatesDao CertificatesDao;
	
	@Override
	public CertificatesResultBean save(CertificatesBean bean) {
		// TODO Auto-generated method stub
		return CertificatesDao.save(bean);
	}

	@Override
	public CertificatesResultBean getList() {
		// TODO Auto-generated method stub
		return CertificatesDao.getList();
	}

	@Override
	public CertificatesResultBean edit(String id) {
		// TODO Auto-generated method stub
		return CertificatesDao.edit(id);
	}

	@Override
	public CertificatesResultBean delete(String id) {
		// TODO Auto-generated method stub
		return CertificatesDao.delete(id);
	}

	@Override
	public CertificatesResultBean update(CertificatesBean bean) {
		// TODO Auto-generated method stub
		return CertificatesDao.update(bean);
	}
}
