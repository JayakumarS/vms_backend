package com.vms.crew.applications;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

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
import com.vms.crew.maintainRank.MaintainRankBean;
import com.vms.crew.maintainRank.MaintainRankResultBean;



@RestController
@RequestMapping("/api/crew/Crewapplications")
public class ApplicationsController {
	@Autowired
	ApplicationsService ApplicationsService;
	
	
	@RequestMapping("/getenginelist")
	public @ResponseBody List<ApplicationsBean> getenginelist() {
		List<ApplicationsBean> getenginelist = null;

		getenginelist = ApplicationsService.getenginelist();

		return getenginelist;
	}
	
	
	@RequestMapping("/getlicence")
	public @ResponseBody List<ApplicationsBean> getlicence() {
		List<ApplicationsBean> getlicence = null;

		getlicence = ApplicationsService.getlicence();

		return getlicence;
	}
	
	@RequestMapping("/getvessel")
	public @ResponseBody List<ApplicationsBean> getdepartment() {
		List<ApplicationsBean> getvessel = null;

		getvessel = ApplicationsService.getvessel();

		return getvessel;
	}

	@RequestMapping("/getrank")
	public @ResponseBody List<ApplicationsBean> getrank() {
		List<ApplicationsBean> getrank = null;

		getrank = ApplicationsService.getrank();

		return getrank;
	}
	
	
	@RequestMapping("/getnationality")
	public @ResponseBody List<ApplicationsBean> getnationality() {
		List<ApplicationsBean> getnationality = null;

		getnationality = ApplicationsService.getnationality();

		return getnationality;
	}
	
	@RequestMapping("/getagent")
	public @ResponseBody List<ApplicationsBean> getagent() {
		List<ApplicationsBean> getagent = null;

		getagent = ApplicationsService.getagent();

		return getagent;
	}
	
	
	
	@RequestMapping(value="/save")
	public ApplicationsResultBean save(@RequestBody ApplicationsBean bean) {
		ApplicationsResultBean rbean = new ApplicationsResultBean();
		try {
			rbean = ApplicationsService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	
	@RequestMapping(value="/list")
	public ApplicationsResultBean list() {
		ApplicationsResultBean rbean = new ApplicationsResultBean();
		try {
			rbean = ApplicationsService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public ApplicationsResultBean edit(@RequestParam("id") Integer id) {
		ApplicationsResultBean rbean = new ApplicationsResultBean();
		try {
			rbean = ApplicationsService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public ApplicationsResultBean delete(@RequestParam("id") Integer id) {
		ApplicationsResultBean rbean = new ApplicationsResultBean();
		try {
			rbean = ApplicationsService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	@RequestMapping(value="/update")
	public ApplicationsResultBean update(@RequestBody ApplicationsBean bean) {
		ApplicationsResultBean rbean = new ApplicationsResultBean();
		try {
			rbean = ApplicationsService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping("/uploadfile")
	public @ResponseBody ApplicationsResultBean saveuploadfile(@RequestBody MultipartFile file, HttpServletRequest request) throws CustomException {
		ApplicationsResultBean resultBean= new ApplicationsResultBean();
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
	
	///Load Certificate
	
		@RequestMapping(value="/certificateList")
		public ApplicationsResultBean certificateList(@RequestParam("rankCode") String rankCode) {
			ApplicationsResultBean rbean = new ApplicationsResultBean();
			try {
				rbean = ApplicationsService.certificateList(rankCode);
			} catch (Exception e) {
				e.printStackTrace();
			}
	   		return rbean;
	   	}
		
	///Save Certificate
		
		@RequestMapping(value="/saveCertificate")
		public ApplicationsResultBean saveCertificate(@RequestBody ApplicationsBean bean) {
			ApplicationsResultBean rbean = new ApplicationsResultBean();
			try {
				rbean = ApplicationsService.saveCertificate(bean);
			}catch(Exception e){
				e.printStackTrace();	
			}
			return rbean;
		}
	
}
