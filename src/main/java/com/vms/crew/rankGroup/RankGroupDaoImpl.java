package com.vms.crew.rankGroup;

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
public class RankGroupDaoImpl implements RankGroupDao {

	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public RankGroupResultBean save(RankGroupBean bean) {
		RankGroupResultBean resultBean = new RankGroupResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> rankgroup = new HashMap<String, Object>();
			
			for(RankGroupBean listBean : bean.getRankGroupDtls()) {
				rankgroup.put("userName", userDetails.getUsername());
				rankgroup.put("code", listBean.getCode());
				rankgroup.put("desc", listBean.getDescription());
				rankgroup.put("remarks", listBean.getRemarks());

				
				namedParameterJdbcTemplate.update(RankGroupQueryUtil.SAVE_rank_group,rankgroup);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public RankGroupResultBean getList() {
		RankGroupResultBean resultBean = new RankGroupResultBean();
		List<RankGroupBean> listBean = new ArrayList<RankGroupBean>();
		
		try {
			listBean = jdbcTemplate.query(RankGroupQueryUtil.getList,new BeanPropertyRowMapper<RankGroupBean>(RankGroupBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public RankGroupResultBean edit(String id) {		
		RankGroupResultBean resultBean = new RankGroupResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(RankGroupQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<RankGroupBean>(RankGroupBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public RankGroupResultBean delete(String id) {
		RankGroupResultBean resultBean = new RankGroupResultBean();
		try {
			jdbcTemplate.update(RankGroupQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public RankGroupResultBean update(RankGroupBean bean) {
		RankGroupResultBean resultBean = new RankGroupResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> rankgroup = new HashMap<String, Object>();
			
			for(RankGroupBean listBean : bean.getRankGroupDtls()) {
				rankgroup.put("userName", userDetails.getUsername());
				rankgroup.put("code", listBean.getCode());
				rankgroup.put("desc", listBean.getDescription());
				rankgroup.put("remarks", listBean.getRemarks());

				int k = jdbcTemplate.queryForObject(RankGroupQueryUtil.checkDelete, new Object[] { listBean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(RankGroupQueryUtil.SAVE_rank_group,rankgroup);
				}
				else {
					namedParameterJdbcTemplate.update(RankGroupQueryUtil.UPDATE_rank_group,rankgroup);
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