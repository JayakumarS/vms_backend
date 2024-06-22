package com.vms.vessel.vesselOwner;

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
public class VesselOwnerDaoImpl implements VesselOwnerDao{
	

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public VesselOwnerResultBean save(VesselOwnerBean bean) {
		VesselOwnerResultBean resultBean = new VesselOwnerResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> vesselowner = new HashMap<String, Object>();
			
				vesselowner.put("userName", userDetails.getUsername());
				vesselowner.put("code", bean.getCode());
				vesselowner.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(VesselOwnerQueryUtil.SAVE_vessel_owner,vesselowner);
			
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public VesselOwnerResultBean getList() {
		VesselOwnerResultBean resultBean = new VesselOwnerResultBean();
		List<VesselOwnerBean> listBean = new ArrayList<VesselOwnerBean>();
		
		try {
			listBean = jdbcTemplate.query(VesselOwnerQueryUtil.getList,new BeanPropertyRowMapper<VesselOwnerBean>(VesselOwnerBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public VesselOwnerResultBean edit(String id) {		
		VesselOwnerResultBean resultBean = new VesselOwnerResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(VesselOwnerQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<VesselOwnerBean>(VesselOwnerBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public VesselOwnerResultBean delete(String id) {
		VesselOwnerResultBean resultBean = new VesselOwnerResultBean();
		try {
			jdbcTemplate.update(VesselOwnerQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public VesselOwnerResultBean update(VesselOwnerBean bean) {
		VesselOwnerResultBean resultBean = new VesselOwnerResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> vesselowner = new HashMap<String, Object>();
			
				vesselowner.put("userName", userDetails.getUsername());
				vesselowner.put("code", bean.getCode());
				vesselowner.put("desc", bean.getDescription());
				
				int k = jdbcTemplate.queryForObject(VesselOwnerQueryUtil.checkDelete, new Object[] { bean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(VesselOwnerQueryUtil.SAVE_vessel_owner,vesselowner);
				}
				else {
					namedParameterJdbcTemplate.update(VesselOwnerQueryUtil.UPDATE_vessel_owner,vesselowner);
				}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	
}
