package com.vms.common.Languages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/crew/maintain/language")
public class LanguagesController {

	
	@Autowired
	LanguagesService LanguagesService;
	
	@RequestMapping(value="/save")
	public LanguagesResultBean save(@RequestBody LanguagesBean bean) {
		LanguagesResultBean rbean = new LanguagesResultBean();
		try {
			rbean = LanguagesService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/getlist")
	public LanguagesResultBean list() {
		LanguagesResultBean rbean = new LanguagesResultBean();
		try {
			rbean = LanguagesService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public LanguagesResultBean edit(@RequestParam("id") String id) {
		LanguagesResultBean rbean = new LanguagesResultBean();
		try {
			rbean = LanguagesService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public LanguagesResultBean update(@RequestBody LanguagesBean bean) {
		LanguagesResultBean rbean = new LanguagesResultBean();
		try {
			rbean = LanguagesService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public LanguagesResultBean delete(@RequestParam("id") String id) {
		LanguagesResultBean rbean = new LanguagesResultBean();
		try {
			rbean = LanguagesService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
