package com.vms.crew.utilities.MultiSeamen;

import java.util.List;


public class MultiSeamenBean {
	
	public String vessel;
	public String startdate;
	public Integer nationality;
	public Integer seamenCode;
	public boolean validCheck;
	
	public boolean isValidCheck() {
		return validCheck;
	}
	public void setValidCheck(boolean validCheck) {
		this.validCheck = validCheck;
	}
	public Integer getSeamenCode() {
		return seamenCode;
	}
	public void setSeamenCode(Integer seamenCode) {
		this.seamenCode = seamenCode;
	}
	public Integer getNationality() {
		return nationality;
	}
	public void setNationality(Integer nationality) {
		this.nationality = nationality;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public Integer joinPort;

	public Integer getJoinPort() {
		return joinPort;
	}
	public void setJoinPort(Integer joinPort) {
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
	public Integer rank;
	public String pay;
	public String currency;
	public String joiningDate;
	public String estSignOff;
	public String createdDate;


	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
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

	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
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
	
	
	
	private String portname;
	public String getPortname() {
		return portname;
	}
	public void setPortname(String portname) {
		this.portname = portname;
	}
	public String getVesselname() {
		return vesselname;
	}
	public void setVesselname(String vesselname) {
		this.vesselname = vesselname;
	}


	private String vesselname;
	

}
