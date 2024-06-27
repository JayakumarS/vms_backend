package com.vms.crew.maintain.Medicals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MedicalServiceImpl implements MedicalService {
	
	@Autowired
	MedicalDao MedicalDao;
	
	@Override
	public MedicalResultBean save(MedicalBean bean) {
		// TODO Auto-generated method stub
		return MedicalDao.save(bean);
	}

	@Override
	public MedicalResultBean getList() {
		// TODO Auto-generated method stub
		return MedicalDao.getList();
	}

	@Override
	public MedicalResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return MedicalDao.edit(id);
	}

	@Override
	public MedicalResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return MedicalDao.delete(id);
	}

	@Override
	public MedicalResultBean update(MedicalBean bean) {
		// TODO Auto-generated method stub
		return MedicalDao.update(bean);
	}
	


}
