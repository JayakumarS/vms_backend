package com.vms.crew.maintain.rankmedicals;

import java.util.List;


public class RankMedicalResultBean {

	public boolean success;
	private List<RankMedicalBean>list;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<RankMedicalBean> getList() {
		return list;
	}
	public void setList(List<RankMedicalBean> list) {
		this.list = list;
	}
}
