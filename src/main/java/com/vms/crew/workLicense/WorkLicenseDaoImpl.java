package com.vms.crew.workLicense;

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

import com.vms.crew.workStatus.WorkStatusQueryUtil;



@Repository
public class WorkLicenseDaoImpl implements WorkLicenseDao{


	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public WorkLicenseResultBean save(WorkLicenseBean bean) {
		WorkLicenseResultBean resultBean = new WorkLicenseResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			int code =  jdbcTemplate.queryForObject(WorkLicenseQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(WorkLicenseQueryUtil.get_desc,new Object[] { bean.getDescription() },Integer.class);

			
            if(code==0 && desc==0) {
			Map<String, Object> workLicense = new HashMap<String, Object>();
			
				workLicense.put("userName", userDetails.getUsername());
				workLicense.put("code", bean.getCode());
				workLicense.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(WorkLicenseQueryUtil.SAVE_work_license,workLicense);
			
			
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
	public WorkLicenseResultBean getList() {
		WorkLicenseResultBean resultBean = new WorkLicenseResultBean();
		List<WorkLicenseBean> listBean = new ArrayList<WorkLicenseBean>();
		
		try {
			listBean = jdbcTemplate.query(WorkLicenseQueryUtil.getList,new BeanPropertyRowMapper<WorkLicenseBean>(WorkLicenseBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public WorkLicenseResultBean edit(Integer id) {		
		WorkLicenseResultBean resultBean = new WorkLicenseResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(WorkLicenseQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<WorkLicenseBean>(WorkLicenseBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public WorkLicenseResultBean delete(Integer id) {
		WorkLicenseResultBean resultBean = new WorkLicenseResultBean();
		try {
			jdbcTemplate.update(WorkLicenseQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			   String errorMessage = e.getMessage();
		        if (errorMessage.contains("violates foreign key constraint")) {
		            resultBean.setSuccess(false);
		            resultBean.setMessage("Cannot delete this work license because it is referenced in another");
		        } else {
		            e.printStackTrace();
		            resultBean.setSuccess(false);
		            resultBean.setMessage("Error in Delete");
		        }
		}	
		return resultBean;
	}

	@Override
	public WorkLicenseResultBean update(WorkLicenseBean bean) {
		WorkLicenseResultBean resultBean = new WorkLicenseResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			String workLicensecode =  jdbcTemplate.queryForObject(WorkLicenseQueryUtil.workLicense_code,new Object[] { bean.getWorklicenseid() },String.class);
			String workLicensedesc =  jdbcTemplate.queryForObject(WorkLicenseQueryUtil.workLicense_desc,new Object[] { bean.getWorklicenseid() },String.class);


			int code =  jdbcTemplate.queryForObject(WorkLicenseQueryUtil.get_code_edit,new Object[] { bean.getCode(),workLicensecode },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(WorkLicenseQueryUtil.get_desc_edit,new Object[] { bean.getDescription(),workLicensedesc },Integer.class);

			
	        if(code==0 && desc==0) {
	        	        	
	        
			Map<String, Object> workLicense = new HashMap<String, Object>();
			
				workLicense.put("userName", userDetails.getUsername());
				workLicense.put("code", bean.getCode());
				workLicense.put("desc", bean.getDescription());
				workLicense.put("worklicenseid", bean.getWorklicenseid());

				
				
					namedParameterJdbcTemplate.update(WorkLicenseQueryUtil.UPDATE_work_license,workLicense);
				
			
					
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
	
	
}
