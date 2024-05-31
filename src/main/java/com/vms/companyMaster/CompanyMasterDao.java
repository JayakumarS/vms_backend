package com.vms.companyMaster;


public interface CompanyMasterDao {

	
	CompanyMasterResultBean save(CompanyMasterBean bean) throws Exception;

	CompanyMasterResultBean getCompanyList() throws Exception;
}
