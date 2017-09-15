package com.beingjavaguys.dao;

import java.util.List;

import com.beingjavaguys.model.ConsumerGroup;


public interface DataDao {

	public Integer addEntity(ConsumerGroup consumergroup) throws Exception;
	public ConsumerGroup getEntityById(int id) throws Exception;
	public List<ConsumerGroup> getEntityList() throws Exception;
	public boolean deleteEntity(int id) throws Exception;
	public boolean updateEntity(ConsumerGroup consumergroup) throws Exception ;
	
}
