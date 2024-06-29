package com.vms.master.vesselPrefix;

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

import com.vms.vessel.vesselOwner.VesselOwnerQueryUtil;


@Repository
public class VesselPrefixDaoImpl implements VesselPrefixDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public VesselPrefixResultBean save(VesselPrefixBean bean) {
		VesselPrefixResultBean resultBean = new VesselPrefixResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
       int code =  jdbcTemplate.queryForObject(VesselPrefixQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);


			
            if(code==0) {
            	
            	
            
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("code", bean.getCode());
				vesselType.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(VesselPrefixQueryUtil.SAVE_VESSEL_TYPE,vesselType);
			
			
				   resultBean.setSuccess(true);
  		  }
  		  else {
   	 		   resultBean.setMessage(  bean.getCode() +" already exists,please enter a different Vessel Prefix Code");

  	        }		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 		   resultBean.setMessage("Not Updated");

		}
		return resultBean;
	}

	@Override
	public VesselPrefixResultBean getList() {
		VesselPrefixResultBean resultBean = new VesselPrefixResultBean();
		List<VesselPrefixBean> listBean = new ArrayList<VesselPrefixBean>();
		
		try {
			listBean = jdbcTemplate.query(VesselPrefixQueryUtil.getList,new BeanPropertyRowMapper<VesselPrefixBean>(VesselPrefixBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public VesselPrefixResultBean edit(Integer id) {		
		VesselPrefixResultBean resultBean = new VesselPrefixResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(VesselPrefixQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<VesselPrefixBean>(VesselPrefixBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public VesselPrefixResultBean delete(Integer id) {
		VesselPrefixResultBean resultBean = new VesselPrefixResultBean();
		String code = null;

		try {
			
			code = jdbcTemplate.queryForObject(VesselPrefixQueryUtil.getCodeById, new Object[]{id}, String.class);

			jdbcTemplate.update(VesselPrefixQueryUtil.delete,id);
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
	public VesselPrefixResultBean update(VesselPrefixBean bean) {
		VesselPrefixResultBean resultBean = new VesselPrefixResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			String prefixcode =  jdbcTemplate.queryForObject(VesselPrefixQueryUtil.prefix_code,new Object[] { bean.getVesselprefixid() },String.class);



			int code =  jdbcTemplate.queryForObject(VesselPrefixQueryUtil.get_code_edit,new Object[] { bean.getCode(),prefixcode },Integer.class);


			if(code==0) {
			
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("code", bean.getCode());
				vesselType.put("desc", bean.getDescription());
				vesselType.put("vesselprefixid", bean.getVesselprefixid());

				
					namedParameterJdbcTemplate.update(VesselPrefixQueryUtil.UPDATE_VESSEL_TYPE,vesselType);
				
		
					   resultBean.setSuccess(true);
	  		  }
	  		  else {
		 		   resultBean.setMessage(  bean.getCode() +" already exists,please enter a different Vessel Prefix  Code");

	  	        }		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 		   resultBean.setMessage("Not Updated");

		}
		return resultBean;
	}
	
	

}
