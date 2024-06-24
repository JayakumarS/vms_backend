package com.vms.vessels.wageScale;

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
public class WageScaleDaoImpl implements WageScaleDao{


@Autowired
NamedParameterJdbcTemplate namedParameterJdbcTemplate;

@Autowired
JdbcTemplate jdbcTemplate;

@Override
public WageScaleResultBean save(WageScaleBean bean) {
	WageScaleResultBean resultBean = new WageScaleResultBean();
	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
	try {
		Map<String, Object> wagescale = new HashMap<String, Object>();
		
			wagescale.put("userName", userDetails.getUsername());
			wagescale.put("code", bean.getCode());
			wagescale.put("desc", bean.getDescription());
			namedParameterJdbcTemplate.update(WageScaleQueryUtil.SAVE_WAGE,wagescale);
		
	   resultBean.setSuccess(true);
	}catch(Exception e) {
		e.printStackTrace();
		resultBean.setSuccess(false);
	}
	return resultBean;
}

@Override
public WageScaleResultBean getList() {
	WageScaleResultBean resultBean = new WageScaleResultBean();
	List<WageScaleBean> listBean = new ArrayList<WageScaleBean>();
	
	try {
		listBean = jdbcTemplate.query(WageScaleQueryUtil.getList,new BeanPropertyRowMapper<WageScaleBean>(WageScaleBean.class));
		resultBean.setList(listBean);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return resultBean;
}

@Override
public WageScaleResultBean edit(String id) {		
	WageScaleResultBean resultBean = new WageScaleResultBean();
	resultBean.setSuccess(false);
	try {
		resultBean.setList(jdbcTemplate.query(WageScaleQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<WageScaleBean>(WageScaleBean.class)));
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return resultBean; 
}

@Override
public WageScaleResultBean delete(String id) {
	WageScaleResultBean resultBean = new WageScaleResultBean();
	try {
		jdbcTemplate.update(WageScaleQueryUtil.delete,id);
		resultBean.setSuccess(true);
	}
	catch(Exception e) {
		e.printStackTrace();
		resultBean.setSuccess(false);
	}	
	return resultBean;
}

@Override
public WageScaleResultBean update(WageScaleBean bean) {
	WageScaleResultBean resultBean = new WageScaleResultBean();
	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
	try {
		Map<String, Object> wagescale = new HashMap<String, Object>();
		
			wagescale.put("userName", userDetails.getUsername());
			wagescale.put("code", bean.getCode());
			wagescale.put("desc", bean.getDescription());
			
			
				namedParameterJdbcTemplate.update(WageScaleQueryUtil.UPDATE_WAGE,wagescale);
			
	   resultBean.setSuccess(true);
	}catch(Exception e) {
		e.printStackTrace();
		resultBean.setSuccess(false);
	}
	return resultBean;
}
}