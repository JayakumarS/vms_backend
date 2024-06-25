package com.vms.master.department;

public interface DepartmentService {
	public DepartmentResultBean save(DepartmentBean bean);

	public DepartmentResultBean getList();

	public DepartmentResultBean edit(Integer id);

	public DepartmentResultBean delete(Integer id);

	public DepartmentResultBean update(DepartmentBean bean);

}
