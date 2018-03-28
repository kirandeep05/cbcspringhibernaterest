package com.cbc.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.bean.Network;
import com.cbc.service.NetworkService;

@RestController
@RequestMapping("rest")
public class ProgramGuideRest {
	
	@Autowired
	NetworkService networkService;

	@RequestMapping(value="/programs", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Network> listOfPrograms() {
		Network prog1 = new Network();
		prog1.setId(1);
		prog1.setName("CBC Television");
		prog1.setUrl("http://www.cbc.ca/programguide/daily/today/cbc_television");
		
		Network prog2 = new Network();
		prog2.setId(2);
		prog2.setName("CBC News Network");
		prog2.setUrl("http://www.cbc.ca/programguide/daily/today/cbc_news");
		
		ArrayList<Network> networks = new ArrayList<Network>();
		networks.add(prog1);
		networks.add(prog2);	
		
		return networks;
	}
	
	@RequestMapping(value="/createNetwork", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> addNetwork(@RequestBody Network network) {
		System.out.println(network);
		networkService.saveNetwork(network);
		HashMap<String,String> result = new HashMap<String, String>();
		result.put("result", "added");
		return result;
	}
	
	
}
