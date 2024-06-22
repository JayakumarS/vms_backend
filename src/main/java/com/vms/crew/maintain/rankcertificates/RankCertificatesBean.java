package com.vms.crew.maintain.rankcertificates;

import java.util.List;


public class RankCertificatesBean {

	private String categories;
	private String certificatecode;
	private String rankcode;
	private List<RankCertificatesBean>certificateStatusDtls;
	public String getCertificatecode() {
		return certificatecode;
	}
	public void setCertificatecode(String certificatecode) {
		this.certificatecode = certificatecode;
	}
	public String getRankcode() {
		return rankcode;
	}
	public void setRankcode(String rankcode) {
		this.rankcode = rankcode;
	}
	private boolean master;
	private boolean bmaster;
	private boolean cheifofc;
	private boolean scndofc;
	private boolean thrdofc;
	private boolean Juniorofficer;
	private boolean TOF;
	private boolean Dualclutchtrans;
	private boolean chiefeng;
	private boolean scndEng;
	private boolean thirdEng;
	private boolean fourthEng;
	private boolean JuniorEngineer;
	private boolean thermoelectricgenerator;
	private boolean ECT;
	private boolean Electricalengineer;
	private boolean Electrotechofficer;
	private boolean JEE;
	private boolean TEE;
	private String id;
	private String text;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public boolean isMaster() {
		return master;
	}
	public void setMaster(boolean master) {
		this.master = master;
	}
	public boolean isBmaster() {
		return bmaster;
	}
	public void setBmaster(boolean bmaster) {
		this.bmaster = bmaster;
	}
	public boolean isCheifofc() {
		return cheifofc;
	}
	public void setCheifofc(boolean cheifofc) {
		this.cheifofc = cheifofc;
	}
	public boolean isScndofc() {
		return scndofc;
	}
	public void setScndofc(boolean scndofc) {
		this.scndofc = scndofc;
	}
	public boolean isThrdofc() {
		return thrdofc;
	}
	public void setThrdofc(boolean thrdofc) {
		this.thrdofc = thrdofc;
	}
	
	public boolean isDualclutchtrans() {
		return Dualclutchtrans;
	}
	public void setDualclutchtrans(boolean dualclutchtrans) {
		Dualclutchtrans = dualclutchtrans;
	}
	public boolean isElectricalengineer() {
		return Electricalengineer;
	}
	public void setElectricalengineer(boolean electricalengineer) {
		Electricalengineer = electricalengineer;
	}
	public boolean isElectrotechofficer() {
		return Electrotechofficer;
	}
	public void setElectrotechofficer(boolean electrotechofficer) {
		Electrotechofficer = electrotechofficer;
	}
	public boolean isTOF() {
		return TOF;
	}
	public void setTOF(boolean tOF) {
		TOF = tOF;
	}
	
	public boolean isChiefeng() {
		return chiefeng;
	}
	public void setChiefeng(boolean chiefeng) {
		this.chiefeng = chiefeng;
	}
	public boolean isScndEng() {
		return scndEng;
	}
	public void setScndEng(boolean scndEng) {
		this.scndEng = scndEng;
	}
	public boolean isThirdEng() {
		return thirdEng;
	}
	public void setThirdEng(boolean thirdEng) {
		this.thirdEng = thirdEng;
	}
	public boolean isFourthEng() {
		return fourthEng;
	}
	public void setFourthEng(boolean fourthEng) {
		this.fourthEng = fourthEng;
	}
	
	
	public boolean isECT() {
		return ECT;
	}
	public void setECT(boolean eCT) {
		ECT = eCT;
	}
	
	
	public boolean isJEE() {
		return JEE;
	}
	public void setJEE(boolean jEE) {
		JEE = jEE;
	}
	public boolean isTEE() {
		return TEE;
	}
	public void setTEE(boolean tEE) {
		TEE = tEE;
	}
	public boolean isELC() {
		return ELC;
	}
	public void setELC(boolean eLC) {
		ELC = eLC;
	}
	public boolean isBSN() {
		return BSN;
	}
	public void setBSN(boolean bSN) {
		BSN = bSN;
	}
	public boolean isJuniorEngineer() {
		return JuniorEngineer;
	}
	public void setJuniorEngineer(boolean juniorEngineer) {
		JuniorEngineer = juniorEngineer;
	}
	public boolean isThermoelectricgenerator() {
		return thermoelectricgenerator;
	}
	public void setThermoelectricgenerator(boolean thermoelectricgenerator) {
		this.thermoelectricgenerator = thermoelectricgenerator;
	}
	public boolean isJuniorofficer() {
		return Juniorofficer;
	}
	public void setJuniorofficer(boolean juniorofficer) {
		Juniorofficer = juniorofficer;
	}
	public List<RankCertificatesBean> getCertificateStatusDtls() {
		return certificateStatusDtls;
	}
	public void setCertificateStatusDtls(List<RankCertificatesBean> certificateStatusDtls) {
		this.certificateStatusDtls = certificateStatusDtls;
	}
	private boolean ELC;
	private boolean BSN;
}
