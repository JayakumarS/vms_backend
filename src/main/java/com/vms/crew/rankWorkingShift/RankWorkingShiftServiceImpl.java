package com.vms.crew.rankWorkingShift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RankWorkingShiftServiceImpl implements RankWorkingShiftService{
	
	@Autowired
	RankWorkingShiftDao RankWorkingShiftDao;
	
	@Override
	public RankWorkingShiftResultBean save(RankWorkingShiftBean bean) {
		// TODO Auto-generated method stub
		return RankWorkingShiftDao.save(bean);
	}
	


	@Override
	public RankWorkingShiftResultBean getList() {
		// TODO Auto-generated method stub
		return RankWorkingShiftDao.getList();
	}

	@Override
	public RankWorkingShiftResultBean edit(int id) {
		// TODO Auto-generated method stub
		return RankWorkingShiftDao.edit(id);
	}

	@Override
	public RankWorkingShiftResultBean delete(int id) {
		// TODO Auto-generated method stub
		return RankWorkingShiftDao.delete(id);
	}

	@Override
	public RankWorkingShiftResultBean update(RankWorkingShiftBean bean) {
		// TODO Auto-generated method stub
		return RankWorkingShiftDao.update(bean);
	}
	

}
