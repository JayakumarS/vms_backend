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
			Map<String, Object> vesselinsurance = new HashMap<String, Object>();
			
				vesselinsurance.put("userName", userDetails.getUsername());
				vesselinsurance.put("code", bean.getCode());
				vesselinsurance.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(VesselinsuranceQueryUtil.SAVE_vsl_insurance,vesselinsurance);
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
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
	public VesselinsuranceResultBean edit(String id) {		
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
	public VesselinsuranceResultBean delete(String id) {
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
			Map<String, Object> vesselinsurance = new HashMap<String, Object>();
			
				vesselinsurance.put("userName", userDetails.getUsername());
				vesselinsurance.put("code", bean.getCode());
				vesselinsurance.put("desc", bean.getDescription());
				
				int k = jdbcTemplate.queryForObject(VesselinsuranceQueryUtil.checkDelete, new Object[] { bean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(VesselinsuranceQueryUtil.SAVE_vsl_insurance,vesselinsurance);
				}
				else {
					namedParameterJdbcTemplate.update(VesselinsuranceQueryUtil.UPDATE_vsl_insurance,vesselinsurance);
				}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	
}
