package com.vms.crew.maintain.rankcertificates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/crew/maintain/rankcertificate")
public class RankCertificatesController {

	
	@Autowired
	RankCertificatesService RankCertificatesService;
	
	@RequestMapping(value="/save")
	public RankCertificatesResultBean save(@RequestBody RankCertificatesBean bean) {
		RankCertificatesResultBean rbean = new RankCertificatesResultBean();
		try {
			rbean = RankCertificatesService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public RankCertificatesResultBean list() {
		RankCertificatesResultBean rbean = new RankCertificatesResultBean();
		try {
			rbean = RankCertificatesService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
}
