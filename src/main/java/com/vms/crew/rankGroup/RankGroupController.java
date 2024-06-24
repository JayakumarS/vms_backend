package com.vms.crew.rankGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/crew/rankGroup")
public class RankGroupController {

	
	@Autowired
	RankGroupService RankGroupService;
	
	@RequestMapping(value="/save")
	public RankGroupResultBean save(@RequestBody RankGroupBean bean) {
		RankGroupResultBean rbean = new RankGroupResultBean();
		try {
			rbean = RankGroupService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public RankGroupResultBean list() {
		RankGroupResultBean rbean = new RankGroupResultBean();
		try {
			rbean = RankGroupService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public RankGroupResultBean edit(@RequestParam("id") Integer id) {
		RankGroupResultBean rbean = new RankGroupResultBean();
		try {
			rbean = RankGroupService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public RankGroupResultBean update(@RequestBody RankGroupBean bean) {
		RankGroupResultBean rbean = new RankGroupResultBean();
		try {
			rbean = RankGroupService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public RankGroupResultBean delete(@RequestParam("id") Integer id) {
		RankGroupResultBean rbean = new RankGroupResultBean();
		try {
			rbean = RankGroupService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
