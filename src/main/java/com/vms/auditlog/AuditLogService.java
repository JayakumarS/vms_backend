package com.vms.auditlog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
public interface AuditLogService {


	public AuditLogResultBean save(@Valid AuditLogBean bean) throws Exception;

	public List<AuditLogBean> getAuditLogList(AuditLogBean bean) throws Exception;

	public AuditLogResultBean view(Long auditId) throws Exception;

	public AuditLogResultBean getFormName() throws Exception;
	
}
