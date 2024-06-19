package com.vms.crew.crewVesselAssignment;

import java.util.List;

import org.springframework.stereotype.Service;


@Service

public interface CrewVesselAssignmentService {
	
	List<CrewVesselAssignmentBean> getvessel();
	
	List<CrewVesselAssignmentBean> getrank();


}
