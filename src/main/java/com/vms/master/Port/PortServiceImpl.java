package com.vms.master.Port;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PortServiceImpl implements PortService{
	
	@Autowired
	PortDao PortDao;
	
	@Override
	public PortResultBean savePort(PortBean bean) {
		// TODO Auto-generated method stub
		return PortDao.savePort(bean);
	}
	
	@Override
	public PortResultBean listPort() {
		// TODO Auto-generated method stub
		return PortDao.listPort();
	}
	
	@Override
	public PortResultBean editPort(String id) {
		// TODO Auto-generated method stub
		return PortDao.editPort(id);
	}
	

	@Override
	public PortResultBean deletePort(String id) {
		// TODO Auto-generated method stub
		return PortDao.deletePort(id);
	}

	@Override
	public PortResultBean updatePort(PortBean bean) {
		// TODO Auto-generated method stub
		return PortDao.updatePort(bean);
	
	}

}
