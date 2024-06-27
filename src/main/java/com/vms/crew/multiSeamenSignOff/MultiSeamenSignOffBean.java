package com.vms.crew.multiSeamenSignOff;

public class MultiSeamenSignOffBean {
	private String port;
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getJoiningdate() {
		return joiningdate;
	}
	public void setJoiningdate(String joiningdate) {
		this.joiningdate = joiningdate;
	}
	private String rank;
	private String joiningdate;
	
	private String seaman;
	public String getSeaman() {
		return seaman;
	}
	public void setSeaman(String seaman) {
		this.seaman = seaman;
	}
	
	private String estSignoff;
	public String getEstSignoff() {
		return estSignoff;
	}
	public void setEstSignoff(String estSignoff) {
		this.estSignoff = estSignoff;
	}
	
	private String nationality;
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}
