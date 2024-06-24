package com.vms.crew.maintainRank;

public class MaintainRankQueryUtil {

	public static final String SAVE_VESSEL_TYPE = "Insert into rank_master (rank_code,rank_name,dept_code,rank_group_code,ot_flag,rank_remarks,created_by,created_dt)\r\n"
			+ "values (:code,:description,:department,:groupage,:oAndt,:remarks,:userName,now())";

public static final String getList = "select rank_code as code,rank_name as description,dept_code as department,rank_group_code as groupage,ot_flag as oAndt,rank_remarks as remarks from rank_master order by created_dt desc";

public static final String getEdit = "select rank_code as code,rank_name as description,dept_code as department,rank_group_code as groupage,ot_flag as oAndt,rank_remarks as remarks from rank_master where rank_code = ?";

public static final String delete = "delete from rank_master where rank_code = ? ";

public static final String checkDelete = "select count(*) from rank_master where rank_code = ?";

public static final String UPDATE_VESSEL_TYPE = "UPDATE rank_master SET "
	    + "rank_code = :code, "
	    + "rank_name = :description, "
	    + "dept_code = :department, "
	    + "rank_group_code = :groupage, "
	    + "ot_flag = :oAndt, "
	    + "rank_remarks = :remarks, "
	    + "modified_by = :userName, "
	    + "modified_dt = NOW() "
	    + "WHERE rank_code = :code";
public static String getdepartment="select dept_code as id ,dept_name as text  from department_master";

public static String getgrouppage="select rank_group_id as id ,rank_group_name as text  from rank_group";

}
