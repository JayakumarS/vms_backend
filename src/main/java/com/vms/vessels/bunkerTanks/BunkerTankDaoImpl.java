package com.vms.vessels.bunkerTanks;

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
public class BunkerTankDaoImpl implements BunkerTankDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public BunkerTankResultBean save(BunkerTankBean bean) {
		BunkerTankResultBean resultBean = new BunkerTankResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			int code =  jdbcTemplate.queryForObject(BunkerTankQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(BunkerTankQueryUtil.get_desc,new Object[] { bean.getDescription() },Integer.class);
		    if(code==0 && desc==0) {
		    	
		   
			Map<String, Object> bunkertank = new HashMap<String, Object>();
			
			
			bunkertank.put("userName", userDetails.getUsername());
			bunkertank.put("code", bean.getCode());
			bunkertank.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(BunkerTankQueryUtil.SAVE_bunkertank,bunkertank);
			
			
		   resultBean.setSuccess(true);
		    }
		    else {
		    	 resultBean.setMessage(  bean.getCode() +" already exists,please enter a different Training Code");

	  	        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public BunkerTankResultBean getList() {
		BunkerTankResultBean resultBean = new BunkerTankResultBean();
		List<BunkerTankBean> listBean = new ArrayList<BunkerTankBean>();
		
		try {
			listBean = jdbcTemplate.query(BunkerTankQueryUtil.getList,new BeanPropertyRowMapper<BunkerTankBean>(BunkerTankBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public BunkerTankResultBean edit(Integer id) {		
		BunkerTankResultBean resultBean = new BunkerTankResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(BunkerTankQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<BunkerTankBean>(BunkerTankBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public BunkerTankResultBean delete(Integer id) {
		BunkerTankResultBean resultBean = new BunkerTankResultBean();
		String code = null; 
		try {
			
	    	code = jdbcTemplate.queryForObject(BunkerTankQueryUtil.getCodeById, new Object[]{id}, String.class);

			jdbcTemplate.update(BunkerTankQueryUtil.delete,id);
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
	public BunkerTankResultBean update(BunkerTankBean bean) {
		BunkerTankResultBean resultBean = new BunkerTankResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			String bunkertankcode =  jdbcTemplate.queryForObject(BunkerTankQueryUtil.bunker_tank_code,new Object[] { bean.getBunkertankid() },String.class);
			String bunkertankdesc =  jdbcTemplate.queryForObject(BunkerTankQueryUtil.bunkertank_desc,new Object[] { bean.getBunkertankid() },String.class);


			int code =  jdbcTemplate.queryForObject(BunkerTankQueryUtil.get_code_edit,new Object[] { bean.getCode(),bunkertankcode },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(BunkerTankQueryUtil.get_desc_edit,new Object[] { bean.getDescription(),bunkertankdesc },Integer.class);
		    if(code==0 && desc==0) {
			Map<String, Object> bunkertank = new HashMap<String, Object>();
			
			bunkertank.put("userName", userDetails.getUsername());
			bunkertank.put("code", bean.getCode());
			bunkertank.put("desc", bean.getDescription());
			bunkertank.put("bunkertankid", bean.getBunkertankid());
				
				namedParameterJdbcTemplate.update(BunkerTankQueryUtil.UPDATE_bunkertank,bunkertank);
				
			
		   resultBean.setSuccess(true);
		    } 
		    else {
		 		   resultBean.setMessage( bean.getCode() +" already exists,please enter a different Training Code");

		        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
}
