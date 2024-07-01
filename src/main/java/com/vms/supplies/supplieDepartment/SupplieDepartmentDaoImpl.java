package com.vms.supplies.supplieDepartment;

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

import com.vms.vessel.vesselParticular.VesselParticularBean;
import com.vms.vessel.vesselParticular.VesselParticularQueryUtil;
import com.vms.vessel.vesselParticular.VesselParticularResultBean;


@Repository

public class SupplieDepartmentDaoImpl implements SupplieDepartmentDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public SupplieDepartmentResultBean save(SupplieDepartmentBean bean) {
		SupplieDepartmentResultBean resultBean = new SupplieDepartmentResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> depMap = new HashMap<String, Object>();
						
			depMap.put("userName", userDetails.getUsername());
			depMap.put("code", bean.getCode());
			depMap.put("depName", bean.getDepartment());
			depMap.put("formType", bean.getFormType());
			depMap.put("itemOrder", bean.getItemsToOrderComments());
			depMap.put("itemNotOrder", bean.getItemsNotToOrderComments());
			depMap.put("tol", bean.getTolerance());
			depMap.put("minItem", bean.getMinimumItems());
			depMap.put("lscInv", (bean.getLscInvoiceDate()== null || bean.getLscInvoiceDate().isEmpty()) ? null : bean.getLscInvoiceDate());
			depMap.put("availOff", bean.isAvailableOffice());
			depMap.put("availVsl", bean.isAvailableVessel());
			depMap.put("offUndefine", bean.isOfficeUndefinedItemS());
			depMap.put("vslUndefine", bean.isVesselUndefinedItemS());
			depMap.put("pItems", bean.isProposedItems());
			
			namedParameterJdbcTemplate.update(SupplieDepartmentQueryUtil.SAVE_SUPPLIE_DEPARTMENT,depMap);
			
		    resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public SupplieDepartmentResultBean getList() {
		SupplieDepartmentResultBean resultBean = new SupplieDepartmentResultBean();
		List<SupplieDepartmentBean> listBean = new ArrayList<SupplieDepartmentBean>();
		
		try {
			listBean = jdbcTemplate.query(SupplieDepartmentQueryUtil.GET_LIST,new BeanPropertyRowMapper<SupplieDepartmentBean>(SupplieDepartmentBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
			
	public SupplieDepartmentResultBean delete(String id) {
		SupplieDepartmentResultBean resultBean = new SupplieDepartmentResultBean();
		try {
			jdbcTemplate.update(SupplieDepartmentQueryUtil.DELETE_SUPPLIE_DEPARTMENT,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public SupplieDepartmentResultBean edit(String id) {		
		SupplieDepartmentResultBean resultBean = new SupplieDepartmentResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setDepartmentDtls(jdbcTemplate.queryForObject(SupplieDepartmentQueryUtil.GET_SUPP_DEPT_DTLS,new Object[] { id }, new BeanPropertyRowMapper<SupplieDepartmentBean>(SupplieDepartmentBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public SupplieDepartmentResultBean update(SupplieDepartmentBean bean) {
		SupplieDepartmentResultBean resultBean = new SupplieDepartmentResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> depMap = new HashMap<String, Object>();
						
			depMap.put("userName", userDetails.getUsername());
			depMap.put("code", bean.getCode());
			depMap.put("depName", bean.getDepartment());
			depMap.put("formType", bean.getFormType());
			depMap.put("itemOrder", bean.getItemsToOrderComments());
			depMap.put("itemNotOrder", bean.getItemsNotToOrderComments());
			depMap.put("tol", bean.getTolerance());
			depMap.put("minItem", bean.getMinimumItems());
			depMap.put("lscInv", bean.getLscInvoiceDate());
			depMap.put("availOff", bean.isAvailableOffice());
			depMap.put("availVsl", bean.isAvailableVessel());
			depMap.put("offUndefine", bean.isOfficeUndefinedItemS());
			depMap.put("vslUndefine", bean.isVesselUndefinedItemS());
			depMap.put("pItems", bean.isProposedItems());
			
			namedParameterJdbcTemplate.update(SupplieDepartmentQueryUtil.UPDATE_SUPPLIE_DEPARTMENT,depMap);
			
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
			code = jdbcTemplate.queryForObject(SupplieDepartmentQueryUtil.GET_CODE,new Object[]{}, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}	
}
