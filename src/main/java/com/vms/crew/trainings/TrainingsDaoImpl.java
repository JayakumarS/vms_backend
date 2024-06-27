package com.vms.crew.trainings;

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

import com.vms.crew.payTypes.PayTypesQueryUtil;
import com.vms.vessels.fleet.FleetQueryUtil;



@Repository
public class TrainingsDaoImpl implements TrainingsDao {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public TrainingsResultBean save(TrainingsBean bean) {
		TrainingsResultBean resultBean = new TrainingsResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			int code =  jdbcTemplate.queryForObject(TrainingsQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(TrainingsQueryUtil.get_desc,new Object[] { bean.getDescription() },Integer.class);
		    if(code==0 && desc==0) {
		    	
		   
			Map<String, Object> trainings = new HashMap<String, Object>();
			
			
				trainings.put("userName", userDetails.getUsername());
				trainings.put("code", bean.getCode());
				trainings.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(TrainingsQueryUtil.SAVE_trainings,trainings);
			
			
		   resultBean.setSuccess(true);
		    }
		    else {
		    	 resultBean.setMessage(  bean.getCode() +" already exists,please enter a different Training Code");

	  	        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public TrainingsResultBean getList() {
		TrainingsResultBean resultBean = new TrainingsResultBean();
		List<TrainingsBean> listBean = new ArrayList<TrainingsBean>();
		
		try {
			listBean = jdbcTemplate.query(TrainingsQueryUtil.getList,new BeanPropertyRowMapper<TrainingsBean>(TrainingsBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public TrainingsResultBean edit(Integer id) {		
		TrainingsResultBean resultBean = new TrainingsResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(TrainingsQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<TrainingsBean>(TrainingsBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public TrainingsResultBean delete(Integer id) {
		TrainingsResultBean resultBean = new TrainingsResultBean();
		String code = null; 
		try {
			
	    	code = jdbcTemplate.queryForObject(TrainingsQueryUtil.getCodeById, new Object[]{id}, String.class);

			jdbcTemplate.update(TrainingsQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		  catch (DataAccessException e) {
		        String errorMessage = e.getMessage();
		        if (errorMessage.contains("violates foreign key constraint")) {
		            resultBean.setSuccess(false);
		            resultBean.setMessage(code + " code cannot be deleted as it is already used in system.");
		        } else {
		            e.printStackTrace();
		            resultBean.setSuccess(false);
		            resultBean.setMessage(errorMessage);
		        }
		    }	
		return resultBean;
	}

	@Override
	public TrainingsResultBean update(TrainingsBean bean) {
		TrainingsResultBean resultBean = new TrainingsResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			String trainingcode =  jdbcTemplate.queryForObject(TrainingsQueryUtil.training_code,new Object[] { bean.getTrainingid() },String.class);
			String trainingdesc =  jdbcTemplate.queryForObject(TrainingsQueryUtil.training_desc,new Object[] { bean.getTrainingid() },String.class);


			int code =  jdbcTemplate.queryForObject(TrainingsQueryUtil.get_code_edit,new Object[] { bean.getCode(),trainingcode },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(TrainingsQueryUtil.get_desc_edit,new Object[] { bean.getDescription(),trainingdesc },Integer.class);
		    if(code==0 && desc==0) {
			Map<String, Object> trainings = new HashMap<String, Object>();
			
				trainings.put("userName", userDetails.getUsername());
				trainings.put("code", bean.getCode());
				trainings.put("desc", bean.getDescription());
				trainings.put("trainingid", bean.getTrainingid());
				
				namedParameterJdbcTemplate.update(TrainingsQueryUtil.UPDATE_trainings,trainings);
				
			
		   resultBean.setSuccess(true);
		    } 
		    else {
		 		   resultBean.setMessage( bean.getCode() +" already exists,please enter a different Training Code");

		        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

}
