package com.vms.crew.crewVesselAssignment;

import java.util.List;

public class CrewVesselAssignmentResultBean {
	
	private List<CrewVesselAssignmentBean> vesselList;

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

}
