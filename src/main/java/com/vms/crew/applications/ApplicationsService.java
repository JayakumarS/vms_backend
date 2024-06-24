package com.vms.crew.applications;

import java.util.List;


public interface ApplicationsService { 
	
	List<ApplicationsBean> getenginelist();

	
	List<ApplicationsBean> getlicence();

	List<ApplicationsBean> getvessel();
	
	List<ApplicationsBean> getrank();
	
	List<ApplicationsBean> getnationality();
	
	List<ApplicationsBean> getagent();

	public ApplicationsResultBean save(ApplicationsBean bean);

	public ApplicationsResultBean getList();

	
	public ApplicationsResultBean edit(Integer id);

	public ApplicationsResultBean delete(Integer id);
	
	public ApplicationsResultBean update(ApplicationsBean bean);

	public ApplicationsResultBean certificateList();

	public ApplicationsResultBean saveCertificate(ApplicationsBean bean);


}
