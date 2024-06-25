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
			
		
				officialManagers.put("code", bean.getCode());
				officialManagers.put("description", bean.getDescription());
				officialManagers.put("city", bean.getCity());
				officialManagers.put("address", bean.getAddress());
				officialManagers.put("poscode", bean.getPoscode());
				officialManagers.put("phone", bean.getPhone());
				officialManagers.put("remarks", bean.getRemarks());
				officialManagers.put("blogofileName", bean.getBlogofileName());
				officialManagers.put("blogofilePath", bean.getBlogofilePath());
				officialManagers.put("plogofileName", bean.getPlogofileName());
				officialManagers.put("plogofilePath", bean.getPlogofilePath());
				officialManagers.put("userName", userDetails.getUsername());
				
				namedParameterJdbcTemplate.update(OfficialManagersQueryUtil.SAVE_OFFICIAL_MANAGERS,officialManagers);
			
			
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
	public OfficialManagersResultBean edit(Integer id) {		
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
	public OfficialManagersResultBean delete(Integer id) {
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
			String offmanagercode =  jdbcTemplate.queryForObject(OfficialManagersQueryUtil.offmanager_code,new Object[] { bean.getOffmanagerid() },String.class);
			String offmanagername =  jdbcTemplate.queryForObject(OfficialManagersQueryUtil.name_desc,new Object[] { bean.getOffmanagerid() },String.class);

			
			int code =  jdbcTemplate.queryForObject(OfficialManagersQueryUtil.get_code_edit,new Object[] { bean.getCode(),offmanagercode },int.class);

		    int description =  jdbcTemplate.queryForObject(OfficialManagersQueryUtil.get_name_edit,new Object[] { bean.getDescription(),offmanagername },int.class);
		    if(code == 0 && description == 0) {
			
			Map<String, Object> officialManagers = new HashMap<String, Object>();
			
		     	officialManagers.put("offmanagerid", bean.getOffmanagerid());
				officialManagers.put("code", bean.getCode());
				officialManagers.put("description", bean.getDescription());
				officialManagers.put("city", bean.getCity());
				officialManagers.put("address", bean.getAddress());
				officialManagers.put("poscode", bean.getPoscode());
				officialManagers.put("phone", bean.getPhone());
				officialManagers.put("remarks", bean.getRemarks());
				officialManagers.put("remarks", bean.getRemarks());
				officialManagers.put("blogofileName", bean.getBlogofileName());
				officialManagers.put("blogofilePath", bean.getBlogofilePath());
				officialManagers.put("plogofileName", bean.getPlogofileName());
				officialManagers.put("plogofilePath", bean.getPlogofilePath());
				officialManagers.put("userName", userDetails.getUsername());

				namedParameterJdbcTemplate.update(OfficialManagersQueryUtil.UPDATE_OFFICIAL_MANAGERS,officialManagers);
		
			
		  
		    resultBean.setSuccess(true);
		    }
		    else {
	 	 		   resultBean.setMessage("These details are already existed");

	 	        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	

}
