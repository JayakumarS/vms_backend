package com.vms.common.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crew/maintain/agent")
public class AgentController {


	@Autowired
	AgentService AgentService;
	
	@RequestMapping(value="/save")
	public AgentResultBean save(@RequestBody AgentBean bean) {
		AgentResultBean rbean = new AgentResultBean();
		try {
			rbean = AgentService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/getlist")
	public AgentResultBean list() {
		AgentResultBean rbean = new AgentResultBean();
		try {
			rbean = AgentService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public AgentResultBean edit(@RequestParam("id") int id) {
		AgentResultBean rbean = new AgentResultBean();
		try {
			rbean = AgentService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public AgentResultBean update(@RequestBody AgentBean bean) {
		AgentResultBean rbean = new AgentResultBean();
		try {
			rbean = AgentService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public AgentResultBean delete(@RequestParam("id") int id) {
		AgentResultBean rbean = new AgentResultBean();
		try {
			rbean = AgentService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}

}
