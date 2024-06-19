package com.vms.master.UOM;

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
public class UOMDaoImpl implements UOMDao{

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public UOMResultBean saveUom(UOMBean bean) {
		UOMResultBean resultBean = new UOMResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> Country = new HashMap<String, Object>();
			
			Country.put("userName", userDetails.getUsername());
			Country.put("uomCode", bean.getUomCode());
			Country.put("uomName", bean.getUomName());
			
			namedParameterJdbcTemplate.update(UOMQueryUtil.SAVE_UOM,Country);
			
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	@Override
	public UOMResultBean listUom() {
		UOMResultBean resultBean = new UOMResultBean();
		List<UOMBean> listBean = new ArrayList<UOMBean>();
		
		try {
			listBean = jdbcTemplate.query(UOMQueryUtil.GET_UOM_LIST,new BeanPropertyRowMapper<UOMBean>(UOMBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public UOMResultBean editUom(String id) {		
		UOMResultBean resultBean = new UOMResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(UOMQueryUtil.GET_EDIT_UOM,new Object[] { id }, new BeanPropertyRowMapper<UOMBean>(UOMBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	
	@Override
	public UOMResultBean deleteUom(String id) {
		UOMResultBean resultBean = new UOMResultBean();
		try {
			jdbcTemplate.update(UOMQueryUtil.DELETE_UOM,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public UOMResultBean updateUom(UOMBean bean) {
		UOMResultBean resultBean = new UOMResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> Country = new HashMap<String, Object>();
			
			Country.put("userName", userDetails.getUsername());
			Country.put("uomCode", bean.getUomCode());
			Country.put("uomName", bean.getUomName());
								
				namedParameterJdbcTemplate.update(UOMQueryUtil.UPDATE_UOM,Country);
				
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
}
