package com.vms.supplies.vesselCounters;

import java.util.List;

public class VesselCountersResultBean {
	
	public boolean success;
	private List<VesselCountersBean> list;
	private VesselCountersBean personMaintenanceBean;
	private VesselCountersBean departmentDtls;
	private VesselCountersBean crewMasterDocDtls;
	private String filePath;
	private String fileName;
	private String code;

	public VesselCountersBean getDepartmentDtls() {
		return departmentDtls;
	}
	public void setDepartmentDtls(VesselCountersBean departmentDtls) {
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
	public VesselCountersBean getCrewMasterDocDtls() {
		return crewMasterDocDtls;
	}
	public void setCrewMasterDocDtls(VesselCountersBean crewMasterDocDtls) {
		this.crewMasterDocDtls = crewMasterDocDtls;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public VesselCountersBean getPersonMaintenanceBean() {
		return personMaintenanceBean;
	}
	public void setPersonMaintenanceBean(VesselCountersBean personMaintenanceBean) {
		this.personMaintenanceBean = personMaintenanceBean;
	}
	
	public List<VesselCountersBean> getList() {
		return list;
	}
	public void setList(List<VesselCountersBean> list) {
		this.list = list;
	}

}
