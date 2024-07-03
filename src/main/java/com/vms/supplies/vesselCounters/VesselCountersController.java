package com.vms.supplies.vesselCounters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/supplies/vesselCounter")

public class VesselCountersController {
	
	@Autowired
	VesselCountersService vesselCountersService;
	
	@RequestMapping(value="/save")
	public VesselCountersResultBean save(@RequestBody VesselCountersBean bean) {
		VesselCountersResultBean rbean = new VesselCountersResultBean();
		try {
			rbean = vesselCountersService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/edit")
	public VesselCountersResultBean edit(@RequestParam("id") String id) {
		VesselCountersResultBean rbean = new VesselCountersResultBean();
		try {
			rbean = vesselCountersService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public VesselCountersResultBean update(@RequestBody VesselCountersBean bean) {
		VesselCountersResultBean rbean = new VesselCountersResultBean();
		try {
			rbean = vesselCountersService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public VesselCountersResultBean list() {
		VesselCountersResultBean rbean = new VesselCountersResultBean();
		try {
			rbean = vesselCountersService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}

	@RequestMapping(value="/delete")
	public VesselCountersResultBean delete(@RequestParam("id") String id) {
		VesselCountersResultBean rbean = new VesselCountersResultBean();
		try {
			rbean = vesselCountersService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/generateCode")
	public VesselCountersResultBean generateCode() throws Exception{
		String code = "";
		VesselCountersResultBean rbean = new VesselCountersResultBean();
		try {
			code = vesselCountersService.generateCode();
			rbean.setCode(code);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}			
}
