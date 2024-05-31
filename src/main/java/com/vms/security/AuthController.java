package com.vms.security;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vms.common.services.CommonServiceService;
import com.vms.companyMaster.CompanyMasterQueryUtil;
import com.vms.companyMaster.CompanyMasterResultBean;
import com.vms.companyMaster.CompanyMasterService;
import com.vms.employeeMaster.EmployeeMasterBean;
import com.vms.employeeMaster.EmployeeMasterService;
import com.vms.usermanagement.User;
import com.vms.usermanagement.UserDetailsImpl;
import com.vms.usermaster.UserMasterBean;
import com.vms.usermaster.UserMasterResultBean;
import com.vms.usermaster.UserMasterService;

import org.apache.commons.lang3.RandomStringUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags="Authentication", description="Manages Authentication operation")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserMasterService userMasterService;
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	private EmployeeMasterService employeeMasterService;
	private CompanyMasterService companyMasterService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private CommonServiceService commonServicesService;
	
	
		
	@ApiOperation(value = "Sign In")
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		//loginRequest.setPassword(jwtUtils.decrypt(loginRequest.getPassword()));
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		roles.add("Admin");
		
		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),userDetails.getEmail(),roles,true,"Sucess","Admin"));
	}

	@ApiOperation(value = "Get user info by token")
	@GetMapping("/userbytoken")
	public Optional<User> getUserDetail(@RequestParam("token") String jwtToken) {
		Optional<User> userDetails = null;
		if (jwtToken != null && jwtUtils.validateJwtToken(jwtToken)) {
			String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
			//userDetails = userRepository.findByUsername(username); // by Kannan for JPA
			try {
				userDetails = employeeMasterService.getEmployeeUserName(username);
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			userDetails.get().setPassword(null);

		}
		return userDetails;
	}

	@ApiOperation(value = "Sign Up")
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody EmployeeMasterBean employeeMasterBean) {
//		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//			
//			return ResponseEntity.badRequest().body(new MessageResponse("Username is already taken!"));
//		}
//
//		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//			return ResponseEntity.badRequest().body(new MessageResponse("Email is already in use!"));
//		}

		// Create new user's account
		/*
		 * User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
		 * encoder.encode(signUpRequest.getPassword()));
		 */

		/*
		 * Set<String> strRoles = signUpRequest.getRole(); Set<Role> roles = new
		 * HashSet<>();
		 * 
		 * if (strRoles == null) { Role userRole =
		 * roleRepository.findByName(ERole.ROLE_USER) .orElseThrow(() -> new
		 * RuntimeException("Error: Role is not found.")); roles.add(userRole); } else {
		 * strRoles.forEach(role -> { switch (role) { case "admin": Role adminRole =
		 * roleRepository.findByName(ERole.ROLE_ADMIN) .orElseThrow(() -> new
		 * RuntimeException("Error: Role is not found.")); roles.add(adminRole);
		 * 
		 * break; default: Role userRole = roleRepository.findByName(ERole.ROLE_USER)
		 * .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		 * roles.add(userRole); } }); }
		 * 
		 * user.setRoles(roles); userRepository.save(user);
		 */
		
//		employeeMasterBean.setPassword(encoder.encode(employeeMasterBean.getPassword()));
//		EmployeeMasterResultBean insertAppUserMaster = employeeMasterService.addEmployeeMaster(employeeMasterBean); 
//		
		
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	//For companyLogo
	
	@ApiOperation(value = "Get Company")
	@GetMapping("/getCompany")
	public CompanyMasterResultBean getCompany() throws Exception{
		CompanyMasterResultBean objResultBean = new CompanyMasterResultBean();
		Integer length = jdbcTemplate.queryForObject(CompanyMasterQueryUtil.getCount,Integer.class);
		if(length > 0 ) {
			objResultBean = jdbcTemplate.queryForObject(CompanyMasterQueryUtil.Get_Company_Logo,new BeanPropertyRowMapper<CompanyMasterResultBean>(CompanyMasterResultBean.class));
		}
		objResultBean.setSuccess(true);
		return objResultBean;
	}
	
	
	/***************************  Forgotten Password ************************/
	@ApiOperation(value = "Forgotten Password")
	@PostMapping("/forgotPassword")
	public HashMap<String,Object> forgotPassword(@RequestBody LoginRequest loginRequest) throws Exception{
		String otpForForgotPassword = RandomStringUtils.random(8, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
		HashMap<String,Object> resultMap = commonServicesService.forgotPassword(loginRequest.getEmailId(),otpForForgotPassword);
		return resultMap;
	}
	
	@RequestMapping(value="/deleteUser")
	public UserMasterResultBean deleteUser(@RequestParam("userId") String userId) {
		UserMasterResultBean objbean = new UserMasterResultBean();
		try {
			objbean = userMasterService.deleteUser(userId);
			objbean.setSuccess(true);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objbean;
		
	}
	
	@RequestMapping(value="/save")
	public UserMasterResultBean save(@RequestBody UserMasterBean bean, HttpServletRequest request) {
		UserMasterResultBean objbean = new UserMasterResultBean();
		try {
			objbean = userMasterService.save(bean,request);
			objbean.setSuccess(true);
			
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
}
