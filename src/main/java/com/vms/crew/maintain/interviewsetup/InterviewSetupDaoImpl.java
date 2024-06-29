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
import org.springframework.transaction.annotation.Transactional;




@Transactional
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

			  int rank =  jdbcTemplate.queryForObject(InterviewSetupQueryUtil.get_rank,new Object[] { bean.getRank() },Integer.class);

				
	            if(rank==0) {
			Map<String, Object> interviewSetup = new HashMap<String, Object>();
			
			interviewSetup.put("rank", bean.getRank());
			interviewSetup.put("desc", bean.getDesc());
			interviewSetup.put("userName", userDetails.getUsername());
			
			Integer interviewsetupid =namedParameterJdbcTemplate.queryForObject(InterviewSetupQueryUtil.SAVE_INTERVIEWSETUP_HDR,interviewSetup,Integer.class);
	
			savedetail(bean,interviewsetupid);
			
		   resultBean.setSuccess(true);
	            }
	    		  else {
	    	 		   resultBean.setMessage( " already exists ");

	    	        }
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
			

			
			resultBean.setList(jdbcTemplate.query(InterviewSetupQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<InterviewSetupBean>(InterviewSetupBean.class)));
		
//			List<InterviewSetupBean> sampleDtl = jdbcTemplate.query(InterviewSetupQueryUtil.getEditDtl,new Object[] { id },new BeanPropertyRowMapper<InterviewSetupBean>(InterviewSetupBean.class));	
//			resultBean.setlInterviewSetupBean(sampleDtl);
		
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
	        Map<String, Object> interviewSetup = new HashMap<>();
	        interviewSetup.put("interviewsetupid", bean.getInterviewsetupid());
	        interviewSetup.put("userName", userDetails.getUsername());
	        interviewSetup.put("rank", bean.getRank());
	        interviewSetup.put("desc", bean.getDesc());

	      
	        Integer headerId = namedParameterJdbcTemplate.queryForObject(InterviewSetupQueryUtil.UPDATE_INTERVIEWSETUP_HDR, interviewSetup,Integer.class);

	        if(headerId !=null) {
	           
	            jdbcTemplate.update(InterviewSetupQueryUtil.delete_INTERVIEWSETUP_dtl, headerId);

	            for (InterviewSetupBean detailBean : bean.getInterviewSetupBeanDtls()) {
	                interviewSetup.put("description", detailBean.getDescription());
	                interviewSetup.put("interviewsetupid", headerId);
	                namedParameterJdbcTemplate.update(InterviewSetupQueryUtil.SAVE_INTERVIEWSETUP_DTL, interviewSetup);
	            }

	           
	        } 
	        
	        resultBean.setSuccess(true);
	    } catch (Exception e) {
	        e.printStackTrace();
	        resultBean.setSuccess(false);
	    }

	    return resultBean;
	}

	
	
	
	

	@Override
	public InterviewSetupResultBean delete(String id) {
		InterviewSetupResultBean resultBean = new InterviewSetupResultBean();
		try {
			
			 int interviewSetupId = Integer.parseInt(id);

			jdbcTemplate.update(InterviewSetupQueryUtil.delete_INTERVIEWSETUP_HDR,interviewSetupId);
			jdbcTemplate.update(InterviewSetupQueryUtil.delete_INTERVIEWSETUP_DTL,interviewSetupId);
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
