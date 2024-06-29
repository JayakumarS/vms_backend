package com.vms.vessels.officialManagers;



public interface OfficialManagersService {
	
	public OfficialManagersResultBean save(OfficialManagersBean bean);

	public OfficialManagersResultBean getList();

	public OfficialManagersResultBean edit(Integer id);

	public OfficialManagersResultBean delete(Integer id);

	public OfficialManagersResultBean update(OfficialManagersBean bean);

	OfficialManagersBean getSequenceCode();

}
