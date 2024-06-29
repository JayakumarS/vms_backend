package com.vms.vessel.vesselInsurance;


public interface VesselinsuranceDao {

	
	public VesselinsuranceResultBean save(VesselinsuranceBean bean);

	public VesselinsuranceResultBean getListpandi();
	
	public VesselinsuranceResultBean getListfdandd();

	public VesselinsuranceResultBean edit(Integer id);

	public VesselinsuranceResultBean delete(Integer id);

	public VesselinsuranceResultBean update(VesselinsuranceBean bean);
	
	
}
