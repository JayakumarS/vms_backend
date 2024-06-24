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
			int code =  jdbcTemplate.queryForObject(PayTypesQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(PayTypesQueryUtil.get_desc,new Object[] { bean.getDescription() },Integer.class);
		    
		    if(code==0 && desc==0) {
		    
			Map<String, Object> paytypes = new HashMap<String, Object>();
			
				paytypes.put("userName", userDetails.getUsername());
				paytypes.put("code", bean.getCode());
				paytypes.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(PayTypesQueryUtil.SAVE_pay_types,paytypes);
			
			
		   resultBean.setSuccess(true);
		    }
		    
		    else {
	  	 		   resultBean.setMessage("These details are already existed");

	  	        }
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
	public PayTypesResultBean edit(int id) {		
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
	public PayTypesResultBean delete(int id) {
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
			String paycode =  jdbcTemplate.queryForObject(PayTypesQueryUtil.paytype_code,new Object[] { bean.getPaytypeid() },String.class);
			String paydesc =  jdbcTemplate.queryForObject(PayTypesQueryUtil.paytype_desc,new Object[] { bean.getPaytypeid() },String.class);


			int code =  jdbcTemplate.queryForObject(PayTypesQueryUtil.get_code_edit,new Object[] { bean.getCode(),paycode },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(PayTypesQueryUtil.get_desc_edit,new Object[] { bean.getDescription(),paydesc },Integer.class);
		    if(code==0 && desc==0) {
			Map<String, Object> paytypes = new HashMap<String, Object>();
			
		
				paytypes.put("userName", userDetails.getUsername());
				paytypes.put("code", bean.getCode());
				paytypes.put("desc", bean.getDescription());
				paytypes.put("paytypeid", bean.getPaytypeid());
				
			
				namedParameterJdbcTemplate.update(PayTypesQueryUtil.UPDATE_pay_types,paytypes);
			
		
		   resultBean.setSuccess(true);
		    }
		    else {
 	 		   resultBean.setMessage("These details are already existed");

 	        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}


}
