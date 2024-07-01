package com.vms.vessels.iceClass;

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
public class IceClassDaoImpl implements IceClassDao {
	

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public IceClassBean getSequenceCode() {
	    IceClassBean resultBean = new IceClassBean();

	    try {
	        Integer code = jdbcTemplate.queryForObject(IceClassQueryUtil.get_code, Integer.class);
	        resultBean.setCode(code);
	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();
	    }

	    return resultBean;
	}
	
	@Override
	public IceClassResultBean save(IceClassBean bean) {
		IceClassResultBean resultBean = new IceClassResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			Map<String, Object> iceclass = new HashMap<String, Object>();

			iceclass.put("userName", userDetails.getUsername());
			iceclass.put("code", bean.getCode());
			iceclass.put("desc", bean.getDesc());
			
			namedParameterJdbcTemplate.update(IceClassQueryUtil.save_ice,iceclass);
			
			
		   resultBean.setSuccess(true);
		   
         
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	@Override
	public IceClassResultBean getList() {
		IceClassResultBean resultBean = new IceClassResultBean();
		List<IceClassBean> iceclass = new ArrayList<IceClassBean>();
		
		try {
			iceclass = jdbcTemplate.query(IceClassQueryUtil.get_ice_list,new BeanPropertyRowMapper<IceClassBean>(IceClassBean.class));
			resultBean.setList(iceclass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public IceClassResultBean edit(Integer id) {		
		IceClassResultBean resultBean = new IceClassResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setIceClassBean(jdbcTemplate.queryForObject(IceClassQueryUtil.get_ice_edit,new Object[] { id }, new BeanPropertyRowMapper<IceClassBean>(IceClassBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	@Override
	public IceClassResultBean delete(Integer id) {
		IceClassResultBean resultBean = new IceClassResultBean();

		try {
			jdbcTemplate.update(IceClassQueryUtil.delete_ice,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			  String errorMessage = e.getMessage();
		        if (errorMessage.contains("violates foreign key constraint")) {
		            resultBean.setSuccess(false);
		            resultBean.setMsg("Cannot delete this UOM Id because it is referenced in another table");
		        } else {
		            e.printStackTrace();
		            resultBean.setSuccess(false);
		            resultBean.setMsg(errorMessage);
		        }
		}	
		return resultBean;
	}
	
	public IceClassResultBean update(IceClassBean bean) {
		IceClassResultBean resultBean = new IceClassResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> icebean = new HashMap<String, Object>();
			
				icebean.put("userName", userDetails.getUsername());
				icebean.put("code", bean.getCode());
				icebean.put("desc", bean.getDesc());
				icebean.put("iceId", bean.getIceId());

			
					namedParameterJdbcTemplate.update(IceClassQueryUtil.update_ice,icebean);
				
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

}
