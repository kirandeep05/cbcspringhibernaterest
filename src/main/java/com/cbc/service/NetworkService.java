package com.cbc.service;
import java.util.List;

import com.cbc.bean.Network;

public interface NetworkService {
	Network findById(long id);
	Network findByName(String name);
	List<Network> listAllNetworks();
	void saveNetwork(Network network);
	void deleteNetworkById(long id);
}
