package com.vms.supplies.unitsPackings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplies/unitsPacking")

public class UnitsPackingsController {
	
	@Autowired
	UnitsPackingsService unitsPackingsService;
	
	@RequestMapping(value="/save")
	public UnitsPackingsResultBean save(@RequestBody UnitsPackingsBean bean) {
		UnitsPackingsResultBean rbean = new UnitsPackingsResultBean();
		try {
			rbean = unitsPackingsService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/edit")
	public UnitsPackingsResultBean edit(@RequestParam("id") String id) {
		UnitsPackingsResultBean rbean = new UnitsPackingsResultBean();
		try {
			rbean = unitsPackingsService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public UnitsPackingsResultBean update(@RequestBody UnitsPackingsBean bean) {
		UnitsPackingsResultBean rbean = new UnitsPackingsResultBean();
		try {
			rbean = unitsPackingsService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public UnitsPackingsResultBean list() {
		UnitsPackingsResultBean rbean = new UnitsPackingsResultBean();
		try {
			rbean = unitsPackingsService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}

	@RequestMapping(value="/delete")
	public UnitsPackingsResultBean delete(@RequestParam("id") String id) {
		UnitsPackingsResultBean rbean = new UnitsPackingsResultBean();
		try {
			rbean = unitsPackingsService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/generateCode")
	public UnitsPackingsResultBean generateCode() throws Exception{
		String code = "";
		UnitsPackingsResultBean rbean = new UnitsPackingsResultBean();
		try {
			code = unitsPackingsService.generateCode();
			rbean.setCode(code);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}			
}
