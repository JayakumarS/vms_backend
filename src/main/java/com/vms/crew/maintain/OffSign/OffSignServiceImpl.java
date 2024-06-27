package com.vms.crew.maintain.OffSign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.master.Country.CountryBean;

@Service
public class OffSignServiceImpl implements OffSignService{

	@Autowired
	OffSignDao offSignDao;
	
	@Override
	public OffSignResultBean saveOffSign(OffSignBean bean) {
		// TODO Auto-generated method stub
		return offSignDao.saveOffSign(bean);

	}
	
	@Override
	public OffSignResultBean listOffSign() {
		// TODO Auto-generated method stub
		return offSignDao.listOffSign();
	}
	
	@Override
	public OffSignResultBean editOffSign(Integer id) {
		// TODO Auto-generated method stub
		return offSignDao.editOffSign(id);
	}
	

	@Override
	public OffSignResultBean deleteOffSign(Integer id) {
		// TODO Auto-generated method stub
		return offSignDao.deleteOffSign(id);
	}

	@Override
	public OffSignResultBean updateOffSign(OffSignBean bean) {
		// TODO Auto-generated method stub
		return offSignDao.updateOffSign(bean);
	
	}
}
