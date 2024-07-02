package com.vms.supplies.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
	SupplierDao supplierDao;
	
	@Override
	public SupplierResultBean save(SupplierBean bean) {
		// TODO Auto-generated method stub
		return supplierDao.save(bean);
	}
	
	@Override
	public SupplierResultBean list() {
		// TODO Auto-generated method stub
		return supplierDao.list();
	}
	
	@Override
	public SupplierResultBean edit(String id) {
		// TODO Auto-generated method stub
		return supplierDao.edit(id);
	}
	

	@Override
	public SupplierResultBean delete(String id) {
		// TODO Auto-generated method stub
		return supplierDao.delete(id);
	}

	@Override
	public SupplierResultBean update(SupplierBean bean) {
		// TODO Auto-generated method stub
		return supplierDao.update(bean);
	
	}

	@Override
	public String generateCode() {
		// TODO Auto-generated method stub
	   return supplierDao.generateCode();
	}

}
