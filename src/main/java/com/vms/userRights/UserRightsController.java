package com.vms.userRights;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth/app/userRights")
public class UserRightsController {
	@Autowired
	UserRightsService userRightsService;
	

	@RequestMapping(value = "/getUserList")
   	public UserRightsResultBean getSalesOrderList() throws Exception {
		UserRightsResultBean objResultBean = new UserRightsResultBean();
		
		objResultBean.setUserList(userRightsService.getuserList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	
	@RequestMapping(value = "/getCompanyList")
   	public UserRightsResultBean getCompanyList() throws Exception {
		UserRightsResultBean objResultBean = new UserRightsResultBean();
		
		objResultBean.setCompanyList(userRightsService.getCompanyList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/getModuleList")
   	public UserRightsResultBean getModuleList() throws Exception {
		UserRightsResultBean objResultBean = new UserRightsResultBean();
		
		objResultBean.setModuleList(userRightsService.getModuleList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	
	@RequestMapping(value = "/getuserFormList")
   	public UserRightsResultBean getuserFormList() throws Exception {
		UserRightsResultBean objResultBean = new UserRightsResultBean();
		
		objResultBean.setUserFormList(userRightsService.getuserFormList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
//	@GetMapping(value = "/getFormList")
//   	public @ResponseBody UserRightsResultBean getFormList(@Valid @RequestParam("userId") Integer userId) throws Exception {
//   		return userRightsService.getFormList(userId);
//   	} 
	@GetMapping(value="/getFormList")
	public UserRightsResultBean getFormList(@RequestParam("userId") String userId) {
		UserRightsResultBean objResultBean = new UserRightsResultBean();
		try {
			objResultBean = userRightsService.getFormList(userId);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@GetMapping(value="/getFormByModuleList")
	public UserRightsResultBean getFormByModuleList(@RequestParam("userId") String userId,@RequestParam("moduleCode") String moduleCode) {
		UserRightsResultBean objResultBean = new UserRightsResultBean();
		try {
			objResultBean = userRightsService.getFormByModuleList(userId,moduleCode);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value = "/getPropertyList")
   	public UserRightsResultBean getPropertyList() throws Exception {
		UserRightsResultBean objResultBean = new UserRightsResultBean();
		
		objResultBean.setPropertyList(userRightsService.getPropertyList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	
	@GetMapping(value = "/getuserpermissions")
	public @ResponseBody UserRightsResultBean getUserPermissions(@RequestParam String userId,
			@RequestParam String companyCode, @RequestParam String moduleCode)
			throws Exception {
		UserRightsResultBean objUserMasterResultBean = new UserRightsResultBean();
		
		
		objUserMasterResultBean.setlFormMasterBean(userRightsService.getFormMasterListByCompanyUser(userId, companyCode, moduleCode));
		objUserMasterResultBean.setSuccess(true);
		return objUserMasterResultBean;
	}
	
	
	
	
	@PostMapping(value="/save")
	public UserRightsResultBean save( @RequestBody UserRightsBean bean) {
		UserRightsResultBean objbean = new UserRightsResultBean();
		try {
			objbean = userRightsService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	@PostMapping(value="/getAllPagePermissionList",produces="application/json", consumes="application/json")
	public PermissionResultBean getAllPagePermissionList(@RequestBody PermissionBean permissionBean,HttpServletRequest request) {
			return userRightsService.getAllPagePermissionList(permissionBean,request);
	}
	
	
	//Mobile User Rigts

	
	@PostMapping(value="/getPermissionList")
	public UserRightsResultBean getPermissionList(@RequestBody PermissionBean permissionBean) {
		UserRightsResultBean objResultBean = new UserRightsResultBean();
		try {
			objResultBean = userRightsService.getPermissionList(permissionBean.getUserId());
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	/*
	 * //MVJ
	 * 
	 * @GetMapping(value = "/getuserpermissions1") public @ResponseBody
	 * UserRightsResultBean getUserPermissions(@RequestParam("userId") String
	 * userId,@RequestParam("companyCode") String
	 * companyCode, @RequestParam("moduleCode") String
	 * moduleCode, @RequestParam("formCode") String formCode) throws Exception { int
	 * companyUserId = userRightsService.getCompanyUserId(companyCode, userId);
	 * List<FormMasterBean> lFormMasterBean =
	 * userRightsService.getFormMasterList(companyUserId, moduleCode, formCode);
	 * UserRightsResultBean objUserMasterResultBean = new UserRightsResultBean();
	 * objUserMasterResultBean.setCompanyUserId(companyUserId);
	 * objUserMasterResultBean.setlFormMasterBean1(lFormMasterBean);
	 * objUserMasterResultBean.setSuccess(true); return objUserMasterResultBean; }
	 */
}
