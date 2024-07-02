package com.vms.crew.crewVesselAssignment;

import java.util.List;



public interface CrewVesselAssignmentDao {
	
	List<CrewVesselAssignmentBean> getvessel();

	public CrewVesselAssignmentResultBean getList();

	List<CrewVesselAssignmentBean> getrank();
	
	List<CrewVesselAssignmentBean> getport();

	List<CrewVesselAssignmentBean> showlist(CrewVesselAssignmentBean bean) throws Exception;

//	public boolean savelist(CrewVesselAssignmentBean bean);


}
