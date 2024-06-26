package com.vms.master.religion;

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
public class ReligionDaoImpl implements ReligionDao {

	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	
	
	
	
	
	
	
	@Override
	public ReligionResultBean save(ReligionBean bean) {
		ReligionResultBean resultBean = new ReligionResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			 int name =  jdbcTemplate.queryForObject(ReligionQueryUtil.get_name,new Object[] { bean.getName() },Integer.class);

				
	            if(name==0) {
	        	
			Map<String, Object> religion = new HashMap<String, Object>();
			
			if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
				bean.setActive("Y");
			} else {
				bean.setActive("N");
			}
		
			religion.put("userName", userDetails.getUsername());
			religion.put("code", bean.getCode());
			religion.put("name", bean.getName());
			religion.put("active", bean.getActive());
				namedParameterJdbcTemplate.update(ReligionQueryUtil.SAVE_RELIGION,religion);
			
			
		   resultBean.setSuccess(true);
	        }
			  else {
		 		   resultBean.setMessage("These details already exist");

		        }	
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			 resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}

	@Override
	public ReligionResultBean getList() {
		
		ReligionResultBean resultBean = new ReligionResultBean();
		List<ReligionBean> listBean = new ArrayList<ReligionBean>();
		
		try {
			listBean = jdbcTemplate.query(ReligionQueryUtil.getList,new BeanPropertyRowMapper<ReligionBean>(ReligionBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public ReligionResultBean edit(String id) {
		
		ReligionResultBean resultBean = new ReligionResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(ReligionQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<ReligionBean>(ReligionBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public ReligionResultBean update(ReligionBean bean) {
		ReligionResultBean resultBean = new ReligionResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			
			String religionname =  jdbcTemplate.queryForObject(ReligionQueryUtil.religion_name,new Object[] { bean.getReligionId() },String.class);



		    int name =  jdbcTemplate.queryForObject(ReligionQueryUtil.get_religion_edit,new Object[] { bean.getName(),religionname },Integer.class);

			
	        if(name==0) {
	        	
			Map<String, Object> religion = new HashMap<String, Object>();
			
			if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
				bean.setActive("Y");
			} else {
				bean.setActive("N");
			}

			religion.put("userName", userDetails.getUsername());
			religion.put("code", bean.getCode());
			religion.put("name", bean.getName());
			religion.put("active", bean.getActive());
			religion.put("religionId", bean.getReligionId());
			namedParameterJdbcTemplate.update(ReligionQueryUtil.UPDATE_RELIGION,religion);
				
			
		   resultBean.setSuccess(true);
	   	 }
			  else {
		 		   resultBean.setMessage("These details already exist");

		        }	
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			 resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}

	@Override
	public ReligionResultBean delete(String id) {
		
		ReligionResultBean resultBean = new ReligionResultBean();
		try {
			jdbcTemplate.update(ReligionQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public ReligionBean getSequenceCode() {
		ReligionBean religionBean = new ReligionBean();

		    try {
		        String religionId = jdbcTemplate.queryForObject(ReligionQueryUtil.get_RELIGION_Id, String.class);
		        religionBean.setCode(religionId);
		    } catch (Exception e) {
		        // Log the exception
		        e.printStackTrace();
		    }

		    return religionBean;
	}

	

}
