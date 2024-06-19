package com.vms.master.currency;

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

import com.vms.master.vesselType.VesselTypeBean;
import com.vms.master.vesselType.VesselTypeQueryUtil;
import com.vms.master.vesselType.VesselTypeResultBean;


@Repository
public class CurrencyDaoImpl implements CurrencyDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired 
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public CurrencyResultBean save(CurrencyBean bean) {
		// TODO Auto-generated method stub
		CurrencyResultBean resultBean = new CurrencyResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> currency = new HashMap<String, Object>();
			

				
				if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
					bean.setActive("Y");
				} else {
					bean.setActive("N");
				}
				
				if(bean.getCurrency()!=null && bean.getCurrency().equalsIgnoreCase("true")) {
					bean.setCurrency("Y");
				} else {
					bean.setCurrency("N");
				}
				
				currency.put("userName", userDetails.getUsername());
				currency.put("code", bean.getCode());
				currency.put("name", bean.getName());
				currency.put("fromcurren", bean.getFromcurren());
				currency.put("tocurren",bean.getTocurren());
				currency.put("dvalue", bean.getDvalue());
				currency.put("fractpart", bean.getFractpart());
				currency.put("active", bean.getActive());
				currency.put("currency", bean.getCurrency());
				
				namedParameterJdbcTemplate.update(CurrencyQueryUtil.currency_save,currency);

			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	

	@Override
	public CurrencyResultBean getList() {
		// TODO Auto-generated method stub
		CurrencyResultBean resultBean = new CurrencyResultBean();
		List<CurrencyBean> listBean = new ArrayList<CurrencyBean>();
		
		try {
			listBean = jdbcTemplate.query(CurrencyQueryUtil.currency_list,new BeanPropertyRowMapper<CurrencyBean>(CurrencyBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public CurrencyResultBean edit(String id) {
		// TODO Auto-generated method stub
		CurrencyResultBean resultBean = new CurrencyResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setCurrencyBean(jdbcTemplate.queryForObject(CurrencyQueryUtil.currency_edit,new Object[] { id }, new BeanPropertyRowMapper<CurrencyBean>(CurrencyBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public CurrencyResultBean delete(String id) {
		// TODO Auto-generated method stub
		CurrencyResultBean resultBean = new CurrencyResultBean();
		try {
			jdbcTemplate.update(CurrencyQueryUtil.currency_delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public CurrencyResultBean update(CurrencyBean bean) {
		// TODO Auto-generated method stub
		CurrencyResultBean resultBean = new CurrencyResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> currency = new HashMap<String, Object>();
			
				
				if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
					bean.setActive("Y");
				} else {
					bean.setActive("N");
				}
				
				if(bean.getCurrency()!=null && bean.getCurrency().equalsIgnoreCase("true")) {
					bean.setCurrency("Y");
				} else {
					bean.setCurrency("N");
				}
				
				currency.put("userName", userDetails.getUsername());
				currency.put("code", bean.getCode());
				currency.put("name", bean.getName());
				currency.put("fromcurren", bean.getFromcurren());
				currency.put("tocurren",bean.getTocurren());
				currency.put("dvalue", bean.getDvalue());
				currency.put("fractpart", bean.getFractpart());
				currency.put("active", bean.getActive());
				currency.put("currency", bean.getCurrency());
				
				int k = jdbcTemplate.queryForObject(CurrencyQueryUtil.checkDelete, new Object[] { bean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(CurrencyQueryUtil.currency_save,currency);
				}
				else {
					namedParameterJdbcTemplate.update(CurrencyQueryUtil.currency_update,currency);
				}

		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	

}
