package com.vms.master.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.master.vesselType.VesselTypeBean;
import com.vms.master.vesselType.VesselTypeResultBean;


@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	CountryDao countryDao;
	
	@Override
	public CountryResultBean saveCountry(CountryBean bean) {
		// TODO Auto-generated method stub
		return countryDao.saveCountry(bean);
	}
	
	@Override
	public CountryResultBean listCountry() {
		// TODO Auto-generated method stub
		return countryDao.listCountry();
	}
	
	@Override
	public CountryResultBean editCountry(String id) {
		// TODO Auto-generated method stub
		return countryDao.editCountry(id);
	}
	

	@Override
	public CountryResultBean deleteCountry(String id) {
		// TODO Auto-generated method stub
		return countryDao.deleteCountry(id);
	}

	@Override
	public CountryResultBean updateCountry(CountryBean bean) {
		// TODO Auto-generated method stub
		return countryDao.updateCountry(bean);
	
	}
}
