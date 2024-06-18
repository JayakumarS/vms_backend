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
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
			for(WorkLicenseBean listBean : bean.getWorkLicenseBeanDtls()) {
				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("code", listBean.getCode());
				vesselType.put("desc", listBean.getDescription());
				namedParameterJdbcTemplate.update(WorkLicenseQueryUtil.SAVE_work_license,vesselType);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
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
	public WorkLicenseResultBean edit(String id) {		
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
	public WorkLicenseResultBean delete(String id) {
		WorkLicenseResultBean resultBean = new WorkLicenseResultBean();
		try {
			jdbcTemplate.update(WorkLicenseQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public WorkLicenseResultBean update(WorkLicenseBean bean) {
		WorkLicenseResultBean resultBean = new WorkLicenseResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
			for(WorkLicenseBean listBean : bean.getWorkLicenseBeanDtls()) {
				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("code", listBean.getCode());
				vesselType.put("desc", listBean.getDescription());
				
				int k = jdbcTemplate.queryForObject(WorkLicenseQueryUtil.checkDelete, new Object[] { listBean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(WorkLicenseQueryUtil.SAVE_work_license,vesselType);
				}
				else {
					namedParameterJdbcTemplate.update(WorkLicenseQueryUtil.UPDATE_work_license,vesselType);
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
