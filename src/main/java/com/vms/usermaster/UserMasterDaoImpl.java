package com.vms.usermaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.vms.auditlog.AuditLogUtil;
import com.vms.auditlog.constants;
import com.vms.common.AESEncrypt;
import com.vms.common.Selectivity;



@Repository
public class UserMasterDaoImpl implements UserMasterDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Value("${secret-key}")
	private String secretKey;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserMasterAuditLog userMasterAuditLog;
	
	@Autowired
	AuditLogUtil auditLogUtil;

	@Override
	public UserMasterResultBean save(UserMasterBean bean, HttpServletRequest request) throws Exception {
		UserMasterResultBean resultBean = new UserMasterResultBean();
		try {
			Map<String, Object> userMasterMap = new HashMap<String, Object>();
			
			String password="$2a$10$1bLVBiK6KptrIP1intALmuwpg3WfZ00cp3m3F7eeV1iHBCuZMFYLq";
			
			userMasterMap.put("fullName",bean.getFullName().toUpperCase());
			userMasterMap.put("emailId", bean.getEmailId());
			userMasterMap.put("contactNumber",bean.getContactNumber() );
			userMasterMap.put("designation", bean.getDesignation());
			userMasterMap.put("department", bean.getDepartment());
			userMasterMap.put("company", bean.getCompany());
			userMasterMap.put("address", bean.getAddress());
			userMasterMap.put("location", bean.getLocation());
			userMasterMap.put("reportingmngr", bean.getReportingmngr());
			userMasterMap.put("usertype", bean.getUsertype());
			userMasterMap.put("status", bean.getStatus());
			userMasterMap.put("password", password);
			userMasterMap.put("createdby", bean.getCreatedby());
			userMasterMap.put("loginName", bean.getLoginName().toUpperCase());
			
//			String empId =  jdbcTemplate.queryForObject(UserMasterQueryUtil.GETEMPID, String.class);
			userMasterMap.put("empId", bean.getEmpId());

			namedParameterJdbcTemplate.update(UserMasterQueryUtil.INSERT_AUTH_MASTER, userMasterMap);

			namedParameterJdbcTemplate.update(UserMasterQueryUtil.Insert_User_Master,userMasterMap);
			
			namedParameterJdbcTemplate.update(UserMasterQueryUtil.INSERT_EMPLOYEE, userMasterMap);
			
			namedParameterJdbcTemplate.update(UserMasterQueryUtil.INSERT_Company_User, userMasterMap);

			
		   resultBean.setSuccess(true);
		   resultBean.setUserNameForPopUp(bean.getLoginName().toUpperCase());
		   resultBean.setPasswordForPopUp("paragon@01");
		   
		    //For Audit Log 		   
		    String userID = jdbcTemplate.queryForObject(UserMasterQueryUtil.GET_USER_ID,new Object[] { bean.getEmpId() }, String.class);		
		   	String id = userID.toString();
			String code = (AESEncrypt.encryptFile(id, secretKey));
			UserMasterResultBean userMasterResultBean = edit(code);	
			 
		    JSONObject oldData = null;
			JSONObject data = userMasterAuditLog.userMasterAuditLog(userMasterResultBean.getUserMasterBean());	
			String objectId = bean.getEmpId();
			auditLogUtil.auditLog( data, oldData, constants.User_Master, objectId, constants.Insert, request);
			
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public UserMasterResultBean getDesignationList() throws Exception {
		UserMasterResultBean rb = new UserMasterResultBean();
		List<Selectivity> designationList = null;
		try {
			designationList = jdbcTemplate.query(new UserMasterQueryUtil().getDesignationList,
					new BeanPropertyRowMapper<Selectivity>(Selectivity.class));
			rb.setDesignationList(designationList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}

	@Override
	public UserMasterResultBean getDepartmentList() throws Exception {
		UserMasterResultBean rb = new UserMasterResultBean();
		List<Selectivity> departmentList = null;
		try {
			departmentList = jdbcTemplate.query(new UserMasterQueryUtil().getDepartnemtList,
					new BeanPropertyRowMapper<Selectivity>(Selectivity.class));
			rb.setDepartmentList(departmentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	@Override
	public UserMasterResultBean getUserNameList() throws Exception {
		UserMasterResultBean rb = new UserMasterResultBean();
		List<Selectivity> usernameList = null;
		try {
			usernameList = jdbcTemplate.query(new UserMasterQueryUtil().getUserNameList,
					new BeanPropertyRowMapper<Selectivity>(Selectivity.class));
			rb.setUserNameList(usernameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}

	@Override
	public List<UserMasterBean> getUserList(UserMasterBean bean) throws Exception {
		List<UserMasterBean> userBean = new ArrayList<UserMasterBean>();
		try {
//			
//			String whereCode="";
//			if(!bean.getFromDate().equals("")) {
//				whereCode+=" and date >= to_date('"+bean.getFromDate()+"','yyyy-MM-dd')";
//			} 
//			
//			if(!bean.getToDate().equals("")) {
//				whereCode+=" and date <= to_date('"+bean.getToDate()+"','yyyy-MM-dd')";
//			}
//			
//			if(!bean.getStatus().equals("")) {
//				whereCode+=" and status='"+bean.getStatus()+"'";
//			}
//			
//			if(!bean.getUserName().equals("")) {
//				whereCode+=" and user_name='"+bean.getUserName()+"'";
//			}
			
	     userBean = jdbcTemplate.query(UserMasterQueryUtil.getList,new BeanPropertyRowMapper<UserMasterBean>(UserMasterBean.class));
			
	
		}catch(Exception e){
			e.printStackTrace();
		}
		return userBean;
	}

	@Override
	public UserMasterResultBean edit(String userId) throws Exception {
		
		String dispatchId = (AESEncrypt.decryptFile(userId,secretKey));
		int userID = Integer.parseInt(dispatchId);
		UserMasterResultBean resultBean = new UserMasterResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setUserMasterBean(jdbcTemplate.queryForObject(UserMasterQueryUtil.getEdit,new Object[] { userID }, new BeanPropertyRowMapper<UserMasterBean>(UserMasterBean.class)));
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public UserMasterResultBean update(UserMasterBean bean, HttpServletRequest request) throws Exception {
		UserMasterResultBean resultBean = new UserMasterResultBean();
		
		//For Audit Log 
	   	String id = bean.getUserId().toString();
		String code = (AESEncrypt.encryptFile(id, secretKey));
		UserMasterResultBean userMasterResultBean = edit(code);
		JSONObject oldData = userMasterAuditLog.userMasterAuditLog(userMasterResultBean.getUserMasterBean());
		
		try {
			Map<String, Object> userMasterMap = new HashMap<String, Object>();
		
			userMasterMap.put("fullName",bean.getFullName());
			userMasterMap.put("loginName", bean.getLoginName());
			userMasterMap.put("emailId", bean.getEmailId());
			userMasterMap.put("contactNumber",bean.getContactNumber());
//			userMasterMap.put("password", bean.getPassword());
			userMasterMap.put("empId", bean.getEmpId());
			userMasterMap.put("designation", bean.getDesignation());
			userMasterMap.put("department", bean.getDepartment());
			userMasterMap.put("company", bean.getCompany());
			userMasterMap.put("address", bean.getAddress());
			userMasterMap.put("location", bean.getLocation());
			userMasterMap.put("reportingmngr", bean.getReportingmngr());
			userMasterMap.put("usertype", bean.getUsertype());
			userMasterMap.put("status", bean.getStatus());


			namedParameterJdbcTemplate.update(UserMasterQueryUtil.UPDATE_USER_MASTER,userMasterMap);
			namedParameterJdbcTemplate.update(UserMasterQueryUtil.UPDATE_AUTH_MASTER,userMasterMap);
			namedParameterJdbcTemplate.update(UserMasterQueryUtil.UPDATE_EMPLOYEE_MASTER,userMasterMap);
			namedParameterJdbcTemplate.update(UserMasterQueryUtil.UPDATE_COMPANY_MASTER,userMasterMap);
			
		   resultBean.setSuccess(true);
		   
		   //For Audit Log
		   JSONObject data = new JSONObject(userMasterMap);
		   String objectId = bean.getEmpId();
		   auditLogUtil.auditLog( data, oldData, constants.User_Master, objectId, constants.Update, request);
		   
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public UserMasterResultBean delete(String userId, HttpServletRequest request) throws Exception {
		UserMasterResultBean resultBean = new UserMasterResultBean();
		
		int userMasterId = Integer.parseInt(userId);
		
		try {
			jdbcTemplate.update(UserMasterQueryUtil.Delete_User_Master,userMasterId);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

//	@Override
//	public boolean validateFullName(String tableName, String columnName, String columnValue) throws Exception {
//		// TODO Auto-generated method stub
//		boolean count =  jdbcTemplate.queryForObject(UserMasterQueryUtil.VALIDATE_UNIQUE,new Object[] { tableName,columnName,columnValue }, Boolean.class);
//		return count;
//	}
	
	
	@Override
	public UserMasterResultBean validateFullName(String userId) throws Exception {
		
		UserMasterResultBean resultBean = new UserMasterResultBean();
		try {
			if (userId != null){
				
				int count =  jdbcTemplate.queryForObject(UserMasterQueryUtil.VALIDATE_UNIQUE,new Object[] {userId},Integer.class);
				
				if (count != 0)
				{
					resultBean.setValidateFullName(true);;
				}
				else
				{
					resultBean.setValidateFullName(false);;
				}
				
			
				resultBean.setSuccess(true);
			}
			
		} catch (Exception e) {
			resultBean.setSuccess(false);
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public boolean validateLoginName(String tableName, String columnName, String columnValue) throws Exception {
		// TODO Auto-generated method stub
		boolean count =  jdbcTemplate.queryForObject(UserMasterQueryUtil.VALIDATE_UNIQUE,new Object[] { columnValue }, Boolean.class);
		return count;
	}
	
	@Override
	public UserMasterResultBean oldPasswordValidation(String inputPwd, String userId) throws Exception {
		// TODO Auto-generated method stub
		UserMasterResultBean usersMasterResultBean = new UserMasterResultBean();
		String password = jdbcTemplate.queryForObject(UserMasterQueryUtil.GETOLDPASSWORD,new Object[] { userId }, String.class);
		
		usersMasterResultBean.setSuccess(false);
		if(!password.isEmpty()) {
			
			if(encoder.matches(inputPwd, password)) {
				usersMasterResultBean.setSuccess(true);
			}else {
				usersMasterResultBean.setSuccess(false);
			}
		}
		
		return usersMasterResultBean;
	}

	@Override
	public UserMasterResultBean updatePassword(UserMasterBean bean) throws Exception {
		// TODO Auto-generated method stub
		UserMasterResultBean resultBean = new UserMasterResultBean();
		
		try {
			Map<String, Object> updateChangePasswordMap = new HashMap<String, Object>();
			
			updateChangePasswordMap.put("password", encoder.encode(bean.getNewChangePassword()));
			updateChangePasswordMap.put("emailId", bean.getEmailId());

			int insertUserRoleMap = namedParameterJdbcTemplate.update(UserMasterQueryUtil.UPDATE_CHANGE_PASSWORD, updateChangePasswordMap);
			//EmailService.sendChangePasswordMail(bean.getEmailId(),bean.getFullName());
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}
	
	@Override
	public boolean resetPasswordCheck(String userId) throws Exception {
		// TODO Auto-generated method stub
		boolean  emailId =  jdbcTemplate.queryForObject(UserMasterQueryUtil.GET_FLAG_VALUE,new Object[] { userId }, boolean .class);
		return emailId;
	}

	@Override
	public UserMasterResultBean getList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateLoginid(String tableName, String columnName, String columnValue) {
		// TODO Auto-generated method stub
		boolean count =  jdbcTemplate.queryForObject(UserMasterQueryUtil.VALIDATE_UNIQUE_id,new Object[] { columnValue }, Boolean.class);
		return count;
	}

	@Override
	public UserMasterResultBean deleteUser(String userId) throws Exception {
		UserMasterResultBean resultBean = new UserMasterResultBean();
		try {
		jdbcTemplate.update(UserMasterQueryUtil.Delete_flag_User_Master,userId);
		resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	
	
}
