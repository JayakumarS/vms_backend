package com.vms.crew.trainings;

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
			Map<String, Object> trainings = new HashMap<String, Object>();
			
			for(TrainingsBean listBean : bean.getTrainingsBeanDtls()) {
				trainings.put("userName", userDetails.getUsername());
				trainings.put("code", listBean.getCode());
				trainings.put("desc", listBean.getDescription());
				namedParameterJdbcTemplate.update(TrainingsQueryUtil.SAVE_trainings,trainings);
			}
			
		   resultBean.setSuccess(true);
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
	public TrainingsResultBean edit(String id) {		
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
	public TrainingsResultBean delete(String id) {
		TrainingsResultBean resultBean = new TrainingsResultBean();
		try {
			jdbcTemplate.update(TrainingsQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public TrainingsResultBean update(TrainingsBean bean) {
		TrainingsResultBean resultBean = new TrainingsResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> trainings = new HashMap<String, Object>();
			
			for(TrainingsBean listBean : bean.getTrainingsBeanDtls()) {
				trainings.put("userName", userDetails.getUsername());
				trainings.put("code", listBean.getCode());
				trainings.put("desc", listBean.getDescription());
				
				int k = jdbcTemplate.queryForObject(TrainingsQueryUtil.checkDelete, new Object[] { listBean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(TrainingsQueryUtil.SAVE_trainings,trainings);
				}
				else {
					namedParameterJdbcTemplate.update(TrainingsQueryUtil.UPDATE_trainings,trainings);
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
