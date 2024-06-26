package com.vms.master.Port;

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

import com.vms.crew.healthStatus.HealthStatusQueryUtil;
import com.vms.crew.rankGroup.RankGroupQueryUtil;

@Repository
public class PortDaoImpl implements PortDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public PortResultBean savePort(PortBean bean) {
		PortResultBean resultBean = new PortResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			int code =  jdbcTemplate.queryForObject(PortQueryUtil.get_code,new Object[] { bean.getPortCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(PortQueryUtil.get_name,new Object[] { bean.getPortName() },Integer.class);
		    
            if(code==0 && desc==0) {

			Map<String, Object> Country = new HashMap<String, Object>();
			
			Country.put("userName", userDetails.getUsername());
			Country.put("portCode", bean.getPortCode());
			Country.put("portName", bean.getPortName());
			Country.put("portType", bean.getPortType());
			Country.put("active", bean.isActive());
			Country.put("countryCode", bean.getCountryCode());
			
			namedParameterJdbcTemplate.update(PortQueryUtil.SAVE_COUNTRY,Country);
			
			
		   resultBean.setSuccess(true);
            }else {
   	 		   resultBean.setMessage("These details are already exist");

            }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	@Override
	public PortResultBean listPort() {
		PortResultBean resultBean = new PortResultBean();
		List<PortBean> listBean = new ArrayList<PortBean>();
		
		try {
			listBean = jdbcTemplate.query(PortQueryUtil.GET_PORT_LIST,new BeanPropertyRowMapper<PortBean>(PortBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public PortResultBean editPort(Integer id) {		
		PortResultBean resultBean = new PortResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(PortQueryUtil.GET_EDIT_PORT,new Object[] { id }, new BeanPropertyRowMapper<PortBean>(PortBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	
	@Override
	public PortResultBean deletePort(String id) {
		PortResultBean resultBean = new PortResultBean();
		try {
			jdbcTemplate.update(PortQueryUtil.DELETE_PORT,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			  String errorMessage = e.getMessage();
		        if (errorMessage.contains("violates foreign key constraint")) {
		            resultBean.setSuccess(false);
		            resultBean.setMessage("Cannot delete this fleetid because it is referenced in another table");
		        } else {
		            e.printStackTrace();
		            resultBean.setSuccess(false);
		            resultBean.setMessage(errorMessage);
		        }
		}	
		return resultBean;
	}

	@Override
	public PortResultBean updatePort(PortBean bean) {
		PortResultBean resultBean = new PortResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			String portcode =  jdbcTemplate.queryForObject(PortQueryUtil.port_code,new Object[] { bean.getPortId() },String.class);
			String portName =  jdbcTemplate.queryForObject(PortQueryUtil.port_name,new Object[] { bean.getPortId() },String.class);

			
			
			int code =  jdbcTemplate.queryForObject(PortQueryUtil.get_code_edit,new Object[] { bean.getPortCode(),portcode },Integer.class);

		    int name =  jdbcTemplate.queryForObject(PortQueryUtil.get_name_edit,new Object[] { bean.getPortName(),portName },Integer.class);

            if(code==0 && name==0) {

			Map<String, Object> Country = new HashMap<String, Object>();
			
			Country.put("userName", userDetails.getUsername());
			Country.put("portCode", bean.getPortCode());
			Country.put("portName", bean.getPortName());
			Country.put("portType", bean.getPortType());
			Country.put("active", bean.isActive());
			Country.put("portId", bean.getPortId());
			Country.put("countryCode", bean.getCountryCode());
								
				namedParameterJdbcTemplate.update(PortQueryUtil.UPDATE_PORT,Country);
				
		   resultBean.setSuccess(true);
            }else {
      		   resultBean.setMessage("These details already exist");

            }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

}
