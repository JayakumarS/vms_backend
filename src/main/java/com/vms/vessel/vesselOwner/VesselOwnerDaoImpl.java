package com.vms.vessel.vesselOwner;

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
import com.vms.crew.rankGroup.RankGroupQueryUtil;



@Repository
public class VesselOwnerDaoImpl implements VesselOwnerDao{
	

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public VesselOwnerResultBean save(VesselOwnerBean bean) {
		VesselOwnerResultBean resultBean = new VesselOwnerResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {

			int code =  jdbcTemplate.queryForObject(VesselOwnerQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(VesselOwnerQueryUtil.get_desc,new Object[] { bean.getDescription() },Integer.class);

			
            if(code==0 && desc==0) {
            	
            
			Map<String, Object> vesselowner = new HashMap<String, Object>();
			
				vesselowner.put("userName", userDetails.getUsername());
				vesselowner.put("code", bean.getCode());
				vesselowner.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(VesselOwnerQueryUtil.SAVE_vessel_owner,vesselowner);
			
			
		   resultBean.setSuccess(true);
		  }
		  else {
 	 		   resultBean.setMessage(  bean.getCode() +" already exists,please enter a different Vessel Owner Code");

	        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 		   resultBean.setMessage("Not Updated");

		}
		return resultBean;
	}

	@Override
	public VesselOwnerResultBean getList() {
		VesselOwnerResultBean resultBean = new VesselOwnerResultBean();
		List<VesselOwnerBean> listBean = new ArrayList<VesselOwnerBean>();
		
		try {
			listBean = jdbcTemplate.query(VesselOwnerQueryUtil.getList,new BeanPropertyRowMapper<VesselOwnerBean>(VesselOwnerBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public VesselOwnerResultBean edit(Integer id) {		
		VesselOwnerResultBean resultBean = new VesselOwnerResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(VesselOwnerQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<VesselOwnerBean>(VesselOwnerBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public VesselOwnerResultBean delete(Integer id) {
		VesselOwnerResultBean resultBean = new VesselOwnerResultBean();
		String code = null;

		try {
			
			code = jdbcTemplate.queryForObject(VesselOwnerQueryUtil.getCodeById, new Object[]{id}, String.class);

			jdbcTemplate.update(VesselOwnerQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			 String errorMessage = e.getMessage();
		        if (errorMessage.contains("violates foreign key constraint")) {
		            resultBean.setSuccess(false);
		            resultBean.setMessage(code + " code cannot be deleted as it is already used in system.");
		        } else {
		            e.printStackTrace();
		            resultBean.setSuccess(false);
		            resultBean.setMessage("Error in Delete");
		        }
		}	
		return resultBean;
	}

	@Override
	public VesselOwnerResultBean update(VesselOwnerBean bean) {
		VesselOwnerResultBean resultBean = new VesselOwnerResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			String vesselcode =  jdbcTemplate.queryForObject(VesselOwnerQueryUtil.vessel_code,new Object[] { bean.getVesselownerid() },String.class);



			int code =  jdbcTemplate.queryForObject(VesselOwnerQueryUtil.get_code_edit,new Object[] { bean.getCode(),vesselcode },Integer.class);


			
            if(code==0) {
            	
			Map<String, Object> vesselowner = new HashMap<String, Object>();
			
				vesselowner.put("userName", userDetails.getUsername());
				vesselowner.put("code", bean.getCode());
				vesselowner.put("desc", bean.getDescription());
				vesselowner.put("vesselownerid", bean.getVesselownerid());

				
				
			
					namedParameterJdbcTemplate.update(VesselOwnerQueryUtil.UPDATE_vessel_owner,vesselowner);
				
			
					   resultBean.setSuccess(true);
  		  }
  		  else {
	 		   resultBean.setMessage(  bean.getCode() +" already exists,please enter a different Vessel Owner Code");

  	        }
            }catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 		   resultBean.setMessage("Not Updated");

		}
		return resultBean;
	}
	
	
}
