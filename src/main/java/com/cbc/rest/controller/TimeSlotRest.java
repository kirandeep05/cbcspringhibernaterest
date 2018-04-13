package com.cbc.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.bean.TimeSlot;
import com.cbc.service.TimeSlotService;

@RestController
@RequestMapping("rest/timeslot")
public class TimeSlotRest {

	@Autowired
	TimeSlotService timeSlotService;
	
	@RequestMapping(value="/create",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Map<String,String> saveTimeSlot(@RequestBody TimeSlot timeSlot) {
		System.out.println(timeSlot);
		timeSlotService.saveTimeSlot(timeSlot);
		Map<String,String> map = new HashMap<String,String>();
		return map;
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TimeSlot> listAllTimeSlots() {
		return timeSlotService.listAllTimeSlots();
	}
}
