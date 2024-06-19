package com.vms.vessels.officialManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/vessels/officialManagers")
public class OfficialManagersController {
	
	@Autowired
	OfficialManagersService officialManagersService;
	
	@RequestMapping(value="/save")
	public OfficialManagersResultBean save(@RequestBody OfficialManagersBean bean) {
		OfficialManagersResultBean rbean = new OfficialManagersResultBean();
		try {
			rbean = officialManagersService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public OfficialManagersResultBean list() {
		OfficialManagersResultBean rbean = new OfficialManagersResultBean();
		try {
			rbean = officialManagersService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public OfficialManagersResultBean edit(@RequestParam("id") String id) {
		OfficialManagersResultBean rbean = new OfficialManagersResultBean();
		try {
			rbean = officialManagersService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public OfficialManagersResultBean update(@RequestBody OfficialManagersBean bean) {
		OfficialManagersResultBean rbean = new OfficialManagersResultBean();
		try {
			rbean = officialManagersService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public OfficialManagersResultBean delete(@RequestParam("id") String id) {
		OfficialManagersResultBean rbean = new OfficialManagersResultBean();
		try {
			rbean = officialManagersService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}

}
