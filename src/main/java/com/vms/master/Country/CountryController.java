package com.vms.master.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/master/country")
public class CountryController {
	@Autowired
	CountryService countryService;
	
	@RequestMapping(value="/saveCountry")
	public CountryResultBean save(@RequestBody CountryBean bean) {
		CountryResultBean rbean = new CountryResultBean();
		try {
			rbean = countryService.saveCountry(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/listCountry")
	public CountryResultBean list() {
		CountryResultBean rbean = new CountryResultBean();
		try {
			rbean = countryService.listCountry();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/editCountry")
	public CountryResultBean editCountry(@RequestParam("id") Integer id) {
		CountryResultBean rbean = new CountryResultBean();
		try {
			rbean = countryService.editCountry(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/updateCountry")
	public CountryResultBean updateCountry(@RequestBody CountryBean bean) {
		CountryResultBean rbean = new CountryResultBean();
		try {
			rbean = countryService.updateCountry(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/deleteCountry")
	public CountryResultBean deleteCountry(@RequestParam("id") String id) {
		CountryResultBean rbean = new CountryResultBean();
		try {
			rbean = countryService.deleteCountry(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
