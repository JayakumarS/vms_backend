package com.vms.crew.utilities.MultiSeamen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crew/utilities/multiseamen")
public class MultiSeamenController {
	
	@Autowired
	MultiSeamenService multiSeamenService;
	
	@RequestMapping(value="/saveMultiSeamen")
	public MultiSeamenResultBean saveMultiSeamen(@RequestBody MultiSeamenBean bean) {
		MultiSeamenResultBean rbean = new MultiSeamenResultBean();
		try {
			rbean = multiSeamenService.saveMultiSeamen(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	

}
