package com.vms.master.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/master/department")

public class DepartmentController {
	
	@Autowired 
	DepartmentService departmentService;
	
	@RequestMapping(value="/save")
	public DepartmentResultBean save(@RequestBody DepartmentBean bean) {
		DepartmentResultBean rbean = new DepartmentResultBean();
		try {
			rbean = departmentService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public DepartmentResultBean list() {
		DepartmentResultBean rbean = new DepartmentResultBean();
		try {
			rbean = departmentService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	

	@RequestMapping(value="/edit")
	public DepartmentResultBean edit(@RequestParam("id") String id) {
		DepartmentResultBean rbean = new DepartmentResultBean();
		try {
			rbean = departmentService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public DepartmentResultBean update(@RequestBody DepartmentBean bean) {
		DepartmentResultBean rbean = new DepartmentResultBean();	
		try {
			rbean = departmentService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public DepartmentResultBean delete(@RequestParam("id") String id) {
		DepartmentResultBean rbean = new DepartmentResultBean();
		try {
			rbean = departmentService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	

}
