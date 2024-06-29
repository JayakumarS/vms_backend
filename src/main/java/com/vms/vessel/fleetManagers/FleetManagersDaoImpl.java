package com.vms.vessel.fleetManagers;

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

import com.vms.crew.certificates.CertificatesBean;
import com.vms.crew.certificates.CertificatesQueryutil;



@Repository
public class FleetManagersDaoImpl implements FleetManagersDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public FleetManagersResultBean save(FleetManagersBean bean) {
		FleetManagersResultBean resultBean = new FleetManagersResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
		
            
			Map<String, Object> fleetManagers = new HashMap<String, Object>();
			
			fleetManagers.put("userName", userDetails.getUsername());
			fleetManagers.put("code", bean.getCode());
			fleetManagers.put("fleet", bean.getFleet());
			fleetManagers.put("opmanager", bean.getOpmanager());
			fleetManagers.put("techmanager", bean.getTechmanager());

				namedParameterJdbcTemplate.update(FleetManagersQueryUtil.SAVE_fleetManagers,fleetManagers);
			
		   resultBean.setSuccess(true);
		   
	
            
            
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);

		}
		return resultBean;
	}


	
	

	@Override
	public FleetManagersResultBean getList() {
		FleetManagersResultBean resultBean = new FleetManagersResultBean();
		List<FleetManagersBean> listBean = new ArrayList<FleetManagersBean>();
		
		try {
			listBean = jdbcTemplate.query(FleetManagersQueryUtil.getList,new BeanPropertyRowMapper<FleetManagersBean>(FleetManagersBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public FleetManagersResultBean edit(Integer id) {		
		FleetManagersResultBean resultBean = new FleetManagersResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(FleetManagersQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<FleetManagersBean>(FleetManagersBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public FleetManagersResultBean delete(Integer id) {
		FleetManagersResultBean resultBean = new FleetManagersResultBean();
		String code = null;

		try {
			
			jdbcTemplate.update(FleetManagersQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public FleetManagersResultBean update(FleetManagersBean bean) {
		FleetManagersResultBean resultBean = new FleetManagersResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
		
			Map<String, Object> fleetManagers = new HashMap<String, Object>();
			
			fleetManagers.put("userName", userDetails.getUsername());
			fleetManagers.put("code", bean.getCode());
			fleetManagers.put("fleet", bean.getFleet());
			fleetManagers.put("opmanager", bean.getOpmanager());
			fleetManagers.put("techmanager", bean.getTechmanager());
			fleetManagers.put("fleetManagersid", bean.getFleetManagersid());


					namedParameterJdbcTemplate.update(FleetManagersQueryUtil.UPDATE_fleetManagers,fleetManagers);
			
				resultBean.setSuccess(true);
         		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	
	
	@Override
	public FleetManagersBean getSequenceCode() {
		FleetManagersBean certificate = new FleetManagersBean();

	    try {
	        String fleetManagerId = jdbcTemplate.queryForObject(FleetManagersQueryUtil.get_fleetManagerId, String.class);
	        certificate.setCode(fleetManagerId);
	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();
	    }

	    return certificate;
	}
	
	
}
