package com.vms.crew.rankWorkingShift;

public class RankWorkingShiftQueryUtil {
	
	public static final String SAVE_rank_shift_master = "Insert into rank_shift_master (rank_shift_vessel_code,rank_shift_rank_code,rank_shift_start_date,rank_shift_end_date,rank_shift_remarks,rank_shift_watchkeep_hrs_flag,created_by,created_dt)"
			+ "values (:vessel,:rank, to_date(:sDate,'DD/MM/YYYY'),to_date(:eDate,'DD/MM/YYYY'),:remarks,:watchkeepers,:userName,now())returning rank_shift_id ";
	
	public static final String SAVE_rank_shift_dtl = "Insert into rank_shift_dtl (rank_shift_dtl_start_date,rank_shift_dtl_end_date,rank_shift_place,rank_shift_watch_keeping,created_by,rank_shift_id,created_dt)"
			+"values (:shiftStart::TIME,:shiftEnd::TIME,:place,:watchKeeping,:userName,:rankshiftiddtl,now())";


	public static final String getList = "select rsm.rank_shift_vessel_code as vessel,vh.vessel_name as vesselname,rsm.rank_shift_rank_code as rankcode,\r\n"
			+ "rm.rank_name as rankname,rsm.rank_shift_start_date as sDate ,\r\n"
			+ "rsm.rank_shift_end_date as eDate,rsm.rank_shift_remarks as remarks,rsm.rank_shift_id as rankshiftid  \r\n"
			+ "from rank_shift_master rsm\r\n"
			+ "left join vessel_hdr vh on vh.vessel_code=rsm.rank_shift_vessel_code\r\n"
			+ "left join rank_master rm on rm.rank_id=rsm.rank_shift_rank_code\r\n"
			+ "order by rsm.created_dt desc";
			

	public static final String getEdit = "select rsm.rank_shift_vessel_code as vessel,rsm.rank_shift_rank_code as rankcode,to_char(rsm.rank_shift_start_date,'DD/MM/YYYY') as sDate,\r\n"
			+ "to_char(rsm.rank_shift_end_date,'DD/MM/YYYY') as eDate,rsm.rank_shift_remarks as remarks,rsm.rank_shift_watchkeep_hrs_flag as watchkeepers,\r\n"
			+ "rsm.rank_shift_id as rankshiftid ,vh.vessel_name as vesselname ,rm.rank_name as rankname from rank_shift_master rsm \r\n"
			+ "left join vessel_hdr vh on vh.vessel_code=rsm.rank_shift_vessel_code\r\n"
			+ "left join rank_master rm on rm.rank_id=rsm.rank_shift_rank_code\r\n"
			+ "where rank_shift_id =?";
	
	public static final String getEditDtl = "select  to_char(rank_shift_dtl_start_date, 'HH24:MI') as shiftStart,to_char(rank_shift_dtl_end_date, 'HH24:MI') as shiftEnd,rank_shift_place as place,rank_shift_watch_keeping as watchKeeping,rank_shift_id as rankshiftid  from rank_shift_dtl where rank_shift_id =?";


	public static final String delete = "delete from rank_shift_master where rank_shift_id = ? ";
	
	public static final String DELETE_RANK_SHIFT_DTL = "delete from rank_shift_dtl where rank_shift_id=?";


	public static final String UPDATE_rank_Shift_dtl = "update rank_shift_master set rank_shift_vessel_code=:vessel,rank_shift_rank_code=:rank,rank_shift_start_date=to_date(:sDate,'DD/MM/YYYY'),rank_shift_end_date=to_date(:eDate,'DD/MM/YYYY'),rank_shift_remarks=:remarks,rank_shift_watchkeep_hrs_flag=:watchkeepers,modified_by=:userName,modified_dt=now() where rank_shift_id = :rankshiftid returning rank_shift_id";

	


}
