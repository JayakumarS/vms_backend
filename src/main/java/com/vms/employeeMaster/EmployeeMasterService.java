package com.vms.employeeMaster;

import java.util.Optional;

import com.vms.usermanagement.User;
import com.vms.usermanagement.UserDetailsImpl;

public interface EmployeeMasterService {

	EmployeeMasterResultBean addEmployeeMaster(EmployeeMasterBean employeeMasterBean) throws Exception;
	
	Optional<User> getEmployeeUserName(String userName) throws Exception;

	EmployeeMasterBean getCompanyLogo();

	

	
}
