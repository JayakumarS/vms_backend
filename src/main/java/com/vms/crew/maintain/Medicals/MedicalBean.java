package com.vms.crew.maintain.Medicals;

public class MedicalBean {

	
	private Integer MedicalId;
	private String mcode;
	private String mdescription;
	public Integer getMedicalId() {
		return MedicalId;
	}
	public void setMedicalId(Integer medicalId) {
		MedicalId = medicalId;
	}
	public String getMcode() {
		return mcode;
	}
	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	public String getMdescription() {
		return mdescription;
	}
	public void setMdescription(String mdescription) {
		this.mdescription = mdescription;
	}
}
