package com.vms.crew.multiSeamenSignOff;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vms.core.util.CustomException;

@RestController
@RequestMapping("/api/crew/multiSeamenSignOff")
public class MultiSeamenSignOffController {
	
	@Autowired
	private MultiSeamenSignOffService MultiSeamenSignOffService;
	
	
	@RequestMapping("/multiSemanlist")
	public @ResponseBody  List<MultiSeamenSignOffBean> multiSemanlist(@RequestParam("date") String date, @RequestParam("vessel") String vessel,@RequestParam("port") Integer port) throws CustomException {
		List<MultiSeamenSignOffBean>  multiSemanlist = new ArrayList<>();

		try {
			multiSemanlist=MultiSeamenSignOffService.multiSemanlist(date,vessel,port);
 
		} catch (Exception e) {
			throw new CustomException();
		}
		return multiSemanlist;
	}
	
	
	
	@RequestMapping("/saveMultiSeamen")
	public @ResponseBody MultiSeamenSignOffResultBean saveMultiSeamen(@RequestBody MultiSeamenSignOffBean MultiSeamenSignOffBean)
			throws CustomException, InterruptedException {
		MultiSeamenSignOffResultBean objPaymentInformationResultBean = new MultiSeamenSignOffResultBean();
		boolean isSucess = false;
		try {
			isSucess = MultiSeamenSignOffService.saveMultiSeamen(MultiSeamenSignOffBean);
			objPaymentInformationResultBean.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}
		return objPaymentInformationResultBean;
	}
}
