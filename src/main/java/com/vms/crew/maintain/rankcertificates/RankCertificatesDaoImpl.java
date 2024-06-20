package com.vms.crew.maintain.rankcertificates;

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
	public RankCertificatesResultBean save(RankCertificatesBean bean) {
		RankCertificatesResultBean resultBean = new RankCertificatesResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
//		try {
//			Map<String, Object> healthStatus = new HashMap<String, Object>();
//			
//			for(HealthStatusBean listBean : bean.getHealthStatusBeanDtls()) {
//				healthStatus.put("userName", userDetails.getUsername());
//				healthStatus.put("code", listBean.getCode());
//				healthStatus.put("desc", listBean.getDescription());
//				namedParameterJdbcTemplate.update(HealthStatusQueryUtil.SAVE_health_status,healthStatus);
//			}
			
//		   resultBean.setSuccess(true);
//		}catch(Exception e) {
//			e.printStackTrace();
//			resultBean.setSuccess(false);
//		}
		return resultBean;
	}

}
