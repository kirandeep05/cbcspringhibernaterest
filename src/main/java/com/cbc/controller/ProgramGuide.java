package com.cbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.cbc.bean.Network;
import com.cbc.constants.CommonConstants;
import com.cbc.rest.controller.ProgramGuideRest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("cbc")
public class ProgramGuide {

	@Autowired
	ProgramGuideRest progGuideRest;
	
	@ModelAttribute
	public void commonText(Model model) {
		model.addAttribute("HeaderText", "Program Guide");
		model.addAttribute("CBCtext", "CBC.ca displays schedules for each television and radio network. To see the schedule for a particular network, please select your network below:");
	}
	
	@RequestMapping("/network")
	public ModelAndView viewProgramGuide() {
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<Network> response = restTemplate.getForObject(CommonConstants.REST_NETWORK_VIEW_ALL_URL,ArrayList.class);
		ModelAndView mv = new ModelAndView("viewProgramGuide");
		mv.addObject("networksList", response);
		return mv;		
	}

	@RequestMapping("/network/{id}")
	public ModelAndView viewNetwork(@PathVariable("id") long id) {
		RestTemplate restTemplate = new RestTemplate();
		Network network = restTemplate.getForObject(CommonConstants.REST_NETWORK_VIEW_ALL_URL+id, Network.class);
		ModelAndView mv = new ModelAndView("viewNetwork");
		mv.addObject("network", network);
		return mv;
	}
	
	@RequestMapping("/viewCreateNetwork")
	public ModelAndView viewCreateNetworkPage() {
		return new ModelAndView("createNetwork");
	}
	
	@RequestMapping(value="/createNetwork", method=RequestMethod.POST)
	public String createNetwork(@ModelAttribute Network network) {
		ObjectMapper objMapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = objMapper.writeValueAsString(network);
		} catch (JsonProcessingException e) {
			System.out.println("Test repo");
			e.printStackTrace();
		}
		postJsonResponseRestTemplate(CommonConstants.REST_NETWORK_CREATE_URL, jsonString, MediaType.APPLICATION_JSON);
		return "forward:network";
	}
	
	
	public String postJsonResponseRestTemplate(String url,String jsonString,MediaType mediaType) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		List<MediaType> list = new ArrayList<MediaType>();
		list.add(mediaType);
		headers.setAccept(list);
		HttpEntity<String> entity = new HttpEntity<String>(jsonString,headers);
		String response = restTemplate.postForObject(url, entity, String.class);
		return response;
	}
	
	public ArrayList<Network> getJsonResponseObject(String url) {
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<Network> response = restTemplate.getForObject(url,ArrayList.class);
		return response;
	}
	
}
