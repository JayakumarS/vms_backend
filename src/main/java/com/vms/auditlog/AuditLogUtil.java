package com.vms.auditlog;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vms.employeeMaster.EmployeeMasterBean;
import com.vms.employeeMaster.EmployeeMasterService;
import com.vms.usermanagement.User;
import com.vms.usermanagement.UserDetailsImpl;
import com.vms.usermanagement.UserDetailsServiceImpl;

@Component
public class AuditLogUtil {
	
	@Autowired
	EmployeeMasterService employeeMasterService;
		
	@Autowired
	AuditLogService auditLogService;
	
	public void auditLog(JSONObject data, JSONObject oldData, String object, 
			String objectId, String action, HttpServletRequest request) throws Exception {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String userId = userDetails.getUsername();
		
		Optional<User> employeeMasterBean = employeeMasterService.getEmployeeUserName(userId);
		
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormatTime = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
		

		AuditLogBean auditLog = getAuditLog(request);
		auditLog.setActions(action);
				
		if(action == "INSERT" || action == "LOGIN") {
			auditLog.setPrimaryValue(null);
		} else if(action == "UPDATE" || action == "DELETE") {
			auditLog.setPrimaryValue("1");
			if(oldData != null) {
				auditLog.setOldData(oldData.toString());
			} else {
				auditLog.setOldData(null);
			}
		} 
		if(data != null) {
			auditLog.setData(data.toString());
		} else {
			auditLog.setData(null);
		}
		auditLog.setAuditLogId(employeeMasterBean.get().getId());
		auditLog.setIpAddress(auditLog.getIpAddress());
		auditLog.setHostName(auditLog.getHostName());
		auditLog.setObject(object);
		auditLog.setObjectId(objectId);
		auditLog.setCreatedBy(employeeMasterBean.get().getEmail());
		auditLog.setLastModifiedBy(employeeMasterBean.get().getEmail());
		auditLog.setUserName(userId);
		auditLog.setDateTime(dateFormatTime.format(date));
		
		auditLogService.save(auditLog);
		
	}
	
	public static AuditLogBean getClientIp(HttpServletRequest request) {
		AuditLogBean auditLogDto = new AuditLogBean();
	    for (String header : HEADERS_LIST) {
	        String ip = request.getHeader(header);
	        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
	        	 //if(isDebugEnabled)
	        		// System.out.println("ip Address :::::::::::::"+ip);
	        		 auditLogDto.setIpAddress(request.getRemoteAddr());
	        	return auditLogDto;
	        }
	    }
	    auditLogDto.setIpAddress(request.getRemoteAddr());
	    return auditLogDto; 
	}
	
	private static final String[] HEADERS_LIST = { 
		    "X-Forwarded-For",
		    "Proxy-Client-IP",
		    "WL-Proxy-Client-IP",
		    "HTTP_X_FORWARDED_FOR",
		    "HTTP_X_FORWARDED",
		    "HTTP_X_CLUSTER_CLIENT_IP",
		    "HTTP_CLIENT_IP",
		    "HTTP_FORWARDED_FOR",
		    "HTTP_FORWARDED",
		    "HTTP_VIA",
		    "REMOTE_ADDR" 
		};

	private AuditLogBean getAuditLog(HttpServletRequest request) {
		AuditLogBean auditLog = new AuditLogBean();
		
		try {
			//String ipAddress = request.getRemoteAddr();
			
//			String ipAddress = request.getHeader("X-FORWARDED-FOR");  
//			if (ipAddress == null) {  
//			    ipAddress = request.getRemoteAddr(); 
//			    ipAddress = request.getLocalAddr();
//			}		
//			auditLogDto.setIpAddress(ipAddress);
//			auditLogDto.setHostName(ipAddress);
			
			InetAddress ip = InetAddress.getLocalHost();
					
			auditLog.setIpAddress(ip.getHostAddress());
			auditLog.setHostName(ip.getHostName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auditLog;
	}

	static Pattern macpt = null;

	private static String getMac(String ip) {

		// Find OS and set command according to OS
		String OS = System.getProperty("os.name").toLowerCase();

		String[] cmd;
		if (OS.contains("win")) {
			// Windows
			macpt = Pattern.compile("[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+");
			String[] a = { "arp", "-a", ip };
			cmd = a;
		} else {
			// Mac OS X, Linux
			macpt = Pattern.compile("[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+");
			String[] a = { "arp", ip };
			cmd = a;
		}

		try {
			// Run command
			Process p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
			// read output with BufferedReader
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = reader.readLine();

			// Loop trough lines
			while (line != null) {
				Matcher m = macpt.matcher(line);
				// when Matcher finds a Line then return it as result
				if (m.find()) {
					//System.out.println("Found");
					//System.out.println("MAC: " + m.group(0));
					return m.group(0);
				}

				line = reader.readLine();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// Return empty string if no MAC is found
		return "";
	}

	public static String getMacAddress() throws Exception {
		String macAddress = null;
		String command = "ifconfig";

		String osName = System.getProperty("os.name");
		//System.out.println("Operating System is " + osName);

		if (osName.startsWith("Windows")) {
			command = "ipconfig /all";
		} else if (osName.startsWith("Linux") || osName.startsWith("Mac") || osName.startsWith("HP-UX")
				|| osName.startsWith("NeXTStep") || osName.startsWith("Solaris") || osName.startsWith("SunOS")
				|| osName.startsWith("FreeBSD") || osName.startsWith("NetBSD")) {
			command = "ifconfig -a";
		} else if (osName.startsWith("OpenBSD")) {
			command = "netstat -in";
		} else if (osName.startsWith("IRIX") || osName.startsWith("AIX") || osName.startsWith("Tru64")) {
			command = "netstat -ia";
		} else if (osName.startsWith("Caldera") || osName.startsWith("UnixWare") || osName.startsWith("OpenUNIX")) {
			command = "ndstat";
		} else {// Note: Unsupported system.
			throw new Exception("The current operating system '" + osName + "' is not supported.");
		}

		Process pid = Runtime.getRuntime().exec(command);
		BufferedReader in = new BufferedReader(new InputStreamReader(pid.getInputStream()));
		Pattern p = Pattern.compile("([\\w]{1,2}(-|:)){5}[\\w]{1,2}");
		while (true) {
			String line = in.readLine();
			//System.out.println("line " + line);
			if (line == null)
				break;

			Matcher m = p.matcher(line);
			if (m.find()) {
				macAddress = m.group();
				break;
			}
		}
		in.close();
		return macAddress;
		
	}
	
}
