package com.vms.crew.rankWorkingShift;



public interface RankWorkingShiftDao {
	
	public RankWorkingShiftResultBean save(RankWorkingShiftBean bean);
	
	public RankWorkingShiftResultBean savedetail(RankWorkingShiftBean bean);

	public RankWorkingShiftResultBean getList();

	public RankWorkingShiftResultBean edit(String id);

	public RankWorkingShiftResultBean delete(String id);

	public RankWorkingShiftResultBean update(RankWorkingShiftBean bean);

}
