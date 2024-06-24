package com.vms.crew.rankWorkingShift;

public interface RankWorkingShiftService {
	
	public RankWorkingShiftResultBean save(RankWorkingShiftBean bean);
	
	public RankWorkingShiftResultBean savedetail(RankWorkingShiftBean bean);


	public RankWorkingShiftResultBean getList();

	public RankWorkingShiftResultBean edit(int id);

	public RankWorkingShiftResultBean delete(int id);

	public RankWorkingShiftResultBean update(RankWorkingShiftBean bean);


}
