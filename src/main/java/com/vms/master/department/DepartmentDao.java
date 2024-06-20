package com.vms.master.department;

public interface DepartmentDao {
	
	public DepartmentResultBean save(DepartmentBean bean);
	
	public DepartmentResultBean getList();
	
	public DepartmentResultBean edit(String id);
	
	public DepartmentResultBean delete(String id);
	
	public DepartmentResultBean update(DepartmentBean bean);

}
