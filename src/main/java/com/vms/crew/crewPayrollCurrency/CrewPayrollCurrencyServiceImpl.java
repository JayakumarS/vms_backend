package com.vms.crew.crewPayrollCurrency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CrewPayrollCurrencyServiceImpl implements CrewPayrollCurrencyService {
	
	@Autowired
	CrewPayrollCurrencyDao CrewPayrollCurrencyDao;
	
	@Override
   public CrewPayrollCurrencyResultBean save(CrewPayrollCurrencyBean bean) {
		// TODO Auto-generated method stub
	return CrewPayrollCurrencyDao.save(bean);
	}

	@Override
	public CrewPayrollCurrencyResultBean getList() {
		// TODO Auto-generated method stub
		return CrewPayrollCurrencyDao.getList();
	}

	@Override
	public CrewPayrollCurrencyResultBean edit(int id) {
		// TODO Auto-generated method stub
		return CrewPayrollCurrencyDao.edit(id);
	}

	@Override
	public CrewPayrollCurrencyResultBean delete(int id) {
		// TODO Auto-generated method stub
		return CrewPayrollCurrencyDao.delete(id);
	}
	
	@Override
	public CrewPayrollCurrencyResultBean getCountry(String id) {
		// TODO Auto-generated method stub
		return CrewPayrollCurrencyDao.getCountry(id);
	}

	@Override
	public CrewPayrollCurrencyResultBean update(CrewPayrollCurrencyBean bean) {
		// TODO Auto-generated method stub
		return CrewPayrollCurrencyDao.update(bean);
	}

}
