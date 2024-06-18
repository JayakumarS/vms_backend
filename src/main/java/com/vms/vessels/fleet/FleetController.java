package com.vms.vessels.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/vessels/fleet")
public class FleetController {

	
	@Autowired
	FleetService FleetService;
	
	@RequestMapping(value="/save")
	public FleetResultBean save(@RequestBody FleetBean bean) {
		FleetResultBean rbean = new FleetResultBean();
		try {
			rbean = FleetService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public FleetResultBean list() {
		FleetResultBean rbean = new FleetResultBean();
		try {
			rbean = FleetService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public FleetResultBean edit(@RequestParam("id") String id) {
		FleetResultBean rbean = new FleetResultBean();
		try {
			rbean = FleetService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public FleetResultBean update(@RequestBody FleetBean bean) {
		FleetResultBean rbean = new FleetResultBean();
		try {
			rbean = FleetService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public FleetResultBean delete(@RequestParam("id") String id) {
		FleetResultBean rbean = new FleetResultBean();
		try {
			rbean = FleetService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
