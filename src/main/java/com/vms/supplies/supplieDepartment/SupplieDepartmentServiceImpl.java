package com.vms.supplies.supplieDepartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SupplieDepartmentServiceImpl implements SupplieDepartmentService{
	
	@Autowired
	SupplieDepartmentDao personMaintenanceDao;
	
	@Override
	public SupplieDepartmentResultBean save(SupplieDepartmentBean bean) {
		// TODO Auto-generated method stub
		return personMaintenanceDao.save(bean);
	}

	@Override
	public SupplieDepartmentResultBean getList() {
		// TODO Auto-generated method stub
		return personMaintenanceDao.getList();
	}

	@Override
	public SupplieDepartmentResultBean delete(String id) {
		// TODO Auto-generated method stub
		return personMaintenanceDao.delete(id);
	}

	@Override
	public SupplieDepartmentResultBean edit(String id) {
		// TODO Auto-generated method stub
		return personMaintenanceDao.edit(id);
	}

	@Override
	public SupplieDepartmentResultBean update(SupplieDepartmentBean bean) {
		// TODO Auto-generated method stub
		return personMaintenanceDao.update(bean);
	}

	@Override
	public String generateCode() {
		// TODO Auto-generated method stub
		return personMaintenanceDao.generateCode();
	}

}
