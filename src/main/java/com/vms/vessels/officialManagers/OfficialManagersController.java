package com.vms.vessels.officialManagers;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vms.common.ConfigurationProps;
import com.vms.core.util.CustomException;
import com.vms.crew.certificates.CertificatesBean;



@RestController
@RequestMapping("/api/vessels/officialManagers")
public class OfficialManagersController {
	
	@Autowired
	OfficialManagersService officialManagersService;
	
	@RequestMapping(value="/save")
	public OfficialManagersResultBean save(@RequestBody OfficialManagersBean bean) {
		OfficialManagersResultBean rbean = new OfficialManagersResultBean();
		try {
			rbean = officialManagersService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public OfficialManagersResultBean list() {
		OfficialManagersResultBean rbean = new OfficialManagersResultBean();
		try {
			rbean = officialManagersService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public OfficialManagersResultBean edit(@RequestParam("id") Integer id) {
		OfficialManagersResultBean rbean = new OfficialManagersResultBean();
		try {
			rbean = officialManagersService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public OfficialManagersResultBean update(@RequestBody OfficialManagersBean bean) {
		OfficialManagersResultBean rbean = new OfficialManagersResultBean();
		try {
			rbean = officialManagersService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public OfficialManagersResultBean delete(@RequestParam("id") Integer id) {
		OfficialManagersResultBean rbean = new OfficialManagersResultBean();
		try {
			rbean = officialManagersService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	@RequestMapping("/uploadfile")
	public @ResponseBody OfficialManagersResultBean saveuploadfile(@RequestBody MultipartFile file, HttpServletRequest request) throws CustomException {
		OfficialManagersResultBean resultBean= new OfficialManagersResultBean();
		try {
 
			String filepath =  ConfigurationProps.exportFilesPath;
			//String filepath = "F:\\uploads\\"+purInvoiceNo;
			String path = filepath+"/"+ file.getOriginalFilename();

			File checkfile = new File(filepath);
			if (!checkfile.exists())
				checkfile.mkdir();

			File convFile = new File(path);

			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
			resultBean.setPath(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	@RequestMapping("/getSequenceCode")
	public @ResponseBody OfficialManagersBean getSequenceCode() {
		OfficialManagersBean getSequenceCode = null;

	   getSequenceCode = officialManagersService.getSequenceCode();

		return getSequenceCode;
	}
	
}
