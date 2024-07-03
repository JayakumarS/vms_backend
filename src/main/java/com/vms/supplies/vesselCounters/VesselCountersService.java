package com.vms.supplies.vesselCounters;

public interface VesselCountersService {
	
	public VesselCountersResultBean save(VesselCountersBean bean);

	public VesselCountersResultBean getList();

	public VesselCountersResultBean delete(String id);

	public VesselCountersResultBean edit(String id);

	public VesselCountersResultBean update(VesselCountersBean bean);

	public String generateCode();


}
