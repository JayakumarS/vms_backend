package com.vms.common.agent;

public class AgentQueryUtil {

	
public static final String SAVE_AGENT = "Insert into agent_master (agent_code,agent_code_name,created_by,created_dt)"
			+ "values (:code,:desc,:userName,now())";

public static final String getList = "select agent_id as agentid,agent_code as code,agent_code_name as description from agent_master order by created_dt desc";

public static final String getEdit_AGENT = "select agent_id as agentid, agent_code as code,agent_code_name as description from agent_master where agent_id = ?";

public static final String delete = "delete from agent_master where agent_id = ? ";

public static final String checkDelete = "select count(*) from agent_master where agent_id = ?";

public static final String UPDATE_AGENT = "update agent_master set  agent_id=:agentid,agent_code=:code,agent_code_name=:desc,modified_by=:userName,modified_dt=now() where agent_id =:agentid";

public static final String get_code = "select count(agent_code) from agent_master where agent_code=?";

public static final String get_desc = "select count(agent_code_name) from agent_master where agent_code_name=?";


}
