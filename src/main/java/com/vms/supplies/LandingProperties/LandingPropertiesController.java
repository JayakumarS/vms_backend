package com.vms.supplies.LandingProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/supplies")
public class LandingPropertiesController {

	@Autowired
	LandingPropertiesService landingPropertiesService;
	
	@RequestMapping(value="/save")
	public LandingPropertiesResultBean save(@RequestBody LandingPropertiesBean bean) {
		LandingPropertiesResultBean rbean = new LandingPropertiesResultBean();
		try {
			rbean = landingPropertiesService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public LandingPropertiesResultBean list() {
		LandingPropertiesResultBean rbean = new LandingPropertiesResultBean();
		try {
			rbean = landingPropertiesService.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public LandingPropertiesResultBean edit(@RequestParam("id") Integer id) {
		LandingPropertiesResultBean rbean = new LandingPropertiesResultBean();
		try {
			rbean = landingPropertiesService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public LandingPropertiesResultBean update(@RequestBody LandingPropertiesBean bean) {
		LandingPropertiesResultBean rbean = new LandingPropertiesResultBean();
		try {
			rbean = landingPropertiesService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public LandingPropertiesResultBean delete(@RequestParam("id") String id) {
		LandingPropertiesResultBean rbean = new LandingPropertiesResultBean();
		try {
			rbean = landingPropertiesService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
