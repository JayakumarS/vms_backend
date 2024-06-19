package com.vms.crew.payTypes;

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
public class PayTypesDaoImpl implements PayTypesDao {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public PayTypesResultBean save(PayTypesBean bean) {
		PayTypesResultBean resultBean = new PayTypesResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> paytypes = new HashMap<String, Object>();
			
			for(PayTypesBean listBean : bean.getPayTypesBeanDtls()) {
				paytypes.put("userName", userDetails.getUsername());
				paytypes.put("code", listBean.getCode());
				paytypes.put("desc", listBean.getDescription());
				namedParameterJdbcTemplate.update(PayTypesQueryUtil.SAVE_pay_types,paytypes);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public PayTypesResultBean getList() {
		PayTypesResultBean resultBean = new PayTypesResultBean();
		List<PayTypesBean> listBean = new ArrayList<PayTypesBean>();
		
		try {
			listBean = jdbcTemplate.query(PayTypesQueryUtil.getList,new BeanPropertyRowMapper<PayTypesBean>(PayTypesBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public PayTypesResultBean edit(String id) {		
		PayTypesResultBean resultBean = new PayTypesResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(PayTypesQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<PayTypesBean>(PayTypesBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public PayTypesResultBean delete(String id) {
		PayTypesResultBean resultBean = new PayTypesResultBean();
		try {
			jdbcTemplate.update(PayTypesQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public PayTypesResultBean update(PayTypesBean bean) {
		PayTypesResultBean resultBean = new PayTypesResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> paytypes = new HashMap<String, Object>();
			
			for(PayTypesBean listBean : bean.getPayTypesBeanDtls()) {
				paytypes.put("userName", userDetails.getUsername());
				paytypes.put("code", listBean.getCode());
				paytypes.put("desc", listBean.getDescription());
				
				int k = jdbcTemplate.queryForObject(PayTypesQueryUtil.checkDelete, new Object[] { listBean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(PayTypesQueryUtil.SAVE_pay_types,paytypes);
				}
				else {
					namedParameterJdbcTemplate.update(PayTypesQueryUtil.UPDATE_pay_types,paytypes);
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
