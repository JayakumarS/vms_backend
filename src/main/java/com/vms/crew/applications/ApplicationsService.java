package com.vms.crew.applications;


public interface ApplicationsService { 

	public ApplicationsResultBean save(ApplicationsBean bean);

	public ApplicationsResultBean getList();

	
	public ApplicationsResultBean edit(Integer id);

	public ApplicationsResultBean delete(Integer id);
	
	public ApplicationsResultBean update(ApplicationsBean bean);

	public ApplicationsResultBean certificateList(int rankCode);

	public ApplicationsResultBean saveCertificate(ApplicationsBean bean);

	public ApplicationsResultBean mcertificateList(int rankCode);

}
