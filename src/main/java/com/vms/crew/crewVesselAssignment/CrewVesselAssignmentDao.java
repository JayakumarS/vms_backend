package com.vms.crew.crewVesselAssignment;

import java.util.List;


public interface CrewVesselAssignmentDao {
	
	List<CrewVesselAssignmentBean> getvessel();

	
	List<CrewVesselAssignmentBean> getrank();
	
	List<CrewVesselAssignmentBean> getport();

//	List<CrewVesselAssignmentBean> showlist(CrewVesselAssignmentBean bean);

//	public boolean savelist(CrewVesselAssignmentBean bean);

}
