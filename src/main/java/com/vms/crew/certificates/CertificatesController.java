package com.vms.crew.certificates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/crew/Certificates")
public class CertificatesController {
	

	@Autowired
	CertificatesService CertificatesService;
	
	@RequestMapping(value="/save")
	public CertificatesResultBean save(@RequestBody CertificatesBean bean) {
		CertificatesResultBean rbean = new CertificatesResultBean();
		try {
			rbean = CertificatesService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public CertificatesResultBean list() {
		CertificatesResultBean rbean = new CertificatesResultBean();
		try {
			rbean = CertificatesService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public CertificatesResultBean edit(@RequestParam("id") String id) {
		CertificatesResultBean rbean = new CertificatesResultBean();
		try {
			rbean = CertificatesService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public CertificatesResultBean update(@RequestBody CertificatesBean bean) {
		CertificatesResultBean rbean = new CertificatesResultBean();
		try {
			rbean = CertificatesService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public CertificatesResultBean delete(@RequestParam("id") String id) {
		CertificatesResultBean rbean = new CertificatesResultBean();
		try {
			rbean = CertificatesService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
}
