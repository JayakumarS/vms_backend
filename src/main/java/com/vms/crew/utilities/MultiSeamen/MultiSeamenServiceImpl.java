package com.vms.crew.utilities.MultiSeamen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiSeamenServiceImpl implements MultiSeamenService{

	@Autowired
	MultiSeamenDao multiSeamenDao;
	
	@Override
	public MultiSeamenResultBean saveMultiSeamen(MultiSeamenBean bean) {
		// TODO Auto-generated method stub
		return multiSeamenDao.saveMultiSeamen(bean);

	}
}
