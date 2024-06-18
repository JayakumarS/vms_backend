package com.vms.vessels.Class;

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
public class ClassDaoImpl implements ClassDao{


	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public ClassResultBean save(ClassBean bean) {
		ClassResultBean resultBean = new ClassResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> fleet = new HashMap<String, Object>();
			
			for(ClassBean listBean : bean.getClassDetails()) {
				
				fleet.put("code", listBean.getCode());
				fleet.put("desc", listBean.getDescription());
				fleet.put("userName", userDetails.getUsername());
				namedParameterJdbcTemplate.update(ClassQueryUtil.SAVE_CLASS,fleet);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public ClassResultBean getList() {
		ClassResultBean resultBean = new ClassResultBean();
		List<ClassBean> listBean = new ArrayList<ClassBean>();
		
		try {
			listBean = jdbcTemplate.query(ClassQueryUtil.getList,new BeanPropertyRowMapper<ClassBean>(ClassBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public ClassResultBean edit(String id) {		
		ClassResultBean resultBean = new ClassResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(ClassQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<ClassBean>(ClassBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public ClassResultBean delete(String id) {
		ClassResultBean resultBean = new ClassResultBean();
		try {
			jdbcTemplate.update(ClassQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public ClassResultBean update(ClassBean bean) {
		ClassResultBean resultBean = new ClassResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> fleet = new HashMap<String, Object>();
			
			for(ClassBean listBean : bean.getClassDetails()) {
				
				fleet.put("code", listBean.getCode());
				fleet.put("desc", listBean.getDescription());
				fleet.put("userName", userDetails.getUsername());
				int k = jdbcTemplate.queryForObject(ClassQueryUtil.checkDelete, new Object[] { listBean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(ClassQueryUtil.SAVE_CLASS,fleet);
				}
				else {
					namedParameterJdbcTemplate.update(ClassQueryUtil.UPDATE_CLASS,fleet);
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
