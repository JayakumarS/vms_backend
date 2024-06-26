package com.vms.crew.maintain.interviewsetup;

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
public class InterviewSetupDaoImpl implements InterviewSetupDao {

	
	
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	
	
	@Override
	public InterviewSetupResultBean save(InterviewSetupBean bean) {
		InterviewSetupResultBean resultBean = new InterviewSetupResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {

		
			Map<String, Object> interviewSetup = new HashMap<String, Object>();
			
			
			interviewSetup.put("rank", bean.getRank());
			interviewSetup.put("userName", userDetails.getUsername());
			
			Integer interviewsetupid =namedParameterJdbcTemplate.queryForObject(InterviewSetupQueryUtil.SAVE_INTERVIEWSETUP_HDR,interviewSetup,Integer.class);
	
			savedetail(bean,interviewsetupid);
			
		   resultBean.setSuccess(true);
		   
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	
	@Override
	public InterviewSetupResultBean savedetail(InterviewSetupBean bean,Integer interviewsetupid) {
		InterviewSetupResultBean resultBean = new InterviewSetupResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> interviewSetup = new HashMap<String, Object>();
			
			for(InterviewSetupBean listBean : bean.getInterviewSetupBeanDtls()) {
				
				interviewSetup.put("userName", userDetails.getUsername());
				interviewSetup.put("interviewsetupid", interviewsetupid);
				interviewSetup.put("rank",listBean.getRank());
				interviewSetup.put("description", listBean.getDescription());
				
				namedParameterJdbcTemplate.update(InterviewSetupQueryUtil.SAVE_INTERVIEWSETUP_DTL,interviewSetup);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public InterviewSetupResultBean getList() {
		InterviewSetupResultBean resultBean = new InterviewSetupResultBean();
		List<InterviewSetupBean> listBean = new ArrayList<InterviewSetupBean>();
		
		try {
			listBean = jdbcTemplate.query(InterviewSetupQueryUtil.getList,new BeanPropertyRowMapper<InterviewSetupBean>(InterviewSetupBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public InterviewSetupResultBean edit(String id) {
		
		InterviewSetupResultBean resultBean = new InterviewSetupResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setInterviewSetupBean(jdbcTemplate.queryForObject(InterviewSetupQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<InterviewSetupBean>(InterviewSetupBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public InterviewSetupResultBean update(InterviewSetupBean bean) {
		InterviewSetupResultBean resultBean = new InterviewSetupResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			
			
			Map<String, Object> interviewSetup = new HashMap<String, Object>();
			
			interviewSetup.put("userName", userDetails.getUsername());
			interviewSetup.put("description", bean.getDescription());
			interviewSetup.put("rank", bean.getRank());
			namedParameterJdbcTemplate.update(InterviewSetupQueryUtil.UPDATE_INTERVIEWSETUP,interviewSetup);
				
			
		   resultBean.setSuccess(true);
	      
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	
	}

	@Override
	public InterviewSetupResultBean delete(String id) {
		InterviewSetupResultBean resultBean = new InterviewSetupResultBean();
		try {
			jdbcTemplate.update(InterviewSetupQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public List<InterviewSetupBean> getRankMasters() {
		List<InterviewSetupBean> lInterviewSetupBean = new ArrayList<InterviewSetupBean>();
		try {
			lInterviewSetupBean = jdbcTemplate.query(InterviewSetupQueryUtil.GET_RANK_MASTERS,new Object[]{},new BeanPropertyRowMapper<InterviewSetupBean>(InterviewSetupBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lInterviewSetupBean;
	}

	

}
