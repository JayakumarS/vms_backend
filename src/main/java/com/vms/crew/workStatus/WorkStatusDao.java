package com.vms.crew.workStatus;



public interface WorkStatusDao {
	public WorkStatusResultBean save(WorkStatusBean bean);

	public WorkStatusResultBean getList();

	public WorkStatusResultBean edit(String id);

	public WorkStatusResultBean delete(String id);

	public WorkStatusResultBean update(WorkStatusBean bean);
}