package com.vms.crew.maintain.bloodgroup;

public interface BloodGroupDao {

	public BloodGroupResultBean delete(String id);

	public BloodGroupResultBean save(BloodGroupBean bean);

	public BloodGroupResultBean getList();

	public BloodGroupResultBean edit(String id);

	public BloodGroupResultBean update(BloodGroupBean bean);

	

}
