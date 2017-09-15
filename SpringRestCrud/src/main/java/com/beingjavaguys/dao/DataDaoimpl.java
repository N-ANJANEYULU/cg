package com.beingjavaguys.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.beingjavaguys.model.ConsumerGroup;

/* @Repository */
public class DataDaoimpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Session session = null;
	
	Transaction tx = null;

	public Integer addEntity(ConsumerGroup consumergroup) throws Exception {
		// System.out.println(consumergroup.getBrand());
		System.out.println(consumergroup.getFirstName());
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Integer id = (Integer)session.save(consumergroup);
		System.out.println("Object Created with Id "+ id);
		tx.commit();
		session.close();

		return id;
	}
	
	
	public boolean updateEntity(ConsumerGroup consumergroup) throws Exception {
		// System.out.println(consumergroup.getBrand());
		
		if(consumergroup.getConsumergroupid()!=null){
		System.out.println(consumergroup.getFirstName());
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.update(consumergroup);

		tx.commit();
		session.close();
		return true;
		} 

		return false;
	}

	@Override
	public ConsumerGroup getEntityById(int id) throws Exception {
		session = sessionFactory.openSession();
		ConsumerGroup consumergroup = (ConsumerGroup) session.load(ConsumerGroup.class, new Integer(id));
		return consumergroup;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsumerGroup> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		List<ConsumerGroup> consumergroupList = session.createCriteria(ConsumerGroup.class).list();
		session.close();
		return consumergroupList;
	}

	@Override
	public boolean deleteEntity(int id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(ConsumerGroup.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
