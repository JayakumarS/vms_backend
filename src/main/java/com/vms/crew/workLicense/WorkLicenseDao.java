package com.vms.crew.workLicense;



public interface WorkLicenseDao {
	
	public WorkLicenseResultBean save(WorkLicenseBean bean);

	public WorkLicenseResultBean getList();

	public WorkLicenseResultBean edit(String id);

	public WorkLicenseResultBean delete(String id);

	public WorkLicenseResultBean update(WorkLicenseBean bean);

}
