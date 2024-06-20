package com.vms.crew.rankWorkingShift;

import java.util.List;


public class RankWorkingShiftBean {
	private String vessel;
	private String rank;
	private String sDate;
	private String code;
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getVessel() {
		return vessel;
	}


	public void setVessel(String vessel) {
		this.vessel = vessel;
	}


	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}


	public String getsDate() {
		return sDate;
	}


	public void setsDate(String sDate) {
		this.sDate = sDate;
	}


	public String geteDate() {
		return eDate;
	}


	public void seteDate(String eDate) {
		this.eDate = eDate;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getShiftStart() {
		return shiftStart;
	}


	public void setShiftStart(String shiftStart) {
		this.shiftStart = shiftStart;
	}


	public String getShiftEnd() {
		return shiftEnd;
	}


	public void setShiftEnd(String shiftEnd) {
		this.shiftEnd = shiftEnd;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	

	public List<RankWorkingShiftBean> getRankWorkingShiftBeanDtls() {
		return rankWorkingShiftBeanDtls;
	}


	public void setRankWorkingShiftBeanDtls(List<RankWorkingShiftBean> rankWorkingShiftBeanDtls) {
		this.rankWorkingShiftBeanDtls = rankWorkingShiftBeanDtls;
	}


	private String eDate;
	private String remarks;
	private String shiftStart;
	private String shiftEnd;
	private String place;
	private Boolean watchKeeping;
	
	
	public Boolean getWatchKeeping() {
		return watchKeeping;
	}


	public void setWatchKeeping(Boolean watchKeeping) {
		this.watchKeeping = watchKeeping;
	}
	private List<RankWorkingShiftBean> secondDetailRow;


	public List<RankWorkingShiftBean> getSecondDetailRow() {
		return secondDetailRow;
	}


	public void setSecondDetailRow(List<RankWorkingShiftBean> secondDetailRow) {
		this.secondDetailRow = secondDetailRow;
	}


	private List<RankWorkingShiftBean> rankWorkingShiftBeanDtls;

}
