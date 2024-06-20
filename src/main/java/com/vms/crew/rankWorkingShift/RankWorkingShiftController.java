package com.vms.crew.rankWorkingShift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/crew/RankWorkingShift")

public class RankWorkingShiftController {
	
	@Autowired
	RankWorkingShiftService RankWorkingShiftService;
	
	@RequestMapping(value="/save")
	public RankWorkingShiftResultBean save(@RequestBody RankWorkingShiftBean bean) {
		RankWorkingShiftResultBean rbean = new RankWorkingShiftResultBean();
		try {
			System.out.println("error");
			rbean = RankWorkingShiftService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
//	@RequestMapping(value="/savedetail")
//	public RankWorkingShiftResultBean savedetail(@RequestBody RankWorkingShiftBean bean) {
//		RankWorkingShiftResultBean rbean = new RankWorkingShiftResultBean();
//		try {
//			rbean = RankWorkingShiftService.savedetail(bean);
//		}catch(Exception e){
//			e.printStackTrace();	
//		}
//		return rbean;
//	}
	
	@RequestMapping(value="/list")
	public RankWorkingShiftResultBean list() {
		RankWorkingShiftResultBean rbean = new RankWorkingShiftResultBean();
		try {
			rbean = RankWorkingShiftService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public RankWorkingShiftResultBean edit(@RequestParam("id") String id) {
		RankWorkingShiftResultBean rbean = new RankWorkingShiftResultBean();
		try {
			rbean = RankWorkingShiftService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public RankWorkingShiftResultBean update(@RequestBody RankWorkingShiftBean bean) {
		RankWorkingShiftResultBean rbean = new RankWorkingShiftResultBean();
		try {
			rbean = RankWorkingShiftService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public RankWorkingShiftResultBean delete(@RequestParam("id") String id) {
		RankWorkingShiftResultBean rbean = new RankWorkingShiftResultBean();
		try {
			rbean = RankWorkingShiftService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}

}
