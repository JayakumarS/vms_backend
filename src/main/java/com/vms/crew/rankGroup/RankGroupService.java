package com.vms.crew.rankGroup;

public interface RankGroupService {
	public RankGroupResultBean save(RankGroupBean bean);

	public RankGroupResultBean getList();

	public RankGroupResultBean edit(Integer id);

	public RankGroupResultBean delete(Integer id);

	public RankGroupResultBean update(RankGroupBean bean);
}
