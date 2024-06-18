package com.vms.crew.maintainRank;

public class MaintainRankQueryUtil {

	public static final String SAVE_VESSEL_TYPE = "Insert into rank_master (rank_id,rank_code,rank_desc,dept_code,rank_grp_code,ot_flag,rank_remarks,created_by,created_dt)\r\n"
			+ "values (:sno,:code,:description,:department,:groupage,:oAndt,:remarks,:userName,now())";

public static final String getList = "select rank_id as sno,rank_code as code,rank_desc as description,dept_code as department,rank_grp_code as groupage,ot_flag as oAndt,rank_remarks as remarks from rank_master order by created_dt desc";

public static final String getEdit = "select rank_id as sno,rank_code as code,rank_desc as description,dept_code as department,rank_grp_code as groupage,ot_flag as oAndt,rank_remarks as remarks from rank_master where rank_code = ?";

public static final String delete = "delete from rank_master where rank_code = ? ";

public static final String checkDelete = "select count(*) from rank_master where rank_code = ?";

public static final String UPDATE_VESSEL_TYPE = "UPDATE rank_master SET "
	    + "rank_id = :sno, "
	    + "rank_code = :code, "
	    + "rank_desc = :description, "
	    + "dept_code = :department, "
	    + "rank_grp_code = :groupage, "
	    + "ot_flag = :oAndt, "
	    + "rank_remarks = :remarks, "
	    + "modified_by = :userName, "
	    + "modified_dt = NOW() "
	    + "WHERE rank_code = :code";
public static String getdepartment="select dept_code as id ,dept_desc as text  from department_master";

public static String getgrouppage="select rank_grp_code as id ,rank_grp_desc as text  from rank_group";

}
