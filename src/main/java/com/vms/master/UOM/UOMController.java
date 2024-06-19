package com.vms.master.UOM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/master/uom")
public class UOMController {
	@Autowired
	UOMService uomService;
	
	@RequestMapping(value="/saveUom")
	public UOMResultBean saveUom(@RequestBody UOMBean bean) {
		UOMResultBean rbean = new UOMResultBean();
		try {
			rbean = uomService.saveUom(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/listUom")
	public UOMResultBean listUom() {
		UOMResultBean rbean = new UOMResultBean();
		try {
			rbean = uomService.listUom();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/editUom")
	public UOMResultBean editUom(@RequestParam("id") String id) {
		UOMResultBean rbean = new UOMResultBean();
		try {
			rbean = uomService.editUom(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/updateUom")
	public UOMResultBean updateUom(@RequestBody UOMBean bean) {
		UOMResultBean rbean = new UOMResultBean();
		try {
			rbean = uomService.updateUom(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/deleteUom")
	public UOMResultBean deleteUom(@RequestParam("id") String id) {
		UOMResultBean rbean = new UOMResultBean();
		try {
			rbean = uomService.deleteUom(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}

}
