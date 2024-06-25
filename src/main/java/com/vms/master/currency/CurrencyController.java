package com.vms.master.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/master/currency")

public class CurrencyController {
	
	@Autowired  
	CurrencyService currencyService;
	
	@RequestMapping(value="/save")
	public CurrencyResultBean save(@RequestBody CurrencyBean bean) {
		CurrencyResultBean rbean = new CurrencyResultBean();
		try {
			rbean = currencyService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public CurrencyResultBean list() {
		CurrencyResultBean rbean = new CurrencyResultBean();
		try {
			rbean = currencyService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public CurrencyResultBean edit(@RequestParam("id") Integer id) {
		CurrencyResultBean rbean = new CurrencyResultBean();
		try {
			rbean = currencyService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public CurrencyResultBean update(@RequestBody CurrencyBean bean) {
		CurrencyResultBean rbean = new CurrencyResultBean();	
		try {
			rbean = currencyService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public CurrencyResultBean delete(@RequestParam("id") Integer id) {
		CurrencyResultBean rbean = new CurrencyResultBean();
		try {
			rbean = currencyService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}

}
