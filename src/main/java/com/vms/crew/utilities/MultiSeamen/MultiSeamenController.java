package com.vms.crew.utilities.MultiSeamen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vms.master.Country.CountryBean;

@RestController
@RequestMapping("/api/crew/utilities/multiseamen")
public class MultiSeamenController {
	
	@Autowired
	MultiSeamenService multiSeamenService;
	
	@RequestMapping(value="/saveMultiSeamen")
	public MultiSeamenResultBean saveMultiSeamen(@RequestBody MultiSeamenBean bean) {
		MultiSeamenResultBean rbean = new MultiSeamenResultBean();
		try {
			rbean = multiSeamenService.saveMultiSeamen(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/listMultiSeamen")
	public MultiSeamenResultBean listMultiSeamen() {
		MultiSeamenResultBean rbean = new MultiSeamenResultBean();
		try {
			rbean = multiSeamenService.listMultiSeamen();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/editMultiSeamen")
	public MultiSeamenResultBean editMultiSeamen(@RequestParam("id") Integer id) {
		MultiSeamenResultBean rbean = new MultiSeamenResultBean();
		try {
			rbean = multiSeamenService.editMultiSeamen(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/updateMultiSeamen")
	public MultiSeamenResultBean updateMultiSeamen(@RequestBody MultiSeamenBean bean) {
		MultiSeamenResultBean rbean = new MultiSeamenResultBean();
		try {
			rbean = multiSeamenService.updateMultiSeamen(bean);
		}catch(Exception e){
			
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/deleteMultiSeamen")
	public MultiSeamenResultBean deleteMultiSeamen(@RequestParam("id") Integer id) {
		MultiSeamenResultBean rbean = new MultiSeamenResultBean();
		try {
			rbean = multiSeamenService.deleteMultiSeamen(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
