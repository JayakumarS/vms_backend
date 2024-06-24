package com.vms.crew.workStatus;

public interface WorkStatusService {
	public WorkStatusResultBean save(WorkStatusBean bean);

	public WorkStatusResultBean getList();

	public WorkStatusResultBean edit(Integer id);

	public WorkStatusResultBean delete(Integer id);

	public WorkStatusResultBean update(WorkStatusBean bean);
}
