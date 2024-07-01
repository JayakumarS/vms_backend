package com.vms.supplies.unitsPackings;

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

public class UnitsPackingsDaoImpl implements UnitsPackingsDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public UnitsPackingsResultBean save(UnitsPackingsBean bean) {
		UnitsPackingsResultBean resultBean = new UnitsPackingsResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> unitMap = new HashMap<String, Object>();
						
			unitMap.put("userName", userDetails.getUsername());
			unitMap.put("id", bean.getId());
			unitMap.put("unitGroup", bean.getUnitGroup());
			unitMap.put("abbre", bean.getAbbreviation());
			unitMap.put("conFactor", bean.getConversionFactor());
			unitMap.put("interCode", bean.getInterfaceCode());
			unitMap.put("shipUnit", bean.getShipservUnit());
			unitMap.put("proUnit", bean.getProcureShipUnit());
			unitMap.put("mesapUnit", bean.getMespasUnit());
			unitMap.put("impUnit", bean.getImpaUnit());
			
			namedParameterJdbcTemplate.update(UnitsPackingsQueryUtil.SAVE_SUPPLIE_DEPARTMENT,unitMap);
			
		    resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public UnitsPackingsResultBean getList() {
		UnitsPackingsResultBean resultBean = new UnitsPackingsResultBean();
		List<UnitsPackingsBean> listBean = new ArrayList<UnitsPackingsBean>();
		
		try {
			listBean = jdbcTemplate.query(UnitsPackingsQueryUtil.GET_LIST,new BeanPropertyRowMapper<UnitsPackingsBean>(UnitsPackingsBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
			
	public UnitsPackingsResultBean delete(String id) {
		UnitsPackingsResultBean resultBean = new UnitsPackingsResultBean();
		try {
			jdbcTemplate.update(UnitsPackingsQueryUtil.DELETE_SUPPLIE_DEPARTMENT,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public UnitsPackingsResultBean edit(String id) {		
		UnitsPackingsResultBean resultBean = new UnitsPackingsResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setDepartmentDtls(jdbcTemplate.queryForObject(UnitsPackingsQueryUtil.GET_SUPP_DEPT_DTLS,new Object[] { id }, new BeanPropertyRowMapper<UnitsPackingsBean>(UnitsPackingsBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public UnitsPackingsResultBean update(UnitsPackingsBean bean) {
		UnitsPackingsResultBean resultBean = new UnitsPackingsResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> unitMap = new HashMap<String, Object>();
						
			unitMap.put("userName", userDetails.getUsername());
			unitMap.put("id", bean.getId());
			unitMap.put("unitGroup", bean.getUnitGroup());
			unitMap.put("abbre", bean.getAbbreviation());
			unitMap.put("conFactor", bean.getConversionFactor());
			unitMap.put("interCode", bean.getInterfaceCode());
			unitMap.put("shipUnit", bean.getShipservUnit());
			unitMap.put("proUnit", bean.getProcureShipUnit());
			unitMap.put("mesapUnit", bean.getMespasUnit());
			unitMap.put("impUnit", bean.getImpaUnit());
			
			namedParameterJdbcTemplate.update(UnitsPackingsQueryUtil.UPDATE_SUPPLIE_DEPARTMENT,unitMap);
			
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
			code = jdbcTemplate.queryForObject(UnitsPackingsQueryUtil.GET_CODE,new Object[]{}, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}	
}
