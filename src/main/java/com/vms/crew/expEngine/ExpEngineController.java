package com.vms.crew.expEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/crew/ExpEngine")
public class ExpEngineController {
	
	@Autowired
	ExpEngineService ExpEngineService;
	
	@RequestMapping(value="/save")
	public ExpEngineResultBean save(@RequestBody ExpEngineBean bean) {
		ExpEngineResultBean rbean = new ExpEngineResultBean();
		try {
			rbean = ExpEngineService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public ExpEngineResultBean list() {
		ExpEngineResultBean rbean = new ExpEngineResultBean();
		try {
			rbean = ExpEngineService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public ExpEngineResultBean edit(@RequestParam("id") int id) {
		ExpEngineResultBean rbean = new ExpEngineResultBean();
		try {
			rbean = ExpEngineService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public ExpEngineResultBean update(@RequestBody ExpEngineBean bean) {
		ExpEngineResultBean rbean = new ExpEngineResultBean();
		try {
			rbean = ExpEngineService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public ExpEngineResultBean delete(@RequestParam("id") int id) {
		ExpEngineResultBean rbean = new ExpEngineResultBean();
		try {
			rbean = ExpEngineService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	

}
