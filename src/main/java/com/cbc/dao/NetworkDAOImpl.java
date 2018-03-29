package com.cbc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cbc.bean.Network;

@Repository
public class NetworkDAOImpl implements NetworkDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public Network findById(long id) {
		Session session = sessionFactory.openSession();
		Network network = (Network) session.get(Network.class, id);		
		return network;
	}

	public Network findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<Network> listAllNetworks() {
		Session session = sessionFactory.openSession();
		List<Network> list = session.createCriteria(Network.class).list();
		return list;
	}

	@Transactional
	public void saveNetwork(Network network) {
		Session session = sessionFactory.openSession();
		session.save(network);
	}

	public void deleteNetworkById(long id) {
		// TODO Auto-generated method stub
		
	}
	
}
