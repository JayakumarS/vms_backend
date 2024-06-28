package com.vms.master.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentDao departmentDao;

	@Override
	public DepartmentResultBean save(DepartmentBean bean) {
		// TODO Auto-generated method stub
		return departmentDao.save(bean);
	}

	@Override
	public DepartmentResultBean getList() {
		// TODO Auto-generated method stub
		return departmentDao.getList();
	}

	@Override
	public DepartmentResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return departmentDao.edit(id);
	}

	@Override
	public DepartmentResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return departmentDao.delete(id);
	}

	@Override
	public DepartmentResultBean update(DepartmentBean bean) {
		// TODO Auto-generated method stub
		return departmentDao.update(bean);
	}

	@Override
	public DepartmentBean getSequenceCode() {
		// TODO Auto-generated method stub
		return departmentDao.getSequenceCode();
	}

}
