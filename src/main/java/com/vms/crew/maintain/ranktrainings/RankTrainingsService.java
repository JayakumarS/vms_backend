package com.vms.crew.maintain.ranktrainings;

import java.util.List;

public interface RankTrainingsService {

	public RankTrainingsResultBean save(List<RankTrainingsBean> selectedCertificates);

	public RankTrainingsResultBean getList();

	public RankTrainingsResultBean getsavelist();
	
	List<RankTrainingsBean> getrank();
}
