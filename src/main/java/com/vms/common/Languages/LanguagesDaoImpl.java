package com.vms.common.Languages;

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
public class LanguagesDaoImpl implements LanguagesDao{

	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public LanguagesResultBean save(LanguagesBean bean) {
		LanguagesResultBean resultBean = new LanguagesResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> fleet = new HashMap<String, Object>();
			
				
				fleet.put("code", bean.getCode());
				fleet.put("desc", bean.getDescription());
				fleet.put("userName", userDetails.getUsername());
				namedParameterJdbcTemplate.update(LanguagesQueryUtil.SAVE_LANG,fleet);
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public LanguagesResultBean getList() {
		LanguagesResultBean resultBean = new LanguagesResultBean();
		List<LanguagesBean> listBean = new ArrayList<LanguagesBean>();
		
		try {
			listBean = jdbcTemplate.query(LanguagesQueryUtil.getList,new BeanPropertyRowMapper<LanguagesBean>(LanguagesBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public LanguagesResultBean edit(String id) {		
		LanguagesResultBean resultBean = new LanguagesResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(LanguagesQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<LanguagesBean>(LanguagesBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public LanguagesResultBean delete(String id) {
		LanguagesResultBean resultBean = new LanguagesResultBean();
		try {
			jdbcTemplate.update(LanguagesQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public LanguagesResultBean update(LanguagesBean bean) {
		LanguagesResultBean resultBean = new LanguagesResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> fleet = new HashMap<String, Object>();
			
			
				fleet.put("code", bean.getCode());
				fleet.put("desc", bean.getDescription());
				fleet.put("userName", userDetails.getUsername());
				
					namedParameterJdbcTemplate.update(LanguagesQueryUtil.UPDATE_LANG,fleet);
				
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
}
