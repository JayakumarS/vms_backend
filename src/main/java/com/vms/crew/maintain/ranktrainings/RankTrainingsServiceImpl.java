package com.vms.crew.maintain.ranktrainings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankTrainingsServiceImpl implements RankTrainingsService{



	@Autowired
	RankTrainingsDao RankTrainingsDao;
	
	@Override
	public RankTrainingsResultBean save(List<RankTrainingsBean> selectedCertificates) {
		// TODO Auto-generated method stub
		return RankTrainingsDao.save(selectedCertificates);
	}

	@Override
	public RankTrainingsResultBean getList() {
		// TODO Auto-generated method stub
		return RankTrainingsDao.getList();
	}

	@Override
	public RankTrainingsResultBean getsavelist() {
		// TODO Auto-generated method stub
		return RankTrainingsDao.getsavelist();
	}
	@Override
	public List<RankTrainingsBean> getrank() {
		return RankTrainingsDao.getrank();
	}
}
