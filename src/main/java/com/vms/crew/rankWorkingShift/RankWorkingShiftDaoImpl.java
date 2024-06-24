package com.vms.crew.rankWorkingShift;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
			
				rankWorkingShift.put("userName", userDetails.getUsername());
				rankWorkingShift.put("vessel", bean.getVessel());
				rankWorkingShift.put("rank", bean.getRank());
				rankWorkingShift.put("sDate", bean.getsDate());
				rankWorkingShift.put("eDate", bean.geteDate());
				rankWorkingShift.put("remarks", bean.getRemarks());
				rankWorkingShift.put("watchkeepers", bean.getWatchkeepers());
				
				

				
				
				namedParameterJdbcTemplate.update(RankWorkingShiftQueryUtil.SAVE_rank_shift_master,rankWorkingShift);
				
				savedetail(bean);
			
		
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
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");

            for (RankWorkingShiftBean listBean : bean.getSecondDetailRow()) {
                Map<String, Object> rankWorkingShift = new HashMap<>();

                rankWorkingShift.put("userName", userDetails.getUsername());

                String shiftStart = listBean.getShiftStart().replace('.', ':');
                String shiftEnd = listBean.getShiftEnd().replace('.', ':');

                try {
                    LocalTime shiftStartTime = LocalTime.parse(shiftStart, timeFormatter);
                    LocalTime shiftEndTime = LocalTime.parse(shiftEnd, timeFormatter);

                    rankWorkingShift.put("shiftStart", shiftStartTime);
                    rankWorkingShift.put("shiftEnd", shiftEndTime);
                } catch (DateTimeParseException e) {
                    throw new IllegalArgumentException("Invalid time format for shift start or end: " + e.getMessage());
                }

                rankWorkingShift.put("place", listBean.getPlace());
                rankWorkingShift.put("watchKeeping", listBean.getWatchKeeping());

                namedParameterJdbcTemplate.update(RankWorkingShiftQueryUtil.SAVE_rank_shift_dtl, rankWorkingShift);
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
	public RankWorkingShiftResultBean edit(int id) {		
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
	public RankWorkingShiftResultBean delete(int id) {
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
			
		
				rankWorkingShift.put("userName", userDetails.getUsername());
				rankWorkingShift.put("vessel", bean.getVessel());
				rankWorkingShift.put("rank", bean.getRank());
				rankWorkingShift.put("sDate", bean.getsDate());
				rankWorkingShift.put("eDate", bean.geteDate());
				rankWorkingShift.put("remarks", bean.getRemarks());
				rankWorkingShift.put("watchkeepers", bean.getWatchkeepers());
				
				
				int k = jdbcTemplate.queryForObject(RankWorkingShiftQueryUtil.checkDelete, new Object[] {bean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(RankWorkingShiftQueryUtil.SAVE_rank_shift_master,rankWorkingShift);
				}
				else {
					namedParameterJdbcTemplate.update(RankWorkingShiftQueryUtil.UPDATE_rank_Shift_dtl,rankWorkingShift);
				}
		
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

}
