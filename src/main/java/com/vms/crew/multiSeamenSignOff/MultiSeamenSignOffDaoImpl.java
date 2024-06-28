package com.vms.crew.multiSeamenSignOff;

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
import org.springframework.transaction.annotation.Transactional;

import com.vms.crew.maintainRank.MaintainRankQueryUtil;

@Repository
public class MultiSeamenSignOffDaoImpl implements MultiSeamenSignOffDao{

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public  List<MultiSeamenSignOffBean> multiSemanlist(String date,String vessel ,Integer port) {
		 List<MultiSeamenSignOffBean> list = new ArrayList<>();

		try {
			int count =  jdbcTemplate.queryForObject(MultiSeamenSignOffQueryUtil.get_count,new Object[] { vessel,date,port },Integer.class);

if(count>0) {
	list = jdbcTemplate.query(MultiSeamenSignOffQueryUtil.GET_LIST_SIGN_OFF, new Object[] {vessel,date,port,vessel,date,port},
			new BeanPropertyRowMapper<>(MultiSeamenSignOffBean.class));
}
else {
			list = jdbcTemplate.query(MultiSeamenSignOffQueryUtil.GET_LIST, new Object[] {vessel,date,port},
					new BeanPropertyRowMapper<>(MultiSeamenSignOffBean.class));
}
		} catch (DataAccessException e) {
		}
		return list;
	}
	
	
	@Override
	@Transactional
	public boolean saveMultiSeamen(MultiSeamenSignOffBean multiSeamenSignOffBean) {
	    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	    try {
	    	
			int count =  jdbcTemplate.queryForObject(MultiSeamenSignOffQueryUtil.get_count,new Object[] { multiSeamenSignOffBean.getVessel(),multiSeamenSignOffBean.getFromdate(),multiSeamenSignOffBean.getJoinPort() },Integer.class);

			if(count==0) {
		    	Map<String, Object> multiSeamen = new HashMap<String, Object>();
				
		    	multiSeamen.put("userName", userDetails.getUsername());
		    	multiSeamen.put("fromdate", multiSeamenSignOffBean.getFromdate());
		    	multiSeamen.put("vessel", multiSeamenSignOffBean.getVessel());
		    	multiSeamen.put("signoffcode", multiSeamenSignOffBean.getSignoffCode());
		    	multiSeamen.put("port", multiSeamenSignOffBean.getJoinPort());

		    	Integer headerId=namedParameterJdbcTemplate.queryForObject(MultiSeamenSignOffQueryUtil.SAVE_MULTI_SEAMEN_HDR,multiSeamen,Integer.class);
		    	saveMultiSeamendetail(multiSeamenSignOffBean,headerId);

			}
			else {
				
//				jdbcTemplate.update(MultiSeamenSignOffQueryUtil.delete_hdr,multiSeamenSignOffBean.getSeamenId());
				jdbcTemplate.update(MultiSeamenSignOffQueryUtil.delete_dtl,multiSeamenSignOffBean.getSeamenId());

	Map<String, Object> multiSeamen = new HashMap<String, Object>();
	
	            multiSeamen.put("id", multiSeamenSignOffBean.getSeamenId());
		    	multiSeamen.put("userName", userDetails.getUsername());
		    	multiSeamen.put("fromdate", multiSeamenSignOffBean.getFromdate());
		    	multiSeamen.put("vessel", multiSeamenSignOffBean.getVessel());
		    	multiSeamen.put("signoffcode", multiSeamenSignOffBean.getSignoffCode());
		    	multiSeamen.put("port", multiSeamenSignOffBean.getJoinPort());

		    	Integer headerId=namedParameterJdbcTemplate.queryForObject(MultiSeamenSignOffQueryUtil.UPDATE_MULTI_SEAMEN_HDR,multiSeamen,Integer.class);
		    	saveMultiSeamendetail(multiSeamenSignOffBean,headerId);
				
			}
	    } catch (DataAccessException e) {
			e.printStackTrace();

	    }
	    return true;
	}

	
	@Override
	@Transactional
	public boolean saveMultiSeamendetail(MultiSeamenSignOffBean multiSeamenSignOffBean,Integer headerId) {
	    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	    try {
	    	
	
			
			
	        for (MultiSeamenSignOffBean signOffBean : multiSeamenSignOffBean.getTablerow()) {
		    	Map<String, Object> multiSeamen = new HashMap<String, Object>();
				
		    	multiSeamen.put("userName", userDetails.getUsername());
		    	multiSeamen.put("id", headerId);
		    	multiSeamen.put("code", signOffBean.getCode());
		    	multiSeamen.put("seman", signOffBean.getSeaman());
		    	multiSeamen.put("rank", signOffBean.getRank());
		    	multiSeamen.put("nation", signOffBean.getNationality());
		    	multiSeamen.put("jdate", signOffBean.getJoiningdate());
		    	multiSeamen.put("port", signOffBean.getPort());
		    	multiSeamen.put("est", signOffBean.getEstSignoff());
		    	
		    	multiSeamen.put("reason", signOffBean.getReason());
		    	multiSeamen.put("signoffDate", signOffBean.getSignOffDate());
		    	multiSeamen.put("signoffport", signOffBean.getSignoffport());

				namedParameterJdbcTemplate.update(MultiSeamenSignOffQueryUtil.SAVE_MULTI_SEAMEN_DTL,multiSeamen);
	        }
	    } catch (DataAccessException e) {
			System.out.print(e);

	    }
	    return true;
	}

	
}
