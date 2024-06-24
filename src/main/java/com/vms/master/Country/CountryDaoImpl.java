package com.vms.master.Country;

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

import com.vms.crew.healthStatus.HealthStatusQueryUtil;

@Repository
public class CountryDaoImpl implements CountryDao{

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public CountryResultBean saveCountry(CountryBean bean) {
		CountryResultBean resultBean = new CountryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			int code =  jdbcTemplate.queryForObject(CountryQueryUtil.get_code,new Object[] { bean.getCountryCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(CountryQueryUtil.get_name,new Object[] { bean.getCountryName() },Integer.class);

			
            if(code==0 && desc==0) {
			Map<String, Object> Country = new HashMap<String, Object>();
			
			Country.put("userName", userDetails.getUsername());
			Country.put("countryCode", bean.getCountryCode());
			Country.put("countryName", bean.getCountryName());
			Country.put("currencyCode", bean.getCurrencyCode());
			Country.put("phoneCode", bean.getPhoneCode());
			Country.put("nationality", bean.getNationality());
			Country.put("active", bean.isActive());
			
			namedParameterJdbcTemplate.update(CountryQueryUtil.SAVE_COUNTRY,Country);
            }else {
   	 		   resultBean.setMessage("These datails are already exist");

            }
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	@Override
	public CountryResultBean listCountry() {
		CountryResultBean resultBean = new CountryResultBean();
		List<CountryBean> listBean = new ArrayList<CountryBean>();
		
		try {
			listBean = jdbcTemplate.query(CountryQueryUtil.GET_COUNTRY_LIST,new BeanPropertyRowMapper<CountryBean>(CountryBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public CountryResultBean editCountry(Integer id) {		
		CountryResultBean resultBean = new CountryResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(CountryQueryUtil.GET_EDIT_COUNTRY,new Object[] { id }, new BeanPropertyRowMapper<CountryBean>(CountryBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	
	@Override
	public CountryResultBean deleteCountry(String id) {
		CountryResultBean resultBean = new CountryResultBean();
		try {
			jdbcTemplate.update(CountryQueryUtil.DELETE_COUNTRY,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public CountryResultBean updateCountry(CountryBean bean) {
		CountryResultBean resultBean = new CountryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> Country = new HashMap<String, Object>();
			
			Country.put("userName", userDetails.getUsername());
			Country.put("countryCode", bean.getCountryCode());
			Country.put("countryName", bean.getCountryName());
			Country.put("currencyCode", bean.getCurrencyCode());
			Country.put("phoneCode", bean.getPhoneCode());
			Country.put("nationality", bean.getNationality());
			Country.put("active", bean.isActive());
								
					namedParameterJdbcTemplate.update(CountryQueryUtil.UPDATE_COUNTRY,Country);
				
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}


}
