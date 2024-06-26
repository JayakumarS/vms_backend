package com.vms.crew.rankWorkingShift;

import java.util.List;



public class RankWorkingShiftResultBean {
	
	public boolean success;
	public String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private List<RankWorkingShiftBean> list;
	private RankWorkingShiftBean RankWorkingShiftBean;
    private List<RankWorkingShiftBean> secondDetailRow;

	
	public List<RankWorkingShiftBean> getSecondDetailRow() {
		return secondDetailRow;
	}
	public void setSecondDetailRow(List<RankWorkingShiftBean> secondDetailRow) {
		this.secondDetailRow = secondDetailRow;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<RankWorkingShiftBean> getList() {
		return list;
	}
	public void setList(List<RankWorkingShiftBean> list) {
		this.list = list;
	}
	public RankWorkingShiftBean getRankWorkingShiftBean() {
		return RankWorkingShiftBean;
	}
	public void setRankWorkingShiftBean(RankWorkingShiftBean rankWorkingShiftBean) {
		RankWorkingShiftBean = rankWorkingShiftBean;
	}

}
