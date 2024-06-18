package com.vms.vessels.wageScale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/vessels/wagescale")
public class WageScaleController {

	
	@Autowired
	WageScaleService WageScaleService;
	
	@RequestMapping(value="/save")
	public WageScaleResultBean save(@RequestBody WageScaleBean bean) {
		WageScaleResultBean rbean = new WageScaleResultBean();
		try {
			rbean = WageScaleService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public WageScaleResultBean list() {
		WageScaleResultBean rbean = new WageScaleResultBean();
		try {
			rbean = WageScaleService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public WageScaleResultBean edit(@RequestParam("id") String id) {
		WageScaleResultBean rbean = new WageScaleResultBean();
		try {
			rbean = WageScaleService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public WageScaleResultBean update(@RequestBody WageScaleBean bean) {
		WageScaleResultBean rbean = new WageScaleResultBean();
		try {
			rbean = WageScaleService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public WageScaleResultBean delete(@RequestParam("id") String id) {
		WageScaleResultBean rbean = new WageScaleResultBean();
		try {
			rbean = WageScaleService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
