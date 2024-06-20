package com.vms.crew.maintain.rankcertificates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RankCertificatesServiceImpl implements RankCertificatesService{

	@Autowired
	RankCertificatesDao RankCertificatesDao;
	
	@Override
	public RankCertificatesResultBean save(RankCertificatesBean bean) {
		// TODO Auto-generated method stub
		return RankCertificatesDao.save(bean);
	}

	@Override
	public RankCertificatesResultBean getList() {
		// TODO Auto-generated method stub
		return RankCertificatesDao.getList();
	}

}
