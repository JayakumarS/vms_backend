package com.vms.vessels.iceClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vms.crew.certificates.CertificatesResultBean;

@RestController
@RequestMapping("/api/vessel/iceClass")

public class IceClassController {
	
	@Autowired 
	IceClassService iceClassService;
	
	@RequestMapping(value="/save")
	public IceClassResultBean save(@RequestBody IceClassBean bean) {
		IceClassResultBean rbean = new IceClassResultBean();
		try {
			rbean = iceClassService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public IceClassResultBean getList() {
		IceClassResultBean rbean = new IceClassResultBean();
		try {
			rbean = iceClassService.getList();
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/edit")
	public IceClassResultBean edit(@RequestParam("id") Integer id) {
		IceClassResultBean rbean = new IceClassResultBean();
		try {
			rbean = iceClassService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public IceClassResultBean update(@RequestBody IceClassBean bean) {
		IceClassResultBean rbean = new IceClassResultBean();
		try {
			rbean = iceClassService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public IceClassResultBean delete(@RequestParam("id") Integer id) {
		IceClassResultBean rbean = new IceClassResultBean();
		try {
			rbean = iceClassService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	@RequestMapping("/getSequenceCode")
	public @ResponseBody IceClassBean getSequenceCode() {
		IceClassBean getSequenceCode = null;

	   getSequenceCode = iceClassService.getSequenceCode();

		return getSequenceCode;
	}
	

}
