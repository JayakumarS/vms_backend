package com.vms.crew.crewVesselAssignment;

import java.util.List;

import org.springframework.stereotype.Service;



public interface CrewVesselAssignmentService {
	
	List<CrewVesselAssignmentBean> getvessel();
	
	List<CrewVesselAssignmentBean> getrank();
	
	List<CrewVesselAssignmentBean> getport();

//	List<CrewVesselAssignmentBean> showlist(CrewVesselAssignmentBean bean);

//	public boolean savelist(CrewVesselAssignmentBean bean);

}
