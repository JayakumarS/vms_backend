package com.vms.crew.applications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.vms.crew.maintainRank.MaintainRankBean;
import com.vms.crew.maintainRank.MaintainRankQueryUtil;
import com.vms.crew.maintainRank.MaintainRankResultBean;
import com.vms.crew.utilities.MultiSeamen.MultiSeamenQueryUtil;
import com.vms.crew.utilities.MultiSeamen.MultiSeamenResultBean;




@Repository

public class ApplicationsDaoImpl implements ApplicationsDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	
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
		
		
//		if(bean.getNation()=="") {
//			bean.setNation(null);
//		}
//		if(bean.getRank()=="") {
//			bean.setRank(null);
//		}
		if(bean.getVessel()=="") {
			bean.setVessel(null);
		}
//		if(bean.getEngine()=="") {
//			bean.setEngine(null);
//		}
//		if(bean.getAgent()=="") {
//			bean.setAgent(null);
//		}
//		if(bean.getLicence()=="") {
//			bean.setLicence(null);
//		}
//		if(bean.getEngine()=="") {
//			bean.setEngine(null);
//		}
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
				
				
				int conHdrId = namedParameterJdbcTemplate.queryForObject(ApplicationsQueryUtil.SAVE_APPLICATION, applications,int.class);


				if (conHdrId > 0) {
				    // Insert regular certificates
				    List<ApplicationsBean> certificates = bean.getCertificates();
				    if (certificates != null && !certificates.isEmpty()) {
				        for (ApplicationsBean certificate : certificates) {
				            List<ApplicationsBean> splitCertificateNames = certificate.getSplitCertificateNames();
				            if (splitCertificateNames != null && !splitCertificateNames.isEmpty()) {
				                for (ApplicationsBean splitCertificateName : splitCertificateNames) {
				                    Map<String, Object> certificateMap = new HashMap<>();
				                    certificateMap.put("userName", userDetails.getUsername());
				                    certificateMap.put("applcode", conHdrId);
				                    certificateMap.put("rankCode", bean.getRankCode());
				                    certificateMap.put("certifiCode", certificate.getCertifiCode());
				                    certificateMap.put("mcertificateCode", null); // Set medical certificate code to null
				                    certificateMap.put("mandatoryValid", splitCertificateName.getMandatoryValid());
				                    certificateMap.put("mandatoryInvalid", splitCertificateName.getMandatoryInvalid());
				                    certificateMap.put("optionalInvalid", splitCertificateName.getOptionalInvalid());

				                    namedParameterJdbcTemplate.update(ApplicationsQueryUtil.SAVE_CERTIFICATE, certificateMap);
				                }
				            }
				        }
				    }

				    // Insert medical certificates
				    List<ApplicationsBean> medicalCertificates = bean.getMedicalcertificates();
				    if (medicalCertificates != null && !medicalCertificates.isEmpty()) {
				        for (ApplicationsBean mcertificate : medicalCertificates) {
				            List<ApplicationsBean> splitCertificateMedicalNames = mcertificate.getSplitCertificateMedicalNames();
				            if (splitCertificateMedicalNames != null && !splitCertificateMedicalNames.isEmpty()) {
				                for (ApplicationsBean splitCertificateName : splitCertificateMedicalNames) {
				                    Map<String, Object> certificateMap = new HashMap<>();
				                    certificateMap.put("userName", userDetails.getUsername());
				                    certificateMap.put("applcode", conHdrId);
				                    certificateMap.put("rankCode", bean.getRankCode());
				                    certificateMap.put("certifiCode", null); // Set regular certificate code to null
				                    certificateMap.put("mcertificateCode", mcertificate.getMcertificateCode());
				                    certificateMap.put("mandatoryValid", splitCertificateName.getMmandatoryValid());
				                    certificateMap.put("mandatoryInvalid", splitCertificateName.getMmandatoryInvalid());
				                    certificateMap.put("optionalInvalid", splitCertificateName.getMoptionalInvalid());

				                    namedParameterJdbcTemplate.update(ApplicationsQueryUtil.SAVE_CERTIFICATE, certificateMap);
				                }
				            }
				        }
				    }
				}


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
	
