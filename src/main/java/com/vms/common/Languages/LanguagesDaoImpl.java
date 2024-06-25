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
			

			int code =  jdbcTemplate.queryForObject(LanguagesQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(LanguagesQueryUtil.get_desc,new Object[] { bean.getDescription() },Integer.class);

		    if(code==0 && desc==0) {
			Map<String, Object> fleet = new HashMap<String, Object>();
			
				if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
				bean.setActive("Y");
			} else {
				bean.setActive("N");
			}
				
				fleet.put("code", bean.getCode());
				fleet.put("desc", bean.getDescription());
				fleet.put("active", bean.getActive());
				fleet.put("userName", userDetails.getUsername());
				namedParameterJdbcTemplate.update(LanguagesQueryUtil.SAVE_LANG,fleet);
			
			
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
	public LanguagesResultBean edit(int id) {		
		LanguagesResultBean resultBean = new LanguagesResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setLanguagesBean(jdbcTemplate.queryForObject(LanguagesQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<LanguagesBean>(LanguagesBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public LanguagesResultBean delete(int id) {
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
			
			
			String languagecode =  jdbcTemplate.queryForObject(LanguagesQueryUtil.language_code,new Object[] { bean.getLanguageid() },String.class);
			String languagedesc =  jdbcTemplate.queryForObject(LanguagesQueryUtil.language_desc,new Object[] { bean.getLanguageid() },String.class);


			int code =  jdbcTemplate.queryForObject(LanguagesQueryUtil.get_code_edit,new Object[] { bean.getCode(),languagecode },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(LanguagesQueryUtil.get_desc_edit,new Object[] { bean.getDescription(),languagedesc },Integer.class);

			
	        if(code==0 && desc==0) {
			Map<String, Object> fleet = new HashMap<String, Object>();
			
			if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
				bean.setActive("Y");
			} else {
				bean.setActive("N");
			}
			  fleet.put("languageid", bean.getLanguageid());
				fleet.put("code", bean.getCode());
				fleet.put("desc", bean.getDescription());
				fleet.put("active", bean.getActive());
				fleet.put("userName", userDetails.getUsername());
//				int k = jdbcTemplate.queryForObject(LanguagesQueryUtil.checkDelete, new Object[] { bean.getCode() },Integer.class);
				
					namedParameterJdbcTemplate.update(LanguagesQueryUtil.UPDATE_LANG,fleet);

		    resultBean.setSuccess(true);
	        }
			  else {
		 		   resultBean.setMessage("These details already exist");

		        }	 
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
}
