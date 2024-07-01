package com.vms.supplies.unitsPackings;

import java.util.List;

public class UnitsPackingsResultBean {
	
	public boolean success;
	private List<UnitsPackingsBean> list;
	private UnitsPackingsBean personMaintenanceBean;
	private UnitsPackingsBean departmentDtls;
	private UnitsPackingsBean crewMasterDocDtls;
	private String filePath;
	private String fileName;
	private String code;

	public UnitsPackingsBean getDepartmentDtls() {
		return departmentDtls;
	}
	public void setDepartmentDtls(UnitsPackingsBean departmentDtls) {
		this.departmentDtls = departmentDtls;
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
	public UnitsPackingsBean getCrewMasterDocDtls() {
		return crewMasterDocDtls;
	}
	public void setCrewMasterDocDtls(UnitsPackingsBean crewMasterDocDtls) {
		this.crewMasterDocDtls = crewMasterDocDtls;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public UnitsPackingsBean getPersonMaintenanceBean() {
		return personMaintenanceBean;
	}
	public void setPersonMaintenanceBean(UnitsPackingsBean personMaintenanceBean) {
		this.personMaintenanceBean = personMaintenanceBean;
	}
	
	public List<UnitsPackingsBean> getList() {
		return list;
	}
	public void setList(List<UnitsPackingsBean> list) {
		this.list = list;
	}

}
