package com.vms.supplies.Supplier;

public interface SupplierService {

	public SupplierResultBean save(SupplierBean bean);

	public SupplierResultBean list();

	public SupplierResultBean edit(String id);

	public SupplierResultBean update(SupplierBean bean);

	public SupplierResultBean delete(String id);

	public String generateCode();

}
