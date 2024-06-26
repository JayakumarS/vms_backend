package com.vms.crew.maintain.interviewsetup;

import java.util.List;

public interface InterviewSetupService {

	public InterviewSetupResultBean save(InterviewSetupBean bean);

	public InterviewSetupResultBean getList();

	public InterviewSetupResultBean edit(String id);

	public InterviewSetupResultBean update(InterviewSetupBean bean);

	public InterviewSetupResultBean delete(String id);

	public List<InterviewSetupBean> getRankMasters();

	

}
