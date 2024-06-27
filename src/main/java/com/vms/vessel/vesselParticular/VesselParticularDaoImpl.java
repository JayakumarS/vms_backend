package com.vms.vessel.vesselParticular;

import java.util.ArrayList;
import java.util.Calendar;
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

import com.vms.common.services.CommonServiceBean;
import com.vms.common.services.CommonServiceQueryUtil;
import com.vms.usermaster.UserMasterBean;
import com.vms.usermaster.UserMasterQueryUtil;


@Repository
public class VesselParticularDaoImpl implements VesselParticularDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public VesselParticularResultBean save(VesselParticularBean bean) {
		VesselParticularResultBean resultBean = new VesselParticularResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> vesselParticular = new HashMap<String, Object>();
			
			//Header Details
			vesselParticular.put("userName", userDetails.getUsername());
			vesselParticular.put("code", bean.getCode());
			vesselParticular.put("name", bean.getName());
			vesselParticular.put("sName", bean.getShortname());
			vesselParticular.put("type", bean.getType());
			vesselParticular.put("fleet", (bean.getFleet() == null || bean.getFleet().isEmpty()) ? null : Integer.parseInt(bean.getFleet()));
			vesselParticular.put("vesselType", bean.getVesseltype());
			vesselParticular.put("pI", (bean.getPandi() == null || bean.getPandi().isEmpty()) ? null : Integer.parseInt(bean.getPandi()));
			vesselParticular.put("hM", (bean.getHullandmachinery() == null || bean.getHullandmachinery().isEmpty()) ? null : Integer.parseInt(bean.getHullandmachinery()));
			vesselParticular.put("vesselGroup", bean.getVesselgroup());
			vesselParticular.put("fD", (bean.getFdandd() == null || bean.getFdandd().isEmpty()) ? null : Integer.parseInt(bean.getFdandd()));
			vesselParticular.put("wageScale", (bean.getWagescale() == null || bean.getWagescale().isEmpty()) ? null : Integer.parseInt(bean.getWagescale()));
			vesselParticular.put("reason", bean.getReason());
			vesselParticular.put("vesselClass", (bean.getVesselClass() == null || bean.getVesselClass().isEmpty()) ? null : Integer.parseInt(bean.getVesselClass()));
			vesselParticular.put("validUnit", (bean.getValiedUntil() == null || bean.getValiedUntil().isEmpty()) ? null : bean.getValiedUntil());
			vesselParticular.put("leadVessel", bean.getLeadvesselid());
			vesselParticular.put("fleetVessel", bean.getFleetvessel());
			vesselParticular.put("fleetDate", (bean.getDateinfleettype() == null || bean.getDateinfleettype().isEmpty()) ? null : bean.getDateinfleettype());
			vesselParticular.put("status", bean.isVesselStatus());
			
			namedParameterJdbcTemplate.update(VesselParticularQueryUtil.SAVE_HDR_VESSEL_PARTICULAR,vesselParticular);
			
			//Main Details
			vesselParticular.put("flag", (bean.getFlag() == null || bean.getFlag().isEmpty()) ? null : Integer.parseInt(bean.getFlag()));
			vesselParticular.put("greek", bean.isGreek());
			vesselParticular.put("port", (bean.getRegistryport() == null || bean.getRegistryport().isEmpty()) ? null : Integer.parseInt(bean.getRegistryport()));
			vesselParticular.put("rNo", bean.getRegistryno());
			vesselParticular.put("bDate", (bean.getBuiltdate() == null || bean.getBuiltdate().isEmpty()) ? null : bean.getBuiltdate());
			vesselParticular.put("pBuild", bean.getPlaceBuild());
			vesselParticular.put("yBuild", bean.getYardbuild());
			vesselParticular.put("imoNo", bean.getImono());
			vesselParticular.put("hullNo", bean.getHullno());
			vesselParticular.put("cSign", bean.getCallsign());
			vesselParticular.put("natNo", bean.getNatnumber());
			vesselParticular.put("mmis", bean.getMmis());
			vesselParticular.put("cNo", bean.getClassno());
			vesselParticular.put("iClass", bean.getIceclass());
			
			namedParameterJdbcTemplate.update(VesselParticularQueryUtil.SAVE_MAIN_VESSEL_PARTICULAR,vesselParticular);
			
