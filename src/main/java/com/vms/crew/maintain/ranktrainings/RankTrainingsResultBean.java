package com.vms.crew.maintain.ranktrainings;

import java.util.List;

public class RankTrainingsResultBean {

	public boolean success;
	private List<RankTrainingsBean>list;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<RankTrainingsBean> getList() {
		return list;
	}
	public void setList(List<RankTrainingsBean> list) {
		this.list = list;
	}
}
