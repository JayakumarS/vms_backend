package com.vms.crew.personMaintenance;

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

public class PersonMaintenanceDaoImpl implements PersonMaintenanceDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public PersonMaintenanceResultBean save(PersonMaintenanceBean bean) {
		PersonMaintenanceResultBean resultBean = new PersonMaintenanceResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> personMaintenanceMap = new HashMap<String, Object>();
			
			String code = jdbcTemplate.queryForObject(PersonMaintenanceQueryUtil.GET_CODE,new Object[]{}, String.class);
			
			//Header
			personMaintenanceMap.put("userName", userDetails.getUsername());
			personMaintenanceMap.put("code", code);
			personMaintenanceMap.put("surname", bean.getSurname());
			personMaintenanceMap.put("name", bean.getName());
			personMaintenanceMap.put("middle", bean.getMiddle());
			personMaintenanceMap.put("nationality", bean.getNationality());
			personMaintenanceMap.put("rank", (bean.getRank() == null || bean.getRank().isEmpty()) ? null : bean.getRank());
			personMaintenanceMap.put("bDate", bean.getBirthDate());
			personMaintenanceMap.put("gender", bean.getGender());
			personMaintenanceMap.put("father", bean.getFather());
			personMaintenanceMap.put("mother", bean.getMother());
			personMaintenanceMap.put("place", bean.getPlace());
			personMaintenanceMap.put("licence", (bean.getLicence() == null || bean.getLicence().isEmpty()) ? null : bean.getLicence());
			personMaintenanceMap.put("healthSt", (bean.getHealth() == null || bean.getHealth().isEmpty()) ? null : bean.getHealth());
			personMaintenanceMap.put("decisionC", bean.getDecision());
			personMaintenanceMap.put("workStatus", (bean.getWorkStatus() == null || bean.getWorkStatus().isEmpty()) ? null : bean.getWorkStatus());
			personMaintenanceMap.put("religion", (bean.getReligion() == null || bean.getReligion().isEmpty()) ? null : bean.getReligion());
			personMaintenanceMap.put("agent", (bean.getAgent() == null || bean.getAgent().isEmpty()) ? null : bean.getAgent());
			personMaintenanceMap.put("expMonth", bean.getExpMonth());
			personMaintenanceMap.put("noVoyage", bean.getNoVoyage());
			personMaintenanceMap.put("vslType", (bean.getProposedType() == null || bean.getProposedType().isEmpty()) ? null : bean.getProposedType());
			personMaintenanceMap.put("lastSignOff", (bean.getSignedOff() == null || bean.getSignedOff().isEmpty()) ? null : bean.getSignedOff());
			personMaintenanceMap.put("available", (bean.getAvailableFrom() == null || bean.getAvailableFrom().isEmpty()) ? null : bean.getAvailableFrom());
			personMaintenanceMap.put("remarksOne", bean.getRemarksOne());
			personMaintenanceMap.put("remarksTwo", bean.getRemarksTwo());
			personMaintenanceMap.put("reCom", bean.getReCom());
			personMaintenanceMap.put("active", "yes".equalsIgnoreCase(bean.getActive()) ? "Y" : "N");
			
			namedParameterJdbcTemplate.update(PersonMaintenanceQueryUtil.SAVE_CREW_MASTER,personMaintenanceMap);
			
			//Document Details
			personMaintenanceMap.put("passPort", bean.getPassport());
			personMaintenanceMap.put("pIssue", (bean.getpIssue() == null || bean.getpIssue().isEmpty()) ? null : bean.getpIssue());
			personMaintenanceMap.put("pExpiry", (bean.getpExpiry() == null || bean.getpExpiry().isEmpty()) ? null : bean.getpExpiry());
			personMaintenanceMap.put("pIssuePlace", bean.getpIssuePlace());
			personMaintenanceMap.put("sBook", bean.getsBook());
			personMaintenanceMap.put("sIssue", (bean.getsIssue() == null || bean.getsIssue().isEmpty()) ? null : bean.getsIssue());
			personMaintenanceMap.put("sExpiry", (bean.getsExpiry() == null || bean.getsExpiry().isEmpty()) ? null : bean.getsExpiry());
			personMaintenanceMap.put("sIssuePlace", bean.getsIssuePlace());
			personMaintenanceMap.put("usVisa", bean.isUsVisa() == true ? "Y" : "N");
			personMaintenanceMap.put("usVisaNo", bean.getUsVisaNo());
			personMaintenanceMap.put("usExpiry", (bean.getUsExpiry() == null || bean.getUsExpiry().isEmpty()) ? null : bean.getUsExpiry());
			personMaintenanceMap.put("sid", bean.getSid());
			personMaintenanceMap.put("sidIssue", (bean.getSidIssue() == null || bean.getSidIssue().isEmpty()) ? null : bean.getSidIssue());
			personMaintenanceMap.put("sidExpiry", (bean.getSidExpiry() == null || bean.getSidExpiry().isEmpty()) ? null : bean.getSidExpiry());
			personMaintenanceMap.put("pan", bean.getPan());
			personMaintenanceMap.put("indos", bean.getIndos());
			personMaintenanceMap.put("adhar", bean.getAdhar());
			personMaintenanceMap.put("sidFileName", "");
			personMaintenanceMap.put("sidFilePath", "");
			personMaintenanceMap.put("cvFileName", "");
			personMaintenanceMap.put("cvFilePath", "");
			
