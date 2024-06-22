package com.vms.crew.workStatus;

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
public class WorkStatusDaoImpl implements WorkStatusDao{


	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public WorkStatusResultBean save(WorkStatusBean bean) {
		WorkStatusResultBean resultBean = new WorkStatusResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> workStatus = new HashMap<String, Object>();
			
			workStatus.put("userName", userDetails.getUsername());
			workStatus.put("code", bean.getCode());
			workStatus.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(WorkStatusQueryUtil.SAVE_work_status,workStatus);
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public WorkStatusResultBean getList() {
		WorkStatusResultBean resultBean = new WorkStatusResultBean();
		List<WorkStatusBean> listBean = new ArrayList<WorkStatusBean>();
		
		try {
			listBean = jdbcTemplate.query(WorkStatusQueryUtil.getList,new BeanPropertyRowMapper<WorkStatusBean>(WorkStatusBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public WorkStatusResultBean edit(String id) {		
		WorkStatusResultBean resultBean = new WorkStatusResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(WorkStatusQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<WorkStatusBean>(WorkStatusBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public WorkStatusResultBean delete(String id) {
		WorkStatusResultBean resultBean = new WorkStatusResultBean();
		try {
			jdbcTemplate.update(WorkStatusQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public WorkStatusResultBean update(WorkStatusBean bean) {
		WorkStatusResultBean resultBean = new WorkStatusResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> workStatus = new HashMap<String, Object>();
			
				workStatus.put("userName", userDetails.getUsername());
				workStatus.put("code", bean.getCode());
				workStatus.put("desc", bean.getDescription());
				
				int k = jdbcTemplate.queryForObject(WorkStatusQueryUtil.checkDelete, new Object[] { bean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(WorkStatusQueryUtil.SAVE_work_status,workStatus);
				}
				else {
					namedParameterJdbcTemplate.update(WorkStatusQueryUtil.UPDATE_work_status,workStatus);
				}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
}
