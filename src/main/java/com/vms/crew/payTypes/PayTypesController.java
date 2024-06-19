package com.vms.crew.payTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/crew/PayTypes")
public class PayTypesController {
	
	@Autowired
	PayTypesService PayTypesService;
	
	@RequestMapping(value="/save")
	public PayTypesResultBean save(@RequestBody PayTypesBean bean) {
		PayTypesResultBean rbean = new PayTypesResultBean();
		try {
			rbean = PayTypesService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public PayTypesResultBean list() {
		PayTypesResultBean rbean = new PayTypesResultBean();
		try {
			rbean = PayTypesService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public PayTypesResultBean edit(@RequestParam("id") String id) {
		PayTypesResultBean rbean = new PayTypesResultBean();
		try {
			rbean = PayTypesService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public PayTypesResultBean update(@RequestBody PayTypesBean bean) {
		PayTypesResultBean rbean = new PayTypesResultBean();
		try {
			rbean = PayTypesService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public PayTypesResultBean delete(@RequestParam("id") String id) {
		PayTypesResultBean rbean = new PayTypesResultBean();
		try {
			rbean = PayTypesService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}

}
