package com.vms.crew.crewPayrollCurrency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/crew/CrewPayrollCurrency")
public class CrewPayrollCurrencyController {
	
	@Autowired
	CrewPayrollCurrencyService CrewPayrollCurrencyService;
	
	@RequestMapping(value="/save")
	public CrewPayrollCurrencyResultBean save(@RequestBody CrewPayrollCurrencyBean bean) {
		CrewPayrollCurrencyResultBean rbean = new CrewPayrollCurrencyResultBean();
		try {
			rbean = CrewPayrollCurrencyService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public CrewPayrollCurrencyResultBean list() {
		CrewPayrollCurrencyResultBean rbean = new CrewPayrollCurrencyResultBean();
		try {
			rbean = CrewPayrollCurrencyService.getList();
		} catch (Exception e) {
		e.printStackTrace();
		}
   		return rbean;
  	}
	
	@RequestMapping(value="/edit")
	public CrewPayrollCurrencyResultBean edit(@RequestParam("id") int id) {
		CrewPayrollCurrencyResultBean rbean = new CrewPayrollCurrencyResultBean();
		try {
			rbean = CrewPayrollCurrencyService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public CrewPayrollCurrencyResultBean update(@RequestBody CrewPayrollCurrencyBean bean) {
		CrewPayrollCurrencyResultBean rbean = new CrewPayrollCurrencyResultBean();
		try {
			rbean = CrewPayrollCurrencyService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public CrewPayrollCurrencyResultBean delete(@RequestParam("id") int id) {
		CrewPayrollCurrencyResultBean rbean = new CrewPayrollCurrencyResultBean();
		try {
			rbean = CrewPayrollCurrencyService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	@RequestMapping(value="/getCountry")
	public CrewPayrollCurrencyResultBean getCountry(@RequestParam("id") String id) {
		CrewPayrollCurrencyResultBean rbean = new CrewPayrollCurrencyResultBean();
		try {
			rbean = CrewPayrollCurrencyService.getCountry(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	

}
