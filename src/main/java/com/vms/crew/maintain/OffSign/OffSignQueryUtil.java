package com.vms.crew.maintain.OffSign;

public class OffSignQueryUtil {

	public static final String SAVE_OFF_SIGN_HDR = "Insert INTO off_sign_hdr (off_sign_vessel_type,remarks,created_by,created_dt) Values(:vesselType,:remarks,:userName,now()) returning off_sign_id";
	
	public static final String SAVE_OFF_SIGN_DTL = "Insert INTO off_sign_dtl (off_sign_hdr_id,off_sign_nationality,off_sign_rank,off_sign_month) Values(:code,:nationality,:rank,:month)";

	public static final String GET_OFFSIGN_LIST = "select off_sign_id as offSignId,vessel_type_name as offSignVesselType,remarks as remarks,\r\n"
			+ " osh.created_by as createdBy,to_char(osh.created_dt,'DD/MM/YYYY') as createdDate from off_sign_hdr osh\r\n"
			+ " left join vessel_type on vessel_type_code = off_sign_vessel_type\r\n"
			+ " order by off_sign_id desc";
	public static final String GET_EDIT_OFFSIGN = "select off_sign_id as offSignId,off_sign_vessel_type as offSignVesselType,remarks as remarks from off_sign_hdr where off_sign_id=?";

	public static final String DELETE_OFFSIGN = "Delete from off_sign_hdr where off_sign_id=?";

	public static final String UPDATE_OFFSIGN = "update off_sign_hdr set off_sign_vessel_type=:vesselType,remarks=:remarks,modified_by=:userName,modified_dt=now() \r\n"
			+ " where off_sign_id = :offSignId returning off_sign_id";

	public static final String DELETE_OFFSIGN_DTL = "Delete from off_sign_dtl where off_sign_hdr_id=?";

	public static final String GET_EDIT_OFFSIGN_DTL = "select off_sign_nationality as offSignNationality,off_sign_rank as offSignRank,off_sign_month as offSignMonth\r\n"
			+ " from off_sign_dtl where off_sign_hdr_id=?";

}
