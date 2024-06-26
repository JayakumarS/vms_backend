package com.vms.crew.healthStatus;

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

import com.vms.crew.rankGroup.RankGroupQueryUtil;
import com.vms.vessel.vesselOwner.VesselOwnerQueryUtil;



@Repository
public class HealthStatusDaoImpl implements HealthStatusDao{

	
	

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public HealthStatusResultBean save(HealthStatusBean bean) {
		HealthStatusResultBean resultBean = new HealthStatusResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			int code =  jdbcTemplate.queryForObject(HealthStatusQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);


			
            if(code==0) {
            	
			Map<String, Object> healthStatus = new HashMap<String, Object>();
			
				healthStatus.put("userName", userDetails.getUsername());
				healthStatus.put("code", bean.getCode());
				healthStatus.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(HealthStatusQueryUtil.SAVE_health_status,healthStatus);
			
			
				   resultBean.setSuccess(true);
  		  }
  		  else {
	 		   resultBean.setMessage(  bean.getCode() +" already exists,please enter a different Health Status Code");

  	        }		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 		   resultBean.setMessage("Not Updated");

		}
		return resultBean;
	}

	@Override
	public HealthStatusResultBean getList() {
		HealthStatusResultBean resultBean = new HealthStatusResultBean();
		List<HealthStatusBean> listBean = new ArrayList<HealthStatusBean>();
		
		try {
			listBean = jdbcTemplate.query(HealthStatusQueryUtil.getList,new BeanPropertyRowMapper<HealthStatusBean>(HealthStatusBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public HealthStatusResultBean edit(Integer id) {		
		HealthStatusResultBean resultBean = new HealthStatusResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(HealthStatusQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<HealthStatusBean>(HealthStatusBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public HealthStatusResultBean delete(Integer id) {
		HealthStatusResultBean resultBean = new HealthStatusResultBean();
		String code = null;

		try {
			
			code = jdbcTemplate.queryForObject(HealthStatusQueryUtil.getCodeById, new Object[]{id}, String.class);

			jdbcTemplate.update(HealthStatusQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			 String errorMessage = e.getMessage();
		        if (errorMessage.contains("violates foreign key constraint")) {
		            resultBean.setSuccess(false);
		            resultBean.setMessage(code + " code cannot be deleted as it is already used in system.");
		            e.printStackTrace();
		            resultBean.setSuccess(false);
		            resultBean.setMessage("Error in Delete");
		        }
		}	
		return resultBean;
	}

	@Override
	public HealthStatusResultBean update(HealthStatusBean bean) {
		HealthStatusResultBean resultBean = new HealthStatusResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			


			String healthcode =  jdbcTemplate.queryForObject(HealthStatusQueryUtil.health_code,new Object[] { bean.getHealthstatusid() },String.class);
			String healthdesc =  jdbcTemplate.queryForObject(HealthStatusQueryUtil.health_desc,new Object[] { bean.getHealthstatusid() },String.class);


			int code =  jdbcTemplate.queryForObject(HealthStatusQueryUtil.get_code_edit,new Object[] { bean.getCode(),healthcode },Integer.class);


			
            if(code==0) {
			Map<String, Object> healthStatus = new HashMap<String, Object>();
			
				healthStatus.put("userName", userDetails.getUsername());
				healthStatus.put("code", bean.getCode());
				healthStatus.put("desc", bean.getDescription());
				healthStatus.put("healthstatusid", bean.getHealthstatusid());

			
					namedParameterJdbcTemplate.update(HealthStatusQueryUtil.UPDATE_health_status,healthStatus);
				
					   resultBean.setSuccess(true);
    		  }
    		  else {
   	 		   resultBean.setMessage(  bean.getCode() +" already exists,please enter a different Health Status Code");

    	        }			}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 		   resultBean.setMessage("Not Updated");

		}
		return resultBean;
	}
	
	
	
}