//	@Override
//	public ApplicationsResultBean edit(Integer id) {		
//		ApplicationsResultBean resultBean = new ApplicationsResultBean();
//		resultBean.setSuccess(false);
//		try {
//			resultBean.setList(jdbcTemplate.query(ApplicationsQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<ApplicationsBean>(ApplicationsBean.class)));
//			resultBean.setListpopup(jdbcTemplate.query(ApplicationsQueryUtil.getEditpopup,new Object[] { id,resultBean.}, new BeanPropertyRowMapper<ApplicationsBean>(ApplicationsBean.class)));
//
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		return resultBean; 
//	}
	
	
	@Override
	public ApplicationsResultBean edit(Integer id) {
	    ApplicationsResultBean resultBean = new ApplicationsResultBean();
	    resultBean.setSuccess(false);
	    try {
	        // Fetch the main details using getEdit query
	        List<ApplicationsBean> mainList = jdbcTemplate.query(ApplicationsQueryUtil.getEdit, new Object[]{id}, new BeanPropertyRowMapper<>(ApplicationsBean.class));
	        
	        if (!mainList.isEmpty()) {
	            // Assuming the first item contains the necessary rank_id
	            ApplicationsBean mainBean = mainList.get(0);
	            Integer rankId = mainBean.getRank();  // Adjust based on your actual getter method for rank_id
	            
	            // Fetch the popup details using getEditpopup query with the rank_id
	            List<ApplicationsBean> popupList = jdbcTemplate.query(ApplicationsQueryUtil.getEditpopup, new Object[]{id,id,rankId,id,rankId}, new BeanPropertyRowMapper<>(ApplicationsBean.class));
	            
	            resultBean.setList(mainList);
	            resultBean.setListpopup(popupList);
	            resultBean.setSuccess(true);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return resultBean;
	}

	
	
	@Override
	public ApplicationsResultBean delete(Integer id) {
		ApplicationsResultBean resultBean = new ApplicationsResultBean();
		 String code = null; 

		try {
			code = jdbcTemplate.queryForObject(ApplicationsQueryUtil.getCodeById, new Object[]{id}, String.class);

			
			jdbcTemplate.update(ApplicationsQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch (DataAccessException e) {
	        String errorMessage = e.getMessage();
	        if (errorMessage.contains("violates foreign key constraint")) {
	            resultBean.setSuccess(false);
	            resultBean.setMessage(code + " code cannot be deleted as it is already used in system.");
	        } else {
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMessage(errorMessage);
	        }
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
			
			
					
					   // Delete existing certificates
			        Map<String, Object> deleteParams = new HashMap<>();
			        deleteParams.put("applcode", bean.getCode());
			        namedParameterJdbcTemplate.update(ApplicationsQueryUtil.DELETE_CERTIFICATES, deleteParams);

			        // Insert regular certificates
			        List<ApplicationsBean> certificates = bean.getCertificates();
			        if (certificates != null && !certificates.isEmpty()) {
			            for (ApplicationsBean certificate : certificates) {
			                List<ApplicationsBean> splitCertificateNames = certificate.getSplitCertificateNames();
			                if (splitCertificateNames != null && !splitCertificateNames.isEmpty()) {
			                    for (ApplicationsBean splitCertificateName : splitCertificateNames) {
			                        Map<String, Object> certificateMap = new HashMap<>();
			                        certificateMap.put("userName", userDetails.getUsername());
			                        certificateMap.put("applcode", bean.getCode());
			                        certificateMap.put("rankCode", bean.getRankCode());
			                        certificateMap.put("certifiCode", certificate.getCertifiCode());
			                        certificateMap.put("mcertificateCode", null); // Set medical certificate code to null
			                        certificateMap.put("mandatoryValid", splitCertificateName.getMandatoryValid());
			                        certificateMap.put("mandatoryInvalid", splitCertificateName.getMandatoryInvalid());
			                        certificateMap.put("optionalInvalid", splitCertificateName.getOptionalInvalid());

			                        namedParameterJdbcTemplate.update(ApplicationsQueryUtil.SAVE_CERTIFICATE, certificateMap);
			                    }
			                }
			            }
			        }

			        // Insert medical certificates
			        List<ApplicationsBean> medicalCertificates = bean.getMedicalcertificates();
			        if (medicalCertificates != null && !medicalCertificates.isEmpty()) {
			            for (ApplicationsBean mcertificate : medicalCertificates) {
			                List<ApplicationsBean> splitCertificateMedicalNames = mcertificate.getSplitCertificateMedicalNames();
			                if (splitCertificateMedicalNames != null && !splitCertificateMedicalNames.isEmpty()) {
			                    for (ApplicationsBean splitCertificateName : splitCertificateMedicalNames) {
			                        Map<String, Object> certificateMap = new HashMap<>();
			                        certificateMap.put("userName", userDetails.getUsername());
			                        certificateMap.put("applcode", bean.getCode());
			                        certificateMap.put("rankCode", bean.getRankCode());
			                        certificateMap.put("certifiCode", null); // Set regular certificate code to null
			                        certificateMap.put("mcertificateCode", mcertificate.getMcertificateCode());
			                        certificateMap.put("mandatoryValid", splitCertificateName.getMmandatoryValid());
			                        certificateMap.put("mandatoryInvalid", splitCertificateName.getMmandatoryInvalid());
			                        certificateMap.put("optionalInvalid", splitCertificateName.getMoptionalInvalid());

			                        namedParameterJdbcTemplate.update(ApplicationsQueryUtil.SAVE_CERTIFICATE, certificateMap);
			                    }
			                }
			            }
			        }
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}



	@Override
	public ApplicationsResultBean certificateList(int rankCode) {
		ApplicationsResultBean resultBean = new ApplicationsResultBean();
		List<ApplicationsBean> listBean = new ArrayList<ApplicationsBean>();
		
		try {
			listBean = jdbcTemplate.query(ApplicationsQueryUtil.get_certificate_List(rankCode),new BeanPropertyRowMapper<ApplicationsBean>(ApplicationsBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}



	@Override
	public ApplicationsResultBean mcertificateList(int rankCode) {
		ApplicationsResultBean resultBean = new ApplicationsResultBean();
		List<ApplicationsBean> listBean = new ArrayList<ApplicationsBean>();
		
		try {
			listBean = jdbcTemplate.query(ApplicationsQueryUtil.get_mcertificate_List(rankCode),new BeanPropertyRowMapper<ApplicationsBean>(ApplicationsBean.class));
			resultBean.setList1(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	public ApplicationsResultBean saveCertificate(ApplicationsBean bean) {
	    ApplicationsResultBean resultBean = new ApplicationsResultBean();
	    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	    try {
	        // Loop through each certificate
	        for (ApplicationsBean certificate : bean.getCertificates()) {
	            // Loop through each splitCertificateName in the current certificate
	            for (ApplicationsBean splitCertificateName : certificate.getSplitCertificateNames()) {
	                Map<String, Object> certificateMap = new HashMap<>();

	                certificateMap.put("userName", userDetails.getUsername());
	                certificateMap.put("rankCode", bean.getRankCode());
	                certificateMap.put("certifiCode", certificate.getCertifiCode());
	                certificateMap.put("mandatoryValid", splitCertificateName.getMandatoryValid());
	                certificateMap.put("mandatoryInvalid", splitCertificateName.getMandatoryInvalid());
	                certificateMap.put("optionalInvalid", splitCertificateName.getOptionalInvalid());

	                namedParameterJdbcTemplate.update(ApplicationsQueryUtil.SAVE_CERTIFICATE, certificateMap);
	            }
	        }

	        resultBean.setSuccess(true);
	    } catch (Exception e) {
	        e.printStackTrace();
	        resultBean.setSuccess(false);
	    }
	    return resultBean;
	}




	
	
}
