package com.vms.crew.maintainRank;

public class MaintainRankQueryUtil {

	public static final String SAVE_VESSEL_TYPE = "Insert into rank_master (rank_code,rank_name,dept_code,rank_group_code,ot_flag,rank_remarks,is_active,created_by,created_dt)\r\n"
			+ "values (:code,:description,:department,:groupage,:oAndt,:remarks,:isActive,:userName,now())";

public static final String getList = "select rm.rank_code as code,rm.rank_name as description,rm.dept_code as department,dm.dept_code as departmentname,rg.rank_group_name as \r\n"
		+ "groupagename,rm.rank_group_code as groupage,rm.ot_flag as oAndt,rm.rank_remarks as remarks,rm.is_active as \r\n"
		+ "isActive,rank_id as rankid from rank_master rm left Join  rank_group rg ON rg.rank_group_id = rm.rank_group_code\r\n"
		+ "left Join  department_master dm ON dm.dept_id = rm.dept_code";

public static final String getEdit = "select rm.rank_code as code,rm.rank_name as description,rm.dept_code as department,dm.dept_code as departmentname,rg.rank_group_name as \r\n"
		+ "groupagename,rm.rank_group_code as groupage,rm.ot_flag as oAndt,rm.rank_remarks as remarks,rm.is_active as \r\n"
		+ "isActive,rank_id as rankid from rank_master rm left Join  rank_group rg ON rg.rank_group_id = rm.rank_group_code\r\n"
		+ "left Join  department_master dm ON dm.dept_id = rm.dept_code where rank_id = ?";

public static final String delete = "delete from rank_master where rank_id = ? ";

public static final String checkDelete = "select count(*) from rank_master where rank_code = ?";

public static final String UPDATE_VESSEL_TYPE = "UPDATE rank_master SET "
	    + "rank_code = :code, "
	    + "rank_name = :description, "
	    + "dept_code = :department, "
	    + "rank_group_code = :groupage, "
	    + "ot_flag = :oAndt, "
	    + "rank_remarks = :remarks, "
	    + "is_active =:isActive, "
	    + "modified_by = :userName, "
	    + "modified_dt = NOW() "
	    + "WHERE rank_id = :rankid";

public static final String get_code ="select count(rank_code) from rank_master where rank_code=?";

public static final String get_desc ="select count(rank_name) from rank_master where rank_name=?";

public static final String maintainRank_code ="select rank_code from rank_master where rank_id= ?";

public static final String maintainRank_desc = "select rank_name from rank_master where rank_id= ?";

public static final String get_code_edit = "SELECT COUNT(rank_code) FROM rank_master WHERE rank_code = ?  AND rank_code != ?";

public static final String get_desc_edit = "SELECT COUNT(rank_name) FROM rank_master WHERE rank_name = ?  AND rank_name != ?";

public static String getdepartment="select dept_id as id ,dept_name as text  from department_master";

public static String getgrouppage="select rank_group_id as id ,rank_group_name as text  from rank_group";

}
