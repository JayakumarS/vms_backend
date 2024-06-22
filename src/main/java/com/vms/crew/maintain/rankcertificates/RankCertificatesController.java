package com.vms.crew.maintain.rankcertificates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/crew/maintain/rankcertificate")
public class RankCertificatesController {

	
	@Autowired
	RankCertificatesService RankCertificatesService;
	
	@RequestMapping(value="/save")
	public RankCertificatesResultBean save(@RequestBody List<RankCertificatesBean> selectedCertificates) {
		RankCertificatesResultBean rbean = new RankCertificatesResultBean();
		try {
			rbean = RankCertificatesService.save(selectedCertificates);
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
	
	@RequestMapping(value="/savelist")
	public RankCertificatesResultBean savelist() {
		RankCertificatesResultBean rbean = new RankCertificatesResultBean();
		try {
			rbean = RankCertificatesService.getsavelist();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	
	@RequestMapping("/getrank")
	public @ResponseBody List<RankCertificatesBean> getrank() {
		List<RankCertificatesBean> getrank = null;

		getrank = RankCertificatesService.getrank();

		return getrank;
	}
}
