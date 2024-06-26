package com.vms.crew.expEngine;

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

import com.vms.crew.payTypes.PayTypesQueryUtil;
import com.vms.crew.payTypes.PayTypesResultBean;
import com.vms.vessels.fleet.FleetQueryUtil;


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
			int code =  jdbcTemplate.queryForObject(ExpEngineQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(ExpEngineQueryUtil.get_desc,new Object[] { bean.getDescription() },Integer.class);
		    if(code==0 && desc==0) {
			Map<String, Object> expEngine = new HashMap<String, Object>();
			
				expEngine.put("userName", userDetails.getUsername());
				expEngine.put("code", bean.getCode());
				expEngine.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(ExpEngineQueryUtil. SAVE_exp_Engine,expEngine);
				
				
				resultBean.setSuccess(true);
			
		    }
		    else {
		    	 resultBean.setMessage(  bean.getCode() +" already exists,please enter a different Engine Type Code");

	  	        }
		    
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
	public ExpEngineResultBean edit(int id) {		
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
	public ExpEngineResultBean delete(int id) {
		ExpEngineResultBean resultBean = new ExpEngineResultBean();
		String code = null; 
		try {
	    	code = jdbcTemplate.queryForObject(ExpEngineQueryUtil.getCodeById, new Object[]{id}, String.class);

			
			jdbcTemplate.update(ExpEngineQueryUtil.delete,id);
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
	public ExpEngineResultBean update(ExpEngineBean bean) {
		ExpEngineResultBean resultBean = new ExpEngineResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			String paycode =  jdbcTemplate.queryForObject(ExpEngineQueryUtil.engine_code,new Object[] { bean.getEngineid() },String.class);
			String paydesc =  jdbcTemplate.queryForObject(ExpEngineQueryUtil.engine_desc,new Object[] { bean.getEngineid() },String.class);


			int code =  jdbcTemplate.queryForObject(ExpEngineQueryUtil.get_code_edit,new Object[] { bean.getCode(),paycode },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(ExpEngineQueryUtil.get_desc_edit,new Object[] { bean.getDescription(),paydesc },Integer.class);
		    if(code==0 && desc==0) {
			Map<String, Object> expEngine = new HashMap<String, Object>();
			
				expEngine.put("userName", userDetails.getUsername());
				expEngine.put("code", bean.getCode());
				expEngine.put("desc", bean.getDescription());
				
					namedParameterJdbcTemplate.update(ExpEngineQueryUtil.UPDATE_exp_Engine,expEngine);
				
			
		    }
		    else {
		 		   resultBean.setMessage( bean.getCode() +" already exists,please enter a different Engine Type Code");

		        }
		    resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	

}
