package com.vms.supplies.freightType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;



@Repository
public class FreightTypeDaoImpl implements FreightTypeDao {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public FreightTypeResultBean save(FreightTypeBean bean) {
		FreightTypeResultBean resultBean = new FreightTypeResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			int code =  jdbcTemplate.queryForObject(FreightTypeQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(FreightTypeQueryUtil.get_desc,new Object[] { bean.getDescription() },Integer.class);
		    
		    if(code==0 && desc==0) {
		    
			Map<String, Object> freighttype = new HashMap<String, Object>();
			
			freighttype.put("userName", userDetails.getUsername());
			freighttype.put("code", bean.getCode());
			freighttype.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(FreightTypeQueryUtil.SAVE_freight_type,freighttype);
			
			
		   resultBean.setSuccess(true);
		    }
		    
		    else {
 	 		   resultBean.setMessage(  bean.getCode() +" already exists,please enter a different Pay Type Code");

	  	        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}

	@Override
	public FreightTypeResultBean getList() {
		FreightTypeResultBean resultBean = new FreightTypeResultBean();
		List<FreightTypeBean> listBean = new ArrayList<FreightTypeBean>();
		
		try {
			listBean = jdbcTemplate.query(FreightTypeQueryUtil.getList,new BeanPropertyRowMapper<FreightTypeBean>(FreightTypeBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public FreightTypeResultBean edit(int id) {		
		FreightTypeResultBean resultBean = new FreightTypeResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(FreightTypeQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<FreightTypeBean>(FreightTypeBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public FreightTypeResultBean delete(int id) {
		FreightTypeResultBean resultBean = new FreightTypeResultBean();
		String code = null; 
		try {
	    	code = jdbcTemplate.queryForObject(FreightTypeQueryUtil.getCodeById, new Object[]{id}, String.class);

			
			jdbcTemplate.update(FreightTypeQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
	  catch (DataAccessException e) {
	        String errorMessage = e.getMessage();
	        if (errorMessage.contains("violates foreign key constraint")) {
	            resultBean.setSuccess(false);
	            resultBean.setMessage(code + " code cannot be deleted as it is already used in system.");
	        } else {
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMessage(errorMessage);
	        }
	    }	
		return resultBean;
	}

	@Override
	public FreightTypeResultBean update(FreightTypeBean bean) {
		FreightTypeResultBean resultBean = new FreightTypeResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			String freighttypecode =  jdbcTemplate.queryForObject(FreightTypeQueryUtil.freight_type_code,new Object[] { bean.getFreighttypeid() },String.class);
			String freighttypedesc =  jdbcTemplate.queryForObject(FreightTypeQueryUtil.freight_type_desc,new Object[] { bean.getFreighttypeid() },String.class);


			int code =  jdbcTemplate.queryForObject(FreightTypeQueryUtil.get_code_edit,new Object[] { bean.getCode(),freighttypecode },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(FreightTypeQueryUtil.get_desc_edit,new Object[] { bean.getDescription(),freighttypedesc },Integer.class);
		    if(code==0 && desc==0) {
			Map<String, Object> freighttype = new HashMap<String, Object>();
			
		
			freighttype.put("userName", userDetails.getUsername());
			freighttype.put("code", bean.getCode());
			freighttype.put("desc", bean.getDescription());
			freighttype.put("freighttypeid", bean.getFreighttypeid());
				
			
				namedParameterJdbcTemplate.update(FreightTypeQueryUtil.UPDATE_freight_type,freighttype);
			
		
		   resultBean.setSuccess(true);
		    }
		    else {
		 		   resultBean.setMessage( bean.getCode() +" already exists,please enter a different Pay Type Code");

		        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	

}
