package com.vms.supplies.supplieDepartment;

import java.util.List;

public class SupplieDepartmentResultBean {
	
	public boolean success;
	private List<SupplieDepartmentBean> list;
	private SupplieDepartmentBean personMaintenanceBean;
	private SupplieDepartmentBean departmentDtls;
	private SupplieDepartmentBean crewMasterDocDtls;
	private String filePath;
	private String fileName;
	private String code;

	public SupplieDepartmentBean getDepartmentDtls() {
		return departmentDtls;
	}
	public void setDepartmentDtls(SupplieDepartmentBean departmentDtls) {
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
	public SupplieDepartmentBean getCrewMasterDocDtls() {
		return crewMasterDocDtls;
	}
	public void setCrewMasterDocDtls(SupplieDepartmentBean crewMasterDocDtls) {
		this.crewMasterDocDtls = crewMasterDocDtls;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public SupplieDepartmentBean getPersonMaintenanceBean() {
		return personMaintenanceBean;
	}
	public void setPersonMaintenanceBean(SupplieDepartmentBean personMaintenanceBean) {
		this.personMaintenanceBean = personMaintenanceBean;
	}
	
	public List<SupplieDepartmentBean> getList() {
		return list;
	}
	public void setList(List<SupplieDepartmentBean> list) {
		this.list = list;
	}

}
