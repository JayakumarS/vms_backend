package com.vms.crew.maintain.interviewsetup;

import java.util.List;

public interface InterviewSetupDao {

	public	InterviewSetupResultBean save(InterviewSetupBean bean);

	public InterviewSetupResultBean getList();

	public InterviewSetupResultBean edit(String id);

	public	InterviewSetupResultBean update(InterviewSetupBean bean);

	public	InterviewSetupResultBean delete(String id);

	public List<InterviewSetupBean> getRankMasters();

	InterviewSetupResultBean savedetail(InterviewSetupBean bean, Integer rank);
	

}