			namedParameterJdbcTemplate.update(PersonMaintenanceQueryUtil.SAVE_CREW_MASTER_DOCUMENT,personMaintenanceMap);
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public PersonMaintenanceResultBean getList() {
		PersonMaintenanceResultBean resultBean = new PersonMaintenanceResultBean();
		List<PersonMaintenanceBean> listBean = new ArrayList<PersonMaintenanceBean>();
		
		try {
			listBean = jdbcTemplate.query(PersonMaintenanceQueryUtil.GET_LIST,new BeanPropertyRowMapper<PersonMaintenanceBean>(PersonMaintenanceBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public PersonMaintenanceResultBean getDetails(String id) {
		// TODO Auto-generated method stub
		PersonMaintenanceResultBean resultBean = new PersonMaintenanceResultBean();
		
		try {
			resultBean.setPersonMaintenanceBean(jdbcTemplate.queryForObject(PersonMaintenanceQueryUtil.GET_DETAILS, new Object[] {id}, new BeanPropertyRowMapper<PersonMaintenanceBean>(PersonMaintenanceBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}
			
	public PersonMaintenanceResultBean delete(String id) {
		PersonMaintenanceResultBean resultBean = new PersonMaintenanceResultBean();
		try {
			jdbcTemplate.update(PersonMaintenanceQueryUtil.DELETE_CREW_DOCUMNENT,id);
			jdbcTemplate.update(PersonMaintenanceQueryUtil.DELETE_CREW_MASTER,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public PersonMaintenanceResultBean edit(String id) {		
		PersonMaintenanceResultBean resultBean = new PersonMaintenanceResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setCrewMasterDtls(jdbcTemplate.queryForObject(PersonMaintenanceQueryUtil.GET_CREW_MASTER_DTLS,new Object[] { id }, new BeanPropertyRowMapper<PersonMaintenanceBean>(PersonMaintenanceBean.class)));
			resultBean.setCrewMasterDocDtls(jdbcTemplate.queryForObject(PersonMaintenanceQueryUtil.GET_CREW_MASTER_DOCUMENT_DTLS,new Object[] { id }, new BeanPropertyRowMapper<PersonMaintenanceBean>(PersonMaintenanceBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public PersonMaintenanceResultBean update(PersonMaintenanceBean bean) {
		PersonMaintenanceResultBean resultBean = new PersonMaintenanceResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> personMaintenanceMap = new HashMap<String, Object>();
						
			//Header
			personMaintenanceMap.put("userName", userDetails.getUsername());
			personMaintenanceMap.put("code", bean.getCode());
			personMaintenanceMap.put("surname", bean.getSurname());
			personMaintenanceMap.put("name", bean.getName());
			personMaintenanceMap.put("middle", bean.getMiddle());
			personMaintenanceMap.put("nationality", bean.getNationality());
			personMaintenanceMap.put("rank", (bean.getRank() == null || bean.getRank().isEmpty()) ? null : bean.getRank());
			personMaintenanceMap.put("bDate", bean.getBirthDate());
			personMaintenanceMap.put("gender", bean.getGender());
			personMaintenanceMap.put("father", bean.getFather());
			personMaintenanceMap.put("mother", bean.getMother());
			personMaintenanceMap.put("place", bean.getPlace());
			personMaintenanceMap.put("licence", (bean.getLicence() == null || bean.getLicence().isEmpty()) ? null : bean.getLicence());
			personMaintenanceMap.put("healthSt", (bean.getHealth() == null || bean.getHealth().isEmpty()) ? null : bean.getHealth());
			personMaintenanceMap.put("decisionC", bean.getDecision());
			personMaintenanceMap.put("workStatus", (bean.getWorkStatus() == null || bean.getWorkStatus().isEmpty()) ? null : bean.getWorkStatus());
			personMaintenanceMap.put("religion", (bean.getReligion() == null || bean.getReligion().isEmpty()) ? null : bean.getReligion());
			personMaintenanceMap.put("agent", (bean.getAgent() == null || bean.getAgent().isEmpty()) ? null : bean.getAgent());
			personMaintenanceMap.put("expMonth", bean.getExpMonth());
			personMaintenanceMap.put("noVoyage", bean.getNoVoyage());
			personMaintenanceMap.put("vslType", (bean.getProposedType() == null || bean.getProposedType().isEmpty()) ? null : bean.getProposedType());
			personMaintenanceMap.put("lastSignOff", (bean.getSignedOff() == null || bean.getSignedOff().isEmpty()) ? null : bean.getSignedOff());
			personMaintenanceMap.put("available", (bean.getAvailableFrom() == null || bean.getAvailableFrom().isEmpty()) ? null : bean.getAvailableFrom());
			personMaintenanceMap.put("remarksOne", bean.getRemarksOne());
			personMaintenanceMap.put("remarksTwo", bean.getRemarksTwo());
			personMaintenanceMap.put("reCom", bean.getReCom());
			personMaintenanceMap.put("active", "yes".equalsIgnoreCase(bean.getActive()) ? "Y" : "N");
			
			namedParameterJdbcTemplate.update(PersonMaintenanceQueryUtil.UPDATE_CREW_MASTER,personMaintenanceMap);
			
			//Document Details
			personMaintenanceMap.put("passPort", bean.getPassport());
			personMaintenanceMap.put("pIssue", (bean.getpIssue() == null || bean.getpIssue().isEmpty()) ? null : bean.getpIssue());
			personMaintenanceMap.put("pExpiry", (bean.getpExpiry() == null || bean.getpExpiry().isEmpty()) ? null : bean.getpExpiry());
			personMaintenanceMap.put("pIssuePlace", bean.getpIssuePlace());
			personMaintenanceMap.put("sBook", bean.getsBook());
			personMaintenanceMap.put("sIssue", (bean.getsIssue() == null || bean.getsIssue().isEmpty()) ? null : bean.getsIssue());
			personMaintenanceMap.put("sExpiry", (bean.getsExpiry() == null || bean.getsExpiry().isEmpty()) ? null : bean.getsExpiry());
			personMaintenanceMap.put("sIssuePlace", bean.getsIssuePlace());
			personMaintenanceMap.put("usVisa", bean.isUsVisa() == true ? "Y" : "N");
			personMaintenanceMap.put("usVisaNo", bean.getUsVisaNo());
			personMaintenanceMap.put("usExpiry", (bean.getUsExpiry() == null || bean.getUsExpiry().isEmpty()) ? null : bean.getUsExpiry());
			personMaintenanceMap.put("sid", bean.getSid());
			personMaintenanceMap.put("sidIssue", (bean.getSidIssue() == null || bean.getSidIssue().isEmpty()) ? null : bean.getSidIssue());
			personMaintenanceMap.put("sidExpiry", (bean.getSidExpiry() == null || bean.getSidExpiry().isEmpty()) ? null : bean.getSidExpiry());
			personMaintenanceMap.put("pan", bean.getPan());
			personMaintenanceMap.put("indos", bean.getIndos());
			personMaintenanceMap.put("adhar", bean.getAdhar());
			personMaintenanceMap.put("sidFileName", "");
			personMaintenanceMap.put("sidFilePath", "");
			personMaintenanceMap.put("cvFileName", "");
			personMaintenanceMap.put("cvFilePath", "");
			
			namedParameterJdbcTemplate.update(PersonMaintenanceQueryUtil.UPDATE_CREW_MASTER_DOCUMENT,personMaintenanceMap);
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public PersonMaintenanceResultBean getApplicantList() {
		PersonMaintenanceResultBean resultBean = new PersonMaintenanceResultBean();
		List<PersonMaintenanceBean> listBean = new ArrayList<PersonMaintenanceBean>();
		
		try {
			listBean = jdbcTemplate.query(PersonMaintenanceQueryUtil.GET_APPLICANT_LIST,new BeanPropertyRowMapper<PersonMaintenanceBean>(PersonMaintenanceBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}


	


}
