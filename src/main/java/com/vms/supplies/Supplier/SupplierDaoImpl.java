package com.vms.supplies.Supplier;

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

import com.vms.crew.personMaintenance.PersonMaintenanceQueryUtil;

@Repository
public class SupplierDaoImpl implements SupplierDao{

	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public SupplierResultBean save(SupplierBean bean) {
		SupplierResultBean resultBean = new SupplierResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
	
			Map<String, Object> supplier = new HashMap<String, Object>();
			
			supplier.put("userName", userDetails.getUsername());
			supplier.put("supplierCode", bean.getSupplierCode());
			supplier.put("supplierShortName", bean.getSupplierShortName());
			supplier.put("supplierName", bean.getSupplierName());
			
			namedParameterJdbcTemplate.update(SupplierQueryUtil.SAVE_SUPPLIER,supplier);
			
			
		   resultBean.setSuccess(true);
          
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	@Override
	public SupplierResultBean list() {
		SupplierResultBean resultBean = new SupplierResultBean();
		List<SupplierBean> listBean = new ArrayList<SupplierBean>();
		
		try {
			listBean = jdbcTemplate.query(SupplierQueryUtil.GET_SUPPLIER_LIST,new BeanPropertyRowMapper<SupplierBean>(SupplierBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public SupplierResultBean edit(String id) {		
		SupplierResultBean resultBean = new SupplierResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(SupplierQueryUtil.GET_EDIT_SUPPLIER,new Object[] { id }, new BeanPropertyRowMapper<SupplierBean>(SupplierBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	
	@Override
	public SupplierResultBean delete(String id) {
		SupplierResultBean resultBean = new SupplierResultBean();
		try {
			jdbcTemplate.update(SupplierQueryUtil.DELETE_SUPPLIER,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			  String errorMessage = e.getMessage();
		        if (errorMessage.contains("violates foreign key constraint")) {
		            resultBean.setSuccess(false);
		            resultBean.setMessage("Cannot delete this UOM Id because it is referenced in another table");
		        } else {
		            e.printStackTrace();
		            resultBean.setSuccess(false);
		            resultBean.setMessage(errorMessage);
		        }
		}	
		return resultBean;
	}

	@Override
	public SupplierResultBean update(SupplierBean bean) {
		SupplierResultBean resultBean = new SupplierResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			Map<String, Object> supplier = new HashMap<String, Object>();
			
			supplier.put("userName", userDetails.getUsername());
			supplier.put("supplierName", bean.getSupplierName());
			supplier.put("supplierShortName", bean.getSupplierShortName());
			supplier.put("supplierCode", bean.getSupplierCode());

								
				namedParameterJdbcTemplate.update(SupplierQueryUtil.UPDATE_SUPPLIER,supplier);
				
		   resultBean.setSuccess(true);
          
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public String generateCode() {
		String code = "";
		try {
			code = jdbcTemplate.queryForObject(SupplierQueryUtil.GET_SUPPLIER_CODE,new Object[]{}, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}
}
