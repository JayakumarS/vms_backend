package com.vms.vessels.fleet;

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
public class FleetDaoImpl implements FleetDao{

	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public FleetResultBean save(FleetBean bean) {
		FleetResultBean resultBean = new FleetResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> fleet = new HashMap<String, Object>();
			
				
				fleet.put("code", bean.getCode());
				fleet.put("desc", bean.getDescription());
				fleet.put("userName", userDetails.getUsername());
				namedParameterJdbcTemplate.update(FleetQueryUtil.SAVE_FLEET,fleet);
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public FleetResultBean getList() {
		FleetResultBean resultBean = new FleetResultBean();
		List<FleetBean> listBean = new ArrayList<FleetBean>();
		
		try {
			listBean = jdbcTemplate.query(FleetQueryUtil.getList,new BeanPropertyRowMapper<FleetBean>(FleetBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public FleetResultBean edit(String id) {		
		FleetResultBean resultBean = new FleetResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(FleetQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<FleetBean>(FleetBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public FleetResultBean delete(String id) {
		FleetResultBean resultBean = new FleetResultBean();
		try {
			jdbcTemplate.update(FleetQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public FleetResultBean update(FleetBean bean) {
		FleetResultBean resultBean = new FleetResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> fleet = new HashMap<String, Object>();
			
				
				fleet.put("code", bean.getCode());
				fleet.put("desc", bean.getDescription());
				fleet.put("userName", userDetails.getUsername());
				
					namedParameterJdbcTemplate.update(FleetQueryUtil.UPDATE_FLEET,fleet);
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
}
