package com.vms.crew.utilities.MultiSeamen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.master.Country.CountryBean;

@Service
public class MultiSeamenServiceImpl implements MultiSeamenService{

	@Autowired
	MultiSeamenDao multiSeamenDao;
	
	@Override
	public MultiSeamenResultBean saveMultiSeamen(MultiSeamenBean bean) {
		// TODO Auto-generated method stub
		return multiSeamenDao.saveMultiSeamen(bean);
	}
	
	@Override
	public MultiSeamenResultBean listMultiSeamen() {
		// TODO Auto-generated method stub
		return multiSeamenDao.listMultiSeamen();
	}
	
	@Override
	public MultiSeamenResultBean editMultiSeamen(Integer id) {
		// TODO Auto-generated method stub
		return multiSeamenDao.editMultiSeamen(id);
	}
	

	@Override
	public MultiSeamenResultBean deleteMultiSeamen(Integer id) {
		// TODO Auto-generated method stub
		return multiSeamenDao.deleteMultiSeamen(id);
	}

	@Override
	public MultiSeamenResultBean updateMultiSeamen(MultiSeamenBean bean) {
		// TODO Auto-generated method stub
		return multiSeamenDao.updateMultiSeamen(bean);
	}
	
	@Override
	public MultiSeamenResultBean checkValid(Integer id) {
		// TODO Auto-generated method stub
		return multiSeamenDao.checkValid(id);
	}
}
