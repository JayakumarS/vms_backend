package com.vms.vessel.vesselParticular;

import java.util.List;

public class VesselParticularBean {
	
	//Header Bean
	private String code;
	private String description;
	private String name;
	private String shortname;
	private String type;
	private String fleet;
	private String vesseltype;
	private String pandi;
	private String hullandmachinery;
	private String vesselgroup;
	private String fdandd;
	private String wagescale;
	private String reason;
	private String vesselClass;
	private String valiedUntil;
	private String leadvesselid;
	private boolean vesselStatus;
	private String dateinfleettype;
	private String fleetvessel;
	private String fleetName;
	private String vesselTypeName;
	private String pandiName;
	private String wageScaleName;
	private String vesselClassName;

	public boolean isVesselStatus() {
		return vesselStatus;
	}
	public void setVesselStatus(boolean vesselStatus) {
		this.vesselStatus = vesselStatus;
	}
	public String getWageScaleName() {
		return wageScaleName;
	}
	public void setWageScaleName(String wageScaleName) {
		this.wageScaleName = wageScaleName;
	}
	public String getVesselClassName() {
		return vesselClassName;
	}
	public void setVesselClassName(String vesselClassName) {
		this.vesselClassName = vesselClassName;
	}
	public String getPandiName() {
		return pandiName;
	}
	public void setPandiName(String pandiName) {
		this.pandiName = pandiName;
	}
	public String getVesselTypeName() {
		return vesselTypeName;
	}
	public void setVesselTypeName(String vesselTypeName) {
		this.vesselTypeName = vesselTypeName;
	}
	public String getFleetName() {
		return fleetName;
	}
	public void setFleetName(String fleetName) {
		this.fleetName = fleetName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFleet() {
		return fleet;
	}
	public void setFleet(String fleet) {
		this.fleet = fleet;
	}
	public String getVesseltype() {
		return vesseltype;
	}
	public void setVesseltype(String vesseltype) {
		this.vesseltype = vesseltype;
	}
	public String getPandi() {
		return pandi;
	}
	public void setPandi(String pandi) {
		this.pandi = pandi;
	}
	public String getHullandmachinery() {
		return hullandmachinery;
	}
	public void setHullandmachinery(String hullandmachinery) {
		this.hullandmachinery = hullandmachinery;
	}
	public String getVesselgroup() {
		return vesselgroup;
	}
	public void setVesselgroup(String vesselgroup) {
		this.vesselgroup = vesselgroup;
	}
	public String getFdandd() {
		return fdandd;
	}
	public void setFdandd(String fdandd) {
		this.fdandd = fdandd;
	}
	public String getWagescale() {
		return wagescale;
	}
	public void setWagescale(String wagescale) {
		this.wagescale = wagescale;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getVesselClass() {
		return vesselClass;
	}
	public void setVesselClass(String vesselClass) {
		this.vesselClass = vesselClass;
	}
	public String getValiedUntil() {
		return valiedUntil;
	}
	public void setValiedUntil(String valiedUntil) {
		this.valiedUntil = valiedUntil;
	}
	public String getLeadvesselid() {
		return leadvesselid;
	}
	public void setLeadvesselid(String leadvesselid) {
		this.leadvesselid = leadvesselid;
	}
	public String getDateinfleettype() {
		return dateinfleettype;
	}
	public void setDateinfleettype(String dateinfleettype) {
		this.dateinfleettype = dateinfleettype;
	}
	public String getFleetvessel() {
		return fleetvessel;
	}
	public void setFleetvessel(String fleetvessel) {
		this.fleetvessel = fleetvessel;
	}
	
	//Main Detail Bean
	private String flag;
	private boolean greek;
	private String registryport;
	private Integer registryno;
	private String builtdate;
	private String placeBuild;
	private String yardbuild;
	private Integer imono;
	private Integer hullno;
	private Integer natnumber;
	private String callsign;
	private Integer mmis;
	private Integer classno;
	private String iceclass;
	private String flagName;
	private String vesselName;
	private String portName;

	public String getPortName() {
		return portName;
	}
	public void setPortName(String portName) {
		this.portName = portName;
	}
	public String getFlagName() {
		return flagName;
	}
	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}
	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public boolean isGreek() {
		return greek;
	}
	public void setGreek(boolean greek) {
		this.greek = greek;
	}
	public String getRegistryport() {
		return registryport;
	}
	public void setRegistryport(String registryport) {
		this.registryport = registryport;
	}
	public Integer getRegistryno() {
		return registryno;
	}
	public void setRegistryno(Integer registryno) {
		this.registryno = registryno;
	}
	public String getBuiltdate() {
		return builtdate;
	}
	public void setBuiltdate(String builtdate) {
		this.builtdate = builtdate;
	}
	public String getPlaceBuild() {
		return placeBuild;
	}
	public void setPlaceBuild(String placeBuild) {
		this.placeBuild = placeBuild;
	}
	public String getYardbuild() {
		return yardbuild;
	}
	public void setYardbuild(String yardbuild) {
		this.yardbuild = yardbuild;
	}
	public Integer getImono() {
		return imono;
	}
	public void setImono(Integer imono) {
		this.imono = imono;
	}
	public Integer getHullno() {
		return hullno;
	}
	public void setHullno(Integer hullno) {
		this.hullno = hullno;
	}
	public Integer getNatnumber() {
		return natnumber;
	}
	public void setNatnumber(Integer natnumber) {
		this.natnumber = natnumber;
	}
	public String getCallsign() {
		return callsign;
	}
	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}
	public Integer getMmis() {
		return mmis;
	}
	public void setMmis(Integer mmis) {
		this.mmis = mmis;
	}
	public Integer getClassno() {
		return classno;
	}
	public void setClassno(Integer classno) {
		this.classno = classno;
	}
	public String getIceclass() {
		return iceclass;
	}
	public void setIceclass(String iceclass) {
		this.iceclass = iceclass;
	}
	
