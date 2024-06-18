package com.vms.crew.rankGroup;



public interface RankGroupDao {
	
	public RankGroupResultBean save(RankGroupBean bean);

	public RankGroupResultBean getList();

	public RankGroupResultBean edit(String id);

	public RankGroupResultBean delete(String id);

	public RankGroupResultBean update(RankGroupBean bean);

}
