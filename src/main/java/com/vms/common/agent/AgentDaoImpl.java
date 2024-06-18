package com.vms.common.agent;

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
public class AgentDaoImpl implements AgentDao{

	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public AgentResultBean save(AgentBean bean) {
		AgentResultBean resultBean = new AgentResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> fleet = new HashMap<String, Object>();
			
			for(AgentBean listBean : bean.getAgentDetails()) {
				
				fleet.put("code", listBean.getCode());
				fleet.put("desc", listBean.getDescription());
				fleet.put("userName", userDetails.getUsername());
				namedParameterJdbcTemplate.update(AgentQueryUtil.SAVE_AGENT,fleet);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public AgentResultBean getList() {
		AgentResultBean resultBean = new AgentResultBean();
		List<AgentBean> listBean = new ArrayList<AgentBean>();
		
		try {
			listBean = jdbcTemplate.query(AgentQueryUtil.getList,new BeanPropertyRowMapper<AgentBean>(AgentBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public AgentResultBean edit(String id) {		
		AgentResultBean resultBean = new AgentResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(AgentQueryUtil.getEdit_AGENT,new Object[] { id }, new BeanPropertyRowMapper<AgentBean>(AgentBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public AgentResultBean delete(String id) {
		AgentResultBean resultBean = new AgentResultBean();
		try {
			jdbcTemplate.update(AgentQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public AgentResultBean update(AgentBean bean) {
		AgentResultBean resultBean = new AgentResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> fleet = new HashMap<String, Object>();
			
			for(AgentBean listBean : bean.getAgentDetails()) {
				
				fleet.put("code", listBean.getCode());
				fleet.put("desc", listBean.getDescription());
				fleet.put("userName", userDetails.getUsername());
				int k = jdbcTemplate.queryForObject(AgentQueryUtil.checkDelete, new Object[] { listBean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(AgentQueryUtil.SAVE_AGENT,fleet);
				}
				else {
					namedParameterJdbcTemplate.update(AgentQueryUtil.UPDATE_AGENT,fleet);
				}
			}
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
}
