package com.vms.vessel.vesselParticular;

public class VesselParticularQueryUtil {

	public static final String SAVE_HDR_VESSEL_PARTICULAR = "Insert into vessel_hdr (vessel_code,vessel_name,vessel_short_name,fleet_code,vessel_type_code,pandi_ins_code,hull_ins_code,fd_ins_code, "
			+ "vessel_group,wage_scale_code,is_active,reason,vessel_class,fleet_vsl_id,fleet_date,valid_until,lead_vsl_id,created_by,created_dt) "
			+ "values (:code,:name,:sName,:fleet,:vesselType,:pI,:hM,:fD,:vesselGroup,:wageScale,true,:reason,:vesselClass,:fleetVessel,to_date(:fleetDate,'dd/mm/yyyy'),to_date(:validUnit,'dd/mm/yyyy'),:leadVessel,:userName,now()) ";
	
	public static final String SAVE_MAIN_VESSEL_PARTICULAR = "Insert into vessel_dtl (vessel_code,flag_code,reg_port,reg_no,build_date,build_place,build_yard,imo_no,hull_no,call_sign,nat_no,mmsi,class_no,ice_class,created_by,created_dt) "
			+ "values (:code,:flag,:port,:rNo,to_date(:bDate,'dd/mm/yyyy'),:pBuild,:yBuild,:imoNo,:hullNo,:cSign,:natNo,:mmis,:cNo,:iClass,:userName,now())";
	
	public static final String SAVE_COMM_VESSEL_PARTICULAR = "Insert into vessel_dtl_comm (vessel_code,vessel_ship_owner,vessel_operator,safety_no,created_by,created_dt) "
			+ "values (:code,:sOwner,:operator,:sNo,:userName,now())";
	
	public static final String SAVE_CREW_VESSEL_PARTICULAR = "Insert into vessel_dtl_crew (vessel_code,vessel_off_mngr,vessel_ship_mngr,vessel_crew_mngr,vessel_grp_mngr,created_by,created_dt) "
			+ "values (:code,:vslOffManager,:vslShipManager,:vslCrewManager,:vslGroupManager,:userName,now())";
	
	public static final String getList = "select vessel_code as code,vessel_name as name,f.fleet_name as fleet,vt.vessel_type_name as vesseltype "
			+ "from vessel_hdr vh "
			+ "left join fleet_master f on vh.fleet_code = f.fleet_id "
			+ "left join vessel_type vt on vh.vessel_code = vt.vessel_type_id "
			+ "order by vh.created_dt desc ";
	
	public static final String GET_HDR_DTLS = "select vh.vessel_code as code,vessel_name as name,vessel_short_name as shortname,vh.fleet_code as fleet,vh.vessel_type_code as vesseltype,pandi_ins_code as pandi, "
			+ "hull_ins_code as hullandmachinery,fd_ins_code as fdandd,vessel_group as vesselgroup,vh.wage_scale_code as wagescale,is_active as isActive, "
			+ "reason as reason,vessel_class as vesselClass,fleet_vsl_id as fleetvessel,to_char(fleet_date,'dd/mm/yyyy') as dateinfleettype,to_char(valid_until,'dd/mm/yyyy') as valiedUntil, "
			+ "lead_vsl_id as leadvesselid,f.fleet_name as fleetName,vt.vessel_type_name as vesselTypeName,vi.vessel_insurance_code as pandiName, "
			+ "w.wage_scale_name as wageScaleName,vc.vessel_class_name as vesselClassName,is_active as vesselStatus,"
			+ "vi.vessel_insurance_name as pandiName,vih.vessel_insurance_name as hullandmachineryName,"
			+ "vif.vessel_insurance_name as fdanddName from vessel_hdr vh  "
			+ "left join fleet_master f on f.fleet_id = vh.fleet_code "
			+ "left join vessel_type vt on vt.vessel_type_id = vh.vessel_type_code "
			+ "left join vessel_insurance vi on vi.vessel_insurance_id = vh.pandi_ins_code "
			+ "left join vessel_insurance vih on vih.vessel_insurance_id = vh.hull_ins_code "
			+ "left join vessel_insurance vif on vif.vessel_insurance_id = vh.fd_ins_code "
			+ "left join wage_scales w on w.wage_scale_id = vh.wage_scale_code "
			+ "left join vessel_class vc on vc.vessel_class_id = vh.vessel_class "
			+ "where vessel_code = ? ";
	
