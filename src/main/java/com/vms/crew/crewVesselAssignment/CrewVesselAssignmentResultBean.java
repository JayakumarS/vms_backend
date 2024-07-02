package com.vms.crew.crewVesselAssignment;

import java.util.List;



public class CrewVesselAssignmentResultBean {
	
	private List<CrewVesselAssignmentBean> vesselList;
	private List<CrewVesselAssignmentBean> list;
	
	private List<CrewVesselAssignmentBean> lcrewBean;

	
	
	
	
	

	public List<CrewVesselAssignmentBean> getVesselList() {
		return vesselList;
	}

	public void setVesselList(List<CrewVesselAssignmentBean> vesselList) {
		this.vesselList = vesselList;
	}
	public boolean success;
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<CrewVesselAssignmentBean> getList() {
		return list;
	}

	public void setList(List<CrewVesselAssignmentBean> list) {
		this.list = list;
	}

	public List<CrewVesselAssignmentBean> getLcrewBean() {
		return lcrewBean;
	}

	public void setLcrewBean(List<CrewVesselAssignmentBean> lcrewBean) {
		this.lcrewBean = lcrewBean;
	}

}
