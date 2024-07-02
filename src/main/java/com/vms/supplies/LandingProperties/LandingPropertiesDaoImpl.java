package com.vms.supplies.LandingProperties;

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
public class LandingPropertiesDaoImpl implements LandingPropertiesDao{

	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public LandingPropertiesResultBean save(LandingPropertiesBean bean) {
		LandingPropertiesResultBean resultBean = new LandingPropertiesResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			

			Map<String, Object> Country = new HashMap<String, Object>();
			
			Country.put("userName", userDetails.getUsername());
			
			namedParameterJdbcTemplate.update(LandingPropertiesQueryUtil.SAVE_LANDING,Country);
			
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	@Override
	public LandingPropertiesResultBean list() {
		LandingPropertiesResultBean resultBean = new LandingPropertiesResultBean();
		List<LandingPropertiesBean> listBean = new ArrayList<LandingPropertiesBean>();
		
		try {
			listBean = jdbcTemplate.query(LandingPropertiesQueryUtil.GET_LANDING_LIST,new BeanPropertyRowMapper<LandingPropertiesBean>(LandingPropertiesBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public LandingPropertiesResultBean edit(Integer id) {		
		LandingPropertiesResultBean resultBean = new LandingPropertiesResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(LandingPropertiesQueryUtil.GET_EDIT_LANDING,new Object[] { id }, new BeanPropertyRowMapper<LandingPropertiesBean>(LandingPropertiesBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	
	@Override
	public LandingPropertiesResultBean delete(String id) {
		LandingPropertiesResultBean resultBean = new LandingPropertiesResultBean();
		try {
			jdbcTemplate.update(LandingPropertiesQueryUtil.DELETE_LANDING,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			  String errorMessage = e.getMessage();
		        if (errorMessage.contains("violates foreign key constraint")) {
		            resultBean.setSuccess(false);
		            resultBean.setMessage("Cannot delete this country id because it is referenced in another table");
		        } else {
		            e.printStackTrace();
		            resultBean.setSuccess(false);
		            resultBean.setMessage(errorMessage);
		        }
		}	
		return resultBean;
	}

	@Override
	public LandingPropertiesResultBean update(LandingPropertiesBean bean) {
		LandingPropertiesResultBean resultBean = new LandingPropertiesResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
	
			Map<String, Object> Country = new HashMap<String, Object>();
			
			Country.put("userName", userDetails.getUsername());
			
			namedParameterJdbcTemplate.update(LandingPropertiesQueryUtil.UPDATE_LANDING,Country);
				
		    resultBean.setSuccess(true);
		   
          
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

}
