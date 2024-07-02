package com.vms.supplies.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vms.crew.personMaintenance.PersonMaintenanceResultBean;


@RestController
@RequestMapping("/api/supplies/supplier")
public class SupplierController {

	
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping(value="/save")
	public SupplierResultBean save(@RequestBody SupplierBean bean) {
		SupplierResultBean rbean = new SupplierResultBean();
		try {
			rbean = supplierService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public SupplierResultBean list() {
		SupplierResultBean rbean = new SupplierResultBean();
		try {
			rbean = supplierService.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public SupplierResultBean edit(@RequestParam("id") String id) {
		SupplierResultBean rbean = new SupplierResultBean();
		try {
			rbean = supplierService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public SupplierResultBean update(@RequestBody SupplierBean bean) {
		SupplierResultBean rbean = new SupplierResultBean();
		try {
			rbean = supplierService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public SupplierResultBean delete(@RequestParam("id") String id) {
		SupplierResultBean rbean = new SupplierResultBean();
		try {
			rbean = supplierService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	@RequestMapping(value="/generateCode")
	public SupplierResultBean generateCode() throws Exception{
		String code = "";
		SupplierResultBean rbean = new SupplierResultBean();
		try {
			code = supplierService.generateCode();
			rbean.setCode(code);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
