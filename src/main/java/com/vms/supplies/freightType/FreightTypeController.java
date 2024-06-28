package com.vms.supplies.freightType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/crew/FreightType")
public class FreightTypeController {
	@Autowired
	FreightTypeService FreightTypeService;
	
	@RequestMapping(value="/save")
	public FreightTypeResultBean save(@RequestBody FreightTypeBean bean) {
		FreightTypeResultBean rbean = new FreightTypeResultBean();
		try {
			rbean = FreightTypeService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public FreightTypeResultBean list() {
		FreightTypeResultBean rbean = new FreightTypeResultBean();
		try {
			rbean = FreightTypeService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public FreightTypeResultBean edit(@RequestParam("id") int id) {
		FreightTypeResultBean rbean = new FreightTypeResultBean();
		try {
			rbean = FreightTypeService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public FreightTypeResultBean update(@RequestBody FreightTypeBean bean) {
		FreightTypeResultBean rbean = new FreightTypeResultBean();
		try {
			rbean = FreightTypeService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public FreightTypeResultBean delete(@RequestParam("id") int id) {
		FreightTypeResultBean rbean = new FreightTypeResultBean();
		try {
			rbean = FreightTypeService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	

}
