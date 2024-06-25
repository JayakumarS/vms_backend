package com.vms.master.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {
	
	@Autowired 
	CurrencyDao currencyDao;
	
	@Override
	public CurrencyResultBean save(CurrencyBean bean) {
		// TODO Auto-generated method stub
		return currencyDao.save(bean);
	}

	@Override
	public CurrencyResultBean getList() {
		// TODO Auto-generated method stub
		return currencyDao.getList();
	}

	@Override
	public CurrencyResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return currencyDao.edit(id);
	}

	@Override
	public CurrencyResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return currencyDao.delete(id);
	}

	@Override
	public CurrencyResultBean update(CurrencyBean bean) {
		// TODO Auto-generated method stub
		return currencyDao.update(bean);
	}

}
