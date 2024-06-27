package com.vms.crew.crewVesselAssignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vms.core.util.CustomException;


@RestController
@RequestMapping("/api/crew/CrewVesselAssignment")
public class CrewVesselAssignmentController {
	@Autowired
	CrewVesselAssignmentService CrewVesselAssignmentService;
	
	
	
	@RequestMapping("/getvessel")
	public @ResponseBody List<CrewVesselAssignmentBean> getdepartment() {
		List<CrewVesselAssignmentBean> getvessel = null;

		getvessel = CrewVesselAssignmentService.getvessel();

		return getvessel;
	}

	@RequestMapping("/getrank")
	public @ResponseBody List<CrewVesselAssignmentBean> getrank() {
		List<CrewVesselAssignmentBean> getrank = null;

		getrank = CrewVesselAssignmentService.getrank();

		return getrank;
	}
	
	@RequestMapping("/getport")
	public @ResponseBody List<CrewVesselAssignmentBean> getport() {
		List<CrewVesselAssignmentBean> getport = null;

		getport = CrewVesselAssignmentService.getport();

		return getport;
	}
	
	
//	@RequestMapping("/showlist")     
//	public @ResponseBody CrewVesselAssignmentResultBean showlist(@RequestBody CrewVesselAssignmentBean bean)
//			throws CustomException, InterruptedException {
//		CrewVesselAssignmentResultBean objPaymentInformationResultBean = new CrewVesselAssignmentResultBean();
//		try {
//			objPaymentInformationResultBean.setVesselList(CrewVesselAssignmentService.showlist(bean));
//			objPaymentInformationResultBean.setSuccess(true);
//		} catch (Exception e) {
//			throw new CustomException();
//		}
//		return objPaymentInformationResultBean;
//	}
//	
	
//	@RequestMapping("/savelist")
//	public @ResponseBody CrewVesselAssignmentResultBean savelist(@RequestBody CrewVesselAssignmentBean bean)
//			throws CustomException, InterruptedException {
//		CrewVesselAssignmentResultBean objCrewVesselAssignmentResultBean = new CrewVesselAssignmentResultBean();
//		boolean isSucess = false;
//		try {
//			isSucess = CrewVesselAssignmentService.savelist(bean);
//			objCrewVesselAssignmentResultBean.setSuccess(true);
//		} catch (Exception e) {
//			throw new CustomException();
//		}
//		return objCrewVesselAssignmentResultBean;
//	}
	
	
}
