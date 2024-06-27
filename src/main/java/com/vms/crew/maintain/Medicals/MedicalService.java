package com.vms.crew.maintain.Medicals;

public interface MedicalService {

	public MedicalResultBean save(MedicalBean bean);

	public MedicalResultBean getList();

	public MedicalResultBean edit(Integer id);

	public MedicalResultBean delete(Integer id);

	public MedicalResultBean update(MedicalBean bean);
	
}
