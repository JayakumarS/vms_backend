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


	@Override
	public ApplicationsResultBean certificateList(int rankCode) {
		// TODO Auto-generated method stub
		return ApplicationsDao.certificateList(rankCode);
	}

	@Override
	public ApplicationsResultBean mcertificateList(int rankCode) {
		// TODO Auto-generated method stub
		return ApplicationsDao.mcertificateList(rankCode);
	}

	@Override
	public ApplicationsResultBean saveCertificate(ApplicationsBean bean) {
		// TODO Auto-generated method stub
		return ApplicationsDao.saveCertificate(bean);
	}
	
}
