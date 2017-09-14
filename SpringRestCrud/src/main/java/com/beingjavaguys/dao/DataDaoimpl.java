package com.beingjavaguys.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.sql.ordering.antlr.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	public boolean addEntity(ConsumerGroup consumergroup) throws Exception {
		// System.out.println(consumergroup.getBrand());
		System.out.println(consumergroup.getFirstName());
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.save(consumergroup);

		tx.commit();
		session.close();

		return false;
	}

	@Override
	public ConsumerGroup getEntityById(int id) throws Exception {
		session = sessionFactory.openSession();
		ConsumerGroup consumergroup = (ConsumerGroup) session.load(ConsumerGroup.class, new Integer(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return consumergroup;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsumerGroup> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<ConsumerGroup> consumergroupList = session.createCriteria(ConsumerGroup.class).list();
		tx.commit();
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
