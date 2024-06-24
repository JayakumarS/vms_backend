package com.vms.crew.workStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/crew/WorkStatus")
public class WorkStatusController {

	
	@Autowired
	WorkStatusService WorkStatusService;
	
	@RequestMapping(value="/save")
	public WorkStatusResultBean save(@RequestBody WorkStatusBean bean) {
		WorkStatusResultBean rbean = new WorkStatusResultBean();
		try {
			rbean = WorkStatusService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public WorkStatusResultBean list() {
		WorkStatusResultBean rbean = new WorkStatusResultBean();
		try {
			rbean = WorkStatusService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public WorkStatusResultBean edit(@RequestParam("id") Integer id) {
		WorkStatusResultBean rbean = new WorkStatusResultBean();
		try {
			rbean = WorkStatusService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public WorkStatusResultBean update(@RequestBody WorkStatusBean bean) {
		WorkStatusResultBean rbean = new WorkStatusResultBean();
		try {
			rbean = WorkStatusService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public WorkStatusResultBean delete(@RequestParam("id") Integer id) {
		WorkStatusResultBean rbean = new WorkStatusResultBean();
		try {
			rbean = WorkStatusService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	
}
