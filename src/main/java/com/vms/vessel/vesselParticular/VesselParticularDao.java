package com.vms.vessel.vesselParticular;

public interface VesselParticularDao {

	public VesselParticularResultBean save(VesselParticularBean bean);

	public VesselParticularResultBean getList();

	public VesselParticularResultBean edit(String id);

	public VesselParticularResultBean delete(String id);

	public VesselParticularResultBean update(VesselParticularBean bean);

	public String generateCode();

}
