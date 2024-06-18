package com.vms.common.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	AgentDao AgentDao;
	
	@Override
	public AgentResultBean save(AgentBean bean) {
		// TODO Auto-generated method stub
		return AgentDao.save(bean);
	}

	@Override
	public AgentResultBean getList() {
		// TODO Auto-generated method stub
		return AgentDao.getList();
	}

	@Override
	public AgentResultBean edit(String id) {
		// TODO Auto-generated method stub
		return AgentDao.edit(id);
	}

	@Override
	public AgentResultBean delete(String id) {
		// TODO Auto-generated method stub
		return AgentDao.delete(id);
	}

	@Override
	public AgentResultBean update(AgentBean bean) {
		// TODO Auto-generated method stub
		return AgentDao.update(bean);
	}
	
}
