
package com.beingjavaguys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beingjavaguys.dao.DataDao;
import com.beingjavaguys.dao.DataDaoimpl;
import com.beingjavaguys.model.ConsumerGroup;

/* @Service  */
public class DataServicesimpl implements DataServices {
	@Autowired
	DataDaoimpl dataDao = new DataDaoimpl();

	@Override
	public boolean addEntity(ConsumerGroup consumergroup) throws Exception {
		//System.out.println(consumergroup.getFirstName());
		return dataDao.addEntity(consumergroup);
	}

	@Override
	public ConsumerGroup getEntityById(int id) throws Exception {

		return dataDao.getEntityById(id);
	}

	@Override
	public List<ConsumerGroup> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(int id) throws Exception {
		return dataDao.deleteEntity(id);
	}

}
