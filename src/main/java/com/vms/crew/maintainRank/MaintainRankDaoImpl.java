package com.vms.crew.maintainRank;

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



@Repository
public class MaintainRankDaoImpl implements MaintainRankDao{

	
	
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public MaintainRankResultBean save(MaintainRankBean bean) {
		MaintainRankResultBean resultBean = new MaintainRankResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			int code =  jdbcTemplate.queryForObject(MaintainRankQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(MaintainRankQueryUtil.get_desc,new Object[] { bean.getDescription() },Integer.class);

			
            if(code==0 && desc==0) {
            	
            	
            	
			Map<String, Object> maintainRank = new HashMap<String, Object>();
			
				maintainRank.put("userName", userDetails.getUsername());
				maintainRank.put("code", bean.getCode());
				maintainRank.put("description", bean.getDescription());
				maintainRank.put("groupage", bean.getGroupage());
				maintainRank.put("oAndt", bean.getoAndt());
				maintainRank.put("department", bean.getDepartment());
				maintainRank.put("sno", bean.getSno());
				maintainRank.put("remarks", bean.getRemarks());
				maintainRank.put("isActive", bean.getIsActive());

				namedParameterJdbcTemplate.update(MaintainRankQueryUtil.SAVE_VESSEL_TYPE,maintainRank);
			
			
		   resultBean.setSuccess(true);
		   
            }
    		  else {
    	 		   resultBean.setMessage("These details already exist");

    	        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 		resultBean.setMessage("Not Updated");

		}
		return resultBean;
	}

	@Override
	public MaintainRankResultBean getList() {
		MaintainRankResultBean resultBean = new MaintainRankResultBean();
		List<MaintainRankBean> listBean = new ArrayList<MaintainRankBean>();
		
		try {
			listBean = jdbcTemplate.query(MaintainRankQueryUtil.getList,new BeanPropertyRowMapper<MaintainRankBean>(MaintainRankBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public MaintainRankResultBean edit(Integer id) {		
		MaintainRankResultBean resultBean = new MaintainRankResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(MaintainRankQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<MaintainRankBean>(MaintainRankBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public MaintainRankResultBean delete(Integer id) {
		MaintainRankResultBean resultBean = new MaintainRankResultBean();
		try {
			jdbcTemplate.update(MaintainRankQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public MaintainRankResultBean update(MaintainRankBean bean) {
		MaintainRankResultBean resultBean = new MaintainRankResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			String maintainRankcode =  jdbcTemplate.queryForObject(MaintainRankQueryUtil.maintainRank_code,new Object[] { bean.getRankid() },String.class);
			String maintainRankdesc =  jdbcTemplate.queryForObject(MaintainRankQueryUtil.maintainRank_desc,new Object[] { bean.getRankid() },String.class);


			int code =  jdbcTemplate.queryForObject(MaintainRankQueryUtil.get_code_edit,new Object[] { bean.getCode(),maintainRankcode },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(MaintainRankQueryUtil.get_desc_edit,new Object[] { bean.getDescription(),maintainRankdesc },Integer.class);

			
            if(code==0 && desc==0) {
			
			Map<String, Object> maintainRank = new HashMap<String, Object>();
			
				maintainRank.put("userName", userDetails.getUsername());
				maintainRank.put("code", bean.getCode());
				maintainRank.put("description", bean.getDescription());
				maintainRank.put("groupage", bean.getGroupage());
				maintainRank.put("oAndt", bean.getoAndt());
				maintainRank.put("department", bean.getDepartment());
				maintainRank.put("sno", bean.getSno());
				maintainRank.put("remarks", bean.getRemarks());
				maintainRank.put("isActive", bean.getIsActive());
				maintainRank.put("rankid", bean.getRankid());

			
					namedParameterJdbcTemplate.update(MaintainRankQueryUtil.UPDATE_VESSEL_TYPE,maintainRank);
				
			
		   resultBean.setSuccess(true);
		   
      	  }
  		  else {
  	 		   resultBean.setMessage("These details already exist");

  	        }	
            
            
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 	    resultBean.setMessage("Not Updated");

		}
		return resultBean;
	}
	
	

	@Override
	public List<MaintainRankBean> getdepartment() {
		List<MaintainRankBean> department = new ArrayList<>();

		try {
			department = jdbcTemplate.query(MaintainRankQueryUtil.getdepartment, new Object[] {},new BeanPropertyRowMapper<>(MaintainRankBean.class));

				

		} catch (Exception e) {
		}
		return department;
	}
	
	@Override
	public List<MaintainRankBean> getgrouppage() {
		List<MaintainRankBean> getgrouppage = new ArrayList<>();

		try {
			getgrouppage = jdbcTemplate.query(MaintainRankQueryUtil.getgrouppage, new Object[] {},new BeanPropertyRowMapper<>(MaintainRankBean.class));

				

		} catch (Exception e) {
		}
		return getgrouppage;
	}
	
}
