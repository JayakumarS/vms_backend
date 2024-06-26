package com.vms.master.bloodgroup;

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
public class BloodGroupDaoImpl implements BloodGroupDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	
	
	

	@Override
	public BloodGroupResultBean save(BloodGroupBean bean) {
		BloodGroupResultBean resultBean = new BloodGroupResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			
			
			  int name =  jdbcTemplate.queryForObject(BloodGroupQueryUtil.get_name,new Object[] { bean.getName() },Integer.class);

				
	            if(name==0) {
			Map<String, Object> bloodGroup = new HashMap<String, Object>();
			
			if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
				bean.setActive("Y");
			} else {
				bean.setActive("N");
			}
		
			bloodGroup.put("userName", userDetails.getUsername());
			bloodGroup.put("bloodGroupCode", bean.getBloodGroupCode());
			bloodGroup.put("name", bean.getName());
			bloodGroup.put("active", bean.getActive());
				namedParameterJdbcTemplate.update(BloodGroupQueryUtil.SAVE_BLOODGROUP,bloodGroup);
			
			
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
	public BloodGroupResultBean getList() {
		BloodGroupResultBean resultBean = new BloodGroupResultBean();
		List<BloodGroupBean> listBean = new ArrayList<BloodGroupBean>();
		
		try {
			listBean = jdbcTemplate.query(BloodGroupQueryUtil.getList,new BeanPropertyRowMapper<BloodGroupBean>(BloodGroupBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public BloodGroupResultBean edit(String id) {
		BloodGroupResultBean resultBean = new BloodGroupResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(BloodGroupQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<BloodGroupBean>(BloodGroupBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	
	@Override
	public BloodGroupResultBean update(BloodGroupBean bean) {
		BloodGroupResultBean resultBean = new BloodGroupResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			String bloodGroupname =  jdbcTemplate.queryForObject(BloodGroupQueryUtil.bloodGroup_name,new Object[] { bean.getBloodGroupId() },String.class);



		    int name =  jdbcTemplate.queryForObject(BloodGroupQueryUtil.get_bloodGroup_edit,new Object[] { bean.getName(),bloodGroupname },Integer.class);

			
	        if(name==0) {
	        	
	        
			Map<String, Object> bloodGroup = new HashMap<String, Object>();
			
			if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
				bean.setActive("Y");
			} else {
				bean.setActive("N");
			}

			bloodGroup.put("userName", userDetails.getUsername());
			bloodGroup.put("bloodGroupCode", bean.getBloodGroupCode());
			bloodGroup.put("name", bean.getName());
			bloodGroup.put("active", bean.getActive());
			bloodGroup.put("bloodGroupId", bean.getBloodGroupId());
			namedParameterJdbcTemplate.update(BloodGroupQueryUtil.UPDATE_BLOODGROUP,bloodGroup);
				
			
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
	public BloodGroupResultBean delete(String id) {
		
		BloodGroupResultBean resultBean = new BloodGroupResultBean();
		try {
			jdbcTemplate.update(BloodGroupQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public BloodGroupBean getSequenceCode() {
		BloodGroupBean bloodGroupBean = new BloodGroupBean();

	    try {
	        String bloodGroupId = jdbcTemplate.queryForObject(BloodGroupQueryUtil.get_BLOODGROUP_Id, String.class);
	        bloodGroupBean.setBloodGroupCode(bloodGroupId);
	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();
	    }

	    return bloodGroupBean;
	}

	
	
	
	
	
	
	
}




