package com.vms.vessel.vesselInsurance;

public interface VesselinsuranceService {

	
	public VesselinsuranceResultBean save(VesselinsuranceBean bean);

	public VesselinsuranceResultBean getList();

	public VesselinsuranceResultBean edit(Integer id);

	public VesselinsuranceResultBean delete(Integer id);

	public VesselinsuranceResultBean update(VesselinsuranceBean bean);
	
}
