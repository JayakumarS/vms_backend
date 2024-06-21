package com.vms.crew.personMaintenance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vms.vessel.vesselParticular.VesselParticularResultBean;



@RestController
@RequestMapping("/api/crew/personMaintenance")

public class PersonMaintenanceController {
	
	@Autowired
	PersonMaintenanceService personMaintenanceService;
	
	@RequestMapping(value="/save")
	public PersonMaintenanceResultBean save(@RequestBody PersonMaintenanceBean bean) {
		PersonMaintenanceResultBean rbean = new PersonMaintenanceResultBean();
		try {
			rbean = personMaintenanceService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public PersonMaintenanceResultBean list() {
		PersonMaintenanceResultBean rbean = new PersonMaintenanceResultBean();
		try {
			rbean = personMaintenanceService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}

		
}
