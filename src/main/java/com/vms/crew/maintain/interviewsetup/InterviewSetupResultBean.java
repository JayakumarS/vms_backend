package com.vms.crew.maintain.interviewsetup;

import java.util.List;


public class InterviewSetupResultBean {

	
	public String message;
	public boolean success;
	private List<InterviewSetupBean> list;
	private InterviewSetupBean interviewSetupBean;
	private List<InterviewSetupBean> lInterviewSetupBean;
	
	public List<InterviewSetupBean> getlInterviewSetupBean() {
		return lInterviewSetupBean;
	}
	public void setlInterviewSetupBean(List<InterviewSetupBean> lInterviewSetupBean) {
		this.lInterviewSetupBean = lInterviewSetupBean;
	}
	public InterviewSetupBean getInterviewSetupBean() {
		return interviewSetupBean;
	}
	public void setInterviewSetupBean(InterviewSetupBean interviewSetupBean) {
		this.interviewSetupBean = interviewSetupBean;
	}
	public List<InterviewSetupBean> getList() {
		return list;
	}
	public void setList(List<InterviewSetupBean> list) {
		this.list = list;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
