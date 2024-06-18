package com.vms.crew.rankGroup;

import java.util.List;


public class RankGroupResultBean {

	
	public boolean success;
	private List<RankGroupBean> list;
	private RankGroupBean RankGroupBean;



	public List<RankGroupBean> getList() {
		return list;
	}

	public void setList(List<RankGroupBean> list) {
		this.list = list;
	}

	public RankGroupBean getRankGroupBean() {
		return RankGroupBean;
	}

	public void setRankGroupBean(RankGroupBean rankGroupBean) {
		RankGroupBean = rankGroupBean;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
