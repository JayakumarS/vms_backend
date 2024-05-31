package com.vms.common.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.vms.common.Email;
import com.vms.common.EmailService;

@Repository
public class CommonServiceDaoImpl implements CommonServiceDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	@Autowired
	EmailService emailService;
	
	
	@Override
	public boolean validateUnique(String tableName, String columnName, String columnValue) {
		boolean count =  jdbcTemplate.queryForObject(CommonServiceQueryUtil.VALIDATE_UNIQUE,new Object[] { tableName,columnName,columnValue }, Boolean.class);
		return count;
	}


	@Override
	public HashMap<String, Object> forgotPassword(String emailId, String otpForForgotPassword) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	



}
