package com.vms.crew.rankGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RankGroupServiceImpl implements RankGroupService{

	
	@Autowired
	RankGroupDao RankGroupDao;
	
	@Override
	public RankGroupResultBean save(RankGroupBean bean) {
		// TODO Auto-generated method stub
		return RankGroupDao.save(bean);
	}

	@Override
	public RankGroupResultBean getList() {
		// TODO Auto-generated method stub
		return RankGroupDao.getList();
	}

	@Override
	public RankGroupResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return RankGroupDao.edit(id);
	}

	@Override
	public RankGroupResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return RankGroupDao.delete(id);
	}

	@Override
	public RankGroupResultBean update(RankGroupBean bean) {
		// TODO Auto-generated method stub
		return RankGroupDao.update(bean);
	}

}
