package com.vms.companyMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CompanyMasterServiceImpl implements CompanyMasterService {
	@Autowired
	CompanyMasterDao companyMasterDao;
	
	@Override
	public CompanyMasterResultBean save(CompanyMasterBean bean) throws Exception {
		return companyMasterDao.save(bean);
	}

	@Override
	public CompanyMasterResultBean getCompanyList() throws Exception {
		// TODO Auto-generated method stub
		return companyMasterDao.getCompanyList();
	}

}
