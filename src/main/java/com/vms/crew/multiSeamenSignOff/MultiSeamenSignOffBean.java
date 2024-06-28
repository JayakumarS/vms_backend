package com.vms.crew.multiSeamenSignOff;

import java.util.List;

public class MultiSeamenSignOffBean {
	
	private List<MultiSeamenSignOffBean> tablerow;

	public List<MultiSeamenSignOffBean> getTablerow() {
		return tablerow;
	}
	public void setTablerow(List<MultiSeamenSignOffBean> tablerow) {
		this.tablerow = tablerow;
	}
	private Integer port;
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	private Integer code;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getJoiningdate() {
		return joiningdate;
	}
	public void setJoiningdate(String joiningdate) {
		this.joiningdate = joiningdate;
	}
	private Integer rank;
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
	
	private Integer nationality;
	public Integer getNationality() {
		return nationality;
	}
	public void setNationality(Integer nationality) {
		this.nationality = nationality;
	}
	
	

	public Integer getSignoffport() {
		return signoffport;
	}
	public void setSignoffport(Integer signoffport) {
		this.signoffport = signoffport;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	private String reason;
	public String getSignOffDate() {
		return signOffDate;
	}
	public void setSignOffDate(String signOffDate) {
		this.signOffDate = signOffDate;
	}
	private String signOffDate;
	private Integer signoffport;
	
	
	
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getVessel() {
		return vessel;
	}
	public void setVessel(String vessel) {
		this.vessel = vessel;
	}
	public Integer getJoinPort() {
		return joinPort;
	}
	public void setJoinPort(Integer joinPort) {
		this.joinPort = joinPort;
	}
	public String getSignoffCode() {
		return signoffCode;
	}
	public void setSignoffCode(String signoffCode) {
		this.signoffCode = signoffCode;
	}
	
	private String fromdate;
	private String vessel;
	private Integer joinPort;
    private String signoffCode;
    private Integer seamenId;

	public Integer getSeamenId() {
		return seamenId;
	}
	public void setSeamenId(Integer seamenId) {
		this.seamenId = seamenId;
	}

}
