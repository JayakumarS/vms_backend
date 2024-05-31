package com.vms.formProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.core.util.CustomException;

@Service
public class FormPropertyServiceImpl implements FormPropertyService{
	@Autowired
	FormPropertyDao formPropertyDao;
	
	@Override
	public FormPropertyResultBean getFormProperty(String userId) throws CustomException {
		// TODO Auto-generated method stub
		return formPropertyDao.getFormProperty(userId);
	}

}
