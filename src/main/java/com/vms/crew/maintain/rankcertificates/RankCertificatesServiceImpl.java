package com.vms.crew.maintain.rankcertificates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RankCertificatesServiceImpl implements RankCertificatesService{

	@Autowired
	RankCertificatesDao RankCertificatesDao;
	
	@Override
	public RankCertificatesResultBean save(List<RankCertificatesBean> selectedCertificates) {
		// TODO Auto-generated method stub
		return RankCertificatesDao.save(selectedCertificates);
	}

	@Override
	public RankCertificatesResultBean getList() {
		// TODO Auto-generated method stub
		return RankCertificatesDao.getList();
	}

	@Override
	public RankCertificatesResultBean getsavelist() {
		// TODO Auto-generated method stub
		return RankCertificatesDao.getsavelist();
	}
	@Override
	public List<RankCertificatesBean> getrank() {
		return RankCertificatesDao.getrank();
	}
}
