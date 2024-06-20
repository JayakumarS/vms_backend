package com.vms.master.vesselPrefix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/master/vesselPrefix")
public class VesselPrefixController {
	@Autowired
	VesselPrefixService vesselPrefixService;
	
	@RequestMapping(value="/save")
	public VesselPrefixResultBean save(@RequestBody VesselPrefixBean bean) {
		VesselPrefixResultBean rbean = new VesselPrefixResultBean();
		try {
			rbean = vesselPrefixService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public VesselPrefixResultBean list() {
		VesselPrefixResultBean rbean = new VesselPrefixResultBean();
		try {
			rbean = vesselPrefixService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public VesselPrefixResultBean edit(@RequestParam("id") String id) {
		VesselPrefixResultBean rbean = new VesselPrefixResultBean();
		try {
			rbean = vesselPrefixService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public VesselPrefixResultBean update(@RequestBody VesselPrefixBean bean) {
		VesselPrefixResultBean rbean = new VesselPrefixResultBean();
		try {
			rbean = vesselPrefixService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public VesselPrefixResultBean delete(@RequestParam("id") String id) {
		VesselPrefixResultBean rbean = new VesselPrefixResultBean();
		try {
			rbean = vesselPrefixService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
