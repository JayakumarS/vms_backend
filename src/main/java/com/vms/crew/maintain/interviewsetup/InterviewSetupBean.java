package com.vms.crew.maintain.interviewsetup;

import java.util.List;

public class InterviewSetupBean {

	
	private int interviewsetupid;
	private String description;
	private int rank;
	private String id;
	private String text;
	
	
	private List<InterviewSetupBean>interviewSetupBeanDtls;
	
	public List<InterviewSetupBean> getInterviewSetupBeanDtls() {
		return interviewSetupBeanDtls;
	}
	public void setInterviewSetupBeanDtls(List<InterviewSetupBean> interviewSetupBeanDtls) {
		this.interviewSetupBeanDtls = interviewSetupBeanDtls;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getInterviewsetupid() {
		return interviewsetupid;
	}
	public void setInterviewsetupid(int interviewsetupid) {
		this.interviewsetupid = interviewsetupid;
	}
	
	
	
	
	
	
	
	
	
	
}
