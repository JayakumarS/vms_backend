package com.vms.crew.maintain.Medicals;

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
public class MedicalDaoImpl implements  MedicalDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	

	
	
	@Override
	public MedicalResultBean save(MedicalBean bean) {
		MedicalResultBean resultBean = new MedicalResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
           int code =  jdbcTemplate.queryForObject(MedicalQueryUtil.get_code,new Object[] { bean.getMcode() },Integer.class);

			
            if(code==0) {

			
           
			Map<String, Object> certificate = new HashMap<String, Object>();

			certificate.put("userName", userDetails.getUsername());
			certificate.put("code", bean.getMcode());
			certificate.put("desc", bean.getMdescription());

				namedParameterJdbcTemplate.update(MedicalQueryUtil.SAVE_medical,certificate);
			
			
		   resultBean.setSuccess(true);
            }
  		  else {
    	 		   resultBean.setMessage(  bean.getMcode() +" already exists,please enter a different Medical Type Code");

  	        }
         
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public MedicalResultBean getList() {
		MedicalResultBean resultBean = new MedicalResultBean();
		List<MedicalBean> listBean = new ArrayList<MedicalBean>();
		
		try {
			listBean = jdbcTemplate.query(MedicalQueryUtil.getList,new BeanPropertyRowMapper<MedicalBean>(MedicalBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public MedicalResultBean edit(Integer id) {		
		MedicalResultBean resultBean = new MedicalResultBean();
		resultBean.setSuccess(false);
		
		try {
			resultBean.setList(jdbcTemplate.query(MedicalQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<MedicalBean>(MedicalBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public MedicalResultBean delete(Integer id) {
		MedicalResultBean resultBean = new MedicalResultBean();
		String code = null;

		try {
			
			code = jdbcTemplate.queryForObject(MedicalQueryUtil.getCodeById, new Object[]{id}, String.class);

			jdbcTemplate.update(MedicalQueryUtil.delete,id);
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
	public MedicalResultBean update(MedicalBean bean) {
		MedicalResultBean resultBean = new MedicalResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {

			String maintaincode =  jdbcTemplate.queryForObject(MedicalQueryUtil.medical_code,new Object[] { bean.getMedicalId() },String.class);

			 int code =  jdbcTemplate.queryForObject(MedicalQueryUtil.get_code_edit,new Object[] { bean.getMcode(),maintaincode},Integer.class);

				
	            if(code==0) {

			Map<String, Object> medicals = new HashMap<String, Object>();
			
			    medicals.put("userName", userDetails.getUsername());
				medicals.put("code", bean.getMcode());
				medicals.put("desc", bean.getMdescription());
				medicals.put("medicalId", bean.getMedicalId());

			
					namedParameterJdbcTemplate.update(MedicalQueryUtil.UPDATE_medical,medicals);
				
			
		   resultBean.setSuccess(true);
		   
		   
	            }
	    		  else {
	   	 		   resultBean.setMessage(  bean.getMcode() +" already exists,please enter a different Medical Type Code");

	    	        }	
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

}
