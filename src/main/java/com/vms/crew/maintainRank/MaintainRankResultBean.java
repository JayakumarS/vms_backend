package com.vms.crew.maintainRank;

import java.util.List;


public class MaintainRankResultBean {

	
	public boolean success;
	private List<MaintainRankBean> list;
	private MaintainRankBean maintainRankBean;



	public List<MaintainRankBean> getList() {
		return list;
	}

	public void setList(List<MaintainRankBean> list) {
		this.list = list;
	}

	public MaintainRankBean getMaintainRankBean() {
		return maintainRankBean;
	}

	public void setMaintainRankBean(MaintainRankBean maintainRankBean) {
		this.maintainRankBean = maintainRankBean;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
