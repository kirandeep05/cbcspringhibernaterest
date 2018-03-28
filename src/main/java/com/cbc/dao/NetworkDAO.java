package com.cbc.dao;

import java.util.List;

import com.cbc.bean.Network;

public interface NetworkDAO {
	public Network findById(long id);
	public Network findByName(String name);
	public List<Network> listAllNetworks();
	public void saveNetwork(Network network);
	public void deleteNetworkById(long id);
}
