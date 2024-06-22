package com.vms.vessels.officialManagers;

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
public class OfficialManagersDaoImpl implements OfficialManagersDao{
	

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public OfficialManagersResultBean save(OfficialManagersBean bean) {
		OfficialManagersResultBean resultBean = new OfficialManagersResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> officialManagers = new HashMap<String, Object>();
			
			for(OfficialManagersBean listBean : bean.getOfficialManagersBeanDtls()) {
				officialManagers.put("code", listBean.getCode());
				officialManagers.put("description", listBean.getDescription());
				officialManagers.put("city", listBean.getCity());
				officialManagers.put("address", listBean.getAddress());
				officialManagers.put("poscode", listBean.getPoscode());
				officialManagers.put("phone", listBean.getPhone());
				officialManagers.put("remarks", listBean.getRemarks());
				officialManagers.put("blogofileName", listBean.getBlogofileName());
				officialManagers.put("blogofilePath", listBean.getBlogofilePath());
				officialManagers.put("plogofileName", listBean.getPlogofileName());
				officialManagers.put("plogofilePath", listBean.getPlogofilePath());
				officialManagers.put("userName", userDetails.getUsername());
				
				namedParameterJdbcTemplate.update(OfficialManagersQueryUtil.SAVE_OFFICIAL_MANAGERS,officialManagers);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public OfficialManagersResultBean getList() {
		OfficialManagersResultBean resultBean = new OfficialManagersResultBean();
		List<OfficialManagersBean> listBean = new ArrayList<OfficialManagersBean>();
		
		try {
			listBean = jdbcTemplate.query(OfficialManagersQueryUtil.getList,new BeanPropertyRowMapper<OfficialManagersBean>(OfficialManagersBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public OfficialManagersResultBean edit(String id) {		
		OfficialManagersResultBean resultBean = new OfficialManagersResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(OfficialManagersQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<OfficialManagersBean>(OfficialManagersBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public OfficialManagersResultBean delete(String id) {
		OfficialManagersResultBean resultBean = new OfficialManagersResultBean();
		try {
			jdbcTemplate.update(OfficialManagersQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public OfficialManagersResultBean update(OfficialManagersBean bean) {
		OfficialManagersResultBean resultBean = new OfficialManagersResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> officialManagers = new HashMap<String, Object>();
			
			for(OfficialManagersBean listBean : bean.getOfficialManagersBeanDtls()) {
				officialManagers.put("code", listBean.getCode());
				officialManagers.put("description", listBean.getDescription());
				officialManagers.put("city", listBean.getCity());
				officialManagers.put("address", listBean.getAddress());
				officialManagers.put("poscode", listBean.getPoscode());
				officialManagers.put("phone", listBean.getPhone());
				officialManagers.put("remarks", listBean.getRemarks());
				officialManagers.put("remarks", listBean.getRemarks());
				officialManagers.put("blogofileName", listBean.getBlogofileName());
				officialManagers.put("blogofilePath", listBean.getBlogofilePath());
				officialManagers.put("plogofileName", listBean.getPlogofileName());
				officialManagers.put("plogofilePath", listBean.getPlogofilePath());
				
				
				officialManagers.put("userName", userDetails.getUsername());

				
				
				int k = jdbcTemplate.queryForObject(OfficialManagersQueryUtil.checkDelete, new Object[] { listBean.getCode() },Integer.class);
				
				if(k == 0) {
				   namedParameterJdbcTemplate.update(OfficialManagersQueryUtil.SAVE_OFFICIAL_MANAGERS,officialManagers);
				}
				else {
					namedParameterJdbcTemplate.update(OfficialManagersQueryUtil.UPDATE_OFFICIAL_MANAGERS,officialManagers);
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
