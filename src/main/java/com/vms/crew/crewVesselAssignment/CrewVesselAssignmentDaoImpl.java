package com.vms.crew.crewVesselAssignment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vms.crew.maintainRank.MaintainRankBean;
import com.vms.crew.maintainRank.MaintainRankQueryUtil;

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
}
