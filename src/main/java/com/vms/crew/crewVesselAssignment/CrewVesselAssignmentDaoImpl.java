package com.vms.crew.crewVesselAssignment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;



@Repository

public class CrewVesselAssignmentDaoImpl implements CrewVesselAssignmentDao{
	
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<CrewVesselAssignmentBean> getvessel() {
		List<CrewVesselAssignmentBean> getvessel = new ArrayList<>();

		try {
			getvessel = jdbcTemplate.query(CrewVesselAssignmentQueryUtil.getvessel, new Object[] {},new BeanPropertyRowMapper<>(CrewVesselAssignmentBean.class));

				

		} catch (Exception e) {
		}
		return getvessel;
	}
	
	@Override
	public List<CrewVesselAssignmentBean> getrank() {
		List<CrewVesselAssignmentBean> getrank = new ArrayList<>();

		try {
			getrank = jdbcTemplate.query(CrewVesselAssignmentQueryUtil.getrank, new Object[] {},new BeanPropertyRowMapper<>(CrewVesselAssignmentBean.class));

				

		} catch (Exception e) {
		}
		return getrank;
	}
	
	@Override
	public List<CrewVesselAssignmentBean> getport() {
		List<CrewVesselAssignmentBean> getport = new ArrayList<>();

		try {
			getport = jdbcTemplate.query(CrewVesselAssignmentQueryUtil.getport, new Object[] {},new BeanPropertyRowMapper<>(CrewVesselAssignmentBean.class));

				

		} catch (Exception e) {
		}
		return getport;
	}
	
	
//	@Override
//	public List<CrewVesselAssignmentBean> showlist(
//			CrewVesselAssignmentBean bean) {
//
//		List<CrewVesselAssignmentBean> CrewVesselAssignmentBean = new ArrayList<>();
//		
//		
//		try {
//		
//		} catch (Exception e) {
//		}
//		return CrewVesselAssignmentBean;
//	}
	
//	@Override
//	public boolean savelist(CrewVesselAssignmentBean alPaymentInformationList) {
//
//		
//	
//	
//
//		try {
//			
//		} catch (Exception e) {
//		}
//		return true;
//	}


}
