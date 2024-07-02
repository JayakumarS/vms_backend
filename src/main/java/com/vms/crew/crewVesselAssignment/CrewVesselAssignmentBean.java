package com.vms.crew.crewVesselAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CrewVesselAssignmentBean {
	private String id;
	private String text;
	
	private String name;
	private String rank;
	private String signon;
	private String signoff;
//    public List<CrewVesselAssignmentDetailBean> data;

	
	

	
//	public List<CrewVesselAssignmentDetailBean> getData() {
//		return data;
//	}
//
//	public void setData(List<CrewVesselAssignmentDetailBean> data) {
//		this.data = data;
//	}

//		public String getRankcode() {
//		return rankcode;
//	}
//	public void setRankcode(String rankcode) {
//		this.rankcode = rankcode;
//	}
	public String getDate() {
		return date;
	}
	
	public List<Map<String, Object>> getVessel() {
		return vessel;
	}

	public void setVessel(List<Map<String, Object>> vessel) {
		this.vessel = vessel;
	}

	public List<Map<String, Object>> getRankcode() {
		return rankcode;
	}

	public void setRankcode(List<Map<String, Object>> rankcode) {
		this.rankcode = rankcode;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String getDateObj() {
		return dateObj;
	}
	public void setDateObj(String dateObj) {
		this.dateObj = dateObj;
	}
//	public String getVessel() {
//		return vessel;
//	}
//	public void setVessel(String vessel) {
//		this.vessel = vessel;
//	}
//	private String rankcode;
	private String date;
	private String dateObj;
//	private String vessel;
	 private List<Map<String,Object>> vessel;
	 private List<Map<String,Object>> rankcode; 
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getSignon() {
		return signon;
	}
	public void setSignon(String signon) {
		this.signon = signon;
	}
	public String getSignoff() {
		return signoff;
	}
	public void setSignoff(String signoff) {
		this.signoff = signoff;
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
//	public List<Map<String,Object>> getVessel() {
//		return vessel;
//	}
//	public void setVessel(List<Map<String,Object>> vessel) {
//		this.vessel = vessel;
//	}
//	public List<Map<String,Object>> getRankcode() {
//		return rankcode;
//	}
//	public void setRankcode(List<Map<String,Object>> rankcode) {
//		this.rankcode = rankcode;
//	}
}
