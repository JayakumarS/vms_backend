package com.vms.crew.workLicense;

public interface WorkLicenseService {
	
	public WorkLicenseResultBean save(WorkLicenseBean bean);

	public WorkLicenseResultBean getList();

	public WorkLicenseResultBean edit(Integer id);

	public WorkLicenseResultBean delete(Integer id);

	public WorkLicenseResultBean update(WorkLicenseBean bean);

}
