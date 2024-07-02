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
	
	
	@Override
	public List<CrewVesselAssignmentBean> getport() {
		return CrewVesselAssignmentDao.getport();
	}
	
	
	@Override
	public CrewVesselAssignmentResultBean getList() {
		// TODO Auto-generated method stub
		return CrewVesselAssignmentDao.getList();
	}
	@Override
	public List<CrewVesselAssignmentBean> showlist(CrewVesselAssignmentBean bean) throws Exception {

		return CrewVesselAssignmentDao.showlist(bean);
	}
//	@Override
//	public boolean savelist(CrewVesselAssignmentBean CrewVesselAssignmentBean) {
//
//		return CrewVesselAssignmentBean.savelist(CrewVesselAssignmentBean);
//	}
	

}
