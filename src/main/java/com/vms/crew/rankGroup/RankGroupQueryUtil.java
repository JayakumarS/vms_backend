package com.vms.crew.rankGroup;

public class RankGroupQueryUtil {

	
	public static final String SAVE_rank_group = "Insert into rank_group (rank_group_code,rank_group_name,rank_group_remarks,created_by,created_dt)"
			+ "values (:code,:desc,:remarks,:userName,now())";

public static final String getList = "select rank_group_code as code,rank_group_name as description,rank_group_remarks as remarks,rank_group_id as rankgroupid from rank_group order by created_dt desc";

public static final String getEdit = "select rank_group_code as code,rank_group_name as description, rank_group_remarks as remarks,rank_group_id as rankgroupid from rank_group where rank_group_id = ?";

public static final String delete = "delete from rank_group where rank_group_id = ? ";

public static final String checkDelete = "select count(*) from rank_group where rank_group_code = ?";

public static final String UPDATE_rank_group = "update rank_group set rank_group_code=:code,rank_group_name=:desc,rank_group_remarks=:remarks,modified_by=:userName,modified_dt=now() where rank_group_id = :rankgroupid";

public static final String get_code = "select count(rank_group_code) from rank_group where rank_group_code=?";

public static final String get_desc = "select count(rank_group_name) from rank_group where rank_group_name=?";

public static final String rankGroup_code = "select rank_group_code from rank_group where rank_group_id = ?";

public static final String rankGroup_desc = "select rank_group_name  from rank_group where rank_group_id = ?";

public static final String get_code_edit = "SELECT COUNT(rank_group_code) FROM rank_group WHERE rank_group_code = ?  AND rank_group_code != ?";

public static final String get_desc_edit = "SELECT COUNT(rank_group_name) FROM rank_group WHERE rank_group_name = ?  AND rank_group_name != ?";

}
