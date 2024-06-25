package com.vms.vessels.fleet;

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
public class FleetDaoImpl implements FleetDao{

	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public FleetResultBean save(FleetBean bean) {
		FleetResultBean resultBean = new FleetResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			int code =  jdbcTemplate.queryForObject(FleetQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(FleetQueryUtil.get_desc,new Object[] { bean.getDescription() },Integer.class);

		    if(code==0 && desc==0) {
			Map<String, Object> fleet = new HashMap<String, Object>();
			
				
				fleet.put("code", bean.getCode());
				fleet.put("desc", bean.getDescription());
				fleet.put("userName", userDetails.getUsername());
				namedParameterJdbcTemplate.update(FleetQueryUtil.SAVE_FLEET,fleet);
			
		   resultBean.setSuccess(true);
		    }
			  else {
		 		   resultBean.setMessage("These datails are already exist");

		        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public FleetResultBean getList() {
		FleetResultBean resultBean = new FleetResultBean();
		List<FleetBean> listBean = new ArrayList<FleetBean>();
		
		try {
			listBean = jdbcTemplate.query(FleetQueryUtil.getList,new BeanPropertyRowMapper<FleetBean>(FleetBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public FleetResultBean edit(int id) {		
		FleetResultBean resultBean = new FleetResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(FleetQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<FleetBean>(FleetBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public FleetResultBean delete(int id) {
	    FleetResultBean resultBean = new FleetResultBean();
	    try {
	        jdbcTemplate.update(FleetQueryUtil.delete, id);
	        resultBean.setSuccess(true);
	    } catch (DataAccessException e) {
	        String errorMessage = e.getMessage();
	        if (errorMessage.contains("violates foreign key constraint")) {
	            resultBean.setSuccess(false);
	            resultBean.setMessage("Cannot delete this fleet because it is referenced in another");
	        } else {
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMessage(errorMessage);
	        }
	    }
	    return resultBean;
	}

	@Override
	public FleetResultBean update(FleetBean bean) {
		FleetResultBean resultBean = new FleetResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			

			String fleetcode =  jdbcTemplate.queryForObject(FleetQueryUtil.fleet_code,new Object[] { bean.getFleetid() },String.class);
			String fleetdesc =  jdbcTemplate.queryForObject(FleetQueryUtil.fleet_desc,new Object[] { bean.getFleetid() },String.class);


			int code =  jdbcTemplate.queryForObject(FleetQueryUtil.get_code_edit,new Object[] { bean.getCode(),fleetcode },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(FleetQueryUtil.get_desc_edit,new Object[] { bean.getDescription(),fleetdesc },Integer.class);

			
	        if(code==0 && desc==0) {
			Map<String, Object> fleet = new HashMap<String, Object>();
			
			fleet.put("fleetid", bean.getFleetid());
				fleet.put("code", bean.getCode());
				fleet.put("desc", bean.getDescription());
				fleet.put("userName", userDetails.getUsername());
				
					namedParameterJdbcTemplate.update(FleetQueryUtil.UPDATE_FLEET,fleet);
			
		   resultBean.setSuccess(true);
	        }
			  else {
		 		   resultBean.setMessage("These details already exist");

		        }	 
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
}
