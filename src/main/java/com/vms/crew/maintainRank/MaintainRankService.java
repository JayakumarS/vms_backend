package com.vms.crew.maintainRank;

import java.util.List;

public interface MaintainRankService {
	
	public MaintainRankResultBean save(MaintainRankBean bean);

	public MaintainRankResultBean getList();

	public MaintainRankResultBean edit(String id);

	public MaintainRankResultBean delete(String id);

	public MaintainRankResultBean update(MaintainRankBean bean);

	List<MaintainRankBean> getdepartment();
	
	List<MaintainRankBean> getgrouppage();

	

}
