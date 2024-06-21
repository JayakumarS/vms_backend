package com.vms.crew.applications;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.crew.maintainRank.MaintainRankBean;
import com.vms.crew.maintainRank.MaintainRankResultBean;


@Service
public class ApplicationsServiceImpl implements ApplicationsService{
	
	@Autowired
	ApplicationsDao ApplicationsDao;
	
	@Override
	public List<ApplicationsBean> getlicence() {
		return ApplicationsDao.getlicence();
	}
	
	
	@Override
	public List<ApplicationsBean> getvessel() {
		return ApplicationsDao.getvessel();
	}
	
	
	@Override
	public List<ApplicationsBean> getrank() {
		return ApplicationsDao.getrank();
	}
	
	@Override
	public List<ApplicationsBean> getnationality() {
		return ApplicationsDao.getnationality();
	}
	
	@Override
	public List<ApplicationsBean> getagent() {
		return ApplicationsDao.getagent();
	}
	
	@Override
	public ApplicationsResultBean save(ApplicationsBean bean) {
		// TODO Auto-generated method stub
		return ApplicationsDao.save(bean);
	}

	
	@Override
	public ApplicationsResultBean getList() {
		// TODO Auto-generated method stub
		return ApplicationsDao.getList();
	}
	
	@Override
	public ApplicationsResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return ApplicationsDao.edit(id);
	}
	
	@Override
	public ApplicationsResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return ApplicationsDao.delete(id);
	}
	
	@Override
	public ApplicationsResultBean update(ApplicationsBean bean) {
		// TODO Auto-generated method stub
		return ApplicationsDao.update(bean);
	}
	
}
