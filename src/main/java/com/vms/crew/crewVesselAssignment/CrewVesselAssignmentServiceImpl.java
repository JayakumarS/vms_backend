package com.vms.crew.crewVesselAssignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CrewVesselAssignmentServiceImpl implements CrewVesselAssignmentService{
	@Autowired
	CrewVesselAssignmentDao CrewVesselAssignmentDao;
	
	
	@Override
	public List<CrewVesselAssignmentBean> getvessel() {
		return CrewVesselAssignmentDao.getvessel();
	}
	
	
	@Override
	public List<CrewVesselAssignmentBean> getrank() {
		return CrewVesselAssignmentDao.getrank();
	}
	
}
