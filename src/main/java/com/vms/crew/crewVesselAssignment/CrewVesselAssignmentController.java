package com.vms.crew.crewVesselAssignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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
}
