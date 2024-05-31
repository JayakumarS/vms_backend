package com.vms.auditlog;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vms.common.AESEncrypt;
import com.vms.core.util.CustomException;
import com.vms.core.util.DropDownList;
import com.vms.security.JwtResponse;
import com.vms.security.LoginRequest;
import com.vms.userlog.UserLogBean;
import com.vms.userlog.UserLogResultBean;
import com.vms.usermanagement.User;
import com.vms.usermanagement.UserDetailsImpl;
@RestController
@RequestMapping("/api/auditLog")
public class AuditLogController  {
	
	@Autowired
	AuditLogService auditLogService;
	
	@Value("${secret-key}")
	private String secretKey;
	
	@PostMapping(value="/save",produces="application/json", consumes="application/json")
	public AuditLogResultBean save(@Valid @RequestBody AuditLogBean bean) {
		AuditLogResultBean objbean = new AuditLogResultBean();
		try {
			objbean = auditLogService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
	}
	
	@RequestMapping(value = "/getList")
   	public AuditLogResultBean getAuditLogList(@RequestBody AuditLogBean bean) throws Exception {
		AuditLogResultBean objResultBean = new AuditLogResultBean();
		objResultBean.setAuditLogDetails(auditLogService.getAuditLogList(bean));
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@GetMapping(value = "/viewAudit")
   	public AuditLogResultBean getViewAuditList(@RequestParam Long auditId ) throws Exception {
		
		AuditLogResultBean objResultBean = new AuditLogResultBean();
//		String dispatchId = AESEncrypt.decryptFile(auditId, secretKey);
		try {
			objResultBean = auditLogService.view(auditId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		return objResultBean;
	}
	
	@RequestMapping(value = "/getFormName")
	public AuditLogResultBean getFormName() {
		AuditLogResultBean rb = null;
		try {
			rb = auditLogService.getFormName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}

}
