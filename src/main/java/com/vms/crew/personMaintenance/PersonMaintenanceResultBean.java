package com.vms.crew.personMaintenance;

import java.util.List;

import com.vms.crew.applications.ApplicationsBean;

public class PersonMaintenanceResultBean {
	
	public boolean success;
	private List<PersonMaintenanceBean> list;
	private List<PersonMaintenanceBean> medicalCertificateList;
	private PersonMaintenanceBean personMaintenanceBean;
	private PersonMaintenanceBean crewMasterDtls;
	private PersonMaintenanceBean crewMasterDocDtls;
	private String filePath;
	private String fileName;
	private String code;
	private List<ApplicationsBean>checkListDtls;
	private List<PersonMaintenanceBean> crewMasterDocDtsl;
	
	public List<PersonMaintenanceBean> getCrewMasterDocDtsl() {
		return crewMasterDocDtsl;
	}
	public void setCrewMasterDocDtsl(List<PersonMaintenanceBean> crewMasterDocDtsl) {
		this.crewMasterDocDtsl = crewMasterDocDtsl;
	}
	public List<ApplicationsBean> getCheckListDtls() {
		return checkListDtls;
	}
	public void setCheckListDtls(List<ApplicationsBean> checkListDtls) {
		this.checkListDtls = checkListDtls;
	}
	public List<PersonMaintenanceBean> getMedicalCertificateList() {
		return medicalCertificateList;
	}
	public void setMedicalCertificateList(List<PersonMaintenanceBean> medicalCertificateList) {
		this.medicalCertificateList = medicalCertificateList;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
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
