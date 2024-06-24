package com.vms.crew.maintain.religion;

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
public class ReligionDaoImpl implements ReligionDao {

	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	
	
	
	
	
	
	
	@Override
	public ReligionResultBean save(ReligionBean bean) {
		ReligionResultBean resultBean = new ReligionResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
			if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
				bean.setActive("Y");
			} else {
				bean.setActive("N");
			}
		
				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("code", bean.getCode());
				vesselType.put("name", bean.getName());
				vesselType.put("active", bean.getActive());
				namedParameterJdbcTemplate.update(ReligionQueryUtil.SAVE_RELIGION_TYPE,vesselType);
			
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public ReligionResultBean getList() {
		
		ReligionResultBean resultBean = new ReligionResultBean();
		List<ReligionBean> listBean = new ArrayList<ReligionBean>();
		
		try {
			listBean = jdbcTemplate.query(ReligionQueryUtil.getList,new BeanPropertyRowMapper<ReligionBean>(ReligionBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public ReligionResultBean edit(String id) {
		
		ReligionResultBean resultBean = new ReligionResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setReligionBean(jdbcTemplate.queryForObject(ReligionQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<ReligionBean>(ReligionBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public ReligionResultBean update(ReligionBean bean) {
		ReligionResultBean resultBean = new ReligionResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
			if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
				bean.setActive("Y");
			} else {
				bean.setActive("N");
			}

				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("code", bean.getCode());
				vesselType.put("name", bean.getName());
				vesselType.put("active", bean.getActive());
				
				int k = jdbcTemplate.queryForObject(ReligionQueryUtil.checkDelete, new Object[] { bean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(ReligionQueryUtil.SAVE_RELIGION_TYPE,vesselType);
				}
				else {
					namedParameterJdbcTemplate.update(ReligionQueryUtil.UPDATE_RELIGION_TYPE,vesselType);
				}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public ReligionResultBean delete(String id) {
		
		ReligionResultBean resultBean = new ReligionResultBean();
		try {
			jdbcTemplate.update(ReligionQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	

}
