package com.vms.vessel.vesselInsurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/vessel/VesselInsurance")
public class VesselinsuranceController {

	
	@Autowired
	VesselinsuranceService VesselinsuranceService;
	
	@RequestMapping(value="/save")
	public VesselinsuranceResultBean save(@RequestBody VesselinsuranceBean bean) {
		VesselinsuranceResultBean rbean = new VesselinsuranceResultBean();
		try {
			rbean = VesselinsuranceService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public VesselinsuranceResultBean list() {
		VesselinsuranceResultBean rbean = new VesselinsuranceResultBean();
		try {
			rbean = VesselinsuranceService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public VesselinsuranceResultBean edit(@RequestParam("id") String id) {
		VesselinsuranceResultBean rbean = new VesselinsuranceResultBean();
		try {
			rbean = VesselinsuranceService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public VesselinsuranceResultBean update(@RequestBody VesselinsuranceBean bean) {
		VesselinsuranceResultBean rbean = new VesselinsuranceResultBean();
		try {
			rbean = VesselinsuranceService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public VesselinsuranceResultBean delete(@RequestParam("id") String id) {
		VesselinsuranceResultBean rbean = new VesselinsuranceResultBean();
		try {
			rbean = VesselinsuranceService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
}
