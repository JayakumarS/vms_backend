package com.vms.crew.maintain.rankmedicals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RankMedicalServiceImpl implements RankMedicalService{

	@Autowired
	RankMedicalDao RankMedicalDao;
	
	
	@Override
	public RankMedicalResultBean save(List<RankMedicalBean> selectedCertificates) {
		// TODO Auto-generated method stub
		return RankMedicalDao.save(selectedCertificates);
	}

	@Override
	public RankMedicalResultBean getList() {
		// TODO Auto-generated method stub
		return RankMedicalDao.getList();
	}

	@Override
	public RankMedicalResultBean getsavelist() {
		// TODO Auto-generated method stub
		return RankMedicalDao.getsavelist();
	}
	@Override
	public List<RankMedicalBean> getrank() {
		return RankMedicalDao.getrank();
	}
}
