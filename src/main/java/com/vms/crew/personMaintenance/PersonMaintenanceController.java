package com.vms.crew.personMaintenance;

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
import com.vms.vessel.vesselParticular.VesselParticularBean;
import com.vms.vessel.vesselParticular.VesselParticularResultBean;



@RestController
@RequestMapping("/api/crew/personMaintenance")

public class PersonMaintenanceController {
	
	@Autowired
	PersonMaintenanceService personMaintenanceService;
	
	@RequestMapping(value="/save")
	public PersonMaintenanceResultBean save(@RequestBody PersonMaintenanceBean bean) {
		PersonMaintenanceResultBean rbean = new PersonMaintenanceResultBean();
		try {
			rbean = personMaintenanceService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/edit")
	public PersonMaintenanceResultBean edit(@RequestParam("id") String id) {
		PersonMaintenanceResultBean rbean = new PersonMaintenanceResultBean();
		try {
			rbean = personMaintenanceService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public PersonMaintenanceResultBean update(@RequestBody PersonMaintenanceBean bean) {
		PersonMaintenanceResultBean rbean = new PersonMaintenanceResultBean();
		try {
			rbean = personMaintenanceService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public PersonMaintenanceResultBean list() {
		PersonMaintenanceResultBean rbean = new PersonMaintenanceResultBean();
		try {
			rbean = personMaintenanceService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/getdetails")
	public PersonMaintenanceResultBean getDetails(@RequestParam("id") String id) {
		PersonMaintenanceResultBean rbean= new PersonMaintenanceResultBean();
		try {
			rbean =personMaintenanceService.getDetails(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rbean;
	}

	@RequestMapping(value="/delete")
	public PersonMaintenanceResultBean delete(@RequestParam("id") String id) {
		PersonMaintenanceResultBean rbean = new PersonMaintenanceResultBean();
		try {
			rbean = personMaintenanceService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/getApplicantList")
	public PersonMaintenanceResultBean getApplicantList() {
		PersonMaintenanceResultBean rbean = new PersonMaintenanceResultBean();
		try {
			rbean = personMaintenanceService.getApplicantList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping("/uploadfile")
	public @ResponseBody PersonMaintenanceResultBean saveuploadfile(@RequestBody MultipartFile file, HttpServletRequest request) throws CustomException {
		PersonMaintenanceResultBean resultBean= new PersonMaintenanceResultBean();
		try {
 
			String filepath =  ConfigurationProps.exportFilesPath;
			String path = filepath+"/"+ file.getOriginalFilename();

			File checkfile = new File(filepath);
			if (!checkfile.exists())
				checkfile.mkdir();

			File convFile = new File(path);

			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
			resultBean.setFilePath(path);
			resultBean.setFileName(file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
		
}
