package com.vms.master.department;

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
public class DepartmentDaoImpl implements DepartmentDao {
	

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired 
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public DepartmentResultBean save(DepartmentBean bean) {
		// TODO Auto-generated method stub
		DepartmentResultBean resultBean = new DepartmentResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> department = new HashMap<String, Object>();
				
				if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
					bean.setActive("Y");
				} else {
					bean.setActive("N");
				}
				
				department.put("userName", userDetails.getUsername());
				department.put("code", bean.getCode());
				department.put("name", bean.getName());
				department.put("head", bean.getHead());
				department.put("active", bean.getActive());
				
				namedParameterJdbcTemplate.update(DepartmentQueryUtil.department_save,department);
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	@Override
	public DepartmentResultBean getList() {
		// TODO Auto-generated method stub
		DepartmentResultBean resultBean = new DepartmentResultBean();
		List<DepartmentBean> listBean = new ArrayList<DepartmentBean>();
		
		try {
			listBean = jdbcTemplate.query(DepartmentQueryUtil.department_list,new BeanPropertyRowMapper<DepartmentBean>(DepartmentBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public DepartmentResultBean edit(String id) {
		// TODO Auto-generated method stub
		DepartmentResultBean resultBean = new DepartmentResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setDepartmentBean(jdbcTemplate.queryForObject(DepartmentQueryUtil.department_edit,new Object[] { id }, new BeanPropertyRowMapper<DepartmentBean>(DepartmentBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public DepartmentResultBean delete(String id) {
		// TODO Auto-generated method stub
		DepartmentResultBean resultBean = new DepartmentResultBean();
		try {
			jdbcTemplate.update(DepartmentQueryUtil.department_delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public DepartmentResultBean update(DepartmentBean bean) {
		// TODO Auto-generated method stub
		DepartmentResultBean resultBean = new DepartmentResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> department = new HashMap<String, Object>();
				
				if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
					bean.setActive("Y");
				} else {
					bean.setActive("N");
				}
				
				department.put("userName", userDetails.getUsername());
				department.put("code", bean.getCode());
				department.put("name", bean.getName());
				department.put("head", bean.getHead());
				department.put("active", bean.getActive());
				
				int k = jdbcTemplate.queryForObject(DepartmentQueryUtil.checkDelete, new Object[] { bean.getName() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(DepartmentQueryUtil.department_save,department);
				}
				else {
					namedParameterJdbcTemplate.update(DepartmentQueryUtil.department_update,department);
				}
				
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	

}
