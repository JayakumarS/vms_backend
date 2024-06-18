package com.vms.common.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vms.core.util.CustomException;

@RestController
@RequestMapping("/api/common")
public class CommonServiceController {
	
	@Autowired
	CommonServiceService commonServicesService;
	
	@RequestMapping(value = "/validateUnique")
	public boolean validateUnique(@RequestParam("tableName") String tableName,@RequestParam("columnName") String columnName,@RequestParam("columnValue") String columnValue) throws Exception {
		boolean result = false;
		try {
			result = commonServicesService.validateUnique(tableName,columnName,columnValue);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//Fleet DropDown
	@RequestMapping("/getFleetList")
	public @ResponseBody CommonServicesResultBean getFleetList() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getFleetList());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//Vessel Class DropDown
	@RequestMapping("/getVesselClassList")
	public @ResponseBody CommonServicesResultBean getClassList() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getClassList());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//Vessel Type
	@RequestMapping("/getVesselType")
	public @ResponseBody CommonServicesResultBean getVesselType() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getVesselType());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//Vessel Insurance
	@RequestMapping("/getVesselInsurance")
	public @ResponseBody CommonServicesResultBean getVesselInsurance() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getVesselInsurance());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//Wage Scale
	@RequestMapping("/getWageScale")
	public @ResponseBody CommonServicesResultBean getWageScale() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getWageScale());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//Port
	@RequestMapping("/getPort")
	public @ResponseBody CommonServicesResultBean getPort() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getPort());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//Country
	@RequestMapping("/getCountry")
	public @ResponseBody CommonServicesResultBean getCountry() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getCountry());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
}
