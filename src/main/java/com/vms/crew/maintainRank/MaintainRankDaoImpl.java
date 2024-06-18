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
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
			for(MaintainRankBean listBean : bean.getMaintainRankBeanDtls()) {
				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("code", listBean.getCode());
				vesselType.put("description", listBean.getDescription());
				vesselType.put("groupage", listBean.getGroupage());
				vesselType.put("oAndt", listBean.getoAndt());
				vesselType.put("department", listBean.getDepartment());
				vesselType.put("sno", listBean.getSno());
				vesselType.put("remarks", listBean.getRemarks());
				namedParameterJdbcTemplate.update(MaintainRankQueryUtil.SAVE_VESSEL_TYPE,vesselType);
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
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
			for(MaintainRankBean listBean : bean.getMaintainRankBeanDtls()) {
				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("code", listBean.getCode());
				vesselType.put("description", listBean.getDescription());
				vesselType.put("groupage", listBean.getGroupage());
				vesselType.put("oAndt", listBean.getoAndt());
				vesselType.put("department", listBean.getDepartment());
				vesselType.put("sno", listBean.getSno());
				vesselType.put("remarks", listBean.getRemarks());
				
				int k = jdbcTemplate.queryForObject(MaintainRankQueryUtil.checkDelete, new Object[] { listBean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(MaintainRankQueryUtil.SAVE_VESSEL_TYPE,vesselType);
				}
				else {
					namedParameterJdbcTemplate.update(MaintainRankQueryUtil.UPDATE_VESSEL_TYPE,vesselType);
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
