package com.vms.crew.maintainRank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MaintainRankServiceImpl implements MaintainRankService{

	@Autowired
	MaintainRankDao MaintainRankDao;
	
	@Override
	public MaintainRankResultBean save(MaintainRankBean bean) {
		// TODO Auto-generated method stub
		return MaintainRankDao.save(bean);
	}

	@Override
	public MaintainRankResultBean getList() {
		// TODO Auto-generated method stub
		return MaintainRankDao.getList();
	}

	@Override
	public MaintainRankResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return MaintainRankDao.edit(id);
	}

	@Override
	public MaintainRankResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return MaintainRankDao.delete(id);
	}

	@Override
	public MaintainRankResultBean update(MaintainRankBean bean) {
		// TODO Auto-generated method stub
		return MaintainRankDao.update(bean);
	}
	

}
