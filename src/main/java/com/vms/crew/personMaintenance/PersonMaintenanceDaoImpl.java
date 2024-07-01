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
			personMaintenanceMap.put("code", bean.getCode());
			personMaintenanceMap.put("appCode", Integer.parseInt(bean.getApplCode()));
			personMaintenanceMap.put("surname", bean.getSurname());
			personMaintenanceMap.put("name", bean.getName());
			personMaintenanceMap.put("middle", bean.getMiddle());
			personMaintenanceMap.put("nationality", Integer.parseInt(bean.getNationality()));
			personMaintenanceMap.put("rank", (bean.getRank() == null || bean.getRank().isEmpty()) ? null : Integer.parseInt(bean.getRank()));
			personMaintenanceMap.put("bDate", bean.getBirthDate());
			personMaintenanceMap.put("gender", bean.getGender());
			personMaintenanceMap.put("father", bean.getFather());
			personMaintenanceMap.put("mother", bean.getMother());
			personMaintenanceMap.put("place", bean.getPlace());
			personMaintenanceMap.put("licence", (bean.getLicence() == null || bean.getLicence().isEmpty()) ? null : Integer.parseInt(bean.getLicence()));
			personMaintenanceMap.put("healthSt", (bean.getHealth() == null || bean.getHealth().isEmpty()) ? null : Integer.parseInt(bean.getHealth()));
			personMaintenanceMap.put("decisionC", bean.getDecision());
			personMaintenanceMap.put("workStatus", (bean.getWorkStatus() == null || bean.getWorkStatus().isEmpty()) ? null : Integer.parseInt(bean.getWorkStatus()));
			personMaintenanceMap.put("religion", (bean.getReligion() == null || bean.getReligion().isEmpty()) ? null : Integer.parseInt(bean.getReligion()));
			personMaintenanceMap.put("agent", (bean.getAgent() == null || bean.getAgent().isEmpty()) ? null : Integer.parseInt(bean.getAgent()));
			personMaintenanceMap.put("expMonth", bean.getExpMonth());
			personMaintenanceMap.put("noVoyage", bean.getNoVoyage());
			personMaintenanceMap.put("vslType", (bean.getProposedType() == null || bean.getProposedType().isEmpty()) ? null : Integer.parseInt(bean.getProposedType()));
			personMaintenanceMap.put("lastSignOff", (bean.getSignedOff() == null || bean.getSignedOff().isEmpty()) ? null : bean.getSignedOff());
			personMaintenanceMap.put("available", (bean.getAvailableFrom() == null || bean.getAvailableFrom().isEmpty()) ? null : bean.getAvailableFrom());
			personMaintenanceMap.put("remarksOne", bean.getRemarksOne());
			personMaintenanceMap.put("remarksTwo", bean.getRemarksTwo());
			personMaintenanceMap.put("reCom", bean.getReCom());
			personMaintenanceMap.put("age", bean.getAge());
			personMaintenanceMap.put("compService", bean.getCompService());
			personMaintenanceMap.put("seaService", bean.getSeaService());
			personMaintenanceMap.put("yearsInRank", bean.getYearsInRank());
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
			personMaintenanceMap.put("crewMasterImg", bean.getImgName());
			personMaintenanceMap.put("crewMasterFilePath", bean.getImgPath());
			personMaintenanceMap.put("adhar", bean.getAdhar());
			personMaintenanceMap.put("sidFileName", bean.getSidFileName());
			personMaintenanceMap.put("sidFilePath", bean.getSidFilePath());
			personMaintenanceMap.put("cvFileName", bean.getCvFileName());
			personMaintenanceMap.put("cvFilePath", bean.getCvFilePath());
			
			namedParameterJdbcTemplate.update(PersonMaintenanceQueryUtil.SAVE_CREW_MASTER_DOCUMENT,personMaintenanceMap);
			
			//Rank Details 
			if(bean.getRank() != null && !bean.getRank().isEmpty()) {
			  namedParameterJdbcTemplate.update(PersonMaintenanceQueryUtil.SAVE_RANK_DTLS,personMaintenanceMap);
			}
			
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
			jdbcTemplate.update(PersonMaintenanceQueryUtil.DELETE_CREW_MASTER_RANK_DTL,id);
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
			PersonMaintenanceBean crewMasterDtls =  new PersonMaintenanceBean();
			resultBean.setCrewMasterDtls(jdbcTemplate.queryForObject(PersonMaintenanceQueryUtil.GET_CREW_MASTER_DTLS,new Object[] { id }, new BeanPropertyRowMapper<PersonMaintenanceBean>(PersonMaintenanceBean.class)));
