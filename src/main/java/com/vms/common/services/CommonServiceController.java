package com.vms.common.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/common/commonServices")
public class CommonServiceController {
	
	@Autowired
	CommonServiceService commonServicesService;
	
	@RequestMapping(value = "/validateUnique")
	public boolean validateUnique(@RequestParam("tableName") String tableName,@RequestParam("columnName") String columnName,@RequestParam("columnValue") String columnValue) throws Exception {
		boolean result = false;
		try {
			result = commonServicesService.validateUnique(tableName,columnName,columnValue);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
