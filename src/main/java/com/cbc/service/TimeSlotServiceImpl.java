package com.cbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbc.bean.TimeSlot;
import com.cbc.dao.TimeSlotDAO;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

	@Autowired
	TimeSlotDAO timeSlotDAO;
	
	@Override
	public TimeSlot findById(long id) {
		return timeSlotDAO.findById(id);
	}

	@Override
	public List<TimeSlot> listAllTimeSlots() {
		return timeSlotDAO.listAllTimeSlots();
	}

	@Override
	public void saveTimeSlot(TimeSlot timeSlot) {
		timeSlotDAO.saveTimeSlot(timeSlot);
	}

	@Override
	public void deleteTimeSlot(long id) {
		timeSlotDAO.deleteTimeSlot(id);
	}
	
}
