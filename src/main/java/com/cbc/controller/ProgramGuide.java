package com.cbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.cbc.bean.Network;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("cbc")
public class ProgramGuide {

	@ModelAttribute
	public void commonText(Model model) {
		model.addAttribute("HeaderText", "Program Guide");
		model.addAttribute("CBCtext", "CBC.ca displays schedules for each television and radio network. To see the schedule for a particular network, please select your network below:");
	}
	
	@RequestMapping("/programGuide")
	public ModelAndView viewProgramGuide() {
		return new ModelAndView("viewProgramGuide");		
	}
	
	@RequestMapping("/viewCreateNetwork")
	public ModelAndView viewCreateNetworkPage() {
		return new ModelAndView("createNetwork");
	}
	
	@RequestMapping(value="/createNetwork", method=RequestMethod.POST)
	public ModelAndView createNetwork(@ModelAttribute Network network) {
		System.out.println(network);
		ObjectMapper objMapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = objMapper.writeValueAsString(network);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/programguide/rest/createNetwork";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		List<MediaType> list = new ArrayList<MediaType>();
		list.add(MediaType.APPLICATION_JSON);
		headers.setAccept(list);
		HttpEntity<String> entity = new HttpEntity<String>(jsonString,headers);
		String response = restTemplate.postForObject(url, entity, String.class);
		System.out.println(response);
		return new ModelAndView("viewProgramGuide");
	}
	
}
