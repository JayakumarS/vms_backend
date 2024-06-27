package com.vms.crew.maintain.OffSign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/crew/maintain/offsign")
public class OffSignController {

	
	@Autowired
	OffSignService offSignService;
	
	@RequestMapping(value="/saveOffSign")
	public OffSignResultBean saveOffSign(@RequestBody OffSignBean bean) {
		OffSignResultBean rbean = new OffSignResultBean();
		try {
			rbean = offSignService.saveOffSign(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/listOffSign")
	public OffSignResultBean listOffSign() {
		OffSignResultBean rbean = new OffSignResultBean();
		try {
			rbean = offSignService.listOffSign();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/editOffSign")
	public OffSignResultBean editOffSign(@RequestParam("id") Integer id) {
		OffSignResultBean rbean = new OffSignResultBean();
		try {
			rbean = offSignService.editOffSign(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/updateOffSign")
	public OffSignResultBean updateOffSign(@RequestBody OffSignBean bean) {
		OffSignResultBean rbean = new OffSignResultBean();
		try {
			rbean = offSignService.updateOffSign(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/deleteOffSign")
	public OffSignResultBean deleteOffSign(@RequestParam("id") Integer id) {
		OffSignResultBean rbean = new OffSignResultBean();
		try {
			rbean = offSignService.deleteOffSign(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
