package com.vms.crew.maintain.OffSign;

import java.util.List;

import com.vms.crew.rankWorkingShift.RankWorkingShiftBean;

public class OffSignResultBean {

	public boolean success;
	
	public String message;
	
    private List<OffSignBean> offSignDetail;

	
	public List<OffSignBean> getOffSignDetail() {
		return offSignDetail;
	}

	public void setOffSignDetail(List<OffSignBean> offSignDetail) {
		this.offSignDetail = offSignDetail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private List<OffSignBean> list;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<OffSignBean> getList() {
		return list;
	}

	public void setList(List<OffSignBean> list) {
		this.list = list;
	}
}
