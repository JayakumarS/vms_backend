package com.vms.employeeMaster;

import java.util.Optional;

import com.vms.core.util.CustomException;
import com.vms.usermanagement.User;
import com.vms.usermanagement.UserDetailsImpl;

public interface EmployeeMasterDao {
	public EmployeeMasterResultBean addEmployeeMaster(EmployeeMasterBean objEmployee) throws CustomException;
	
	public Optional<User> getEmployeeUserName(String userName) throws CustomException;

	public EmployeeMasterBean getCompanyLogo();


	
}
