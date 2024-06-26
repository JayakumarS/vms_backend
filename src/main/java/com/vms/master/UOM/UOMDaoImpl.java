package com.vms.master.UOM;

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

import com.vms.master.Country.CountryQueryUtil;
import com.vms.master.Port.PortQueryUtil;

@Repository
public class UOMDaoImpl implements UOMDao{

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public UOMResultBean saveUom(UOMBean bean) {
		UOMResultBean resultBean = new UOMResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			int code =  jdbcTemplate.queryForObject(UOMQueryUtil.get_code,new Object[] { bean.getUomCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(UOMQueryUtil.get_name,new Object[] { bean.getUomName() },Integer.class);

			
            if(code==0 && desc==0) {
			Map<String, Object> Country = new HashMap<String, Object>();
			
			Country.put("userName", userDetails.getUsername());
			Country.put("uomCode", bean.getUomCode());
			Country.put("uomName", bean.getUomName());
			
			namedParameterJdbcTemplate.update(UOMQueryUtil.SAVE_UOM,Country);
			
			
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
	
	@Override
	public UOMResultBean listUom() {
		UOMResultBean resultBean = new UOMResultBean();
		List<UOMBean> listBean = new ArrayList<UOMBean>();
		
		try {
			listBean = jdbcTemplate.query(UOMQueryUtil.GET_UOM_LIST,new BeanPropertyRowMapper<UOMBean>(UOMBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public UOMResultBean editUom(Integer id) {		
		UOMResultBean resultBean = new UOMResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(UOMQueryUtil.GET_EDIT_UOM,new Object[] { id }, new BeanPropertyRowMapper<UOMBean>(UOMBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	
	@Override
	public UOMResultBean deleteUom(String id) {
		UOMResultBean resultBean = new UOMResultBean();
		try {
			jdbcTemplate.update(UOMQueryUtil.DELETE_UOM,id);
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
	public UOMResultBean updateUom(UOMBean bean) {
		UOMResultBean resultBean = new UOMResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			String uomcode =  jdbcTemplate.queryForObject(PortQueryUtil.uom_code,new Object[] { bean.getUomId() },String.class);
			String uomName =  jdbcTemplate.queryForObject(PortQueryUtil.uom_name,new Object[] { bean.getUomId() },String.class);

			
			
			int code =  jdbcTemplate.queryForObject(PortQueryUtil.get_uom_code_edit,new Object[] { bean.getUomCode(),uomcode },Integer.class);

		    int name =  jdbcTemplate.queryForObject(PortQueryUtil.get_uom_name_edit,new Object[] { bean.getUomName(),uomName },Integer.class);

            if(code==0 && name==0) {
			Map<String, Object> Country = new HashMap<String, Object>();
			
			Country.put("userName", userDetails.getUsername());
			Country.put("uomCode", bean.getUomCode());
			Country.put("uomName", bean.getUomName());
			Country.put("uomId", bean.getUomId());

								
				namedParameterJdbcTemplate.update(UOMQueryUtil.UPDATE_UOM,Country);
				
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
