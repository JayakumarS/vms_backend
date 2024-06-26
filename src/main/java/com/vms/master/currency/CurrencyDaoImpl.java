package com.vms.master.currency;

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

import com.vms.crew.rankGroup.RankGroupQueryUtil;
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
			
		Integer i =  jdbcTemplate.queryForObject(CurrencyQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);
		Integer j =  jdbcTemplate.queryForObject(CurrencyQueryUtil.get_name,new Object[] { bean.getName() },Integer.class);
		    
		    if(i==0 && j==0) {
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
            	
            }
            else {
      		   resultBean.setMsg("These details already exist");

             }
			
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 		resultBean.setMsg("Not Updated");
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
	public CurrencyResultBean edit(Integer id) {
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
	public CurrencyResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		CurrencyResultBean resultBean = new CurrencyResultBean();
		try {
			jdbcTemplate.update(CurrencyQueryUtil.currency_delete,id);
			resultBean.setSuccess(true);
		}
		catch (DataAccessException e) {
	        String errorMessage = e.getMessage();
	        if (errorMessage.contains("violates foreign key constraint")) {
	            resultBean.setSuccess(false);
	            resultBean.setMsg("Cannot delete this CurrencyId because it is referenced in another table");
	        } else {
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMsg(errorMessage);
	        }
	    }
		return resultBean;
	}

	@Override
	public CurrencyResultBean update(CurrencyBean bean) {
		// TODO Auto-generated method stub
		CurrencyResultBean resultBean = new CurrencyResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
try {
			
			String currcode =  jdbcTemplate.queryForObject(CurrencyQueryUtil.cur_code,new Object[] { bean.getCurrencyId() },String.class);
			String currname =  jdbcTemplate.queryForObject(CurrencyQueryUtil.cur_name,new Object[] { bean.getCurrencyId() },String.class);

			
			
			int code =  jdbcTemplate.queryForObject(CurrencyQueryUtil.get_cur_edit,new Object[] { bean.getCode(),currcode },Integer.class);

		    int name =  jdbcTemplate.queryForObject(CurrencyQueryUtil.get_name_edit,new Object[] { bean.getName(),currname },Integer.class);

			
            if(code==0 && name==0) {
		    
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
			currency.put("currencyId", bean.getCurrencyId());
			currency.put("code", bean.getCode());
			currency.put("name", bean.getName());
			currency.put("fromcurren", bean.getFromcurren());
			currency.put("tocurren",bean.getTocurren());
			currency.put("dvalue", bean.getDvalue());
			currency.put("fractpart", bean.getFractpart());
			currency.put("active", bean.getActive());
			currency.put("currency", bean.getCurrency());
			
				namedParameterJdbcTemplate.update(CurrencyQueryUtil.currency_update,currency);
		
		   resultBean.setSuccess(true);
            }
            else {
     		   resultBean.setMsg("These details already exist");

            }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 		   resultBean.setMsg("Not Updated");

		}
		return resultBean;
	}
	

}
