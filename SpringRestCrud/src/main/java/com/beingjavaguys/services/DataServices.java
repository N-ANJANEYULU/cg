package com.beingjavaguys.services;

import java.util.List;


import com.beingjavaguys.model.ConsumerGroup;

public interface DataServices {
	public boolean addEntity(ConsumerGroup consumergroup) throws Exception;
	public ConsumerGroup getEntityById(int id) throws Exception;
	public List<ConsumerGroup> getEntityList() throws Exception;
	public boolean deleteEntity(int id) throws Exception;
	
}
