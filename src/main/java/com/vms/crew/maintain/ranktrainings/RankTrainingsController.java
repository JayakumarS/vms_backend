package com.vms.crew.maintain.ranktrainings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/crew/maintain/ranktrainings")
public class RankTrainingsController {

	
	@Autowired
	RankTrainingsService RankTrainingsService;
	
	@RequestMapping(value="/save")
	public RankTrainingsResultBean save(@RequestBody List<RankTrainingsBean> selectedCertificates) {
		RankTrainingsResultBean rbean = new RankTrainingsResultBean();
		try {
			rbean = RankTrainingsService.save(selectedCertificates);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public RankTrainingsResultBean list() {
		RankTrainingsResultBean rbean = new RankTrainingsResultBean();
		try {
			rbean = RankTrainingsService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/savelist")
	public RankTrainingsResultBean savelist() {
		RankTrainingsResultBean rbean = new RankTrainingsResultBean();
		try {
			rbean = RankTrainingsService.getsavelist();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	
	@RequestMapping("/getrank")
	public @ResponseBody List<RankTrainingsBean> getrank() {
		List<RankTrainingsBean> getrank = null;

		getrank = RankTrainingsService.getrank();

		return getrank;
	}
}
