package com.vms.crew.rankWorkingShift;

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

public class RankWorkingShiftDaoImpl implements RankWorkingShiftDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public RankWorkingShiftResultBean save(RankWorkingShiftBean bean) {
		RankWorkingShiftResultBean resultBean = new RankWorkingShiftResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> rankWorkingShift = new HashMap<String, Object>();
			
			for(RankWorkingShiftBean listBean : bean.getRankWorkingShiftBeanDtls()) {
				rankWorkingShift.put("userName", userDetails.getUsername());
				rankWorkingShift.put("vessel", listBean.getVessel());
				rankWorkingShift.put("rank", listBean.getRank());
				rankWorkingShift.put("sDate", listBean.getsDate());
				rankWorkingShift.put("eDate", listBean.geteDate());
				rankWorkingShift.put("remarks", listBean.getRemarks());
				
				namedParameterJdbcTemplate.update(RankWorkingShiftQueryUtil.SAVE_rank_Working_Shift_hdr,rankWorkingShift);
				
				savedetail(bean);
			}
		
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	@Override
	public RankWorkingShiftResultBean savedetail(RankWorkingShiftBean bean) {
		RankWorkingShiftResultBean resultBean = new RankWorkingShiftResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> rankWorkingShift = new HashMap<String, Object>();
			
			for(RankWorkingShiftBean listBean : bean.getSecondDetailRow()) {
				rankWorkingShift.put("userName", userDetails.getUsername());
				rankWorkingShift.put("shiftStart", listBean.getShiftStart());
				rankWorkingShift.put("shiftEnd", listBean.getShiftEnd());
				rankWorkingShift.put("place", listBean.getPlace());
				rankWorkingShift.put("watchKeeping", listBean.getWatchKeeping());
			
				
				namedParameterJdbcTemplate.update(RankWorkingShiftQueryUtil.SAVE_rank_Working_Shift_dtl,rankWorkingShift);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}


	@Override
	public RankWorkingShiftResultBean getList() {
		RankWorkingShiftResultBean resultBean = new RankWorkingShiftResultBean();
		List<RankWorkingShiftBean> listBean = new ArrayList<RankWorkingShiftBean>();
		
		try {
			listBean = jdbcTemplate.query(RankWorkingShiftQueryUtil.getList,new BeanPropertyRowMapper<RankWorkingShiftBean>(RankWorkingShiftBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public RankWorkingShiftResultBean edit(String id) {		
		RankWorkingShiftResultBean resultBean = new RankWorkingShiftResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(RankWorkingShiftQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<RankWorkingShiftBean>(RankWorkingShiftBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public RankWorkingShiftResultBean delete(String id) {
		RankWorkingShiftResultBean resultBean = new RankWorkingShiftResultBean();
		try {
			jdbcTemplate.update(RankWorkingShiftQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public RankWorkingShiftResultBean update(RankWorkingShiftBean bean) {
		RankWorkingShiftResultBean resultBean = new RankWorkingShiftResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> rankWorkingShift = new HashMap<String, Object>();
			
			for(RankWorkingShiftBean listBean : bean.getRankWorkingShiftBeanDtls()) {
				rankWorkingShift.put("userName", userDetails.getUsername());
				rankWorkingShift.put("vessel", listBean.getVessel());
				rankWorkingShift.put("rank", listBean.getRank());
				rankWorkingShift.put("sDate", listBean.getsDate());
				rankWorkingShift.put("eDate", listBean.geteDate());
				rankWorkingShift.put("remarks", listBean.getRemarks());
				
				int k = jdbcTemplate.queryForObject(RankWorkingShiftQueryUtil.checkDelete, new Object[] {  },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(RankWorkingShiftQueryUtil.SAVE_rank_Working_Shift_hdr,rankWorkingShift);
				}
				else {
					namedParameterJdbcTemplate.update(RankWorkingShiftQueryUtil.UPDATE_rank_Working_Shift_hdr,rankWorkingShift);
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
