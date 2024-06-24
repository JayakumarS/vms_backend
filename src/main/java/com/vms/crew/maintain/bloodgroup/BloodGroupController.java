package com.vms.crew.maintain.bloodgroup;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crew/maintain/bloodgroup")
public class BloodGroupController {

	
	@Autowired
	BloodGroupService bloodGroupService;
	
	
	@RequestMapping(value="/save")
	public BloodGroupResultBean save(@RequestBody BloodGroupBean bean) {
		BloodGroupResultBean rbean = new BloodGroupResultBean();
		try {
			rbean = bloodGroupService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public BloodGroupResultBean list() {
		BloodGroupResultBean rbean = new BloodGroupResultBean();
		try {
			rbean = bloodGroupService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public BloodGroupResultBean edit(@RequestParam("id") String id) {
		BloodGroupResultBean rbean = new BloodGroupResultBean();
		try {
			rbean = bloodGroupService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public BloodGroupResultBean update(@RequestBody BloodGroupBean bean) {
		BloodGroupResultBean rbean = new BloodGroupResultBean();
		try {
			rbean = bloodGroupService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public BloodGroupResultBean delete(@RequestParam("id") String id) {
		BloodGroupResultBean rbean = new BloodGroupResultBean();
		try {
			rbean = bloodGroupService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	
	
	
	
	
	
	
	
	
}
