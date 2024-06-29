package com.vms.vessels.shipManagers;

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
import com.vms.crew.payTypes.PayTypesQueryUtil;





@Repository

public class ShipManagersDaoImpl implements ShipManagersDao {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public ShipManagersResultBean save(ShipManagersBean bean) {
		ShipManagersResultBean resultBean = new ShipManagersResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			int shipman =  jdbcTemplate.queryForObject(ShipManagersQueryUtil.get_code,new Object[] { bean.getShipman() },Integer.class);

		    int name =  jdbcTemplate.queryForObject(ShipManagersQueryUtil.get_desc,new Object[] { bean.getName() },Integer.class);
		    if(shipman==0 && name==0) {
			
			Map<String, Object> shipManagers = new HashMap<String, Object>();
			
                shipManagers.put("shipman", bean.getShipman());
				shipManagers.put("name", bean.getName());
				shipManagers.put("remarks", bean.getRemarks());
				shipManagers.put("vatreg", bean.getVatreg());
				shipManagers.put("userName", userDetails.getUsername());

				
				namedParameterJdbcTemplate.update(ShipManagersQueryUtil.SAVE_SHIP_MANAGERS,shipManagers);
			
			
		   resultBean.setSuccess(true);
		    }
		    else {
	 	 		   resultBean.setMessage(  bean.getShipman() +" already exists,please enter a different Shipman");

		  	        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public ShipManagersResultBean getList() {
		ShipManagersResultBean resultBean = new ShipManagersResultBean();
		List<ShipManagersBean> listBean = new ArrayList<ShipManagersBean>();
		
		try {
			listBean = jdbcTemplate.query(ShipManagersQueryUtil.getList,new BeanPropertyRowMapper<ShipManagersBean>(ShipManagersBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public ShipManagersResultBean edit(int id) {		
		ShipManagersResultBean resultBean = new ShipManagersResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(ShipManagersQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<ShipManagersBean>(ShipManagersBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public ShipManagersResultBean delete(int id) {
		ShipManagersResultBean resultBean = new ShipManagersResultBean();
		try {
			jdbcTemplate.update(ShipManagersQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public ShipManagersResultBean update(ShipManagersBean bean) {
		ShipManagersResultBean resultBean = new ShipManagersResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			String shipmancode =  jdbcTemplate.queryForObject(ShipManagersQueryUtil.shipman_code,new Object[] { bean.getShipmanid() },String.class);
			String shipmanname =  jdbcTemplate.queryForObject(ShipManagersQueryUtil.name_desc,new Object[] { bean.getShipmanid() },String.class);

			
			int shipman =  jdbcTemplate.queryForObject(ShipManagersQueryUtil.get_shipman_edit,new Object[] { bean.getShipman(),shipmancode },int.class);

		    int name =  jdbcTemplate.queryForObject(ShipManagersQueryUtil.get_name_edit,new Object[] { bean.getName(),shipmanname },int.class);
			if(shipman == 0 && name == 0) {
			Map<String, Object> shipManagers = new HashMap<String, Object>();
		    	shipManagers.put("shipmanid", bean.getShipmanid());
				shipManagers.put("shipman", bean.getShipman());
				shipManagers.put("name", bean.getName());
				shipManagers.put("remarks", bean.getRemarks());
				shipManagers.put("vatreg", bean.getVatreg());
				shipManagers.put("userName", userDetails.getUsername());
				
				namedParameterJdbcTemplate.update(ShipManagersQueryUtil.UPDATE_SHIP_MANAGERS,shipManagers);
				
			
		   resultBean.setSuccess(true);
		}
		   else {
 	 		   resultBean.setMessage(  bean.getShipman() +" already exists,please enter a different Shipman");


 	        }
		   
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	

	
	@Override
	public ShipManagersBean getSequenceCode() {
		ShipManagersBean shipManagers = new ShipManagersBean();

	    try {
	        String shipManagersId = jdbcTemplate.queryForObject(ShipManagersQueryUtil.get_shipManagersId, String.class);
	        shipManagers.setShipman(shipManagersId);
	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();
	    }

	    return shipManagers;
	}
	
	
	
}
