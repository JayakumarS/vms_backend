package com.vms.crew.personMaintenance;

import java.util.List;


public class PersonMaintenanceBean {
	private List<PersonMaintenanceBean> list;
	private String surname;
	private String name;
	private String middle;
	private String nationality;
	private String rank;
	private String birthDate;
	private String gender;
	private String father;
	private String mother;
	private String place;
	private String licence;
	private String health;
	private String decision;
	private String workStatus;
	private String religion;
	private String agent;
	private Integer expMonth;
	private Integer noVoyage;
	private String proposedType;
	private String signedOff;
	private String availableFrom;
	private String remarksOne;
	private String remarksTwo;
	private String reCom;
	private String active;
	private String code;
	private String rankName;
	private String select;
	private String cvFileName;
	private String cvFilePath;
	private String rankDate;
	private String applCode;
	private boolean valid;
	private boolean inValid;
	private boolean optional;
	
	
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public boolean isInValid() {
		return inValid;
	}
	public void setInValid(boolean inValid) {
		this.inValid = inValid;
	}
	public boolean isOptional() {
		return optional;
	}
	public void setOptional(boolean optional) {
		this.optional = optional;
	}
	public String getApplCode() {
		return applCode;
	}
	public void setApplCode(String applCode) {
		this.applCode = applCode;
	}
	public String getRankDate() {
		return rankDate;
	}
	public void setRankDate(String rankDate) {
		this.rankDate = rankDate;
	}
	public String getCvFileName() {
		return cvFileName;
	}
	public void setCvFileName(String cvFileName) {
		this.cvFileName = cvFileName;
	}
	public String getCvFilePath() {
		return cvFilePath;
	}
	public void setCvFilePath(String cvFilePath) {
		this.cvFilePath = cvFilePath;
	}
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
	public String getProposedType() {
		return proposedType;
	}
	public void setProposedType(String proposedType) {
		this.proposedType = proposedType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<PersonMaintenanceBean> getList() {
		return list;
	}
	public void setList(List<PersonMaintenanceBean> list) {
		this.list = list;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMiddle() {
		return middle;
	}
	public void setMiddle(String middle) {
		this.middle = middle;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public String getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public Integer getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(Integer expMonth) {
		this.expMonth = expMonth;
	}
	public Integer getNoVoyage() {
		return noVoyage;
	}
	public void setNoVoyage(Integer noVoyage) {
		this.noVoyage = noVoyage;
	}
	public String getSignedOff() {
		return signedOff;
	}
	public void setSignedOff(String signedOff) {
		this.signedOff = signedOff;
	}
	public String getAvailableFrom() {
		return availableFrom;
	}
	public void setAvailableFrom(String availableFrom) {
		this.availableFrom = availableFrom;
	}
	public String getRemarksOne() {
		return remarksOne;
	}
	public void setRemarksOne(String remarksOne) {
		this.remarksOne = remarksOne;
	}
	public String getRemarksTwo() {
		return remarksTwo;
	}
	public void setRemarksTwo(String remarksTwo) {
		this.remarksTwo = remarksTwo;
	}
	public String getReCom() {
		return reCom;
	}
	public void setReCom(String reCom) {
		this.reCom = reCom;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	//Document Details
	private String passport;
	private String pIssue;
	private String pExpiry;
	private String pIssuePlace;
	private String sBook;
	private String sIssue;
	private String sExpiry;
	private String sIssuePlace;
	private boolean usVisa;
	private String sid;
	private String sidIssue;
	private String sidExpiry;
	private String usPassport;
	private String pan;
	private String adhar;
	private String indos;
	private String usVisaNo;
	private String usExpiry;
	private String sidFilePath;
	private String sidFileName;
	private String imgPath;
	private String imgName;
	private Integer age;
	private double compService;
	private double seaService;
	private double yearsInRank;
	private String crewMasterImg;
	private String crewMasterFilePath;
	
	public String getCrewMasterImg() {
		return crewMasterImg;
	}
	public void setCrewMasterImg(String crewMasterImg) {
		this.crewMasterImg = crewMasterImg;
	}
	public String getCrewMasterFilePath() {
		return crewMasterFilePath;
	}
	public void setCrewMasterFilePath(String crewMasterFilePath) {
		this.crewMasterFilePath = crewMasterFilePath;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public double getCompService() {
		return compService;
	}
	public void setCompService(double compService) {
		this.compService = compService;
	}
	public double getSeaService() {
		return seaService;
	}
	public void setSeaService(double seaService) {
		this.seaService = seaService;
	}
	public double getYearsInRank() {
		return yearsInRank;
	}
	public void setYearsInRank(double yearsInRank) {
		this.yearsInRank = yearsInRank;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getSidFilePath() {
		return sidFilePath;
	}
	public void setSidFilePath(String sidFilePath) {
		this.sidFilePath = sidFilePath;
	}
	public String getSidFileName() {
		return sidFileName;
	}
	public void setSidFileName(String sidFileName) {
		this.sidFileName = sidFileName;
	}
	public boolean isUsVisa() {
		return usVisa;
	}
	public void setUsVisa(boolean usVisa) {
		this.usVisa = usVisa;
	}

	public String getUsVisaNo() {
		return usVisaNo;
	}
	public void setUsVisaNo(String usVisaNo) {
		this.usVisaNo = usVisaNo;
	}
	public String getUsExpiry() {
		return usExpiry;
	}
	public void setUsExpiry(String usExpiry) {
		this.usExpiry = usExpiry;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getpIssue() {
		return pIssue;
	}
	public void setpIssue(String pIssue) {
		this.pIssue = pIssue;
	}
	public String getpExpiry() {
		return pExpiry;
	}
	public void setpExpiry(String pExpiry) {
		this.pExpiry = pExpiry;
	}
	public String getpIssuePlace() {
		return pIssuePlace;
	}
	public void setpIssuePlace(String pIssuePlace) {
		this.pIssuePlace = pIssuePlace;
	}
	public String getsBook() {
		return sBook;
	}
	public void setsBook(String sBook) {
		this.sBook = sBook;
	}
	public String getsIssue() {
		return sIssue;
	}
	public void setsIssue(String sIssue) {
		this.sIssue = sIssue;
	}
	public String getsExpiry() {
		return sExpiry;
	}
	public void setsExpiry(String sExpiry) {
		this.sExpiry = sExpiry;
	}
	public String getsIssuePlace() {
		return sIssuePlace;
	}
	public void setsIssuePlace(String sIssuePlace) {
		this.sIssuePlace = sIssuePlace;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSidIssue() {
		return sidIssue;
	}
	public void setSidIssue(String sidIssue) {
		this.sidIssue = sidIssue;
	}
	public String getSidExpiry() {
		return sidExpiry;
	}
	public void setSidExpiry(String sidExpiry) {
		this.sidExpiry = sidExpiry;
	}
	public String getUsPassport() {
		return usPassport;
	}
	public void setUsPassport(String usPassport) {
		this.usPassport = usPassport;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
	public String getIndos() {
		return indos;
	}
	public void setIndos(String indos) {
		this.indos = indos;
	}
	
	
	
}
