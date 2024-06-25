package com.vms.common.Languages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LanguagesServiceImpl implements LanguagesService{

	@Autowired
	LanguagesDao LanguagesDao;
	
	@Override
	public LanguagesResultBean save(LanguagesBean bean) {
		// TODO Auto-generated method stub
		return LanguagesDao.save(bean);
	}

	@Override
	public LanguagesResultBean getList() {
		// TODO Auto-generated method stub
		return LanguagesDao.getList();
	}

	@Override
	public LanguagesResultBean edit(int id) {
		// TODO Auto-generated method stub
		return LanguagesDao.edit(id);
	}

	@Override
	public LanguagesResultBean delete(int id) {
		// TODO Auto-generated method stub
		return LanguagesDao.delete(id);
	}

	@Override
	public LanguagesResultBean update(LanguagesBean bean) {
		// TODO Auto-generated method stub
		return LanguagesDao.update(bean);
	}
}
