package com.vms.crew.maintain.rankmedicals;

import java.util.List;

public interface RankMedicalService {

	
	public RankMedicalResultBean save(List<RankMedicalBean> selectedCertificates);

	public RankMedicalResultBean getList();

	public RankMedicalResultBean getsavelist();
	
	List<RankMedicalBean> getrank();
}
