package com.vms.crew.rankGroup;

public class RankGroupQueryUtil {

	
	public static final String SAVE_rank_group = "Insert into rank_group (rank_grp_code,rank_grp_desc,rank_grp_remarks,created_by,created_dt)"
			+ "values (:code,:desc,:remarks,:userName,now())";

public static final String getList = "select rank_grp_code as code,rank_grp_desc as description,rank_grp_remarks as remarks from rank_group order by created_dt desc";

public static final String getEdit = "select rank_grp_code as code,rank_grp_desc as description, rank_grp_remarks as remarks from rank_group where rank_grp_code = ?";

public static final String delete = "delete from rank_group where rank_grp_code = ? ";

public static final String checkDelete = "select count(*) from rank_group where rank_grp_code = ?";

public static final String UPDATE_rank_group = "update rank_group set rank_grp_code=:code,rank_grp_desc=:desc,rank_grp_remarks=:remarks,modified_by=:userName,modified_dt=now() where rank_grp_code = :code";

}
