package com.vms.crew.maintain.rankcertificates;

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
public class RankCertificatesDaoImpl implements RankCertificatesDao{

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public RankCertificatesResultBean getList() {
		RankCertificatesResultBean resultBean = new RankCertificatesResultBean();
		List<RankCertificatesBean> listBean = new ArrayList<RankCertificatesBean>();
		
		try {
			listBean = jdbcTemplate.query(RankCertificatesQueryUtil.getList,new BeanPropertyRowMapper<RankCertificatesBean>(RankCertificatesBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	
	@Override
	public RankCertificatesResultBean getsavelist() {
		RankCertificatesResultBean resultBean = new RankCertificatesResultBean();
		List<RankCertificatesBean> listBean = new ArrayList<RankCertificatesBean>();
		
		try {
			listBean = jdbcTemplate.query(RankCertificatesQueryUtil.getListALL,new BeanPropertyRowMapper<RankCertificatesBean>(RankCertificatesBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public RankCertificatesResultBean save(List<RankCertificatesBean> selectedCertificates) {
	    RankCertificatesResultBean resultBean = new RankCertificatesResultBean();

	    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	    try {
	    	 for (RankCertificatesBean listBean : selectedCertificates) {
            jdbcTemplate.update(RankCertificatesQueryUtil.DELETE, new Object[]{listBean.getRankcode()});
	    	 }
	        for (RankCertificatesBean listBean1 : selectedCertificates) {
	            Map<String, Object> certificate = new HashMap<>();
	            certificate.put("code", listBean1.getCertificatecode());
	            certificate.put("desc", listBean1.getRankcode());
	            certificate.put("userName", userDetails.getUsername());

	            Integer rankCertificateId = jdbcTemplate.queryForObject(RankCertificatesQueryUtil.checkDelete,
	                new Object[]{listBean1.getCertificatecode(), listBean1.getRankcode()}, Integer.class);

	            if (rankCertificateId == 0) {
	                namedParameterJdbcTemplate.update(RankCertificatesQueryUtil.SAVE, certificate);
	            } else {

	                namedParameterJdbcTemplate.update(RankCertificatesQueryUtil.SAVE, certificate);
	            
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
	public List<RankCertificatesBean> getrank() {
		List<RankCertificatesBean> getrank = new ArrayList<>();

		try {
			getrank = jdbcTemplate.query(RankCertificatesQueryUtil.getrank, new Object[] {},new BeanPropertyRowMapper<>(RankCertificatesBean.class));

				

		} catch (Exception e) {
		}
		return getrank;
	}

}
