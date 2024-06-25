package com.vms.crew.applications;

import java.util.List;

import com.vms.crew.maintainRank.MaintainRankBean;
import com.vms.crew.maintainRank.MaintainRankResultBean;






public interface ApplicationsDao {
	
	
	public ApplicationsResultBean save(ApplicationsBean bean);

	public ApplicationsResultBean getList();

	public ApplicationsResultBean edit(Integer id);
	
	public ApplicationsResultBean delete(Integer id);

	public ApplicationsResultBean update(ApplicationsBean bean);

	public  ApplicationsResultBean certificateList(String rankCode);

	public ApplicationsResultBean saveCertificate(ApplicationsBean bean);

}
