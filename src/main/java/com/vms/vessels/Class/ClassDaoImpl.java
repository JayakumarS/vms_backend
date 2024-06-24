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
			
			
			int code =  jdbcTemplate.queryForObject(ClassQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(ClassQueryUtil.get_desc,new Object[] { bean.getDescription() },Integer.class);

		    if(code==0 && desc==0) {
		    	
			Map<String, Object> fleet = new HashMap<String, Object>();
//			String ClassId =  jdbcTemplate.queryForObject(CertificatesQueryutil.get_class_Id,String.class);

		
				
				fleet.put("code", bean.getCode());
				fleet.put("desc", bean.getDescription());
				fleet.put("userName", userDetails.getUsername());
				namedParameterJdbcTemplate.update(ClassQueryUtil.SAVE_CLASS,fleet);
		
			
		   resultBean.setSuccess(true);
		 }
		  else {
	 		   resultBean.setMessage("These datails are already exist");

	        }
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
	public ClassResultBean edit(int id) {		
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
	public ClassResultBean delete(int id) {
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
			
			    fleet.put("classid", bean.getClassid());
				fleet.put("code", bean.getCode());
				fleet.put("desc", bean.getDescription());
				fleet.put("userName", userDetails.getUsername());
				
					namedParameterJdbcTemplate.update(ClassQueryUtil.UPDATE_CLASS,fleet);
				
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
}
