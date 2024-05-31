package com.vms.formProperty;

import com.vms.core.util.CustomException;

public interface FormPropertyDao {
	public FormPropertyResultBean getFormProperty(String userId) throws CustomException;
	
}
