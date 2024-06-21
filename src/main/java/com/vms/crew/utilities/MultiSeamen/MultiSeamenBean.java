package com.vms.crew.utilities.MultiSeamen;

import java.util.List;


public class MultiSeamenBean {
	
	public String vessel;
	public String startdate;
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String joinPort;
	public String getJoinPort() {
		return joinPort;
	}
	public void setJoinPort(String joinPort) {
		this.joinPort = joinPort;
	}


	private List<MultiSeamenBean> multiseamendetail;

	
	public List<MultiSeamenBean> getMultiseamendetail() {
		return multiseamendetail;
	}
	public void setMultiseamendetail(List<MultiSeamenBean> multiseamendetail) {
		this.multiseamendetail = multiseamendetail;
	}
	public String getVessel() {
		return vessel;
	}
	public void setVessel(String vessel) {
		this.vessel = vessel;
	}
	
	
	
	
	//// Detail Bean
	
	public String code;
	public String name;
	public String rank;
	public String pay;
	public String currency;
	public String joiningDate;
	public String estSignOff;


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
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
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getEstSignOff() {
		return estSignOff;
	}
	public void setEstSignOff(String estSignOff) {
		this.estSignOff = estSignOff;
	}
	

}
