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
	
	//Currency
	@RequestMapping("/getCurrency")
	public @ResponseBody CommonServicesResultBean getCurrency() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getCurrency());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//Vessel Insurance
	@RequestMapping("/getVesselOwner")
	public @ResponseBody CommonServicesResultBean getVesselOwner() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getVesselOwner());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	
	//phone code
	@RequestMapping("/getphoneCode")
	public @ResponseBody CommonServicesResultBean getphoneCode() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getphoneCode());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//Official Managers
	@RequestMapping("/getOfficialManagers")
	public @ResponseBody CommonServicesResultBean getOfficialManagers() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getOfficialManagers());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//Official Managers
	@RequestMapping("/getShipManagers")
	public @ResponseBody CommonServicesResultBean getShipManagers() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getShipManagers());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//get Vessel
		@RequestMapping("/getVessel")
		public @ResponseBody CommonServicesResultBean getVessel() throws CustomException {
			CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
			try {
				commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getVessel());
				commonUtilityResultBean.setSuccess(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return commonUtilityResultBean;
		}
		
	//get Joining Port
			@RequestMapping("/getjoinport")
			public @ResponseBody CommonServicesResultBean getjoinport() throws CustomException {
				CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
				try {
					commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getjoinport());
					commonUtilityResultBean.setSuccess(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return commonUtilityResultBean;
			}
			
	//Rank Master
	@RequestMapping("/getRankMasters")
	public @ResponseBody CommonServicesResultBean getRankMasters() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getRankMasters());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//Agent List
	@RequestMapping("/getAgents")
	public @ResponseBody CommonServicesResultBean getAgents() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getAgents());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//Religion
	@RequestMapping("/getReligion")
	public @ResponseBody CommonServicesResultBean getReligion() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getReligion());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//License
	@RequestMapping("/getLicense")
	public @ResponseBody CommonServicesResultBean getLicense() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getLicense());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//Work Status
	@RequestMapping("/getWorkStatus")
	public @ResponseBody CommonServicesResultBean getWorkStatus() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getWorkStatus());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//Health Status
	@RequestMapping("/getHealthStatus")
	public @ResponseBody CommonServicesResultBean getHealthStatus() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getHealthStatus());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
	//Seamen Name
	@RequestMapping("/getSeamenName")
	public @ResponseBody CommonServicesResultBean getSeamenName() throws CustomException {
		CommonServicesResultBean commonUtilityResultBean = new CommonServicesResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(commonServicesService.getSeamenName());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonUtilityResultBean;
	}
	
}
