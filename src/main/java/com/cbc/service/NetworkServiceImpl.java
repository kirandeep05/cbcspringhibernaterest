package com.cbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbc.bean.Network;
import com.cbc.dao.NetworkDAO;

@Service
public class NetworkServiceImpl implements NetworkService{

	@Autowired
	NetworkDAO networkDAO;
	
	public Network findById(long id) {
		return networkDAO.findById(id);
	}

	public Network findByName(String name) {
		return networkDAO.findByName(name);
	}

	public List<Network> listAllNetworks() {
		return networkDAO.listAllNetworks();
	}

	public void saveNetwork(Network network) {
		networkDAO.saveNetwork(network);
	}

	public void deleteNetworkById(long id) {
		networkDAO.deleteNetworkById(id);
	}

}
