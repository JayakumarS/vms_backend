package com.vms.crew.rankWorkingShift;

public class RankWorkingShiftQueryUtil {
	
	public static final String SAVE_rank_Working_Shift_hdr = "Insert into rank_Working_Shift_hdr (rank_working_shift_vessel,rank_working_shift_rank,rank_working_shift_sDate,rank_working_shift_eDate,rank_working_shift_remarks,created_by,created_dt)"
			+"values (:vessel,:rank, :sDate::TIMESTAMP, :eDate::TIMESTAMP,:remarks,:userName,now())";
	
	public static final String SAVE_rank_Working_Shift_dtl = "Insert into rank_working_shift_dtl (rank_working_shift_shiftStart,rank_working_shift_shiftEnd,rank_working_shift_place,rank_working_shift_watchKeeping,created_by,created_dt)"
			+"values (:shiftStart::TIME,:shiftEnd::TIME,:place,:watchKeeping,:userName,now())";


	public static final String getList = "select rank_working_shift_vessel as vessel,rank_working_shift_rank as rank,rank_working_shift_sDate as sDate ,rank_working_shift_eDate as eDate,rank_working_shift_remarks as remarks from rank_working_shift_hdr order by created_dt desc";
			

	public static final String getEdit = "select pay_types_code as code,pay_types_name as description from pay_types where pay_types_code = ?";

	public static final String delete = "delete from rank_working_shift_hdr where rank_working_shift_hdr_code = ? ";

	public static final String checkDelete = "select count(*) from pay_types where pay_types_code = ?";

	public static final String UPDATE_rank_Working_Shift_hdr = "update pay_types set pay_types_code=:code,pay_types_name=:desc,modified_by=:userName,modified_dt=now() where pay_types_code = :code";



}
