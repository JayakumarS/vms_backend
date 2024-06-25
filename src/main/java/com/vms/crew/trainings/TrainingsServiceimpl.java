package com.vms.crew.trainings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TrainingsServiceimpl implements TrainingsService {
	
	@Autowired
	TrainingsDao TrainingsDao;
	
	@Override
	public TrainingsResultBean save(TrainingsBean bean) {
		// TODO Auto-generated method stub
		return TrainingsDao.save(bean);
	}

	@Override
	public TrainingsResultBean getList() {
		// TODO Auto-generated method stub
		return TrainingsDao.getList();
	}

	@Override
	public TrainingsResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return TrainingsDao.edit(id);
	}

	@Override
	public TrainingsResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		return TrainingsDao.delete(id);
	}

	@Override
	public TrainingsResultBean update(TrainingsBean bean) {
		// TODO Auto-generated method stub
		return TrainingsDao.update(bean);
	}

}
