package com.vms.crew.healthStatus;

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
public class HealthStatusDaoImpl implements HealthStatusDao{

	
	

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public HealthStatusResultBean save(HealthStatusBean bean) {
		HealthStatusResultBean resultBean = new HealthStatusResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> healthStatus = new HashMap<String, Object>();
			
				healthStatus.put("userName", userDetails.getUsername());
				healthStatus.put("code", bean.getCode());
				healthStatus.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(HealthStatusQueryUtil.SAVE_health_status,healthStatus);
			
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public HealthStatusResultBean getList() {
		HealthStatusResultBean resultBean = new HealthStatusResultBean();
		List<HealthStatusBean> listBean = new ArrayList<HealthStatusBean>();
		
		try {
			listBean = jdbcTemplate.query(HealthStatusQueryUtil.getList,new BeanPropertyRowMapper<HealthStatusBean>(HealthStatusBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public HealthStatusResultBean edit(String id) {		
		HealthStatusResultBean resultBean = new HealthStatusResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(HealthStatusQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<HealthStatusBean>(HealthStatusBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public HealthStatusResultBean delete(String id) {
		HealthStatusResultBean resultBean = new HealthStatusResultBean();
		try {
			jdbcTemplate.update(HealthStatusQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public HealthStatusResultBean update(HealthStatusBean bean) {
		HealthStatusResultBean resultBean = new HealthStatusResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> healthStatus = new HashMap<String, Object>();
			
				healthStatus.put("userName", userDetails.getUsername());
				healthStatus.put("code", bean.getCode());
				healthStatus.put("desc", bean.getDescription());
				
				int k = jdbcTemplate.queryForObject(HealthStatusQueryUtil.checkDelete, new Object[] { bean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(HealthStatusQueryUtil.SAVE_health_status,healthStatus);
				}
				else {
					namedParameterJdbcTemplate.update(HealthStatusQueryUtil.UPDATE_health_status,healthStatus);
				}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	
	
}
