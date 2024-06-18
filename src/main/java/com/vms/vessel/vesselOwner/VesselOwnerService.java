package com.vms.vessel.vesselOwner;

public interface VesselOwnerService {
	public VesselOwnerResultBean save(VesselOwnerBean bean);

	public VesselOwnerResultBean getList();

	public VesselOwnerResultBean edit(String id);

	public VesselOwnerResultBean delete(String id);

	public VesselOwnerResultBean update(VesselOwnerBean bean);

}