	public static final String GET_MAIN_DTLS = "select vd.flag_code as flag,vd.reg_port as registryport,reg_no as registryno,to_char(build_date,'dd/mm/yyyy')as builtdate,build_place as placeBuild,build_yard as yardbuild, "
			+ "imo_no as imono,hull_no as hullno,call_sign as callsign,nat_no as natnumber,mmsi as mmis,ice_class as iceclass,class_no as classno, "
			+ "f.flag_desc as flagName,p.port_name as portName from vessel_dtl vd "
			+ "left join flag_master f on f.flag_id =  vd.flag_code "
			+ "left join port_master p on p.port_id = vd.reg_port "
			+ "where vessel_code = ? ";
	
	public static final String GET_COMM_DTLS = "select vc.vessel_ship_owner as shipowner,vessel_operator as operator,safety_no as safteyno, "
			+ "vo.vessel_owner_name as vesselOwnerName from vessel_dtl_comm vc "
			+ "left join vessel_owner vo on vo.vessel_owner_id = vc.vessel_ship_owner "
			+ "where vessel_code = ? ";
	
	public static final String GET_CREW_DTLS = "select vc.vessel_off_mngr as officialManager,vc.vessel_ship_mngr as shipmanager,vessel_crew_mngr as crewmanager,vessel_grp_mngr as groupmanager, "
			+ "om.official_manager_name as offManagerName,sm.ship_manager_name as shipManagerName from vessel_dtl_crew vc "
			+ "left join official_managers om on om.official_managers_id = vc.vessel_off_mngr "
			+ "left join ship_managers sm on sm.ship_managers_id = vc.vessel_ship_mngr "
			+ "where vessel_code = ? ";
	
	public static final String UPDATE_HDR_VESSEL_PARTICULAR = "Update vessel_hdr "
			+ "set vessel_name=:name, vessel_short_name=:sName,fleet_code=:fleet, vessel_type_code=:vesselType, pandi_ins_code=:pI, hull_ins_code=:hM, "
			+ "fd_ins_code=:fD, vessel_group=:vesselGroup, wage_scale_code=:wageScale, is_active=:status, reason=:reason, vessel_class=:vesselClass, "
			+ "fleet_vsl_id=:fleetVessel, fleet_date=to_date(:fleetDate,'dd/mm/yyyy'), valid_until=to_date(:validUnit,'dd/mm/yyyy'), lead_vsl_id=:leadVessel,modified_by=:userName, modified_dt=now() "
			+ "where vessel_code=:code ";
	
	public static final String UPDATE_MAIN_VESSEL_PARTICULAR = "Update vessel_dtl "
			+ "set flag_code=:flag, reg_port=:port, reg_no=:rNo, build_date=to_date(:bDate,'dd/mm/yyyy'), build_place=:pBuild, "
			+ "build_yard=:yBuild, imo_no=:imoNo, hull_no=:hullNo, call_sign=:cSign, nat_no=:natNo, mmsi=:mmis, class_no=:cNo, ice_class=:iClass,modified_by=:userName, "
			+ "modified_dt=now() where vessel_code=:code ";
	
	public static final String UPDATE_COMM_VESSEL_PARTICULAR = "Update vessel_dtl_comm "
			+ "set vessel_ship_owner=:sOwner, vessel_operator=:operator, safety_no=:sNo,modified_by=:userName, modified_dt=now() where vessel_code=:code ";
	
	public static final String UPDATE_CREW_VESSEL_PARTICULAR = "Update vessel_dtl_crew "
			+ "set vessel_off_mngr=:vslOffManager, vessel_ship_mngr=:vslShipManager, vessel_crew_mngr=:vslCrewManager, "
			+ "vessel_grp_mngr=:vslGroupManager,modified_by=:userName, modified_dt=now() where vessel_code=:code ";
	
	public static final String Delete_Hdr = "delete from vessel_hdr where vessel_code = ? ";
	
	public static final String Delete_Dtl = "delete from vessel_dtl where vessel_code = ? ";
	
	public static final String Delete_Dtl_Com = "delete from vessel_dtl_comm where vessel_code = ? ";
	
	public static final String Delete_Dtl_Crew = "delete from vessel_dtl_crew where vessel_code = ? ";
	
	public static final String checkDelete = "select count(*) from vessel_prefix where vsl_prefix_code = ?";
	
	public static final String GET_VESSEL_CODE = "SELECT CASE WHEN MAX(vessel_code) IS NULL THEN 'V0001' "
			+ "ELSE rpad(MAX(vessel_code),1,'V')|| lpad(cast(cast((null_or_empty(SUBSTRING(MAX(vessel_code),3),'0')) as int)+1 as text),4,'0') "
			+ "END AS INVOICE_NO  FROM vessel_hdr where vessel_code like 'V%' ";

}
