package com.vms.common.agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
			
			int code =  jdbcTemplate.queryForObject(AgentQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);


		    if(code==0) {
			Map<String, Object> fleet = new HashMap<String, Object>();
			
				
				fleet.put("code", bean.getCode());
				fleet.put("desc", bean.getDescription());
				fleet.put("userName", userDetails.getUsername());
				namedParameterJdbcTemplate.update(AgentQueryUtil.SAVE_AGENT,fleet);
			
			
		   resultBean.setSuccess(true);
		   
		    }
			  else {
				  resultBean.setMessage(bean.getCode() + " already exists,please enter a different agent Code");
		        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
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
	public AgentResultBean edit(int id) {		
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
	public AgentResultBean delete(int id) {
		AgentResultBean resultBean = new AgentResultBean();
		String code = null;
		try {
			code = jdbcTemplate.queryForObject(AgentQueryUtil.getCodeById, new Object[]{id}, String.class);

			jdbcTemplate.update(AgentQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch (DataAccessException e) {
	        String errorMessage = e.getMessage();
	        if (errorMessage.contains("violates foreign key constraint")) {
	            resultBean.setSuccess(false);
	            resultBean.setMessage(code + " code cannot be deleted as it is already used in system.");
	        } else {
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMessage(errorMessage);
	        }
		}
		return resultBean;
	}

	@Override
	public AgentResultBean update(AgentBean bean) {
		AgentResultBean resultBean = new AgentResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			String agentcode =  jdbcTemplate.queryForObject(AgentQueryUtil.agent_code,new Object[] { bean.getAgentid() },String.class);
			String agentdesc =  jdbcTemplate.queryForObject(AgentQueryUtil.agent_desc,new Object[] { bean.getAgentid() },String.class);


			int code =  jdbcTemplate.queryForObject(AgentQueryUtil.get_code_edit,new Object[] { bean.getCode(),agentcode },Integer.class);


			
	        if(code==0) {
			Map<String, Object> fleet = new HashMap<String, Object>();
			
			    fleet.put("agentid", bean.getAgentid());
				fleet.put("code", bean.getCode());
				fleet.put("desc", bean.getDescription());
				fleet.put("userName", userDetails.getUsername());
				
				
					namedParameterJdbcTemplate.update(AgentQueryUtil.UPDATE_AGENT,fleet);
				
		   resultBean.setSuccess(true);
	       }
				  else {
					  resultBean.setMessage(bean.getCode() + " already exists,please enter a different agent Code");

			        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
}
