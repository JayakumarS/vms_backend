package com.vms.master.vesselType;

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
public class VesselTypeDaoImpl implements VesselTypeDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public VesselTypeResultBean save(VesselTypeBean bean) {
		VesselTypeResultBean resultBean = new VesselTypeResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
			for(VesselTypeBean listBean : bean.getVesselTypeDtls()) {
				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("code", listBean.getCode());
				vesselType.put("desc", listBean.getDescription());
				namedParameterJdbcTemplate.update(VesselTypeQueryUtil.SAVE_VESSEL_TYPE,vesselType);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public VesselTypeResultBean getList() {
		VesselTypeResultBean resultBean = new VesselTypeResultBean();
		List<VesselTypeBean> listBean = new ArrayList<VesselTypeBean>();
		
		try {
			listBean = jdbcTemplate.query(VesselTypeQueryUtil.getList,new BeanPropertyRowMapper<VesselTypeBean>(VesselTypeBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public VesselTypeResultBean edit(String id) {		
		VesselTypeResultBean resultBean = new VesselTypeResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(VesselTypeQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<VesselTypeBean>(VesselTypeBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public VesselTypeResultBean delete(String id) {
		VesselTypeResultBean resultBean = new VesselTypeResultBean();
		try {
			jdbcTemplate.update(VesselTypeQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public VesselTypeResultBean update(VesselTypeBean bean) {
		VesselTypeResultBean resultBean = new VesselTypeResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
			for(VesselTypeBean listBean : bean.getVesselTypeDtls()) {
				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("code", listBean.getCode());
				vesselType.put("desc", listBean.getDescription());
				
				int k = jdbcTemplate.queryForObject(VesselTypeQueryUtil.checkDelete, new Object[] { listBean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(VesselTypeQueryUtil.SAVE_VESSEL_TYPE,vesselType);
				}
				else {
					namedParameterJdbcTemplate.update(VesselTypeQueryUtil.UPDATE_VESSEL_TYPE,vesselType);
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
