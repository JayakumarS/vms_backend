package com.vms.crew.healthStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/crew/HealthStatus")
public class HealthStatusController {

	

	@Autowired
	HealthStatusService HealthStatusService;
	
	@RequestMapping(value="/save")
	public HealthStatusResultBean save(@RequestBody HealthStatusBean bean) {
		HealthStatusResultBean rbean = new HealthStatusResultBean();
		try {
			rbean = HealthStatusService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public HealthStatusResultBean list() {
		HealthStatusResultBean rbean = new HealthStatusResultBean();
		try {
			rbean = HealthStatusService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public HealthStatusResultBean edit(@RequestParam("id") String id) {
		HealthStatusResultBean rbean = new HealthStatusResultBean();
		try {
			rbean = HealthStatusService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public HealthStatusResultBean update(@RequestBody HealthStatusBean bean) {
		HealthStatusResultBean rbean = new HealthStatusResultBean();
		try {
			rbean = HealthStatusService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public HealthStatusResultBean delete(@RequestParam("id") String id) {
		HealthStatusResultBean rbean = new HealthStatusResultBean();
		try {
			rbean = HealthStatusService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
}
