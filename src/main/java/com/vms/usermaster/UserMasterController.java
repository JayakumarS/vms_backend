package com.vms.usermaster;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/userMaster")
public class UserMasterController {
	
	@Autowired
	UserMasterService userMasterService;
	
	
	@RequestMapping(value="/save")
	public UserMasterResultBean save(@RequestBody UserMasterBean bean, HttpServletRequest request) {
		UserMasterResultBean objbean = new UserMasterResultBean();
		try {
			objbean = userMasterService.save(bean,request);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	@RequestMapping(value = "/getDesignationList")
   	public UserMasterResultBean getDesignationList() {
		UserMasterResultBean rb = null;
		try {
			rb = userMasterService.getDesignationList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		return rb;
   	}
	
	@RequestMapping(value = "/getDepartmentList")
   	public UserMasterResultBean getDepartmentList() {
		UserMasterResultBean rb = null;
		try {
			rb = userMasterService.getDepartmentList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		return rb;
   	}
	
	@RequestMapping(value = "/getUserNameList")
   	public UserMasterResultBean getUserNameList() {
		UserMasterResultBean rb = null;
		try {
			rb = userMasterService.getUserNameList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		return rb;
   	}
	
	@RequestMapping(value = "/getList")
   	public UserMasterResultBean getUserList(@RequestBody UserMasterBean bean) throws Exception {
		UserMasterResultBean objResultBean = new UserMasterResultBean();
		objResultBean.setUserMasterDetails(userMasterService.getUserList(bean));
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value="/edit")
	public UserMasterResultBean edit(@RequestParam("userId") String userId) {
		UserMasterResultBean objResultBean = new UserMasterResultBean();
		try {
			objResultBean = userMasterService.edit(userId);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objResultBean;
		
	}
	
	@RequestMapping(value="/update")
	public UserMasterResultBean update(@RequestBody UserMasterBean bean,HttpServletRequest request) {
		UserMasterResultBean objResultBean = new UserMasterResultBean();
		try {
			objResultBean = userMasterService.update(bean,request);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objResultBean;
		
	}
	
	@RequestMapping(value="/delete")
	public UserMasterResultBean delete(@RequestParam("userId") String userId,HttpServletRequest request) {
		UserMasterResultBean objResultBean = new UserMasterResultBean();
		try {
			objResultBean = userMasterService.delete(userId,request);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objResultBean;
		
	}
	
//	@RequestMapping(value = "/validateFullName")
//	public boolean validateFullName(@RequestParam("tableName") String tableName,@RequestParam("columnName") String columnName,@RequestParam("columnValue") String columnValue) throws Exception {
//		boolean result = false;
//		try {
//			result = userMasterService.validateFullName(tableName,columnName,columnValue);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	
	@GetMapping(value = "/validateFullName")
	public UserMasterResultBean validateFullName(@RequestParam String userId) {
		UserMasterResultBean objbean = new UserMasterResultBean();
		try {
			objbean = userMasterService.validateFullName(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objbean;

	}
	
	
	@RequestMapping(value = "/validateLoginName")
	public boolean validateLoginName(@RequestParam("tableName") String tableName,@RequestParam("columnName") String columnName,@RequestParam("columnValue") String columnValue) throws Exception {
		boolean result = false;
		try {
			result = userMasterService.validateLoginName(tableName,columnName,columnValue);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@GetMapping(value = "/oldPasswordValidation")
   	public UserMasterResultBean oldPasswordValidation(@RequestParam("validatePassword") String validatePassword,@RequestParam("userId") String userId) throws Exception {
   		return userMasterService.oldPasswordValidation(validatePassword,userId);
   	}
	
	@PostMapping(value = "/updatePassword")
   	public UserMasterResultBean updatePassword(@RequestBody UserMasterBean bean)throws Exception {
		UserMasterResultBean objResultBean = new UserMasterResultBean();
		try {
			objResultBean = userMasterService.updatePassword(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
   	}
	
	@GetMapping(value = "/resetPasswordCheck")
   	public boolean resetPasswordCheck(@RequestParam("resetPasswordPopUp") String userId) throws Exception {
   		return userMasterService.resetPasswordCheck(userId);
   	}
	
	@RequestMapping(value = "/validateLoginid")
	public boolean validateLoginid(@RequestParam("tableName") String tableName,@RequestParam("columnName") String columnName,@RequestParam("columnValue") String columnValue) throws Exception {
		boolean result = false;
		try {
			result = userMasterService.validateLoginid(tableName,columnName,columnValue);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
