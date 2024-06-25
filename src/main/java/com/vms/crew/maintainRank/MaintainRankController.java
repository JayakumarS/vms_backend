package com.vms.crew.maintainRank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/crew/maintainRank")
public class MaintainRankController {

	
	@Autowired
	MaintainRankService maintainRankService;
	
	@RequestMapping(value="/save")
	public MaintainRankResultBean save(@RequestBody MaintainRankBean bean) {
		MaintainRankResultBean rbean = new MaintainRankResultBean();
		try {
			rbean = maintainRankService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public MaintainRankResultBean list() {
		MaintainRankResultBean rbean = new MaintainRankResultBean();
		try {
			rbean = maintainRankService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public MaintainRankResultBean edit(@RequestParam("id") Integer id) {
		MaintainRankResultBean rbean = new MaintainRankResultBean();
		try {
			rbean = maintainRankService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public MaintainRankResultBean update(@RequestBody MaintainRankBean bean) {
		MaintainRankResultBean rbean = new MaintainRankResultBean();
		try {
			rbean = maintainRankService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public MaintainRankResultBean delete(@RequestParam("id") Integer id) {
		MaintainRankResultBean rbean = new MaintainRankResultBean();
		try {
			rbean = maintainRankService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}

	
}
