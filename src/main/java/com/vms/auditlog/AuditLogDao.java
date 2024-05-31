package com.vms.auditlog;

import java.util.List;

import javax.validation.Valid;

public interface AuditLogDao {

	public AuditLogResultBean save(@Valid AuditLogBean bean) throws Exception;

	public List<AuditLogBean> getAuditLogList(AuditLogBean bean) throws Exception;

	public AuditLogResultBean view(Long auditId) throws Exception;

	public AuditLogResultBean getFormName() throws Exception;
	
}
