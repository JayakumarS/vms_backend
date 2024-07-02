package com.vms.crew.crewVesselAssignment;

import java.util.List;

import org.springframework.stereotype.Service;




public interface CrewVesselAssignmentService {
	
	List<CrewVesselAssignmentBean> getvessel();
	
	List<CrewVesselAssignmentBean> getrank();
	
	List<CrewVesselAssignmentBean> getport();
	
	public CrewVesselAssignmentResultBean getList();


	List<CrewVesselAssignmentBean> showlist(CrewVesselAssignmentBean bean) throws Exception;

//	public boolean savelist(CrewVesselAssignmentBean bean);
	


}
