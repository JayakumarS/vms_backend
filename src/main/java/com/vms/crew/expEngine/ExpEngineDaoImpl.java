package com.vms.crew.expEngine;

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
public class ExpEngineDaoImpl implements ExpEngineDao {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public ExpEngineResultBean save(ExpEngineBean bean) {
		ExpEngineResultBean resultBean = new ExpEngineResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> expEngine = new HashMap<String, Object>();
			
			for(ExpEngineBean listBean : bean.getExpEngineBeanBeanDtls()) {
				expEngine.put("userName", userDetails.getUsername());
				expEngine.put("code", listBean.getCode());
				expEngine.put("desc", listBean.getDescription());
				namedParameterJdbcTemplate.update(ExpEngineQueryUtil. SAVE_exp_Engine,expEngine);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public ExpEngineResultBean getList() {
		ExpEngineResultBean resultBean = new ExpEngineResultBean();
		List<ExpEngineBean> listBean = new ArrayList<ExpEngineBean>();
		
		try {
			listBean = jdbcTemplate.query(ExpEngineQueryUtil.getList,new BeanPropertyRowMapper<ExpEngineBean>(ExpEngineBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public ExpEngineResultBean edit(String id) {		
		ExpEngineResultBean resultBean = new ExpEngineResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(ExpEngineQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<ExpEngineBean>(ExpEngineBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public ExpEngineResultBean delete(String id) {
		ExpEngineResultBean resultBean = new ExpEngineResultBean();
		try {
			jdbcTemplate.update(ExpEngineQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public ExpEngineResultBean update(ExpEngineBean bean) {
		ExpEngineResultBean resultBean = new ExpEngineResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> expEngine = new HashMap<String, Object>();
			
			for(ExpEngineBean listBean : bean.getExpEngineBeanBeanDtls()) {
				expEngine.put("userName", userDetails.getUsername());
				expEngine.put("code", listBean.getCode());
				expEngine.put("desc", listBean.getDescription());
				
				int k = jdbcTemplate.queryForObject(ExpEngineQueryUtil.checkDelete, new Object[] { listBean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(ExpEngineQueryUtil. SAVE_exp_Engine,expEngine);
				}
				else {
					namedParameterJdbcTemplate.update(ExpEngineQueryUtil.UPDATE_exp_Engine,expEngine);
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
