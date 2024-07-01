package com.vms.supplies.supplieDepartment;

public interface SupplieDepartmentDao {
	
	public SupplieDepartmentResultBean save(SupplieDepartmentBean bean);

	public SupplieDepartmentResultBean getList();
	
	public SupplieDepartmentResultBean delete(String id);

	public SupplieDepartmentResultBean edit(String id);

	public SupplieDepartmentResultBean update(SupplieDepartmentBean bean);

	public String generateCode();


}
