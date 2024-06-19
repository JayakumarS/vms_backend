package com.vms.vessels.shipManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/vessels/shipManagers")


public class ShipManagersController {
	@Autowired
	ShipManagersService shipManagersService;
	
	@RequestMapping(value="/save")
	public ShipManagersResultBean save(@RequestBody ShipManagersBean bean) {
		ShipManagersResultBean rbean = new ShipManagersResultBean();
		try {
			rbean = shipManagersService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public ShipManagersResultBean list() {
		ShipManagersResultBean rbean = new ShipManagersResultBean();
		try {
			rbean = shipManagersService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public ShipManagersResultBean edit(@RequestParam("id") String id) {
		ShipManagersResultBean rbean = new ShipManagersResultBean();
		try {
			rbean = shipManagersService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public ShipManagersResultBean update(@RequestBody ShipManagersBean bean) {
		ShipManagersResultBean rbean = new ShipManagersResultBean();
		try {
			rbean = shipManagersService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public ShipManagersResultBean delete(@RequestParam("id") String id) {
		ShipManagersResultBean rbean = new ShipManagersResultBean();
		try {
			rbean = shipManagersService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
