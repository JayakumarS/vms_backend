package com.vms.crew.maintain.interviewsetup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewSetupServiceImpl implements InterviewSetupService {

	@Autowired
	InterviewSetupDao  interviewSetupDao;
	
	@Override
	public InterviewSetupResultBean save(InterviewSetupBean bean) {
		// TODO Auto-generated method stub
		return interviewSetupDao.save(bean);
	}

	@Override
	public InterviewSetupResultBean getList() {
		// TODO Auto-generated method stub
		return interviewSetupDao.getList();
	}

	@Override
	public InterviewSetupResultBean edit(String id) {
		// TODO Auto-generated method stub
		return interviewSetupDao.edit(id);
	}

	@Override
	public InterviewSetupResultBean update(InterviewSetupBean bean) {
		// TODO Auto-generated method stub
		return interviewSetupDao.update(bean);
	}

	@Override
	public InterviewSetupResultBean delete(String id) {
		// TODO Auto-generated method stub
		return interviewSetupDao.delete(id);
	}

	@Override
	public List<InterviewSetupBean> getRankMasters() {
		// TODO Auto-generated method stub
		return interviewSetupDao.getRankMasters();
	}

	

	
}