	//Common Detail Bean
	private String shipowner;
	private Integer safteyno;
	private String shipownerplatform;
	private String operator;
	private String vesselOwnerName;
	
	public String getVesselOwnerName() {
		return vesselOwnerName;
	}
	public void setVesselOwnerName(String vesselOwnerName) {
		this.vesselOwnerName = vesselOwnerName;
	}
	public String getShipowner() {
		return shipowner;
	}
	public void setShipowner(String shipowner) {
		this.shipowner = shipowner;
	}
	public Integer getSafteyno() {
		return safteyno;
	}
	public void setSafteyno(Integer safteyno) {
		this.safteyno = safteyno;
	}
	public String getShipownerplatform() {
		return shipownerplatform;
	}
	public void setShipownerplatform(String shipownerplatform) {
		this.shipownerplatform = shipownerplatform;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	//Crew Detail Bean
	private String officialManager;
	private String shipmanager;
	private String crewmanager;
	private String groupmanager;
	private String offManagerName;
	private String shipManagerName;

	public String getOffManagerName() {
		return offManagerName;
	}
	public void setOffManagerName(String offManagerName) {
		this.offManagerName = offManagerName;
	}
	public String getShipManagerName() {
		return shipManagerName;
	}
	public void setShipManagerName(String shipManagerName) {
		this.shipManagerName = shipManagerName;
	}
	public String getOfficialManager() {
		return officialManager;
	}
	public void setOfficialManager(String officialManager) {
		this.officialManager = officialManager;
	}
	public String getShipmanager() {
		return shipmanager;
	}
	public void setShipmanager(String shipmanager) {
		this.shipmanager = shipmanager;
	}
	public String getCrewmanager() {
		return crewmanager;
	}
	public void setCrewmanager(String crewmanager) {
		this.crewmanager = crewmanager;
	}
	public String getGroupmanager() {
		return groupmanager;
	}
	public void setGroupmanager(String groupmanager) {
		this.groupmanager = groupmanager;
	}
	
	
	
	
	
	
	
	
}
