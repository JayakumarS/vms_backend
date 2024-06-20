package com.vms.common.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommonServiceServiceImpl implements CommonServiceService{

	private final RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	CommonServiceDao commonServicesDao;
	
	@Override
	public boolean validateUnique(String tableName, String columnName, String columnValue) {
		return commonServicesDao.validateUnique(tableName,columnName,columnValue);
	}
	
	@Override
	public HashMap<String, Object> forgotPassword(String emailId, String otpForForgotPassword) throws Exception {
		// TODO Auto-generated method stub
		return commonServicesDao.forgotPassword(emailId,otpForForgotPassword);
	}

	@Override
	public List<CommonServiceBean> getFleetList() {
		// TODO Auto-generated method stub
		return commonServicesDao.getFleetList();
	}

	@Override
	public List<CommonServiceBean> getClassList() {
		// TODO Auto-generated method stub
		return commonServicesDao.getClassList();
	}

	@Override
	public List<CommonServiceBean> getVesselType() {
		// TODO Auto-generated method stub
		return commonServicesDao.getVesselType();
	}

	@Override
	public List<CommonServiceBean> getVesselInsurance() {
		// TODO Auto-generated method stub
		return commonServicesDao.getVesselInsurance();
	}

	@Override
	public List<CommonServiceBean> getWageScale() {
		// TODO Auto-generated method stub
		return commonServicesDao.getWageScale();
	}

	@Override
	public List<CommonServiceBean> getPort() {
		// TODO Auto-generated method stub
		return commonServicesDao.getPort();
	}

	@Override
	public List<CommonServiceBean> getCountry() {
		// TODO Auto-generated method stub
		return commonServicesDao.getCountry();
	}
	
	@Override
	public List<CommonServiceBean> getCurrency() {
		// TODO Auto-generated method stub
		return commonServicesDao.getCurrency();
	}
	
	@Override
	public List<CommonServiceBean> getphoneCode() {
		// TODO Auto-generated method stub
		return commonServicesDao.getphoneCode();
	}

	@Override
	public List<CommonServiceBean> getVesselOwner() {
		// TODO Auto-generated method stub
		return commonServicesDao.getVesselOwner();
	}

	@Override
	public List<CommonServiceBean> getOfficialManagers() {
		// TODO Auto-generated method stub
		return commonServicesDao.getOfficialManagers();
	}

	@Override
	public List<CommonServiceBean> getShipManagers() {
		// TODO Auto-generated method stub
		return commonServicesDao.getShipManagers();
	}

}
