package com.vms.crew.applications;

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

import com.vms.crew.maintainRank.MaintainRankBean;
import com.vms.crew.maintainRank.MaintainRankQueryUtil;
import com.vms.crew.maintainRank.MaintainRankResultBean;




@Repository

public class ApplicationsDaoImpl implements ApplicationsDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	
	@Override
	public List<ApplicationsBean> getenginelist() {
		List<ApplicationsBean> getenginelist = new ArrayList<>();

		try {
			getenginelist = jdbcTemplate.query(ApplicationsQueryUtil.getenginelist, new Object[] {},new BeanPropertyRowMapper<>(ApplicationsBean.class));

				

		} catch (Exception e) {
		}
		return getenginelist;
	}
	
	
	
	@Override
	public List<ApplicationsBean> getlicence() {
		List<ApplicationsBean> getlicence = new ArrayList<>();

		try {
			getlicence = jdbcTemplate.query(ApplicationsQueryUtil.getlicence, new Object[] {},new BeanPropertyRowMapper<>(ApplicationsBean.class));

				

		} catch (Exception e) {
		}
		return getlicence;
	}
	
	
	@Override
	public List<ApplicationsBean> getvessel() {
		List<ApplicationsBean> getvessel = new ArrayList<>();

		try {
			getvessel = jdbcTemplate.query(ApplicationsQueryUtil.getvessel, new Object[] {},new BeanPropertyRowMapper<>(ApplicationsBean.class));

				

		} catch (Exception e) {
		}
		return getvessel;
	}
	
	@Override
	public List<ApplicationsBean> getrank() {
		List<ApplicationsBean> getrank = new ArrayList<>();

		try {
			getrank = jdbcTemplate.query(ApplicationsQueryUtil.getrank, new Object[] {},new BeanPropertyRowMapper<>(ApplicationsBean.class));

				

		} catch (Exception e) {
		}
		return getrank;
	}
	
	@Override
	public List<ApplicationsBean> getnationality() {
		List<ApplicationsBean> getrank = new ArrayList<>();

		try {
			getrank = jdbcTemplate.query(ApplicationsQueryUtil.getnationality, new Object[] {},new BeanPropertyRowMapper<>(ApplicationsBean.class));

				

		} catch (Exception e) {
		}
		return getrank;
	}


	@Override
	public List<ApplicationsBean> getagent() {
		List<ApplicationsBean> getrank = new ArrayList<>();

		try {
			getrank = jdbcTemplate.query(ApplicationsQueryUtil.getagent, new Object[] {},new BeanPropertyRowMapper<>(ApplicationsBean.class));

				

		} catch (Exception e) {
		}
		return getrank;
	}
	
	
	@Override
	public ApplicationsResultBean save(ApplicationsBean bean) {
		ApplicationsResultBean resultBean = new ApplicationsResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(bean.getDob()=="") {
			bean.setDob(null);
		}
		if(bean.getSignOffDate()=="") {
			bean.setSignOffDate(null);
		}
		if(bean.getAppDate()=="") {
			bean.setAppDate(null);
		}
		if(bean.getAvailfromDate()=="") {
			bean.setAvailfromDate(null);
		}
		if(bean.getExpiryDate()=="") {
			bean.setExpiryDate(null);
		}
		if(bean.getPassportExpiryDate()=="") {
			bean.setPassportExpiryDate(null);
		}
		if(bean.getLicenceExpiryDate()=="") {
			bean.setLicenceExpiryDate(null);
		}
		
		
		if(bean.getNation()=="") {
			bean.setNation(null);
		}
		if(bean.getRank()=="") {
			bean.setRank(null);
		}
		if(bean.getVessel()=="") {
			bean.setVessel(null);
		}
		if(bean.getEngine()=="") {
			bean.setEngine(null);
		}
		if(bean.getAgent()=="") {
			bean.setAgent(null);
		}
		if(bean.getLicence()=="") {
			bean.setLicence(null);
		}
		try {
			Map<String, Object> applications = new HashMap<String, Object>();
			
			    applications.put("userName", userDetails.getUsername());
				applications.put("surname", bean.getSurname());
				applications.put("name", bean.getName());
				applications.put("nation", bean.getNation());
				applications.put("midname", bean.getMidname());
				applications.put("rank", bean.getRank());
				applications.put("dob", bean.getDob());
				applications.put("father", bean.getFather());
				applications.put("mother", bean.getMother());
				applications.put("birthplace", bean.getBirthplace());
				applications.put("vessel", bean.getVessel());
				applications.put("priormonth", bean.getPriormonth());
				applications.put("decisioncode", bean.getDecisioncode());
				applications.put("engine", bean.getEngine());
				applications.put("signOffDate", bean.getSignOffDate());
				applications.put("agent", bean.getAgent());
				applications.put("remarks", bean.getRemarks());
				applications.put("appDate", bean.getAppDate());
				applications.put("recom", bean.getRecom());
				applications.put("availfromDate", bean.getAvailfromDate());
				applications.put("book", bean.getBook());
				applications.put("issue", bean.getIssue());
				applications.put("expiryDate", bean.getExpiryDate());
				applications.put("passport", bean.getPassport());
				applications.put("passportissue", bean.getPassportissue());
				applications.put("passportExpiryDate", bean.getPassportExpiryDate());
				applications.put("licence", bean.getLicence());
				applications.put("licenceissue", bean.getLicenceissue());
				applications.put("licenceExpiryDate", bean.getLicenceExpiryDate());
				applications.put("grade", bean.getGrade());
				applications.put("licenceno", bean.getLicenceno());
				applications.put("kin", bean.getKin());
				applications.put("city", bean.getCity());
				applications.put("address1", bean.getAddress1());
				applications.put("tel1", bean.getTel1());
				applications.put("address2", bean.getAddress2());
				applications.put("tel2", bean.getTel2());
				
				applications.put("cvOperationsfilePath", bean.getCvOperationsfilePath());
				applications.put("cvOperationsfileName", bean.getCvOperationsfileName());
				applications.put("passBookfilePath", bean.getPassBookfilePath());
				applications.put("passBookfileName", bean.getPassBookfileName());
				applications.put("sBookfilePath", bean.getsBookfilePath());
				applications.put("sBookfileName", bean.getsBookfileName());
				applications.put("applicantimagePath", bean.getApplicantimagePath());
				applications.put("applicantimageFileName", bean.getApplicantimageFileName());
				
				
				namedParameterJdbcTemplate.update(ApplicationsQueryUtil.SAVE_APPLICATION,applications);
			
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	
	@Override
	public ApplicationsResultBean getList() {
		ApplicationsResultBean resultBean = new ApplicationsResultBean();
		List<ApplicationsBean> listBean = new ArrayList<ApplicationsBean>();
		
		try {
			listBean = jdbcTemplate.query(ApplicationsQueryUtil.getList,new BeanPropertyRowMapper<ApplicationsBean>(ApplicationsBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public ApplicationsResultBean edit(Integer id) {		
		ApplicationsResultBean resultBean = new ApplicationsResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(ApplicationsQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<ApplicationsBean>(ApplicationsBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	
	@Override
	public ApplicationsResultBean delete(Integer id) {
		ApplicationsResultBean resultBean = new ApplicationsResultBean();
		try {
			jdbcTemplate.update(ApplicationsQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}
	
	
	@Override
	public ApplicationsResultBean update(ApplicationsBean bean) {
		ApplicationsResultBean resultBean = new ApplicationsResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> applications = new HashMap<String, Object>();
			
		    applications.put("userName", userDetails.getUsername());
			applications.put("code", bean.getCode());
			applications.put("surname", bean.getSurname());
			applications.put("name", bean.getName());
			applications.put("nation", bean.getNation());
			applications.put("midname", bean.getMidname());
			applications.put("rank", bean.getRank());
			applications.put("dob", bean.getDob());
			applications.put("father", bean.getFather());
			applications.put("mother", bean.getMother());
			applications.put("birthplace", bean.getBirthplace());
			applications.put("vessel", bean.getVessel());
			applications.put("priormonth", bean.getPriormonth());
			applications.put("decisioncode", bean.getDecisioncode());
			applications.put("engine", bean.getEngine());
			applications.put("signOffDate", bean.getSignOffDate());
			applications.put("agent", bean.getAgent());
			applications.put("remarks", bean.getRemarks());
			applications.put("appDate", bean.getAppDate());
			applications.put("recom", bean.getRecom());
			applications.put("availfromDate", bean.getAvailfromDate());
			applications.put("book", bean.getBook());
			applications.put("issue", bean.getIssue());
			applications.put("expiryDate", bean.getExpiryDate());
			applications.put("passport", bean.getPassport());
			applications.put("passportissue", bean.getPassportissue());
			applications.put("passportExpiryDate", bean.getPassportExpiryDate());
			applications.put("licence", bean.getLicence());
			applications.put("licenceissue", bean.getLicenceissue());
			applications.put("licenceExpiryDate", bean.getLicenceExpiryDate());
			applications.put("grade", bean.getGrade());
			applications.put("licenceno", bean.getLicenceno());
			applications.put("kin", bean.getKin());
			applications.put("city", bean.getCity());
			applications.put("address1", bean.getAddress1());
			applications.put("tel1", bean.getTel1());
			applications.put("address2", bean.getAddress2());
			applications.put("tel2", bean.getTel2());
			
			applications.put("cvOperationsfilePath", bean.getCvOperationsfilePath());
			applications.put("cvOperationsfileName", bean.getCvOperationsfileName());
			applications.put("passBookfilePath", bean.getPassBookfilePath());
			applications.put("passBookfileName", bean.getPassBookfileName());
			applications.put("sBookfilePath", bean.getsBookfilePath());
			applications.put("sBookfileName", bean.getsBookfileName());
			applications.put("applicantimagePath", bean.getApplicantimagePath());
			applications.put("applicantimageFileName", bean.getApplicantimagePath());
				
			
					namedParameterJdbcTemplate.update(ApplicationsQueryUtil.UPDATE_APPLICATION,applications);
			
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
}
