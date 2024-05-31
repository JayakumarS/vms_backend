package com.vms.userlog;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.vms.usermanagement.User;
import com.vms.usermanagement.UserDetailsImpl;
@RestController
@RequestMapping("/api/userLog")
public class UserLogController  {
	
	@Value("${secret-key}")
	private String secretKey;
	
	public String randomSecretKey;
	
	@Autowired
	UserLogService userLogService;
	
	@PostMapping("/login_data_success_user_log")
	public void userLoginSuccessLog(@RequestBody User userDetail, HttpServletRequest request) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String userName = AESEncrypt.decryptFile(userDetails.getUsername(), this.randomSecretKey);
		System.out.println(userDetails.getUsername());
		//String roleName = AESEncrypt.decryptFile(passwordDTO.getRoleName(), secretKey);
		userLogService.successUserLog(userDetails.getUsername(), request);
	}
	
	
	@PostMapping("/logOut_user_log")
	public void userLogOutLog(@RequestBody User userDetail, HttpServletRequest request) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String userName = AESEncrypt.decryptFile(userDetails.getUsername(), this.randomSecretKey);
		System.out.println(userDetails.getUsername());
		//String roleName = AESEncrypt.decryptFile(passwordDTO.getRoleName(), secretKey);
		userLogService.logOutUserLog(userDetails.getUsername(), request);
	}
	
	@RequestMapping(value = "/getList")
   	public UserLogResultBean getUserLogList(@RequestBody UserLogBean bean) throws Exception {
		UserLogResultBean objResultBean = new UserLogResultBean();
		objResultBean.setUserLogDetails(userLogService.getUserLogList(bean));
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/getUserName")
	public UserLogResultBean getUserName() {
		UserLogResultBean rb = null;
		try {
			rb = userLogService.getUserName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	//dropdown getemployeelist
	@RequestMapping(value = "/getemployeelist")
	public UserLogResultBean getemployeelist() {
		UserLogResultBean rb = null;
		try {
			rb = userLogService.getemployeelist();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	@RequestMapping(value = "/getEmployeepuncheslist")
	public UserLogResultBean getEmployeepuncheslist( UserLogBean bean) {
		UserLogResultBean objbean = new UserLogResultBean();
		try {
			objbean = userLogService.getEmployeepuncheslist(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objbean;

	}
	
}
