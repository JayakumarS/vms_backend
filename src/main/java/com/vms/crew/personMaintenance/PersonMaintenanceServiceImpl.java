package com.vms.crew.personMaintenance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PersonMaintenanceServiceImpl implements PersonMaintenanceService{
	
	@Autowired
	PersonMaintenanceDao personMaintenanceDao;
	
	@Override
	public PersonMaintenanceResultBean save(PersonMaintenanceBean bean) {
		// TODO Auto-generated method stub
		return personMaintenanceDao.save(bean);
	}

	@Override
	public PersonMaintenanceResultBean getList() {
		// TODO Auto-generated method stub
		return personMaintenanceDao.getList();
	}

	@Override
	public PersonMaintenanceResultBean delete(String id) {
		// TODO Auto-generated method stub
		return personMaintenanceDao.delete(id);
	}

	@Override
	public PersonMaintenanceResultBean edit(String id) {
		// TODO Auto-generated method stub
		return personMaintenanceDao.edit(id);
	}

	@Override
	public PersonMaintenanceResultBean update(PersonMaintenanceBean bean) {
		// TODO Auto-generated method stub
		return personMaintenanceDao.update(bean);
	}

	@Override
	public PersonMaintenanceResultBean getApplicantList() {
		// TODO Auto-generated method stub
		return personMaintenanceDao.getApplicantList();
	}

	@Override
	public PersonMaintenanceResultBean getDetails(String id) {
		// TODO Auto-generated method stub
		return personMaintenanceDao.getDetails(id);
	}

	@Override
	public String generateCode() {
		// TODO Auto-generated method stub
		return personMaintenanceDao.generateCode();
	}

	@Override
	public PersonMaintenanceResultBean getCheckListDtl(Integer id) {
		// TODO Auto-generated method stub
		return personMaintenanceDao.getCheckListDtl(id);
	}

	@Override
	public PersonMaintenanceResultBean getcrewCheckListDtl(String id) {
		// TODO Auto-generated method stub
		return personMaintenanceDao.getCheckListDtl(id);
	}

}
