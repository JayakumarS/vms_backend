package com.vms.vessels.shipManagers;

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

public class ShipManagersDaoImpl implements ShipManagersDao {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public ShipManagersResultBean save(ShipManagersBean bean) {
		ShipManagersResultBean resultBean = new ShipManagersResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> shipManagers = new HashMap<String, Object>();
			
			for(ShipManagersBean listBean : bean.getShipManagersBeanDtls()) {
				shipManagers.put("shipman", listBean.getShipman());
				shipManagers.put("name", listBean.getName());
				shipManagers.put("remarks", listBean.getRemarks());
				shipManagers.put("vatreg", listBean.getVatreg());
				shipManagers.put("userName", userDetails.getUsername());

				
				namedParameterJdbcTemplate.update(ShipManagersQueryUtil.SAVE_SHIP_MANAGERS,shipManagers);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public ShipManagersResultBean getList() {
		ShipManagersResultBean resultBean = new ShipManagersResultBean();
		List<ShipManagersBean> listBean = new ArrayList<ShipManagersBean>();
		
		try {
			listBean = jdbcTemplate.query(ShipManagersQueryUtil.getList,new BeanPropertyRowMapper<ShipManagersBean>(ShipManagersBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public ShipManagersResultBean edit(String id) {		
		ShipManagersResultBean resultBean = new ShipManagersResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(ShipManagersQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<ShipManagersBean>(ShipManagersBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public ShipManagersResultBean delete(String id) {
		ShipManagersResultBean resultBean = new ShipManagersResultBean();
		try {
			jdbcTemplate.update(ShipManagersQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public ShipManagersResultBean update(ShipManagersBean bean) {
		ShipManagersResultBean resultBean = new ShipManagersResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> shipManagers = new HashMap<String, Object>();
			
			for(ShipManagersBean listBean : bean.getShipManagersBeanDtls()) {
				shipManagers.put("shipman", listBean.getShipman());
				shipManagers.put("name", listBean.getName());
				shipManagers.put("remarks", listBean.getRemarks());
				shipManagers.put("vatreg", listBean.getVatreg());
				shipManagers.put("userName", userDetails.getUsername());
				
				int k = jdbcTemplate.queryForObject(ShipManagersQueryUtil.checkDelete, new Object[] { listBean.getShipman() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(ShipManagersQueryUtil.SAVE_SHIP_MANAGERS,shipManagers);
				}
				else {
					namedParameterJdbcTemplate.update(ShipManagersQueryUtil.UPDATE_VESSEL_TYPE,shipManagers);
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
