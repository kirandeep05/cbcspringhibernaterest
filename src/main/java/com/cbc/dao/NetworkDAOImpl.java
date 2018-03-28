package com.cbc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cbc.bean.Network;

@Repository
public class NetworkDAOImpl implements NetworkDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public Network findById(long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Network network = session.get(Network.class, id);
		transaction.commit();
		session.close();
		
		return network;
	}

	public Network findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Network> listAllNetworks() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveNetwork(Network network) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(network);
		transaction.commit();
		session.close();	
	}

	public void deleteNetworkById(long id) {
		// TODO Auto-generated method stub
		
	}
	
}
