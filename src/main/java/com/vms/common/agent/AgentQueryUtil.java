package com.vms.common.agent;

public class AgentQueryUtil {

	
public static final String SAVE_AGENT = "Insert into agent_master (agent_code,agent_code_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

public static final String getList = "select agent_code as code,agent_code_name as description from agent_master order by created_dt desc";

public static final String getEdit_AGENT = "select agent_code as code,agent_code_name as description from agent_master where agent_code = ?";

public static final String delete = "delete from agent_master where agent_code = ? ";

public static final String checkDelete = "select count(*) from agent_master where agent_code = ?";

public static final String UPDATE_AGENT = "update agent_master set agent_code=:code,agent_code_name=:desc,modified_by=:userName,modified_dt=now() where agent_code = :code";

}
