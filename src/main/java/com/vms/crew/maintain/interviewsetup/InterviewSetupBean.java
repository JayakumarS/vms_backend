package com.vms.crew.maintain.interviewsetup;

import java.util.List;



public class InterviewSetupBean {

	
	private Integer interviewsetupid;
	private String description;
	private int rank;
	private String id;
	private String text;
	private String select;
	private String desc;
	private String createdDate;
	private String createdBy;
	private String rankname;
	private List<InterviewSetupBean> InterviewSetupdetail;
	private List<InterviewSetupBean>interviewSetupBeanDtls;
	
	public List<InterviewSetupBean> getInterviewSetupdetail() {
		return InterviewSetupdetail;
	}
	public void setInterviewSetupdetail(List<InterviewSetupBean> interviewSetupdetail) {
		InterviewSetupdetail = interviewSetupdetail;
	}
	public String getRankname() {
		return rankname;
	}
	public void setRankname(String rankname) {
		this.rankname = rankname;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	
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
	public Integer getInterviewsetupid() {
		return interviewsetupid;
	}
	public void setInterviewsetupid(Integer interviewsetupid) {
		this.interviewsetupid = interviewsetupid;
	}
	
	
	
	
	
	
	
	
	
	
	
}
