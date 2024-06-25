package com.vms.crew.maintainRank;

import java.util.List;

public interface MaintainRankService {
	
	public MaintainRankResultBean save(MaintainRankBean bean);

	public MaintainRankResultBean getList();

	public MaintainRankResultBean edit(Integer id);

	public MaintainRankResultBean delete(Integer id);

	public MaintainRankResultBean update(MaintainRankBean bean);

	List<MaintainRankBean> getdepartment();
	
	List<MaintainRankBean> getgrouppage();

	

}
