package com.vms.supplies.Supplier;

public interface SupplierDao {

	public SupplierResultBean save(SupplierBean bean);

	public SupplierResultBean list();

	public SupplierResultBean edit(String id);

	public SupplierResultBean delete(String id);

	public SupplierResultBean update(SupplierBean bean);

	public String generateCode();
	
}
