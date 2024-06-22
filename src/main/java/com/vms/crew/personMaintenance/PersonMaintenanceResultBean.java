package com.vms.crew.personMaintenance;

import java.util.List;

public class PersonMaintenanceResultBean {
	
	public boolean success;
	private List<PersonMaintenanceBean> list;
	private PersonMaintenanceBean personMaintenanceBean;
	private PersonMaintenanceBean crewMasterDtls;
	private PersonMaintenanceBean crewMasterDocDtls;
	private String filePath;
	private String fileName;

	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public PersonMaintenanceBean getCrewMasterDtls() {
		return crewMasterDtls;
	}
	public void setCrewMasterDtls(PersonMaintenanceBean crewMasterDtls) {
		this.crewMasterDtls = crewMasterDtls;
	}
	public PersonMaintenanceBean getCrewMasterDocDtls() {
		return crewMasterDocDtls;
	}
	public void setCrewMasterDocDtls(PersonMaintenanceBean crewMasterDocDtls) {
		this.crewMasterDocDtls = crewMasterDocDtls;
	}
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
