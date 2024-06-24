package com.vms.crew.maintain.bloodgroup;

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

import com.vms.master.department.DepartmentBean;
import com.vms.master.department.DepartmentQueryUtil;



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
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
			if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
				bean.setActive("Y");
			} else {
				bean.setActive("N");
			}
		
				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("bloodGroupCode", bean.getBloodGroupCode());
				vesselType.put("name", bean.getName());
				vesselType.put("active", bean.getActive());
				namedParameterJdbcTemplate.update(BloodGroupQueryUtil.SAVE_RELIGION_TYPE,vesselType);
			
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
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
			resultBean.setBloodGroupBean(jdbcTemplate.queryForObject(BloodGroupQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<BloodGroupBean>(BloodGroupBean.class)));
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
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
			if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
				bean.setActive("Y");
			} else {
				bean.setActive("N");
			}

				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("bloodGroupCode", bean.getBloodGroupCode());
				vesselType.put("name", bean.getName());
				vesselType.put("active", bean.getActive());
				
				int k = jdbcTemplate.queryForObject(BloodGroupQueryUtil.checkDelete, new Object[] { bean.getBloodGroupCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(BloodGroupQueryUtil.SAVE_RELIGION_TYPE,vesselType);
				}
				else {
					namedParameterJdbcTemplate.update(BloodGroupQueryUtil.UPDATE_RELIGION_TYPE,vesselType);
				}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
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

}
