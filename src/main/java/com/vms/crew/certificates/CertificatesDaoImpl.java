package com.vms.crew.certificates;

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
public class CertificatesDaoImpl implements CertificatesDao{

	

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public CertificatesResultBean save(CertificatesBean bean) {
		CertificatesResultBean resultBean = new CertificatesResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> healthStatus = new HashMap<String, Object>();
			
			for(CertificatesBean listBean : bean.getCertificatesBeanDtls()) {
				healthStatus.put("userName", userDetails.getUsername());
				healthStatus.put("code", listBean.getCode());
				healthStatus.put("desc", listBean.getDescription());
				namedParameterJdbcTemplate.update(CertificatesQueryutil.SAVE_certificates,healthStatus);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public CertificatesResultBean getList() {
		CertificatesResultBean resultBean = new CertificatesResultBean();
		List<CertificatesBean> listBean = new ArrayList<CertificatesBean>();
		
		try {
			listBean = jdbcTemplate.query(CertificatesQueryutil.getList,new BeanPropertyRowMapper<CertificatesBean>(CertificatesBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public CertificatesResultBean edit(String id) {		
		CertificatesResultBean resultBean = new CertificatesResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(CertificatesQueryutil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<CertificatesBean>(CertificatesBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public CertificatesResultBean delete(String id) {
		CertificatesResultBean resultBean = new CertificatesResultBean();
		try {
			jdbcTemplate.update(CertificatesQueryutil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public CertificatesResultBean update(CertificatesBean bean) {
		CertificatesResultBean resultBean = new CertificatesResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> healthStatus = new HashMap<String, Object>();
			
			for(CertificatesBean listBean : bean.getCertificatesBeanDtls()) {
				healthStatus.put("userName", userDetails.getUsername());
				healthStatus.put("code", listBean.getCode());
				healthStatus.put("desc", listBean.getDescription());
				
				int k = jdbcTemplate.queryForObject(CertificatesQueryutil.checkDelete, new Object[] { listBean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(CertificatesQueryutil.SAVE_certificates,healthStatus);
				}
				else {
					namedParameterJdbcTemplate.update(CertificatesQueryutil.UPDATE_certificates,healthStatus);
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
