package com.vms.vessel.vesselInsurance;

public interface VesselinsuranceService {

	
	public VesselinsuranceResultBean save(VesselinsuranceBean bean);

	public VesselinsuranceResultBean getList();

	public VesselinsuranceResultBean edit(String id);

	public VesselinsuranceResultBean delete(String id);

	public VesselinsuranceResultBean update(VesselinsuranceBean bean);
	
}
