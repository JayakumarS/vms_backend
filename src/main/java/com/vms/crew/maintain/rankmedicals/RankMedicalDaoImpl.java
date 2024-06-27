package com.vms.crew.maintain.rankmedicals;

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


@Repository
public class RankMedicalDaoImpl implements RankMedicalDao{

	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public RankMedicalResultBean getList() {
		RankMedicalResultBean resultBean = new RankMedicalResultBean();
		List<RankMedicalBean> listBean = new ArrayList<RankMedicalBean>();
		
		try {
			listBean = jdbcTemplate.query(RankMedicalQueryUtil.getList,new BeanPropertyRowMapper<RankMedicalBean>(RankMedicalBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	
	@Override
	public RankMedicalResultBean getsavelist() {
		RankMedicalResultBean resultBean = new RankMedicalResultBean();
		List<RankMedicalBean> listBean = new ArrayList<RankMedicalBean>();
		
		try {
			listBean = jdbcTemplate.query(RankMedicalQueryUtil.getListALL,new BeanPropertyRowMapper<RankMedicalBean>(RankMedicalBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public RankMedicalResultBean save(List<RankMedicalBean> selectedCertificates) {
		RankMedicalResultBean resultBean = new RankMedicalResultBean();

	    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	    try {
	    	 for (RankMedicalBean listBean : selectedCertificates) {
            jdbcTemplate.update(RankMedicalQueryUtil.DELETE_Medical_Rank, new Object[]{listBean.getRankcode()});
	    	 }
	        for (RankMedicalBean listBean1 : selectedCertificates) {
	            Map<String, Object> certificate = new HashMap<>();
	            certificate.put("code", listBean1.getMedicalcode());
	            certificate.put("desc", listBean1.getRankcode());
	            certificate.put("userName", userDetails.getUsername());

	            Integer rankCertificateId = jdbcTemplate.queryForObject(RankMedicalQueryUtil.checkDelete,
	                new Object[]{listBean1.getMedicalcode(), listBean1.getRankcode()}, Integer.class);

	            if (rankCertificateId == 0) {
	                namedParameterJdbcTemplate.update(RankMedicalQueryUtil.SAVE_Medical_Rank, certificate);
	            } else {

	                namedParameterJdbcTemplate.update(RankMedicalQueryUtil.SAVE_Medical_Rank, certificate);
	            
	            }
	        }

	        resultBean.setSuccess(true);
	    } catch (DataAccessException e) {
	        e.printStackTrace(); // Log the error instead of just printing stack trace
	        resultBean.setSuccess(false);
	    }
	    return resultBean;
	}

	@Override
	public List<RankMedicalBean> getrank() {
		List<RankMedicalBean> getrank = new ArrayList<>();

		try {
			getrank = jdbcTemplate.query(RankMedicalQueryUtil.getrank, new Object[] {},new BeanPropertyRowMapper<>(RankMedicalBean.class));

				

		} catch (Exception e) {
		}
		return getrank;
	}
	
}
