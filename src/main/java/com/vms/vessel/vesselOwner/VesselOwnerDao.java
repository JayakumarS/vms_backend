package com.vms.vessel.vesselOwner;


public interface VesselOwnerDao {
	public VesselOwnerResultBean save(VesselOwnerBean bean);

	public VesselOwnerResultBean getList();

	public VesselOwnerResultBean edit(Integer id);

	public VesselOwnerResultBean delete(Integer id);

	public VesselOwnerResultBean update(VesselOwnerBean bean);
}
