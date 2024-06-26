package com.vms.master.religion;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/crew/maintain/religion")
public class ReligionController {

	@Autowired
	ReligionService religionService;
	
	
	
	
	@RequestMapping(value="/save")
	public ReligionResultBean save(@RequestBody ReligionBean bean) {
		ReligionResultBean rbean = new ReligionResultBean();
		try {
			rbean = religionService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public ReligionResultBean list() {
		ReligionResultBean rbean = new ReligionResultBean();
		try {
			rbean = religionService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public ReligionResultBean edit(@RequestParam("id") String id) {
		ReligionResultBean rbean = new ReligionResultBean();
		try {
			rbean = religionService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public ReligionResultBean update(@RequestBody ReligionBean bean) {
		ReligionResultBean rbean = new ReligionResultBean();
		try {
			rbean = religionService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public ReligionResultBean delete(@RequestParam("id") String id) {
		ReligionResultBean rbean = new ReligionResultBean();
		try {
			rbean = religionService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	
	@RequestMapping("/getSequenceCode")
	public @ResponseBody ReligionBean getSequenceCode() {
		ReligionBean getSequenceCode = null;

	   getSequenceCode = religionService.getSequenceCode();

		return getSequenceCode;
	}
	
	
	
	
	
	
}
