package com.vms.vessels.Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/vessels/class")
public class ClassController {

	
	@Autowired
	ClassService ClassService;
	
	@RequestMapping(value="/saveclass")
	public ClassResultBean save(@RequestBody ClassBean bean) {
		ClassResultBean rbean = new ClassResultBean();
		try {
			rbean = ClassService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public ClassResultBean list() {
		ClassResultBean rbean = new ClassResultBean();
		try {
			rbean = ClassService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/editclass")
	public ClassResultBean edit(@RequestParam("id") int id) {
		ClassResultBean rbean = new ClassResultBean();
		try {
			rbean = ClassService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/updateclass")
	public ClassResultBean update(@RequestBody ClassBean bean) {
		ClassResultBean rbean = new ClassResultBean();
		try {
			rbean = ClassService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public ClassResultBean delete(@RequestParam("id") int id) {
		ClassResultBean rbean = new ClassResultBean();
		try {
			rbean = ClassService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
