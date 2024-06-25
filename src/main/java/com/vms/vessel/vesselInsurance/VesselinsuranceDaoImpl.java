package com.vms.vessel.vesselInsurance;

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

import com.vms.crew.workLicense.WorkLicenseQueryUtil;



@Repository

public class VesselinsuranceDaoImpl implements VesselinsuranceDao{

	

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public VesselinsuranceResultBean save(VesselinsuranceBean bean) {
		VesselinsuranceResultBean resultBean = new VesselinsuranceResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			int code =  jdbcTemplate.queryForObject(VesselinsuranceQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(VesselinsuranceQueryUtil.get_desc,new Object[] { bean.getDescription() },Integer.class);

			
            if(code==0 && desc==0) {
            	
            
			Map<String, Object> vesselinsurance = new HashMap<String, Object>();
			
				vesselinsurance.put("userName", userDetails.getUsername());
				vesselinsurance.put("code", bean.getCode());
				vesselinsurance.put("desc", bean.getDescription());
				vesselinsurance.put("remarks", bean.getRemarks());

				namedParameterJdbcTemplate.update(VesselinsuranceQueryUtil.SAVE_vsl_insurance,vesselinsurance);
			
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
	public VesselinsuranceResultBean getList() {
		VesselinsuranceResultBean resultBean = new VesselinsuranceResultBean();
		List<VesselinsuranceBean> listBean = new ArrayList<VesselinsuranceBean>();
		
		try {
			listBean = jdbcTemplate.query(VesselinsuranceQueryUtil.getList,new BeanPropertyRowMapper<VesselinsuranceBean>(VesselinsuranceBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public VesselinsuranceResultBean edit(Integer id) {		
		VesselinsuranceResultBean resultBean = new VesselinsuranceResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(VesselinsuranceQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<VesselinsuranceBean>(VesselinsuranceBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public VesselinsuranceResultBean delete(Integer id) {
		VesselinsuranceResultBean resultBean = new VesselinsuranceResultBean();
		try {
			jdbcTemplate.update(VesselinsuranceQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public VesselinsuranceResultBean update(VesselinsuranceBean bean) {
		VesselinsuranceResultBean resultBean = new VesselinsuranceResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			String vesselinsurancecode =  jdbcTemplate.queryForObject(VesselinsuranceQueryUtil.vesselinsurance_code,new Object[] { bean.getVesselinsuranceid() },String.class);
			String vesselinsurancedesc =  jdbcTemplate.queryForObject(VesselinsuranceQueryUtil.vesselinsurance_desc,new Object[] { bean.getVesselinsuranceid() },String.class);


			int code =  jdbcTemplate.queryForObject(VesselinsuranceQueryUtil.get_code_edit,new Object[] { bean.getCode(),vesselinsurancecode },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(VesselinsuranceQueryUtil.get_desc_edit,new Object[] { bean.getDescription(),vesselinsurancedesc },Integer.class);

			
	        if(code==0 && desc==0) {
	        	
	        	
	        
			Map<String, Object> vesselinsurance = new HashMap<String, Object>();
			
				vesselinsurance.put("userName", userDetails.getUsername());
				vesselinsurance.put("code", bean.getCode());
				vesselinsurance.put("desc", bean.getDescription());
				vesselinsurance.put("remarks", bean.getRemarks());
				vesselinsurance.put("vesselinsuranceid", bean.getVesselinsuranceid());

			
					namedParameterJdbcTemplate.update(VesselinsuranceQueryUtil.UPDATE_vsl_insurance,vesselinsurance);
				
			
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
