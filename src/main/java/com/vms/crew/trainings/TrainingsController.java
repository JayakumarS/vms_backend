package com.vms.crew.trainings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/crew/Trainings")
public class TrainingsController {
	
	@Autowired
	TrainingsService TrainingsService;
	
	@RequestMapping(value="/save")
	public TrainingsResultBean save(@RequestBody TrainingsBean bean) {
		TrainingsResultBean rbean = new TrainingsResultBean();
		try {
			rbean = TrainingsService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public TrainingsResultBean list() {
		TrainingsResultBean rbean = new TrainingsResultBean();
		try {
			rbean = TrainingsService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public TrainingsResultBean edit(@RequestParam("id") Integer id) {
		TrainingsResultBean rbean = new TrainingsResultBean();
		try {
			rbean = TrainingsService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public TrainingsResultBean update(@RequestBody TrainingsBean bean) {
		TrainingsResultBean rbean = new TrainingsResultBean();
		try {
			rbean = TrainingsService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public TrainingsResultBean delete(@RequestParam("id") Integer id) {
		TrainingsResultBean rbean = new TrainingsResultBean();
		try {
			rbean = TrainingsService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}

}
