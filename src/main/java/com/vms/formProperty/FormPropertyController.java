package com.vms.formProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="BituTech", description=" Form Property")
@RestController
@RequestMapping("/api/auth/formProperty")
public class FormPropertyController {
	
	@Autowired
	private FormPropertyService menuPropertyService;
	
	
	@ApiOperation(value = "FormProperty Controller")
	@GetMapping("/getFormProperty")
	private FormPropertyResultBean getFormProperty(@RequestParam("userId") String userId) {
		FormPropertyResultBean formPropertyResultBean = new FormPropertyResultBean();
		try {
			formPropertyResultBean = menuPropertyService.getFormProperty(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return formPropertyResultBean;

	}
}
