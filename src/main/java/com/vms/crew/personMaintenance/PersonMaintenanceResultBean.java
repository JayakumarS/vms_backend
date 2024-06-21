package com.vms.crew.personMaintenance;

import java.util.List;

public class PersonMaintenanceResultBean {
	
	public boolean success;
	private List<PersonMaintenanceBean> list;
	private PersonMaintenanceBean personMaintenanceBean;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public PersonMaintenanceBean getPersonMaintenanceBean() {
		return personMaintenanceBean;
	}
	public void setPersonMaintenanceBean(PersonMaintenanceBean personMaintenanceBean) {
		this.personMaintenanceBean = personMaintenanceBean;
	}
	
	public List<PersonMaintenanceBean> getList() {
		return list;
	}
	public void setList(List<PersonMaintenanceBean> list) {
		this.list = list;
	}

}
