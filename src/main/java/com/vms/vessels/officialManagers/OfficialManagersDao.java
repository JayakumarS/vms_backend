package com.vms.vessels.officialManagers;

import com.vms.crew.certificates.CertificatesBean;

public interface OfficialManagersDao {
	
	public OfficialManagersResultBean save(OfficialManagersBean bean);

	public OfficialManagersResultBean getList();

	public OfficialManagersResultBean edit(Integer id);

	public OfficialManagersResultBean delete(Integer id);

	public OfficialManagersResultBean update(OfficialManagersBean bean);

	OfficialManagersBean getSequenceCode();

}
