package com.vms.master.vesselPrefix;

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
public class VesselPrefixDaoImpl implements VesselPrefixDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public VesselPrefixResultBean save(VesselPrefixBean bean) {
		VesselPrefixResultBean resultBean = new VesselPrefixResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
			for(VesselPrefixBean listBean : bean.getFirstDetailRow()) {
				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("code", listBean.getCode());
				vesselType.put("desc", listBean.getDescription());
				namedParameterJdbcTemplate.update(VesselPrefixQueryUtil.SAVE_VESSEL_TYPE,vesselType);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public VesselPrefixResultBean getList() {
		VesselPrefixResultBean resultBean = new VesselPrefixResultBean();
		List<VesselPrefixBean> listBean = new ArrayList<VesselPrefixBean>();
		
		try {
			listBean = jdbcTemplate.query(VesselPrefixQueryUtil.getList,new BeanPropertyRowMapper<VesselPrefixBean>(VesselPrefixBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public VesselPrefixResultBean edit(String id) {		
		VesselPrefixResultBean resultBean = new VesselPrefixResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(VesselPrefixQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<VesselPrefixBean>(VesselPrefixBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public VesselPrefixResultBean delete(String id) {
		VesselPrefixResultBean resultBean = new VesselPrefixResultBean();
		try {
			jdbcTemplate.update(VesselPrefixQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public VesselPrefixResultBean update(VesselPrefixBean bean) {
		VesselPrefixResultBean resultBean = new VesselPrefixResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
			for(VesselPrefixBean listBean : bean.getFirstDetailRow()) {
				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("code", listBean.getCode());
				vesselType.put("desc", listBean.getDescription());
				
				int k = jdbcTemplate.queryForObject(VesselPrefixQueryUtil.checkDelete, new Object[] { listBean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(VesselPrefixQueryUtil.SAVE_VESSEL_TYPE,vesselType);
				}
				else {
					namedParameterJdbcTemplate.update(VesselPrefixQueryUtil.UPDATE_VESSEL_TYPE,vesselType);
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
