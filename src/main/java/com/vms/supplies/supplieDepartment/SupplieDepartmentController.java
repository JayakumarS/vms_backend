package com.vms.supplies.supplieDepartment;

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
@RequestMapping("/api/supplies/supplieDepartment")

public class SupplieDepartmentController {
	
	@Autowired
	SupplieDepartmentService supplieDepartmentService;
	
	@RequestMapping(value="/save")
	public SupplieDepartmentResultBean save(@RequestBody SupplieDepartmentBean bean) {
		SupplieDepartmentResultBean rbean = new SupplieDepartmentResultBean();
		try {
			rbean = supplieDepartmentService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/edit")
	public SupplieDepartmentResultBean edit(@RequestParam("id") String id) {
		SupplieDepartmentResultBean rbean = new SupplieDepartmentResultBean();
		try {
			rbean = supplieDepartmentService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public SupplieDepartmentResultBean update(@RequestBody SupplieDepartmentBean bean) {
		SupplieDepartmentResultBean rbean = new SupplieDepartmentResultBean();
		try {
			rbean = supplieDepartmentService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public SupplieDepartmentResultBean list() {
		SupplieDepartmentResultBean rbean = new SupplieDepartmentResultBean();
		try {
			rbean = supplieDepartmentService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}

	@RequestMapping(value="/delete")
	public SupplieDepartmentResultBean delete(@RequestParam("id") String id) {
		SupplieDepartmentResultBean rbean = new SupplieDepartmentResultBean();
		try {
			rbean = supplieDepartmentService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/generateCode")
	public SupplieDepartmentResultBean generateCode() throws Exception{
		String code = "";
		SupplieDepartmentResultBean rbean = new SupplieDepartmentResultBean();
		try {
			code = supplieDepartmentService.generateCode();
			rbean.setCode(code);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}			
}
