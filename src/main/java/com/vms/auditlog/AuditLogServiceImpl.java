package com.vms.auditlog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AuditLogServiceImpl implements AuditLogService {
	
	@Autowired
	AuditLogDao auditLogDao;

	@Override
	public AuditLogResultBean save(@Valid AuditLogBean bean) throws Exception {
		// TODO Auto-generated method stub
		return auditLogDao.save(bean);
	}

	@Override
	public List<AuditLogBean> getAuditLogList(AuditLogBean bean) throws Exception {
		// TODO Auto-generated method stub
		return auditLogDao.getAuditLogList(bean);
	}

	@Override
	public AuditLogResultBean view(Long auditId) throws Exception {
		// TODO Auto-generated method stub
		return auditLogDao.view(auditId);
	}

	@Override
	public AuditLogResultBean getFormName() throws Exception {
		// TODO Auto-generated method stub
		return auditLogDao.getFormName();
	}

}
