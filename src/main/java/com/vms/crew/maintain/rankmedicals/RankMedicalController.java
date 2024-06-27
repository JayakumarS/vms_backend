package com.vms.crew.maintain.rankmedicals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/crew/maintain/rankmedicals")
public class RankMedicalController {

	@Autowired
	RankMedicalService RankMedicalService;
	

	@RequestMapping(value="/save")
	public RankMedicalResultBean save(@RequestBody List<RankMedicalBean> selectedCertificates) {
		RankMedicalResultBean rbean = new RankMedicalResultBean();
		try {
			rbean = RankMedicalService.save(selectedCertificates);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public RankMedicalResultBean list() {
		RankMedicalResultBean rbean = new RankMedicalResultBean();
		try {
			rbean = RankMedicalService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/savelist")
	public RankMedicalResultBean savelist() {
		RankMedicalResultBean rbean = new RankMedicalResultBean();
		try {
			rbean = RankMedicalService.getsavelist();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	
	@RequestMapping("/getrank")
	public @ResponseBody List<RankMedicalBean> getrank() {
		List<RankMedicalBean> getrank = null;

		getrank = RankMedicalService.getrank();

		return getrank;
	}
}
