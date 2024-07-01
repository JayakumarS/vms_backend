package com.vms.supplies.unitsPackings;

public interface UnitsPackingsService {
	
	public UnitsPackingsResultBean save(UnitsPackingsBean bean);

	public UnitsPackingsResultBean getList();

	public UnitsPackingsResultBean delete(String id);

	public UnitsPackingsResultBean edit(String id);

	public UnitsPackingsResultBean update(UnitsPackingsBean bean);

	public String generateCode();


}
