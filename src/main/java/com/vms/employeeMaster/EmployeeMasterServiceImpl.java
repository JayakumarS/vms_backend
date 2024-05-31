package com.vms.employeeMaster;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.core.util.CustomException;
import com.vms.usermanagement.User;
import com.vms.usermanagement.UserDetailsImpl;

@Service
public class EmployeeMasterServiceImpl implements EmployeeMasterService{
	@Autowired
	EmployeeMasterDao employeeMasterDao;
	
	@Override
	public EmployeeMasterResultBean addEmployeeMaster(EmployeeMasterBean employeeMasterBean) throws CustomException {
		// TODO Auto-generated method stub
		return employeeMasterDao.addEmployeeMaster(employeeMasterBean);
	}

	@Override
	public Optional<User> getEmployeeUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDao.getEmployeeUserName(userName);
	}

	@Override
	public EmployeeMasterBean getCompanyLogo() {
		// TODO Auto-generated method stub
		return employeeMasterDao.getCompanyLogo();
	}

	

	
	
}
