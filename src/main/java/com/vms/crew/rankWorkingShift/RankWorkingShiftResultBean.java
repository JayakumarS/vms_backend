package com.vms.crew.rankWorkingShift;

import java.util.List;



public class RankWorkingShiftResultBean {
	
	public boolean success;


	private List<RankWorkingShiftBean> list;
	private RankWorkingShiftBean RankWorkingShiftBean;
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
