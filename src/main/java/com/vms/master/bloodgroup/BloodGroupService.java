package com.vms.master.bloodgroup;

public interface BloodGroupService {

	public BloodGroupResultBean delete(String id);

	public BloodGroupResultBean update(BloodGroupBean bean);

	public BloodGroupResultBean edit(String id);

	public	BloodGroupResultBean getList();

	public	BloodGroupResultBean save(BloodGroupBean bean);

	public BloodGroupBean getSequenceCode();



}