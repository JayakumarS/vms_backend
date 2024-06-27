package com.vms.crew.crewPayrollCurrency;

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

public class CrewPayrollCurrencyDaoImpl implements CrewPayrollCurrencyDao{
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public CrewPayrollCurrencyResultBean save(CrewPayrollCurrencyBean bean) {
		CrewPayrollCurrencyResultBean resultBean = new CrewPayrollCurrencyResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
		
		    
			Map<String, Object> crewpayroll = new HashMap<String, Object>();
			
			crewpayroll.put("userName", userDetails.getUsername());
			crewpayroll.put("countryname", bean.getCountryname());
			crewpayroll.put("currencycode", bean.getCurrencycode());
			crewpayroll.put("validation", bean.getValidation());
				
				namedParameterJdbcTemplate.update(CrewPayrollCurrencyQueryUtil.save_country_data,crewpayroll);
			
			
		   resultBean.setSuccess(true);
		  
		
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public CrewPayrollCurrencyResultBean getList() {
		CrewPayrollCurrencyResultBean resultBean = new CrewPayrollCurrencyResultBean();
		List<CrewPayrollCurrencyBean> listBean = new ArrayList<CrewPayrollCurrencyBean>();
		
		try {
			listBean = jdbcTemplate.query(CrewPayrollCurrencyQueryUtil.get_country_list,new BeanPropertyRowMapper<CrewPayrollCurrencyBean>(CrewPayrollCurrencyBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
//
	@Override
	public CrewPayrollCurrencyResultBean edit(int id) {		
		CrewPayrollCurrencyResultBean resultBean = new CrewPayrollCurrencyResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(CrewPayrollCurrencyQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<CrewPayrollCurrencyBean>(CrewPayrollCurrencyBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	@Override
	public CrewPayrollCurrencyResultBean getCountry(String id) {		
		CrewPayrollCurrencyResultBean resultBean = new CrewPayrollCurrencyResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(CrewPayrollCurrencyQueryUtil.getCountry,new Object[] { id }, new BeanPropertyRowMapper<CrewPayrollCurrencyBean>(CrewPayrollCurrencyBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}


	@Override
	public CrewPayrollCurrencyResultBean delete(int id) {
		CrewPayrollCurrencyResultBean resultBean = new CrewPayrollCurrencyResultBean();
		try {
			jdbcTemplate.update(CrewPayrollCurrencyQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
	  catch (DataAccessException e) {
	        String errorMessage = e.getMessage();
	        if (errorMessage.contains("violates foreign key constraint")) {
	            resultBean.setSuccess(false);
	            resultBean.setMessage("Cannot delete this paytypeId because it is referenced in another table");
	        } else {
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMessage(errorMessage);
	        }
	    }	
		return resultBean;
	}

	@Override
	public CrewPayrollCurrencyResultBean update(CrewPayrollCurrencyBean bean) {
		CrewPayrollCurrencyResultBean resultBean = new CrewPayrollCurrencyResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
		
			Map<String, Object> crewpayroll = new HashMap<String, Object>();
			
		
			crewpayroll.put("userName", userDetails.getUsername());
			crewpayroll.put("countryname", bean.getCountryname());
			crewpayroll.put("currencycode", bean.getCurrencycode());
			crewpayroll.put("validation", bean.getValidation());
			crewpayroll.put("currencyid", bean.getCurrencyid());
			
				
				
			
				namedParameterJdbcTemplate.update(CrewPayrollCurrencyQueryUtil.Update,crewpayroll);
		
		
		   resultBean.setSuccess(true);
		    
		
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	
	}
}
