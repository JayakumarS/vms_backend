package com.vms.vessel.fleetManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vms.crew.certificates.CertificatesBean;





@RestController
@RequestMapping("/api/vessel/FleetManager")
public class FleetManagersController {
	
	@Autowired
	FleetManagersService FleetManagersService;
	
	
	@RequestMapping(value="/save")
	public FleetManagersResultBean save(@RequestBody FleetManagersBean bean) {
		FleetManagersResultBean rbean = new FleetManagersResultBean();
		try {
			rbean = FleetManagersService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	
	
	

	@RequestMapping(value="/list")
	public FleetManagersResultBean list() {
		FleetManagersResultBean rbean = new FleetManagersResultBean();
		try {
			rbean = FleetManagersService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public FleetManagersResultBean edit(@RequestParam("id") Integer id) {
		FleetManagersResultBean rbean = new FleetManagersResultBean();
		try {
			rbean = FleetManagersService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public FleetManagersResultBean update(@RequestBody FleetManagersBean bean) {
		FleetManagersResultBean rbean = new FleetManagersResultBean();
		try {
			System.out.print("data");
			rbean = FleetManagersService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public FleetManagersResultBean delete(@RequestParam("id") Integer id) {
		FleetManagersResultBean rbean = new FleetManagersResultBean();
		try {
			rbean = FleetManagersService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	@RequestMapping("/getSequenceCode")
	public @ResponseBody FleetManagersBean getSequenceCode() {
		FleetManagersBean getSequenceCode = null;

	   getSequenceCode = FleetManagersService.getSequenceCode();

		return getSequenceCode;
	}
	
	
	
}
