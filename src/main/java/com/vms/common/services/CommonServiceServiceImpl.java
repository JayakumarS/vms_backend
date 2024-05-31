package com.vms.common.services;

import java.util.HashMap;

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

}
