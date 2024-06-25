package com.vms.crew.workLicense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/crew/WorkLicense")
public class WorkLicenseController {

	
	
	@Autowired
	WorkLicenseService WorkLicenseService;
	
	@RequestMapping(value="/save")
	public WorkLicenseResultBean save(@RequestBody WorkLicenseBean bean) {
		WorkLicenseResultBean rbean = new WorkLicenseResultBean();
		try {
			rbean = WorkLicenseService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public WorkLicenseResultBean list() {
		WorkLicenseResultBean rbean = new WorkLicenseResultBean();
		try {
			rbean = WorkLicenseService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public WorkLicenseResultBean edit(@RequestParam("id") Integer id) {
		WorkLicenseResultBean rbean = new WorkLicenseResultBean();
		try {
			rbean = WorkLicenseService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public WorkLicenseResultBean update(@RequestBody WorkLicenseBean bean) {
		WorkLicenseResultBean rbean = new WorkLicenseResultBean();
		try {
			rbean = WorkLicenseService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public WorkLicenseResultBean delete(@RequestParam("id") Integer id) {
		WorkLicenseResultBean rbean = new WorkLicenseResultBean();
		try {
			rbean = WorkLicenseService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	
}
