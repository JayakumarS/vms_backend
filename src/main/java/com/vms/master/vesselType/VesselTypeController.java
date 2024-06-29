package com.vms.master.vesselType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/master/vesselType")
public class VesselTypeController {
	@Autowired
	VesselTypeService vesselTypeService;
	
	@RequestMapping(value="/save")
	public VesselTypeResultBean save(@RequestBody VesselTypeBean bean) {
		VesselTypeResultBean rbean = new VesselTypeResultBean();
		try {
			rbean = vesselTypeService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public VesselTypeResultBean list() {
		VesselTypeResultBean rbean = new VesselTypeResultBean();
		try {
			rbean = vesselTypeService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public VesselTypeResultBean edit(@RequestParam("id") Integer id) {
		VesselTypeResultBean rbean = new VesselTypeResultBean();
		try {
			rbean = vesselTypeService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public VesselTypeResultBean update(@RequestBody VesselTypeBean bean) {
		VesselTypeResultBean rbean = new VesselTypeResultBean();
		try {
			System.out.print("data");
			rbean = vesselTypeService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public VesselTypeResultBean delete(@RequestParam("id") Integer id) {
		VesselTypeResultBean rbean = new VesselTypeResultBean();
		try {
			rbean = vesselTypeService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
