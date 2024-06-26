package com.vms.crew.maintain.interviewsetup;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vms.core.util.CustomException;




@RestController
@RequestMapping("/api/crew/maintain/interviewsetup")
public class InterviewSetupController {
	
	@Autowired
	InterviewSetupService interviewSetupService;
	
	
	@RequestMapping(value="/save")
	public InterviewSetupResultBean save(@RequestBody InterviewSetupBean bean) {
		InterviewSetupResultBean rbean = new InterviewSetupResultBean();
		try {
			rbean = interviewSetupService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public InterviewSetupResultBean list() {
		InterviewSetupResultBean rbean = new InterviewSetupResultBean();
		try {
			rbean = interviewSetupService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/edit")
	public InterviewSetupResultBean edit(@RequestParam("id") String id) {
		InterviewSetupResultBean rbean = new InterviewSetupResultBean();
		try {
			rbean = interviewSetupService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/update")
	public InterviewSetupResultBean update(@RequestBody InterviewSetupBean bean) {
		InterviewSetupResultBean rbean = new InterviewSetupResultBean();
		try {
			rbean = interviewSetupService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/delete")
	public InterviewSetupResultBean delete(@RequestParam("id") String id) {
		InterviewSetupResultBean rbean = new InterviewSetupResultBean();
		try {
			rbean = interviewSetupService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	
	//Rank Master
		@RequestMapping("/getRankMasters")
		public @ResponseBody InterviewSetupResultBean getRankMasters() throws CustomException {
			InterviewSetupResultBean interviewSetupResultBean = new InterviewSetupResultBean();
			try {
				interviewSetupResultBean.setlInterviewSetupBean(interviewSetupService.getRankMasters());
				interviewSetupResultBean.setSuccess(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return interviewSetupResultBean;
		}
	
	
	
	
	
}


