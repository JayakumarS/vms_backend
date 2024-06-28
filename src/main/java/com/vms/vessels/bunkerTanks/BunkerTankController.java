package com.vms.vessels.bunkerTanks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/crew/BunkerTank")
public class BunkerTankController {
	
	@Autowired
	BunkerTankService BunkerTankService;
	
	@RequestMapping(value="/save")
	public BunkerTankResultBean save(@RequestBody BunkerTankBean bean) {
		BunkerTankResultBean rbean = new BunkerTankResultBean();
		try {
			rbean = BunkerTankService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public BunkerTankResultBean list() {
		BunkerTankResultBean rbean = new BunkerTankResultBean();
		try {
			rbean = BunkerTankService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public BunkerTankResultBean edit(@RequestParam("id") Integer id) {
		BunkerTankResultBean rbean = new BunkerTankResultBean();
		try {
			rbean = BunkerTankService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public BunkerTankResultBean update(@RequestBody BunkerTankBean bean) {
		BunkerTankResultBean rbean = new BunkerTankResultBean();
		try {
			rbean = BunkerTankService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public BunkerTankResultBean delete(@RequestParam("id") Integer id) {
		BunkerTankResultBean rbean = new BunkerTankResultBean();
		try {
			rbean = BunkerTankService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	

}
