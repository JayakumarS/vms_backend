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
			Map<String, Object> maintainRank = new HashMap<String, Object>();
			
			for(MaintainRankBean listBean : bean.getMaintainRankBeanDtls()) {
				maintainRank.put("userName", userDetails.getUsername());
				maintainRank.put("code", listBean.getCode());
				maintainRank.put("description", listBean.getDescription());
				maintainRank.put("groupage", listBean.getGroupage());
				maintainRank.put("oAndt", listBean.getoAndt());
				maintainRank.put("department", listBean.getDepartment());
				maintainRank.put("sno", listBean.getSno());
				maintainRank.put("remarks", listBean.getRemarks());
				namedParameterJdbcTemplate.update(MaintainRankQueryUtil.SAVE_VESSEL_TYPE,maintainRank);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
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
	public MaintainRankResultBean edit(String id) {		
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
	public MaintainRankResultBean delete(String id) {
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
			Map<String, Object> maintainRank = new HashMap<String, Object>();
			
			for(MaintainRankBean listBean : bean.getMaintainRankBeanDtls()) {
				maintainRank.put("userName", userDetails.getUsername());
				maintainRank.put("code", listBean.getCode());
				maintainRank.put("description", listBean.getDescription());
				maintainRank.put("groupage", listBean.getGroupage());
				maintainRank.put("oAndt", listBean.getoAndt());
				maintainRank.put("department", listBean.getDepartment());
				maintainRank.put("sno", listBean.getSno());
				maintainRank.put("remarks", listBean.getRemarks());
				
				int k = jdbcTemplate.queryForObject(MaintainRankQueryUtil.checkDelete, new Object[] { listBean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(MaintainRankQueryUtil.SAVE_VESSEL_TYPE,maintainRank);
				}
				else {
					namedParameterJdbcTemplate.update(MaintainRankQueryUtil.UPDATE_VESSEL_TYPE,maintainRank);
				}
			}
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
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
