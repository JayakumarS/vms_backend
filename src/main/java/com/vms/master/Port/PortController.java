package com.vms.master.Port;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/master/port")
public class PortController {
	@Autowired
	PortService portService;
	
	@RequestMapping(value="/savePort")
	public PortResultBean savePort(@RequestBody PortBean bean) {
		PortResultBean rbean = new PortResultBean();
		try {
			rbean = portService.savePort(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/listPort")
	public PortResultBean listPort() {
		PortResultBean rbean = new PortResultBean();
		try {
			rbean = portService.listPort();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/editPort")
	public PortResultBean editPort(@RequestParam("id") Integer id) {
		PortResultBean rbean = new PortResultBean();
		try {
			rbean = portService.editPort(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/updatePort")
	public PortResultBean updatePort(@RequestBody PortBean bean) {
		PortResultBean rbean = new PortResultBean();
		try {
			rbean = portService.updatePort(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/deletePort")
	public PortResultBean deletePort(@RequestParam("id") String id) {
		PortResultBean rbean = new PortResultBean();
		try {
			rbean = portService.deletePort(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}

}
