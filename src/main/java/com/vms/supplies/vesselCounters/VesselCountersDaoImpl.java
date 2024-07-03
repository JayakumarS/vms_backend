package com.vms.supplies.vesselCounters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


@Repository

public class VesselCountersDaoImpl implements VesselCountersDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public VesselCountersResultBean save(VesselCountersBean bean) {
		VesselCountersResultBean resultBean = new VesselCountersResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> vesselMap = new HashMap<String, Object>();
						
			vesselMap.put("userName", userDetails.getUsername());
			vesselMap.put("vessel", bean.getVessel());
			vesselMap.put("option", bean.getOption());
			vesselMap.put("dep", (bean.getDep() == null || bean.getDep().isEmpty()) ? null : Integer.parseInt(bean.getDep()));
			vesselMap.put("type", bean.getType());
			vesselMap.put("startFrom", bean.getStartFrom());
			
			namedParameterJdbcTemplate.update(VesselCountersQueryUtil.SAVE_VESSEL_COUNTERS,vesselMap);
			
		    resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public VesselCountersResultBean getList() {
		VesselCountersResultBean resultBean = new VesselCountersResultBean();
		List<VesselCountersBean> listBean = new ArrayList<VesselCountersBean>();
		
		try {
			listBean = jdbcTemplate.query(VesselCountersQueryUtil.GET_LIST,new BeanPropertyRowMapper<VesselCountersBean>(VesselCountersBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
			
	public VesselCountersResultBean delete(String id) {
		VesselCountersResultBean resultBean = new VesselCountersResultBean();
		try {
			jdbcTemplate.update(VesselCountersQueryUtil.DELETE_SUPPLIE_DEPARTMENT,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public VesselCountersResultBean edit(String id) {		
		VesselCountersResultBean resultBean = new VesselCountersResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setDepartmentDtls(jdbcTemplate.queryForObject(VesselCountersQueryUtil.GET_SUPP_DEPT_DTLS,new Object[] { id }, new BeanPropertyRowMapper<VesselCountersBean>(VesselCountersBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public VesselCountersResultBean update(VesselCountersBean bean) {
		VesselCountersResultBean resultBean = new VesselCountersResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> vesselMap = new HashMap<String, Object>();
						
			vesselMap.put("userName", userDetails.getUsername());
			vesselMap.put("id", bean.getId());
			vesselMap.put("vessel", bean.getVessel());
			vesselMap.put("option", bean.getOption());
			vesselMap.put("dep", (bean.getDep() == null || bean.getDep().isEmpty()) ? null : Integer.parseInt(bean.getDep()));
			vesselMap.put("type", bean.getType());
			vesselMap.put("startFrom", bean.getStartFrom());
			
			namedParameterJdbcTemplate.update(VesselCountersQueryUtil.UPDATE_SUPPLIE_DEPARTMENT,vesselMap);
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public String generateCode() {
		String code = "";
		try {
			code = jdbcTemplate.queryForObject(VesselCountersQueryUtil.GET_CODE,new Object[]{}, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}	
}
