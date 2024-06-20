package com.vms.vessel.vesselParticular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/master/vesselParticular")
public class VesselParticularController {
	@Autowired
	VesselParticularService vesselParticularService;
	
	@RequestMapping(value="/save")
	public VesselParticularResultBean save(@RequestBody VesselParticularBean bean) {
		VesselParticularResultBean rbean = new VesselParticularResultBean();
		try {
			rbean = vesselParticularService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public VesselParticularResultBean list() {
		VesselParticularResultBean rbean = new VesselParticularResultBean();
		try {
			rbean = vesselParticularService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public VesselParticularResultBean edit(@RequestParam("id") String id) {
		VesselParticularResultBean rbean = new VesselParticularResultBean();
		try {
			rbean = vesselParticularService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public VesselParticularResultBean update(@RequestBody VesselParticularBean bean) {
		VesselParticularResultBean rbean = new VesselParticularResultBean();
		try {
			rbean = vesselParticularService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public VesselParticularResultBean delete(@RequestParam("id") String id) {
		VesselParticularResultBean rbean = new VesselParticularResultBean();
		try {
			rbean = vesselParticularService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	@RequestMapping(value="/generateCode")
	public VesselParticularResultBean generateCode() throws Exception{
		String vesselCode = "";
		VesselParticularResultBean rbean = new VesselParticularResultBean();
		try {
			vesselCode = vesselParticularService.generateCode();
			rbean.setVesselCode(vesselCode);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
