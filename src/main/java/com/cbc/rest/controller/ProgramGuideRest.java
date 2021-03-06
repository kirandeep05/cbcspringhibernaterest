package com.cbc.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.bean.Network;
import com.cbc.service.NetworkService;

@RestController
@RequestMapping("rest/network")
public class ProgramGuideRest {
	
	@Autowired
	NetworkService networkService;

	@RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> addNetwork(@RequestBody Network network) {
		System.out.println(network);
		networkService.saveNetwork(network);
		HashMap<String,String> result = new HashMap<String, String>();
		result.put("result", "added");
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Network> listNetworks() {
		return networkService.listAllNetworks();		
	}
	
	@RequestMapping(value="/network/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Network getNetwork(@PathVariable("id") long id) {
		return networkService.findById(id);
	}
	
}
