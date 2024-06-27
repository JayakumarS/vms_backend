package com.vms.crew.maintain.Medicals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/crew/maintain/medical")
public class MedicalController {

	
	@Autowired
	MedicalService MedicalService;
	
	@RequestMapping(value="/save")
	public MedicalResultBean save(@RequestBody MedicalBean bean) {
		MedicalResultBean rbean = new MedicalResultBean();
		try {
			rbean = MedicalService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public MedicalResultBean list() {
		MedicalResultBean rbean = new MedicalResultBean();
		try {
			rbean = MedicalService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public MedicalResultBean edit(@RequestParam("id") Integer id) {
		MedicalResultBean rbean = new MedicalResultBean();
		try {
			rbean = MedicalService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public MedicalResultBean update(@RequestBody MedicalBean bean) {
		MedicalResultBean rbean = new MedicalResultBean();
		try {
			rbean = MedicalService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public MedicalResultBean delete(@RequestParam("id") Integer id) {
		MedicalResultBean rbean = new MedicalResultBean();
		try {
			rbean = MedicalService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	

	
}
