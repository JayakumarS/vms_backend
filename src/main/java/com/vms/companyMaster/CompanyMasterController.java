package com.vms.companyMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vms.common.FileUploadUtill;

import org.apache.commons.io.FilenameUtils;



@RestController
@RequestMapping("/app/companyMaster")
public class CompanyMasterController {
	@Autowired
	CompanyMasterService companyMasterService;
	
	@RequestMapping(value="/save")
	public CompanyMasterResultBean save(@RequestBody CompanyMasterBean bean) {
		CompanyMasterResultBean objbean = new CompanyMasterResultBean();
		try {
			objbean = companyMasterService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
	}
	
	

}