//			resultBean.setCrewMasterDocDtls(jdbcTemplate.queryForObject(PersonMaintenanceQueryUtil.GET_CREW_MASTER_DOCUMENT_DTLS,new Object[] { id }, new BeanPropertyRowMapper<PersonMaintenanceBean>(PersonMaintenanceBean.class)));
			
			List<PersonMaintenanceBean> results = jdbcTemplate.query(
				    PersonMaintenanceQueryUtil.GET_CREW_MASTER_DOCUMENT_DTLS,
				    new Object[] { id },
				    new BeanPropertyRowMapper<>(PersonMaintenanceBean.class)
			);
			Integer count = jdbcTemplate.queryForObject(PersonMaintenanceQueryUtil.GET_RANK_DTL_COUNT,new Object[]{id}, Integer.class);
			
			if(count > 0) {
				String rankDate = jdbcTemplate.queryForObject(PersonMaintenanceQueryUtil.GET_RANK_DATE,new Object[]{id}, String.class);
				resultBean.getCrewMasterDtls().setRankDate(rankDate);
			}
			resultBean.setCrewMasterDocDtls(results.isEmpty() ? crewMasterDtls : results.get(0));
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
			personMaintenanceMap.put("appCode", Integer.parseInt(bean.getApplCode()));
			personMaintenanceMap.put("surname", bean.getSurname());
			personMaintenanceMap.put("name", bean.getName());
			personMaintenanceMap.put("middle", bean.getMiddle());
			personMaintenanceMap.put("nationality", Integer.parseInt(bean.getNationality()));
			personMaintenanceMap.put("rank", (bean.getRank() == null || bean.getRank().isEmpty()) ? null : Integer.parseInt(bean.getRank()));
			personMaintenanceMap.put("bDate", bean.getBirthDate());
			personMaintenanceMap.put("gender", bean.getGender());
			personMaintenanceMap.put("father", bean.getFather());
			personMaintenanceMap.put("mother", bean.getMother());
			personMaintenanceMap.put("place", bean.getPlace());
			personMaintenanceMap.put("licence", (bean.getLicence() == null || bean.getLicence().isEmpty()) ? null : Integer.parseInt(bean.getLicence()));
			personMaintenanceMap.put("healthSt", (bean.getHealth() == null || bean.getHealth().isEmpty()) ? null : Integer.parseInt(bean.getHealth()));
			personMaintenanceMap.put("decisionC", bean.getDecision());
			personMaintenanceMap.put("workStatus", (bean.getWorkStatus() == null || bean.getWorkStatus().isEmpty()) ? null : Integer.parseInt(bean.getWorkStatus()));
			personMaintenanceMap.put("religion", (bean.getReligion() == null || bean.getReligion().isEmpty()) ? null : Integer.parseInt(bean.getReligion()));
			personMaintenanceMap.put("agent", (bean.getAgent() == null || bean.getAgent().isEmpty()) ? null : Integer.parseInt(bean.getAgent()));
			personMaintenanceMap.put("expMonth", bean.getExpMonth());
			personMaintenanceMap.put("noVoyage", bean.getNoVoyage());
			personMaintenanceMap.put("vslType", (bean.getProposedType() == null || bean.getProposedType().isEmpty()) ? null : Integer.parseInt(bean.getProposedType()));
			personMaintenanceMap.put("lastSignOff", (bean.getSignedOff() == null || bean.getSignedOff().isEmpty()) ? null : bean.getSignedOff());
			personMaintenanceMap.put("available", (bean.getAvailableFrom() == null || bean.getAvailableFrom().isEmpty()) ? null : bean.getAvailableFrom());
			personMaintenanceMap.put("remarksOne", bean.getRemarksOne());
			personMaintenanceMap.put("remarksTwo", bean.getRemarksTwo());
			personMaintenanceMap.put("reCom", bean.getReCom());
			personMaintenanceMap.put("age", bean.getAge());
			personMaintenanceMap.put("compService", bean.getCompService());
			personMaintenanceMap.put("seaService", bean.getSeaService());
			personMaintenanceMap.put("yearsInRank", bean.getYearsInRank());
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
			personMaintenanceMap.put("crewMasterImg", bean.getImgName());
			personMaintenanceMap.put("crewMasterFilePath", bean.getImgPath());
			personMaintenanceMap.put("sidFileName", bean.getSidFileName());
			personMaintenanceMap.put("sidFilePath", bean.getSidFilePath());
			personMaintenanceMap.put("cvFileName", bean.getCvFileName());
			personMaintenanceMap.put("cvFilePath", bean.getCvFilePath());
			
			namedParameterJdbcTemplate.update(PersonMaintenanceQueryUtil.UPDATE_CREW_MASTER_DOCUMENT,personMaintenanceMap);
			
			//Check Rank Details
			Integer rankId = jdbcTemplate.queryForObject(PersonMaintenanceQueryUtil.GET_RANK_CODE,new Object[]{ bean.getCode() }, Integer.class);
			
			if(rankId != Integer.parseInt(bean.getRank())) {
			   namedParameterJdbcTemplate.update(PersonMaintenanceQueryUtil.SAVE_RANK_DTLS,personMaintenanceMap);
			}
			
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

	@Override
	public String generateCode() {
		String code = "";
		try {
			code = jdbcTemplate.queryForObject(PersonMaintenanceQueryUtil.GET_CODE,new Object[]{}, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}

	@Override
	public PersonMaintenanceResultBean getCheckListDtl(Integer id) {		
		PersonMaintenanceResultBean resultBean = new PersonMaintenanceResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setCrewMasterDtls(jdbcTemplate.queryForObject(PersonMaintenanceQueryUtil.GET_DOC_CHECK_LIST,new Object[] { id }, new BeanPropertyRowMapper<PersonMaintenanceBean>(PersonMaintenanceBean.class)));
			
			List<PersonMaintenanceBean> results = jdbcTemplate.query(
				    PersonMaintenanceQueryUtil.GET_CERTIFICATE_CHECK_LIST,
				    new Object[] { id },
				    new BeanPropertyRowMapper<>(PersonMaintenanceBean.class)
			);
			
			resultBean.setList(results);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}


	


}
