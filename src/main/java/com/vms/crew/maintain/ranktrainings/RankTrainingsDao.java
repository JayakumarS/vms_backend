package com.vms.crew.maintain.ranktrainings;

import java.util.List;


public interface RankTrainingsDao {

	
	public RankTrainingsResultBean save(List<RankTrainingsBean> selectedCertificates);

	public RankTrainingsResultBean getList();

	public RankTrainingsResultBean getsavelist();
	
	List<RankTrainingsBean> getrank();
}
