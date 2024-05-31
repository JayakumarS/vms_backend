package com.vms.auditlog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vms.common.AESEncrypt;
import com.vms.common.Selectivity;
import com.vms.userlog.UserLogBean;
import com.vms.userlog.UserLogQueryUtil;
import com.vms.userlog.UserLogResultBean;

@Repository
public class AuditLogDaoImpl implements AuditLogDao {
	@Value("${secret-key}")
	private String secretKey;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
		
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public AuditLogResultBean save(@Valid AuditLogBean bean) throws Exception {
		AuditLogResultBean resultBean = new AuditLogResultBean();
 		try { 			
			
 			Map<String, Object> saveMap = new HashMap<String, Object>();			
			
			saveMap.put("createdBy", bean.getCreatedBy());
			saveMap.put("lastModifiedBy", bean.getLastModifiedBy());
			saveMap.put("actions", bean.getActions());
			saveMap.put("data", bean.getData());
			saveMap.put("hostName", bean.getHostName());
			saveMap.put("ipAddress", bean.getIpAddress());
			saveMap.put("macAddress", bean.getMacAddress());
			saveMap.put("object", bean.getObject());
			saveMap.put("objectId", bean.getObjectId());
			saveMap.put("oldData", bean.getOldData());
			saveMap.put("primaryKeyType", bean.getPrimaryKeyType());
			saveMap.put("primaryValue", bean.getPrimaryValue());
			saveMap.put("auditLogEmpId", bean.getAuditLogEmpId());
			saveMap.put("userId", bean.getUserName());
			saveMap.put("dateTime", bean.getDateTime());
	
			int insetEmp = namedParameterJdbcTemplate.update(AuditLogQueryUtil.INSERT_AUDIT_LOG, saveMap);
			
		    resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public List<AuditLogBean> getAuditLogList(AuditLogBean bean) throws Exception {
		List<AuditLogBean> userBean = new ArrayList<AuditLogBean>();
		try {
			
			String whereCode="";
			if(!bean.getFromDate().equals("")) {
				whereCode+=" and created_date::Date >= to_date('"+bean.getFromDate()+"','dd-MM-yyyy')";
			} 
			
			if(!bean.getToDate().equals("")) {
				whereCode+=" and created_date::Date <= to_date('"+bean.getToDate()+"','dd-MM-yyyy')";
			}
			
			if(!bean.getActions().equals("")) {
				whereCode+=" and action='"+bean.getActions()+"'";
			}
			
			if(!bean.getUserName().equals("")) {
				whereCode+=" and user_name='"+bean.getUserName()+"'";
			}
			
			if(!bean.getFormName().equals("")) {
				whereCode+=" and object='"+bean.getFormName()+"'";
			}
			
			
			
	     userBean = jdbcTemplate.query(AuditLogQueryUtil.getAuditLogList+whereCode+" order by audit_log_id desc ",new BeanPropertyRowMapper<AuditLogBean>(AuditLogBean.class));
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return userBean;
	}

	@Override
	public AuditLogResultBean view(Long auditId) throws Exception {
		
//	String dispatchId = AESEncrypt.decryptFile(auditId, secretKey);
//	Long dispatchId = Long.parseLong(AESEncrypt.decryptFile(auditId, secretKey));

	AuditLogResultBean resultBean = new AuditLogResultBean();
	resultBean.setSuccess(false);
	
	try {
		resultBean.setAuditLogBean(jdbcTemplate.queryForObject(AuditLogQueryUtil.SELECT_AUDIT_LOG,new Object[] { auditId }, new BeanPropertyRowMapper<AuditLogBean>(AuditLogBean.class)));
		resultBean.setSuccess(true);
	}
	catch(Exception e) {
		e.printStackTrace();
		resultBean.setSuccess(false);
	}
	return resultBean;
	}

	@Override
	public AuditLogResultBean getFormName() throws Exception {
		// TODO Auto-generated method stub
		AuditLogResultBean rb = new AuditLogResultBean();
		List<Selectivity> formList = null;
		try {
			formList = jdbcTemplate.query(new AuditLogQueryUtil().getFormName,
					new BeanPropertyRowMapper<Selectivity>(Selectivity.class));
			rb.setFormList(formList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rb;
	}
	
}
