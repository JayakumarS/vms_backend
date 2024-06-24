package com.vms.vessel.vesselOwner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/vessel/VesselOwner")
public class VesselOwnerController {

	
	@Autowired
	VesselOwnerService VesselOwnerService;
	
	@RequestMapping(value="/save")
	public VesselOwnerResultBean save(@RequestBody VesselOwnerBean bean) {
		VesselOwnerResultBean rbean = new VesselOwnerResultBean();
		try {
			rbean = VesselOwnerService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public VesselOwnerResultBean list() {
		VesselOwnerResultBean rbean = new VesselOwnerResultBean();
		try {
			rbean = VesselOwnerService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public VesselOwnerResultBean edit(@RequestParam("id") Integer id) {
		VesselOwnerResultBean rbean = new VesselOwnerResultBean();
		try {
			rbean = VesselOwnerService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public VesselOwnerResultBean update(@RequestBody VesselOwnerBean bean) {
		VesselOwnerResultBean rbean = new VesselOwnerResultBean();
		try {
			rbean = VesselOwnerService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public VesselOwnerResultBean delete(@RequestParam("id") Integer id) {
		VesselOwnerResultBean rbean = new VesselOwnerResultBean();
		try {
			rbean = VesselOwnerService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
}