			//Commercial Details
			vesselParticular.put("sOwner", (bean.getShipowner() == null || bean.getShipowner().isEmpty()) ? null : Integer.parseInt(bean.getShipowner()));
			vesselParticular.put("sOwnerPlat", bean.getShipownerplatform());
			vesselParticular.put("operator", bean.getOperator());
			vesselParticular.put("sNo", bean.getSafteyno());
			
			namedParameterJdbcTemplate.update(VesselParticularQueryUtil.SAVE_COMM_VESSEL_PARTICULAR,vesselParticular);
			
			//Crew Details
			vesselParticular.put("vslOffManager", (bean.getOfficialManager() == null || bean.getOfficialManager().isEmpty()) ? null : Integer.parseInt(bean.getOfficialManager()));
			vesselParticular.put("vslShipManager", (bean.getShipmanager() == null || bean.getShipmanager().isEmpty()) ? null : Integer.parseInt(bean.getShipmanager()));
			vesselParticular.put("vslCrewManager", bean.getCrewmanager());
			vesselParticular.put("vslGroupManager", bean.getGroupmanager());
			
			namedParameterJdbcTemplate.update(VesselParticularQueryUtil.SAVE_CREW_VESSEL_PARTICULAR,vesselParticular);
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public VesselParticularResultBean getList() {
		VesselParticularResultBean resultBean = new VesselParticularResultBean();
		List<VesselParticularBean> listBean = new ArrayList<VesselParticularBean>();
		
		try {
			listBean = jdbcTemplate.query(VesselParticularQueryUtil.getList,new BeanPropertyRowMapper<VesselParticularBean>(VesselParticularBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public VesselParticularResultBean edit(String id) {		
		VesselParticularResultBean resultBean = new VesselParticularResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setHdrBean(jdbcTemplate.queryForObject(VesselParticularQueryUtil.GET_HDR_DTLS,new Object[] { id }, new BeanPropertyRowMapper<VesselParticularBean>(VesselParticularBean.class)));
			resultBean.setMainDtlBean(jdbcTemplate.queryForObject(VesselParticularQueryUtil.GET_MAIN_DTLS,new Object[] { id }, new BeanPropertyRowMapper<VesselParticularBean>(VesselParticularBean.class)));
			resultBean.setCommDtlBean(jdbcTemplate.queryForObject(VesselParticularQueryUtil.GET_COMM_DTLS,new Object[] { id }, new BeanPropertyRowMapper<VesselParticularBean>(VesselParticularBean.class)));
			resultBean.setCrewDtlBean(jdbcTemplate.queryForObject(VesselParticularQueryUtil.GET_CREW_DTLS,new Object[] { id }, new BeanPropertyRowMapper<VesselParticularBean>(VesselParticularBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public VesselParticularResultBean delete(String id) {
		VesselParticularResultBean resultBean = new VesselParticularResultBean();
		try {
			jdbcTemplate.update(VesselParticularQueryUtil.Delete_Dtl,id);
			jdbcTemplate.update(VesselParticularQueryUtil.Delete_Dtl_Com,id);
			jdbcTemplate.update(VesselParticularQueryUtil.Delete_Dtl_Crew,id);
			jdbcTemplate.update(VesselParticularQueryUtil.Delete_Hdr,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public VesselParticularResultBean update(VesselParticularBean bean) {
		VesselParticularResultBean resultBean = new VesselParticularResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> vesselParticular = new HashMap<String, Object>();
			
			//Header Details
			vesselParticular.put("userName", userDetails.getUsername());
			vesselParticular.put("code", bean.getCode());
			vesselParticular.put("name", bean.getName());
			vesselParticular.put("sName", bean.getShortname());
			vesselParticular.put("type", bean.getType());
			vesselParticular.put("fleet", (bean.getFleet() == null || bean.getFleet().isEmpty()) ? null : Integer.parseInt(bean.getFleet()));
			vesselParticular.put("vesselType", bean.getVesseltype());
			vesselParticular.put("pI", (bean.getPandi() == null || bean.getPandi().isEmpty()) ? null : Integer.parseInt(bean.getPandi()));
			vesselParticular.put("hM", (bean.getHullandmachinery() == null || bean.getHullandmachinery().isEmpty()) ? null : Integer.parseInt(bean.getHullandmachinery()));
			vesselParticular.put("vesselGroup", bean.getVesselgroup());
			vesselParticular.put("fD", (bean.getFdandd() == null || bean.getFdandd().isEmpty()) ? null : Integer.parseInt(bean.getFdandd()));
			vesselParticular.put("wageScale", (bean.getWagescale() == null || bean.getWagescale().isEmpty()) ? null : Integer.parseInt(bean.getWagescale()));
			vesselParticular.put("reason", bean.getReason());
			vesselParticular.put("vesselClass", (bean.getVesselClass() == null || bean.getVesselClass().isEmpty()) ? null : Integer.parseInt(bean.getVesselClass()));
			vesselParticular.put("validUnit", (bean.getValiedUntil() == null || bean.getValiedUntil().isEmpty()) ? null : bean.getValiedUntil());
			vesselParticular.put("leadVessel", bean.getLeadvesselid());
			vesselParticular.put("fleetVessel", bean.getFleetvessel());
			vesselParticular.put("fleetDate", (bean.getDateinfleettype() == null || bean.getDateinfleettype().isEmpty()) ? null : bean.getDateinfleettype());
			vesselParticular.put("status", bean.isVesselStatus());
			
			namedParameterJdbcTemplate.update(VesselParticularQueryUtil.UPDATE_HDR_VESSEL_PARTICULAR,vesselParticular);
			
			//Main Details
			vesselParticular.put("flag", (bean.getFlag() == null || bean.getFlag().isEmpty()) ? null : Integer.parseInt(bean.getFlag()));
			vesselParticular.put("greek", bean.isGreek());
			vesselParticular.put("port", (bean.getRegistryport() == null || bean.getRegistryport().isEmpty()) ? null : Integer.parseInt(bean.getRegistryport()));
			vesselParticular.put("rNo", bean.getRegistryno());
			vesselParticular.put("bDate", (bean.getBuiltdate() == null || bean.getBuiltdate().isEmpty()) ? null : bean.getBuiltdate());
			vesselParticular.put("pBuild", bean.getPlaceBuild());
			vesselParticular.put("yBuild", bean.getYardbuild());
			vesselParticular.put("imoNo", bean.getImono());
			vesselParticular.put("hullNo", bean.getHullno());
			vesselParticular.put("cSign", bean.getCallsign());
			vesselParticular.put("natNo", bean.getNatnumber());
			vesselParticular.put("mmis", bean.getMmis());
			vesselParticular.put("cNo", bean.getClassno());
			vesselParticular.put("iClass", bean.getIceclass());
			
			namedParameterJdbcTemplate.update(VesselParticularQueryUtil.UPDATE_MAIN_VESSEL_PARTICULAR,vesselParticular);
			
			//Commercial Details
			vesselParticular.put("sOwner", (bean.getShipowner() == null || bean.getShipowner().isEmpty()) ? null : Integer.parseInt(bean.getShipowner()));
			vesselParticular.put("sOwnerPlat", bean.getShipownerplatform());
			vesselParticular.put("operator", bean.getOperator());
			vesselParticular.put("sNo", bean.getSafteyno());
			
			namedParameterJdbcTemplate.update(VesselParticularQueryUtil.UPDATE_COMM_VESSEL_PARTICULAR,vesselParticular);
			
			//Crew Details
			vesselParticular.put("vslOffManager", (bean.getOfficialManager() == null || bean.getOfficialManager().isEmpty()) ? null : Integer.parseInt(bean.getOfficialManager()));
			vesselParticular.put("vslShipManager", (bean.getShipmanager() == null || bean.getShipmanager().isEmpty()) ? null : Integer.parseInt(bean.getShipmanager()));
			vesselParticular.put("vslCrewManager", bean.getCrewmanager());
			vesselParticular.put("vslGroupManager", bean.getGroupmanager());
			
			namedParameterJdbcTemplate.update(VesselParticularQueryUtil.UPDATE_CREW_VESSEL_PARTICULAR,vesselParticular);
			

		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public String generateCode() {
		String vesselCode = "";
		try {
			vesselCode = jdbcTemplate.queryForObject(VesselParticularQueryUtil.GET_VESSEL_CODE,new Object[]{}, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vesselCode;
	}
	
	

}
