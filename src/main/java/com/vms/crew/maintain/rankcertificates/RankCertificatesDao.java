package com.vms.crew.maintain.rankcertificates;

import java.util.List;


public interface RankCertificatesDao {

	public RankCertificatesResultBean save(List<RankCertificatesBean> selectedCertificates);

	public RankCertificatesResultBean getList();

	public RankCertificatesResultBean getsavelist();
	
	List<RankCertificatesBean> getrank();

}
